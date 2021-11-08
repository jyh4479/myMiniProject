package com.jplan.memberserver;

import com.jplan.memberserver.database.MemberConnectionTest;
import com.jplan.memberserver.repositories.MemberRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestConstructor;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;


@SpringBootTest
//@WebAppConfiguration
class MemberServerApplicationTests {

    @Autowired
    private MemberConnectionTest memberConnectionTest;

    @Test
    void contextLoads() {

    }

}
