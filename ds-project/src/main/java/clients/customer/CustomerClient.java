package clients.customer;

import portals.customer.model.Message;
import portals.customer.model.Task;

import java.io.*;
import java.math.BigInteger;
import java.net.Socket;
import java.util.Scanner;

public class CustomerClient {
    static String welcomeMessage = "Bem vindo ao Portal de Clientes, digito o numero do comando desejado:\n";
    static String menu =    "1 Inserir Tarefa\n" +
                            "2 Modificar Tarefa\n" +
                            "3 Listar Tarefas\n" +
                            "4 Apagar Tarefas\n" +
                            "5 Apagar Tarefa\n" +
                            "0 Sair\n" +
                            ">>";


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Message message = new Message();
        String tmp;
        BigInteger cid;
        Task task = new Task();
        try {
            System.out.print(welcomeMessage);
            while(true) {
                System.out.print(menu);
                int option = scanner.nextInt();
                scanner.nextLine();
                switch (option) {
                    case 0:
                        System.out.println("Saindo do sistema...");
                        return;
                    case 1:
                        System.out.print("Digite o seu CID:\n>>");
                        cid = scanner.nextBigInteger();
                        scanner.nextLine();
                        message.setCid(cid);
                        System.out.print("Digite o título da tarefa:\n>>");
                        tmp = scanner.nextLine();
                        task.setTitle(tmp);
                        System.out.print("Digite a descricão da tarefa:\n>>");
                        tmp = scanner.nextLine();
                        task.setDescription(tmp);
                        message.setTask(task);
                        break;
                    case 2:
                        System.out.print("Digite o seu CID:\n>>");
                        cid = scanner.nextBigInteger();
                        scanner.nextLine();
                        message.setCid(cid);
                        System.out.print("Digite o título da tarefa que quer modificar:\n>>");
                        tmp = scanner.nextLine();
                        task.setTitle(tmp);
                        System.out.print("Digite a nova descricão da tarefa:\n>>");
                        tmp = scanner.nextLine();
                        task.setDescription(tmp);
                        message.setTask(task);
                        break;
                    case 3:
                        System.out.print("Digite o seu CID:\n>>");
                        cid = scanner.nextBigInteger();
                        scanner.nextLine();
                        message.setCid(cid);
                        System.out.println("Listando tarefas:");
                        break;
                    case 4:
                        System.out.print("Digite o seu CID:\n>>");
                        cid = scanner.nextBigInteger();
                        scanner.nextLine();
                        message.setCid(cid);
                        System.out.println("Apagando tarefas:");
                        break;
                    case 5:
                        System.out.print("Digite o seu CID:\n>>");
                        cid = scanner.nextBigInteger();
                        scanner.nextLine();
                        message.setCid(cid);
                        System.out.print("Digite o título da tarefa que deseja apagar:\n>>");
                        tmp = scanner.nextLine();
                        task.setTitle(tmp);
                        message.setTask(task);  
                        break;
                }
                message.setOperation(option);
                Socket clientSocket = new Socket("localhost", 12345);
                ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
                out.writeObject(message);
                Object obj;
                ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
                while ((obj = in.readObject()) != null) {
                    System.out.println("Resultado:\n"+(String) obj+"\n");
                    break;
                }
                out.close();
                clientSocket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
