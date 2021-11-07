package com.jplan.memberserver.database;

import com.jplan.memberserver.entities.Member;
import com.jplan.memberserver.repositories.MemberRepository;
import lombok.extern.java.Log;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

//https://github.com/jojoldu/freelec-springboot2-webservice/issues/78 --> test code 설정 참고
//https://memostack.tistory.com/195 --> Repository Test 관련 참고

@Log
@ExtendWith(SpringExtension.class)
@DataJpaTest
public class MemberConnectionTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void getOneMember() {
        Member member = memberRepository.getById("jyh4479");

        Assertions.assertEquals(member.getId(), "jyh4479");
    }
}
