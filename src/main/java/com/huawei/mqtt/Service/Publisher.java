package com.huawei.mqtt.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.eclipse.paho.client.mqttv3.*;

public class Publisher extends Connector {

    private static final Logger logger = LoggerFactory.getLogger(Subscriber.class);

    /**
     * 发布消息
     *
     * @param topic   主题
     * @param message 消息
     */
    public void publishMessage(String topic, String message) {

    };

}
