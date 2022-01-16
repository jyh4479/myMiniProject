package com.jplan.kafkachatserver.controllers;

import com.jplan.kafkachatserver.dto.Member;
import com.jplan.kafkachatserver.services.ChattingRoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/kafka")
public class ChattingRoomController {

    private final ChattingRoomService chattingRoomService;


//    @PostMapping(value = "/test")
//    public void createChattingRoom(@RequestBody NewChattingRoomInfo newChattingRoomInfo) {
//        try {
//            log.info("new Chatting room info : " + newChattingRoomInfo);
//            chattingRoomService.createChattingRoom(newChattingRoomInfo);
//        } catch (Exception e) {
//            log.info("create error");
//        } finally {
//            log.info("logic finish");
//        }
//    }

    @PostMapping(value = "/chatroom")
    public ResponseEntity<?> addChatRoom(@RequestBody List<Member> memberList) {
        log.info("run addChatRoom in Controller");
        log.info("run addChatRoom in Controller " + memberList);

        try {
            chattingRoomService.createChattingRoom(memberList);
            return new ResponseEntity<>(null, null, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
