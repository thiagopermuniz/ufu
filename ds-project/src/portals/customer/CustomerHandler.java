package portals.customer;

import portals.customer.model.Message;
import portals.customer.model.Task;

import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.Socket;
import java.util.Map;

public class CustomerHandler implements Runnable{

    private Socket socket;
    private Map<BigInteger, byte[]> database;

    public CustomerHandler(Socket socket, Map<BigInteger, byte[]> database) {
        this.socket = socket;
        this.database = database;
    }

    public Map<BigInteger, byte[]> getDatabase() {
        return database;
    }

    public Socket getSocket() {
        return socket;
    }


    @Override
    public void run() {
        try {
            Message message;
            Object obj;
            ObjectInputStream in = new ObjectInputStream(this.getSocket().getInputStream());
            while(true) {
                while ((obj = in.readObject()) != null){
                    obj = in.readObject();
                    message = (Message) obj;
                    if (message.getOperation() == 1) {
                        Task task = message.getTask();
                        ByteArrayOutputStream bos = new ByteArrayOutputStream();
                        ObjectOutputStream out = new ObjectOutputStream(bos);
                        out.writeObject(task);
                        BigInteger cid = message.getCid();
                        this.getDatabase().put(cid, bos.toByteArray());
                    }
                    if (message.getOperation() == 0) {
                        Thread.currentThread().interrupt();
                        in.close();
                        this.getSocket().close();
                        return;
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
