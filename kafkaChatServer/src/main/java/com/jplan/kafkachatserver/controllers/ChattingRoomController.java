package com.jplan.kafkachatserver.controllers;

import com.jplan.kafkachatserver.dto.NewChattingRoomInfo;
import com.jplan.kafkachatserver.services.ChattingRoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;

@Log
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/jplan/chatroom")
public class ChattingRoomController {

    private final ChattingRoomService chattingRoomService;


    @PostMapping(value = "/test")
    public void createChattingRoom(@RequestBody NewChattingRoomInfo newChattingRoomInfo) {
        try {
            log.info("new Chatting room info : " + newChattingRoomInfo);
            chattingRoomService.createChattingRoom(newChattingRoomInfo);
        } catch (Exception e) {
            log.info("create error");
        } finally {
            log.info("logic finish");
        }
    }
}
