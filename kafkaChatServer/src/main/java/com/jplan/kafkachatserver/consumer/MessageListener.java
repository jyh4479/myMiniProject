package com.jplan.kafkachatserver.consumer;

import com.jplan.kafkachatserver.constants.KafkaConstants;
import com.jplan.kafkachatserver.entities.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageListener {

    @Autowired
    SimpMessagingTemplate template;

    @KafkaListener(
            topics = KafkaConstants.KAFKA_TOPIC,
            groupId = KafkaConstants.GROUP_ID
    )
    public void listen(Message message) {
        log.info("sending via kafka listener..");
        Long check = message.getFrom();
        log.info(String.valueOf(check));
        //해당 경로를 다이나믹하게 바꾸자
        template.convertAndSend("/topic/group/" + message.getFrom(), message);
    }
}
