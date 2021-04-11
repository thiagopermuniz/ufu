package portals.customer;

import portals.mqttp.MqttSubscriber;

import java.math.BigInteger;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Hashtable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CustomerPortalApp {

    static Hashtable<BigInteger, byte[]> usersDatabase = new Hashtable();
    static Hashtable<BigInteger, byte[]> tasksDatabase = new Hashtable();

    public static void main(String[] args) {
        MqttSubscriber subscriber = new MqttSubscriber(usersDatabase);
        try {
            subscriber.doTheThing();
            ExecutorService executor = Executors.newFixedThreadPool(1);
            ServerSocket serverSocket = new ServerSocket(12345);
            CustomerHandler customerHandler;
            System.out.println("Client Portal Server started at port 12345");
            while (true) {
                Socket clientSocket = serverSocket.accept();
                customerHandler = new CustomerHandler(clientSocket, tasksDatabase, usersDatabase);
                executor.submit(customerHandler);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
