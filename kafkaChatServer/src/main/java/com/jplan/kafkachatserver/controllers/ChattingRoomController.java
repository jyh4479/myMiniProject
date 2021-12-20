package com.jplan.kafkachatserver.controllers;

import com.jplan.kafkachatserver.services.ChattingRoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/jplan/chatroom")
public class ChattingRoomController {
    private final ChattingRoomService chattingRoomService;

    @PostMapping(value = "/test")
    public void createChattingRoom() {
        try {
            log.info("create run");
            chattingRoomService.createChattingRoom();
            log.info("create success");
        } catch (Exception e) {
            log.info("create error");
        } finally {
            log.info("logic finish");
        }
    }
}
