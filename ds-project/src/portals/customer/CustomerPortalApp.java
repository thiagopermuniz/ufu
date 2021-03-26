package portals.customer;

import java.math.BigInteger;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CustomerPortalApp {
    public static void main(String[] args) {
        Map<BigInteger, byte[]> database = new Hashtable<>();
        try {
            ExecutorService executor = Executors.newFixedThreadPool(1);
            ServerSocket serverSocket = new ServerSocket(12345);
            CustomerHandler customerHandler;
            System.out.println("Client Portal Server started at port 12345");
            while (true) {
                Socket clientSocket = serverSocket.accept();
                customerHandler = new CustomerHandler(clientSocket, database);
                System.out.println("New client at port " + clientSocket.getPort());
                executor.submit(customerHandler);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
