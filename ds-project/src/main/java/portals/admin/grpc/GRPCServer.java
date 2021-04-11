package portals.admin.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import portals.admin.AdminPortalApp;

import java.io.IOException;

public class GRPCServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(9090).addService(new AdminPortalApp()).build();
        server.start();
        System.out.println("Admin GRPC Server started at "+server.getPort());
        server.awaitTermination();
    }

}
