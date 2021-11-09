package com.jplan.memberserver.database;

import com.jplan.memberserver.entities.Member;
import com.jplan.memberserver.repositories.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

//https://github.com/jojoldu/freelec-springboot2-webservice/issues/78 --> test code 설정 참고
//https://memostack.tistory.com/195 --> Repository Test 관련 참고
//https://happyer16.tistory.com/entry/Spring-Boot-Test-%EC%A2%85%ED%95%A9-%EC%A0%95%EB%A6%AC --> 테스트 코드 동작 성공 관련 블로그

@DataJpaTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MemberConnectionTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void getOneMember() {
        Member member = memberRepository.getById("jyh4479");
        Assertions.assertEquals("jyh4479", member.getId());
        Assertions.assertEquals(1, 1);
    }
}
