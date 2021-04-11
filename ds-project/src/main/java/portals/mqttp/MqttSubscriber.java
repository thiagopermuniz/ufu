package portals.mqttp;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import java.math.BigInteger;
import java.util.Hashtable;

public class MqttSubscriber implements MqttCallback {

    MqttClient client;
    Hashtable<BigInteger, byte[]> usersDatabase;
    public MqttSubscriber(Hashtable<BigInteger, byte[]> usersDatabase) {
        this.usersDatabase = usersDatabase;
    }

    public void doTheThing() {
        try {
            client = new MqttClient("tcp://localhost:1883", "Subscriber");
            client.connect();
            client.setCallback(this);
            client.subscribe("Customer Accounts");
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void connectionLost(Throwable cause) {

    }

    @Override
    public void messageArrived(String topic, MqttMessage message) {
        try {
            System.out.println("Message from topic " + topic + " received: \"" + message.toString() + "\"");
            String[] values = message.toString().split("\\|");
            BigInteger cid = new BigInteger(values[0]);
            usersDatabase.put(cid, values[1].getBytes());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {

    }

}