package com.kafkademo.kafkaSpringboot.kafka;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class KafkaProducer {

    private static final Logger log = LoggerFactory.getLogger(KafkaProducer.class);

//    private KafkaTemplate<String,String> kafkaTemplate;
//
//    public  KafkaProducer(KafkaTemplate <String,String> kafkaTemplate){
//        this.kafkaTemplate  = kafkaTemplate;
//    }

    @Autowired
    KafkaTemplate<String,String> kafkaTemplate;

    public void sendMessage(String message){
        log.info(String.format("Message sent %s",message));
        kafkaTemplate.send("kafkaTopic",message);
    }

}
