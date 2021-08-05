package com.javainuse.controller;

import com.javainuse.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("producer")
@Slf4j
public class ItemController {

    @Autowired
    KafkaTemplate<String, Message> KafkaJsontemplate;
    String TOPIC_NAME = "AWSKafkaTutorialTopic";

    @PostMapping(value = "/postItem")
    public String postJsonMessage(@RequestBody Message message){
        log.info("Recieved");
        KafkaJsontemplate.send(TOPIC_NAME,new Message(message.getId(),message.getTitle(),message.getMessage()));
        return "Message published successfully";
    }
}
