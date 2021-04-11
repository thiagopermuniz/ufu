package portals.admin;


import grpc.AdminGrpc;
import grpc.Request;
import grpc.Response;
import io.grpc.stub.StreamObserver;

public class AdminService extends AdminGrpc.AdminImplBase {

    @Override
    public void hello(Request request, StreamObserver<Response> responseObserver) {
        System.out.println("Hello");
        String cid = request.getCid();
        String text = request.getText();

        Response.Builder response =  Response.newBuilder();
        response.setStatus("Sucesso");

        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }
}
