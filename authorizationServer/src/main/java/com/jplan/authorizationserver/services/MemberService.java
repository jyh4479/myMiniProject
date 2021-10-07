package com.jplan.authorizationserver.services;

import com.jplan.authorizationserver.entities.Member;
import com.jplan.authorizationserver.repositories.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final MemberRepository memberRepository;

    public boolean memberCheck(String id, String password) {

        Member member = memberRepository.findById(id).orElse(null); //ID 조회

        if (member == null) return false; //ID가 없는 경우

        /* 비밀번호 encode, decode 작업 추가 요망 */

        return member.getPassword().equals(password); //비밀번호가 불일치하는 경우
    }
}