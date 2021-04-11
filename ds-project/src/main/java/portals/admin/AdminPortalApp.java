package portals.admin;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import java.math.BigInteger;
import java.util.Hashtable;
import java.util.UUID;

public class AdminPortalApp {

    static Hashtable<BigInteger, byte[]> usersDatabase = new Hashtable();

    public static void main(String[] args) {
        try {
            System.out.println("Admin Portal Server started at port 12345");
            int i = 0;
            while (true) {
                BigInteger cid = BigInteger.valueOf(1234);
                String customerData = "Thiago "+i;
                usersDatabase.put(cid, customerData.getBytes());
                try {
                    MqttClient mqttClient = new MqttClient("tcp://localhost:1883", UUID.randomUUID().toString(), new MemoryPersistence());
                    MqttMessage message = new MqttMessage((cid.toString()+"|"+customerData).getBytes());
                    System.out.println("Writting: "+message.toString());
                    mqttClient.connect();
                    message.setQos(2);
                    mqttClient.publish("Customer Accounts", message);
                    mqttClient.disconnect();

                    i++;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Thread.sleep(60000l);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
