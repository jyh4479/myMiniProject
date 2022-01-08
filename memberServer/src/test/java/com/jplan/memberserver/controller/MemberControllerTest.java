package com.jplan.memberserver.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jplan.memberserver.controllers.MemberController;
import com.jplan.memberserver.dto.AddFriendInfo;
import com.jplan.memberserver.entities.Member;
import com.jplan.memberserver.services.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MemberController.class)
public class MemberControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    MemberService memberService;

    @Test
    @DisplayName("Get One Member Controller Test")
    public void MemberControllerResponseTest() throws Exception {
        Member member = Member.builder()
                .id("mock")
                .name("mock")
                .phone("mock")
                .email("mock")
                .birth("mock")
                .password("mock")
                .membership("mock")
                .build();

//        when(memberService.getMemberData(anyString())).thenThrow(Exception.class);
        when(memberService.getMemberData(anyString())).thenReturn(member);

        mvc.perform(get("/jplan/memberservice/member")
                .param("id", "jyh4479"))
                .andExpect(status().isOk());

        verify(memberService).getMemberData("jyh4479");
    }

    @Test
    @DisplayName("Add friend Controller Test")
    public void AddFriendFunctionResponseTest() throws Exception {
        AddFriendInfo addFriendInfo = new AddFriendInfo();
        addFriendInfo.setMemberId("jyh4479");
        addFriendInfo.setFriendId("csj");

        ObjectMapper objectMapper = new ObjectMapper();
        String content = objectMapper.writeValueAsString(addFriendInfo);


        mvc.perform(post("/jplan/memberservice/friend")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content))
                .andExpect(status().isOk());

        verify(memberService).addFriend(addFriendInfo);
    }
}
