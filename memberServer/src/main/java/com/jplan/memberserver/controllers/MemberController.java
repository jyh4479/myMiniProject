package com.jplan.memberserver.controllers;

import com.jplan.memberserver.dto.AddFriendInfo;
import com.jplan.memberserver.dto.NewChattingRoomInfo;
import com.jplan.memberserver.entities.Member;
import com.jplan.memberserver.services.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log
@RestController
@RequestMapping("/jplan/memberservice")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/member")
    public Member getMemberData(@RequestParam("id") String id) {
        log.info("run getmemberData");
        return memberService.getMemberData(id);
    }

    @PostMapping("/friend")
    public ResponseEntity<?> addFriend(@RequestBody AddFriendInfo addFriendInfo) {
        log.info("run addFriend");
        try {
            memberService.addFriend(addFriendInfo);
        } catch (Exception e) {
            log.warning("catch error in addFriend controller");
            return new ResponseEntity<>(null, null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(null, null, HttpStatus.OK);
    }

    @PostMapping("/chattingroom")
    public ResponseEntity<?> WebClientTest(@RequestBody NewChattingRoomInfo newChattingRoomInfo) {
        log.info("member server get id from chat server!" + newChattingRoomInfo);
        return new ResponseEntity<>(newChattingRoomInfo, null, HttpStatus.NOT_FOUND);
    }
}
