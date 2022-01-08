package com.jplan.memberserver.total;


import lombok.extern.java.Log;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Log
@SpringBootTest
@AutoConfigureMockMvc
public class GetMemberInfo {

    @Autowired
    MockMvc mvc;

//    @Autowired
//    MemberController memberController;

    @Test
    @DisplayName("Get One Member Controller Test")
    public void MemberControllerResponseTest() throws Exception {


        MvcResult result = mvc.perform(get("/jplan/memberservice/member")
                .param("id", "jyh4479"))
                .andExpect(status().isOk())
                .andReturn();

        String content = result.getResponse().getContentAsString();

        log.info(content);
    }
}
