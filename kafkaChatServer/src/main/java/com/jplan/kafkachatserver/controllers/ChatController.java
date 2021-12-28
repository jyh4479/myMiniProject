package com.jplan.kafkachatserver.controllers;

import com.jplan.kafkachatserver.constants.KafkaConstants;
import com.jplan.kafkachatserver.entities.Message;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Log
@CrossOrigin
@RestController
@RequestMapping(value = "/kafka")
public class ChatController {
    @Autowired
    private KafkaTemplate<String, Message> kafkaTemplate;

//    @Autowired
//    private KafkaTemplate<String, String> kafkaTestTemplate;

    //--> 클라이언트 -> 서버 -> 카프카에 PUSH
    @PostMapping(value = "/publish")
    public void sendMessage(@RequestBody Message message) {
        log.info("Produce message : " + message.toString());
        message.setTimestamp(LocalDateTime.now().toString());

        //해당 부분에서 받은 메세지가 누구로부터 왔고 어떤 was(서버)에 접속한 사용자들에게 전달되어야하는지 판단해야한다고 생각
        try {
            //현재는 한가지 토픽만 있으므로 아래와같은 코드로 동작
            kafkaTemplate.send(KafkaConstants.KAFKA_TOPIC, message).get();
//            kafkaTemplate.send("PUSHTEST", message).get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

//    @PostMapping(value = "/createTopic")
//    public void createTopic() {
//        try {
////            kafkaTemplate;
//            System.out.println("HI");
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }

//    @PostMapping(value = "/test")
//    public void sendTestSignal() {
//        log.info("Call Test Controller");
//        try {
//            kafkaTestTemplate.send(KafkaConstants.KAFKA_TOPIC, "TestMessage!").get();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }

//    @MessageMapping("/sendMessage")
//    @SendTo("/topic/group")
//    public Message broadcastGroupMessage(@Payload Message message) {
//        log.info("send message check!");
//        return message;
//    }


}
