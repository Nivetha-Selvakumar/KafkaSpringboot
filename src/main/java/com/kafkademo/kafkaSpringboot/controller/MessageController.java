package com.kafkademo.kafkaSpringboot.controller;


import com.kafkademo.kafkaSpringboot.kafka.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kafka")
public class MessageController {
//    private KafkaProducer kafkaProducer;
//
//    public MessageController(KafkaProducer kafkaProducer){
//        this.kafkaProducer =kafkaProducer;
//    }

    @Autowired
    KafkaProducer kafkaProducer;

    @GetMapping("/publish")
    public ResponseEntity<String> pubish(@RequestParam("message") String message){
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent to the topic");
    }

}
