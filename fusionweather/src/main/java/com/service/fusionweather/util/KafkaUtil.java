package com.service.fusionweather.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaUtil {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void send(String topic, String msg) {
        kafkaTemplate.send(topic, msg);
    }
}
