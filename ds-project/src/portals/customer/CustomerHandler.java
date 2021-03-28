package portals.customer;

import portals.customer.model.Message;
import portals.customer.model.Task;

import java.io.*;
import java.math.BigInteger;
import java.net.Socket;
import java.util.Hashtable;
import java.util.Map;

public class CustomerHandler implements Runnable {

    private Socket socket;
    private Hashtable<BigInteger, byte[]> database;

    public CustomerHandler(Socket socket, Hashtable<BigInteger, byte[]> database) {
        this.socket = socket;
        this.database = database;
    }

    @Override
    public void run() {
        try {
            Message message = new Message();
            Object obj;
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                while ((obj = in.readObject()) != null) {
                    message = (Message) obj;
                    break;
                }
                Map<String, String> tasks = getTasks(message.getCid());
                Task task = message.getTask();
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(bos);
                BigInteger cid = message.getCid();
                if (message.getOperation() == 1) {
                    tasks.put(task.getTitle(), task.getDescription());
                    oos.writeObject(tasks);
                    database.put(cid, bos.toByteArray());
                    System.out.println(message.toString());
                    ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                    out.writeObject("Tarefa criada com sucesso!");
                    out.close();
                    in.close();
                    socket.close();
                    return;

                }else if (message.getOperation() == 2) {
                    String value = tasks.get(task.getTitle());
                    if(value == null) {
                        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                        out.writeObject("Tarefa não encontrada!");
                        out.close();
                    }else{
                        tasks.put(task.getTitle(), task.getDescription());
                        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                        out.writeObject("Tarefa modificada com sucesso!");
                        out.close();
                    }
                    oos.writeObject(tasks);
                    database.put(cid, bos.toByteArray());
                    System.out.println(message.toString());

                    in.close();
                    socket.close();
                    return;

                }else if (message.getOperation() == 3) {
                    ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                    out.writeObject("Tarefas:\n"+tasks.toString());
                    out.close();
                    oos.writeObject(tasks);
                    database.put(cid, bos.toByteArray());
                    System.out.println(message.toString());
                    in.close();
                    socket.close();
                    return;

                }else if (message.getOperation() == 4) {
                    ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                    out.writeObject("Tarefas apagadas:\n"+tasks.toString());
                    database.remove(cid);
                    System.out.println(message.toString());
                    in.close();
                    socket.close();
                    return;

                }else if (message.getOperation() == 5) {
                    String value = tasks.get(task.getTitle());
                    if(value == null) {
                        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                        out.writeObject("Tarefa não encontrada!");
                        out.close();
                    }else{
                        tasks.remove(task.getTitle());
                        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                        out.writeObject("Tarefa removida com sucesso!");
                        out.close();
                    }
                    oos.writeObject(tasks);
                    database.put(cid, bos.toByteArray());
                    System.out.println(message.toString());

                    in.close();
                    socket.close();
                    return;

                }else if (message.getOperation() == 0) {
                    ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                    out.writeObject("Obrigado!");
                    out.close();
                    in.close();
                    socket.close();

                    Thread.currentThread().interrupt();
                    return;
                }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    Hashtable getTasks(BigInteger cid) {
        byte[] task = database.get(cid);
        try {
            if (task == null || task.length == 0) {
                return new Hashtable();
            } else {
                ByteArrayInputStream in = new ByteArrayInputStream(task);
                ObjectInputStream is = new ObjectInputStream(in);
                return (Hashtable) is.readObject();
            }
        }catch (Exception e){
            System.out.println("Failed to get tasks: "+e.getMessage());
            e.printStackTrace();
        }
        return new Hashtable();

    }

}