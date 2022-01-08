package com.jplan.memberserver.database;

import com.jplan.memberserver.entities.Member;
import com.jplan.memberserver.repositories.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

//https://github.com/jojoldu/freelec-springboot2-webservice/issues/78 --> test code 설정 참고
//https://memostack.tistory.com/195 --> Repository Test 관련 참고
//https://happyer16.tistory.com/entry/Spring-Boot-Test-%EC%A2%85%ED%95%A9-%EC%A0%95%EB%A6%AC --> 테스트 코드 동작 성공 관련 블로그

@DataJpaTest
//@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MemberConnectionTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    @DisplayName("Database connection test")
    public void getOneMember() {
        Member member = Member.builder()
                .id("jyh4479")
                .name("정용훈")
                .phone("01041331927")
                .email("qpal415@gmail.com")
                .birth("1996.03.15")
                .password("1234")
                .membership("normal")
                .build();

        Member testMember = memberRepository.getById("jyh4479");

        assertNotNull(testMember);
        assertNotSame(member, testMember);
        assertEquals(member.getName(), testMember.getName());
    }
}
