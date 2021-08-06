package com.javainuse.controller;

import com.javainuse.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("producer")
@Slf4j
public class ItemController {

    @Autowired
    KafkaTemplate<String, Message> KafkaJsontemplate;
    String TOPIC_NAME = "AWSKafkaTutorialTopic";

    @GetMapping
    public String postJsonMessage(@RequestParam("id") int id, @RequestParam("eventTitle") String eventTitle,
                                  @RequestParam(value = "eventMessage", required = false) String eventMessage){
        log.info("Recieved");
        KafkaJsontemplate.send(TOPIC_NAME,new Message(id,eventTitle,eventMessage));
        return "Message published successfully";
    }
}
