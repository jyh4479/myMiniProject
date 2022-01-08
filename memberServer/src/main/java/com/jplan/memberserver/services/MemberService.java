package com.jplan.memberserver.services;

import com.jplan.memberserver.dto.AddFriendInfo;
import com.jplan.memberserver.entities.Member;
import com.jplan.memberserver.repositories.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Log
@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member getMemberData(String id) throws Exception {
        try {
            return memberRepository.getById(id);
        } catch (Exception e) {
            throw new Exception("Repository error");
        }

    }

    @Transactional(rollbackOn = Exception.class)
    public void addFriend(AddFriendInfo addFriendInfo) {
        log.info(addFriendInfo.getFriendId());
        log.info(addFriendInfo.getMemberId());
    }
}
