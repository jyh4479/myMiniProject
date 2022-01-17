package com.jplan.memberserver.controllers;

import com.jplan.memberserver.dto.NewChattingRoomInfo;
import com.jplan.memberserver.services.ChattingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log
@RestController
@RequestMapping("/jplan/memberservice")
@RequiredArgsConstructor
public class ChattingController {

    private final ChattingService chattingService;

    @PostMapping("/chattingroom")
    public ResponseEntity<?> WebClientTest(@RequestBody NewChattingRoomInfo newChattingRoomInfo) throws ParseException {
        log.info("member server get id from chat server!" + newChattingRoomInfo);
        try {
            chattingService.addChattingRoom(newChattingRoomInfo);
            return new ResponseEntity<>(true, null, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(false, null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
