package com.jplan.authorizationserver.services;

import com.jplan.authorizationserver.entities.Member;
import com.jplan.authorizationserver.repositories.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final MemberRepository memberRepository;

    public boolean memberCheck(String id, String password) {

        Member member = memberRepository.findById(id).orElse(null); //ID 조회
        /* 비밀번호 encode, decode 작업 추가 요망 */
        return member != null && member.getPassword().equals(password);
    }

    public Member loadOneMember(String id) {
        return memberRepository.findById(id).orElseThrow(/* 사용자 정의 에러 */);
    }

    public List<Member> loadListMember() {
        return memberRepository.findAll();
    }
}