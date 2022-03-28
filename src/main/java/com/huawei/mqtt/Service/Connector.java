package com.huawei.mqtt.Service;

import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class Connector implements MqttCallback {

    private String clientId = "springClient";
    private String brokerUrl = "tcp://localhost:1883";
    private String username = "admin";
    private String password = "adminpsw";

    protected MqttClient mqttClient;
    protected MqttConnectOptions connectionOptions;
    protected MemoryPersistence persistence;

    private static final Logger logger = LoggerFactory.getLogger(Subscriber.class);

    public String connect(Map<String, String> map) {

        // if (map.containsKey("clientId") && map.containsKey("brokerUrl") &&
        // map.containsKey("username") && map.containsKey("password")) {
        // clientId = map.get(clientId);
        // brokerUrl = map.get(brokerUrl);
        // username = map.get(username);
        // password = map.get(password);
        // }

        // persistence = new MemoryPersistence();
        persistence = null;
        connectionOptions = new MqttConnectOptions();
        try {
            mqttClient = new MqttClient(brokerUrl, clientId, persistence);
            connectionOptions.setCleanSession(true);
            connectionOptions.setUserName(username);
            connectionOptions.setPassword(password.toCharArray());
            mqttClient.connect(connectionOptions);
            mqttClient.setCallback(this);
        } catch (Exception e) {
            return String.format("Connection failed: %s!", e.getMessage());
        }
        return String.format("Connected %s!", brokerUrl);
    }

    /**
     * 断开连接
     */
    public void disconnect() {
        try {
            mqttClient.disconnect();
        } catch (MqttException me) {
            logger.error("ERROR", me);
        }
    }

    @Override
    public void connectionLost(Throwable cause) {
        logger.info("Connection Lost");
        // try {
        // mqttClient.connect(connectionOptions);
        // mqttClient.setCallback(this);
        // } catch (Exception e) {
        // logger.error(String.format("Connection failed: %s!", e.getMessage()));
        // }
    };

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
        // Leave it blank for connector
    }

    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception {
        // Leave it blank for connector

    };
}