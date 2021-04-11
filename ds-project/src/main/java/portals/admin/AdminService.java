package portals.admin;

import grpc.Request;
import grpc.Response;
import io.grpc.stub.StreamObserver;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import java.math.BigInteger;
import java.util.Hashtable;
import java.util.UUID;

public class AdminService extends grpc.AdminGrpc.AdminImplBase {

    static Hashtable<BigInteger, byte[]> usersDatabase = new Hashtable();

    @Override
    public void insertCustomer(Request request, StreamObserver<Response> responseObserver) {
        MqttClient mqttClient = null;
        byte[] data = usersDatabase.get(new BigInteger(request.getCid()));
        if(data != null && data.length > 0) {
            Response.Builder response = Response.newBuilder();
            response.setResponse("Cliente já existe");
            responseObserver.onNext(response.build());
            responseObserver.onCompleted();
        }else {
            usersDatabase.put(new BigInteger(request.getCid()), request.getCustomerData().getBytes());
        }

        try {
            mqttClient = new MqttClient("tcp://localhost:1883", UUID.randomUUID().toString(), new MemoryPersistence());
            MqttMessage message = new MqttMessage((request.getCid()+"|"+request.getCustomerData()).getBytes());
            System.out.println("Writting: "+message.toString());
            mqttClient.connect();
            message.setQos(2);
            mqttClient.publish("Customer Accounts", message);
            mqttClient.disconnect();
            Response.Builder response = Response.newBuilder();
            response.setResponse("Sucesso");
            responseObserver.onNext(response.build());
            responseObserver.onCompleted();

        } catch (MqttException e) {
            Response.Builder response = Response.newBuilder();
            response.setResponse("Falha");
            responseObserver.onNext(response.build());
            responseObserver.onCompleted();
            e.printStackTrace();
        }
    }

    @Override
    public void modifyCustomer(Request request, StreamObserver<Response> responseObserver) {
        MqttClient mqttClient = null;
        byte[] data = usersDatabase.get(new BigInteger(request.getCid()));
        if(data == null) {
            Response.Builder response = Response.newBuilder();
            response.setResponse("Cliente não encontrado");
            responseObserver.onNext(response.build());
            responseObserver.onCompleted();
        }else{
            usersDatabase.put(new BigInteger(request.getCid()), request.getCustomerData().getBytes());
        }

        try {
            mqttClient = new MqttClient("tcp://localhost:1883", UUID.randomUUID().toString(), new MemoryPersistence());
            MqttMessage message = new MqttMessage((request.getCid()+"|"+request.getCustomerData()).getBytes());
            System.out.println("Writting: "+message.toString());
            mqttClient.connect();
            message.setQos(2);
            mqttClient.publish("Customer Accounts", message);
            mqttClient.disconnect();
            Response.Builder response = Response.newBuilder();
            response.setResponse("Sucesso");
            responseObserver.onNext(response.build());
            responseObserver.onCompleted();

        } catch (MqttException e) {
            Response.Builder response = Response.newBuilder();
            response.setResponse("Falha");
            responseObserver.onNext(response.build());
            responseObserver.onCompleted();
            e.printStackTrace();
        }
    }

    @Override
    public void queryCustomer(Request request, StreamObserver<Response> responseObserver) {
        byte[] data = usersDatabase.get(new BigInteger(request.getCid()));
        try {
            if (data == null) {
                Response.Builder response = Response.newBuilder();
                response.setResponse("Cliente não encontrado");
                responseObserver.onNext(response.build());
                responseObserver.onCompleted();
            } else {
                Response.Builder response = Response.newBuilder();
                response.setResponse(new String(data));
                responseObserver.onNext(response.build());
                responseObserver.onCompleted();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCustomer(Request request, StreamObserver<Response> responseObserver) {
        MqttClient mqttClient = null;
        byte[] data = usersDatabase.get(new BigInteger(request.getCid()));
        if(data == null) {
            Response.Builder response = Response.newBuilder();
            response.setResponse("Cliente não encontrado");
            responseObserver.onNext(response.build());
            responseObserver.onCompleted();
        }else{
            usersDatabase.remove(new BigInteger(request.getCid()));
        }

        try {
            mqttClient = new MqttClient("tcp://localhost:1883", UUID.randomUUID().toString(), new MemoryPersistence());
            MqttMessage message = new MqttMessage((request.getCid()).getBytes());
            System.out.println("Writting: "+message.toString());
            mqttClient.connect();
            message.setQos(2);
            mqttClient.publish("Customer Accounts", message);
            mqttClient.disconnect();
            Response.Builder response = Response.newBuilder();
            response.setResponse("Sucesso");
            responseObserver.onNext(response.build());
            responseObserver.onCompleted();

        } catch (MqttException e) {
            Response.Builder response = Response.newBuilder();
            response.setResponse("Falha");
            responseObserver.onNext(response.build());
            responseObserver.onCompleted();
            e.printStackTrace();
        }
    }
}
