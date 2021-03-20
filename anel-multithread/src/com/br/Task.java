package com.br;

import java.io.*;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicBoolean;
//CONNECTS TO A SERVER, RECEIVES MESSAGE AND RETURNS IT WITH THE FIRST LOWERCASE LETTER TO UPPERCASE, IF ANY.
class Task implements Runnable {
    //FLAGS USED TO HELP THREADS SYNC
    static AtomicBoolean flag = new AtomicBoolean(false);

    public synchronized boolean beingProcessed() {
        return flag.get();
    }

    public synchronized void hold() {
        flag.set(true);
    }

    public synchronized void free() {
        flag.set(false);
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (!beingProcessed()) {
                    //LOCKS EXECUTION
                    hold();
                    Socket clientSocket = new Socket("localhost", 12345);
                    InputStreamReader in = new InputStreamReader(clientSocket.getInputStream());
                    BufferedReader br = new BufferedReader(in);
                    String message;
                    boolean changed  = false;
                    //READS FROM SERVER
                    while ((message = br.readLine())!=null) {
                        if(message.length() != 0) {
                            System.out.println(message);
                            //PROCESS THE MESSAGE
                            char text[] = message.toCharArray();
                            for (int i = 0; i < text.length; i++) {
                                if (Character.isLowerCase(text[i])) {
                                    text[i] = Character.toUpperCase(text[i]);
                                    message = (new String(text));
                                    //FLAG AS CHANGED MESSAGE
                                    changed = true;
                                    break;
                                }
                            }
                            //WRITES BACK TO SERVER
                            PrintWriter pw = new PrintWriter(clientSocket.getOutputStream());
                            pw.println(message);
                            pw.flush();
                            pw.close();
                            Thread.sleep(1000l);
                            break;
                        }
                    }
                    br.close();
                    in.close();
                    clientSocket.close();
                    //UNLOCKS EXECUTION
                    free();

                    //INTERRUPTS THREAD IN CASE NOTHING CHANGED IN THE MESSAGE
                    if(!changed){
                        Thread.currentThread().interrupt();
                        return;
                    }
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

