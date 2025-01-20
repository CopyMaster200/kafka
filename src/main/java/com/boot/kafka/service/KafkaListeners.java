package com.boot.kafka.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaListeners {

    @Value("${kafka.topic}")
    private String kafkaTopic;

    @KafkaListener(
            topics = {"#{@environment.getProperty('kafka.topic')}"},
            groupId = "Group1"
    )
    void listener(String data) {
        System.out.println("Listener received: " + data + " 🎉");
    }
}
