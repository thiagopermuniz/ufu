package clients.admin;

import grpc.AdminGrpc;
import grpc.Request;
import grpc.Response;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

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

        Scanner scanner = new Scanner(System.in);
        String data;
        String cid;
        try {
            System.out.print(welcomeMessage);
            while(true) {
                System.out.print(menu);
                int option = scanner.nextInt();
                scanner.nextLine();
                AdminGrpc.AdminBlockingStub adminStub = AdminGrpc.newBlockingStub(channel);
                switch (option) {
                    case 0:
                        System.out.println("Saindo do sistema...");
                        return;
                    case 1:
                        System.out.print("Digite o CID do cliente:\n>>");
                        cid = scanner.nextLine();
                        System.out.print("Digite o nome ou outro atributo único do cliente:\n>>");
                        data = scanner.nextLine();

                        Request createRequest = Request.newBuilder().setCid(cid).setData(data).build();
                        Response createResponse = adminStub.insertCustomer(createRequest);
                        System.out.println(createResponse.getResponse());
                        break;
                    case 2:
                        System.out.print("Digite o CID do cliente que quer modificar:\n>>");
                        cid = scanner.nextLine();
                        System.out.print("Digite os novos dados do cliente:\n>>");
                        data = scanner.nextLine();

                        Request modifyRequest = Request.newBuilder().setCid(cid).setData(data).build();
                        Response modifyResponse = adminStub.modifyCustomer(modifyRequest);
                        System.out.println(modifyResponse.getResponse());
                        break;
                    case 3:
                        System.out.print("Digite o CID do cliente que deseja buscar:\n>>");
                        cid = scanner.nextLine();

                        Request queryRequest = Request.newBuilder().setCid(cid).build();
                        Response queryResponse = adminStub.queryCustomer(queryRequest);
                        System.out.println(queryResponse.getResponse());
                        break;
                    case 4:
                        System.out.print("Digite o CID da cliente que deseja apagar:\n>>");
                        cid = scanner.nextLine();

                        Request delRequest = Request.newBuilder().setCid(cid).build();
                        Response delResponse = adminStub.deleteCustomer(delRequest);
                        System.out.println(delResponse.getResponse());
                        break;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
