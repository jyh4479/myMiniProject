package com.jplan.memberserver.database;

import com.jplan.memberserver.controllers.MemberController;
import com.jplan.memberserver.services.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MemberController.class)
public class MemberControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    MemberService memberService;

    @Test
    public void MemberControllerResponseTest() throws Exception {
        mvc.perform(get("/jplan/memberservice/member").param("id", "jyh4479"))
                .andExpect(status().isOk());
    }
}
