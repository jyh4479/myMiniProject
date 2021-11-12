package com.jplan.memberserver.services;

import com.jplan.memberserver.entities.Member;
import com.jplan.memberserver.repositories.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    MemberRepository memberRepository;

    public Member getMemberData(String id) {
        return memberRepository.getById(id);
    }
}
