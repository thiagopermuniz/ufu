package clients.admin;

import grpc.AdminGrpc;
import grpc.Request;
import grpc.Response;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.math.BigInteger;
import java.util.Scanner;

public class AdminClient {
    static String welcomeMessage = "Bem vindo ao Portal de Administrador, digito o numero do comando desejado:\n";
    static String menu =    "1 Inserir Cliente\n" +
            "2 Modificar Cliente\n" +
            "3 Recuperar Cliente\n" +
            "4 Apagar Cliente\n" +
            "0 Sair\n" +
            ">>";


    public static void main(String[] args) {

        ManagedChannel channel =
                ManagedChannelBuilder.forAddress("localhost",9090).usePlaintext().build();
        AdminGrpc.AdminBlockingStub adminStub = AdminGrpc.newBlockingStub(channel);
        Request request = Request.newBuilder().setCid("123").setText("Thiago").build();
        Response response = adminStub.hello(request);
        System.out.println(response.getStatus());
        Scanner scanner = new Scanner(System.in);
        String tmp;
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
                        System.out.print("Digite o nome ou outro atributo único do cliente:\n>>");
                        tmp = scanner.nextLine();
                        BigInteger newCid = new BigInteger(tmp.getBytes());
                        System.out.println("CID: "+newCid);
                        break;
                    case 2:
                        System.out.print("Digite o CID do cliente que quer modificar:\n>>");
                        tmp = scanner.nextLine();
                        System.out.print("Digite os novos dados do cliente:\n>>");
                        tmp = scanner.nextLine();
                        break;
                    case 3:
                        System.out.print("Digite o CID do cliente que deseja buscar:\n>>");
                        tmp = scanner.nextLine();
                        break;
                    case 4:
                        System.out.print("Digite o CID da cliente que deseja apagar:\n>>");
                        tmp = scanner.nextLine();
                        break;
                }

                System.out.println("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
