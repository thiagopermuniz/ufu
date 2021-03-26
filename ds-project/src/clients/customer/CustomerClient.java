package clients.customer;

import portals.customer.model.Message;
import portals.customer.model.Task;

import java.io.*;
import java.math.BigInteger;
import java.net.Socket;

public class CustomerClient {
    public static void main(String[] args) {
        try {
            Socket clientSocket = new Socket("localhost", 12345);
            ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
            Message message = new Message(1, new BigInteger("123", 5), new Task("titulo", "descricao"));
            out.writeObject(message);
            out.flush();
            out.close();
            clientSocket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
