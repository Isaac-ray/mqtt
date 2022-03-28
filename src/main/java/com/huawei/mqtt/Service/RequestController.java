package com.huawei.mqtt.Service;

import java.util.Map;

import org.springframework.web.bind.annotation.*;

@RestController
public class RequestController {

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    /**
     * 连接broker
     * 
     * @param name
     * @return
     */
    @RequestMapping("/connect")
    public String connect(@RequestBody Map<String, String> map) {
        Connector connector = new Connector();
        return connector.connect(map);
    };

    /**
     * 订阅topic主题
     * 
     * @param topic
     */
    @GetMapping("subscribe-{topic}")
    public String subscribeTopic(@PathVariable(value = "topic") String topic) {
        Subscriber subscriber = new Subscriber();
        return subscriber.subscribeTopic(topic);
    };

    /**
     * 发布消息
     *
     * @param topic   主题
     * @param message 消息
     */
    @GetMapping("")
    public void publishMessage(String topic, String message) {

    };
}
