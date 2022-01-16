package com.jplan.memberserver.services;

import com.jplan.memberserver.dto.NewChattingRoomInfo;
import com.jplan.memberserver.repositories.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Log
@Service
@RequiredArgsConstructor
public class ChattingService {
    private final MemberRepository memberRepository;

    @Transactional(rollbackFor = Exception.class)
    public void addChattingRoom(NewChattingRoomInfo newChattingRoomInfo) {
        log.info("Hi");
        log.info("HI " + newChattingRoomInfo);
    }

    public void testPrint(){
        log.info("HIHI");
    }
}
