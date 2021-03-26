package portal.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable{

    private String welcomeMessage = "Bem vindo ao Portal, use os comandos:\n" +
            "inserirTarefa(CID, \"titulo da tarefa\", \"descrição da tarefa\")\n" +
            "modificarTarefa(CID, \"titulo da tarefa\", \"nova descrição da tarefa\")\n" +
            "starTarefas(CID)\n" +
            "apagarTarefas(CID)\n" +
            "apagarTarefa(CID, \"titulo da tarefa\")\n" +
            "sair()\n" +
            ">>";

    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    public Socket getSocket() {
        return socket;
    }

    public String getWelcomeMessage(){
        return this.welcomeMessage;
    }

    @Override
    public void run() {
        try {
            PrintWriter pw = new PrintWriter(this.getSocket().getOutputStream());
            InputStreamReader in = new InputStreamReader(this.getSocket().getInputStream());
            BufferedReader br = new BufferedReader(in);
            pw.print(this.getWelcomeMessage());
            pw.flush();
            String message;
            while(true) {
                while ((message = br.readLine()) != null) {
                    if (message.length() != 0) {
                        System.out.println("Received message: "+message);
                        pw.print("Received: " + message + "\n" +
                                ">>");
                        pw.flush();
                        break;
                    }
                }
                if ("sair()".equals(message)) {
                    pw.print("Obrigado e volte sempre!\n");
                    pw.flush();
                    Thread.currentThread().interrupt();
                    br.close();
                    in.close();
                    pw.close();
                    this.getSocket().close();
                    return;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
