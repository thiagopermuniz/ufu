package portal.client;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClientPortalApp {
    public static void main(String[] args) {
        try {
            ExecutorService executor = Executors.newFixedThreadPool(8);
            ServerSocket serverSocket = new ServerSocket(12345);
            ClientHandler clientHandler;
            System.out.println("Client Portal Server started at port 12345");
            while (true) {
                Socket clientSocket = serverSocket.accept();
                clientHandler = new ClientHandler(clientSocket);
                System.out.println("New client at port " + clientSocket.getPort());
                executor.submit(clientHandler);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
