package com.br;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
//SIMPLE TCP SERVER
public class Server {

    //STORAGE
    private static String message;

    public static String getMessage() {
        return message;
    }

    public static void setMessage(String message) {
        Server.message = message;
    }
    //GENERATES RANDOM CASE STRING
    static String generateMessage() {
        String alphbt = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
        StringBuilder sb = new StringBuilder();
        Random r = new Random();
        while (true) {
            sb.append(alphbt.charAt(r.nextInt(alphbt.length())));
            if (sb.length() > 80)
                break;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        try {
            boolean firstTime = true;
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Server started at port 12345");
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Connected: "+clientSocket.getInetAddress().getHostAddress() +":"+ clientSocket.getPort());
                PrintWriter pw = new PrintWriter(clientSocket.getOutputStream());
                //GENERATE MESSAGE WHEN FIRST CLIENT COMES IN
                if(firstTime){
                    pw.println(generateMessage());
                    firstTime = false;
                //SENDS LAST STORED MESSAGE
                }else{
                    pw.println(getMessage());
                }
                pw.flush();

                //READS AND SETS NEW MESSAGE
                InputStreamReader in = new InputStreamReader(clientSocket.getInputStream());
                BufferedReader br = new BufferedReader(in);
                String message;
                while ((message = br.readLine())!=null) {
                    if(message.length() != 0) {
                        System.out.println("Client message: " + message);
                        setMessage(message);
                        break;
                    }
                }
                br.close();
                in.close();
                pw.close();
                clientSocket.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
