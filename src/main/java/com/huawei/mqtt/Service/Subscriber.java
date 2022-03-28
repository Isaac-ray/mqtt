package com.huawei.mqtt.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.eclipse.paho.client.mqttv3.*;
import java.sql.Timestamp;

public class Subscriber extends Connector {

	private static final Logger logger = LoggerFactory.getLogger(Subscriber.class);

	public String subscribeTopic(String topic) {
		try {
			mqttClient.subscribe(topic);
		} catch (MqttException me) {
			logger.error("error: ", me.getMessage());
		}
		return "Subscribed!";
	}

	@Override
	public void messageArrived(String topic, MqttMessage message) throws Exception {
		// Called when a message arrives from the server that matches any subscription
		// made by the client
		String time = new Timestamp(System.currentTimeMillis()).toString();
		System.out.println();
		System.out.println("***********************************************************************");
		System.out.println("消息到达时间：" + time + "\nTopic: " + topic + "\nMessage: "
				+ new String(message.getPayload()));
		System.out.println("***********************************************************************");
		System.out.println();
	};
}
