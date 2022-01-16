package com.jplan.memberserver.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jplan.memberserver.dto.AddFriendInfo;
import com.jplan.memberserver.dto.NewFriendInfo;
import com.jplan.memberserver.entities.Member;
import com.jplan.memberserver.repositories.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Log
@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional(readOnly = true)
    public Member getMemberData(String id) throws Exception {
        log.info("run getmemberData service");
        try {
            return memberRepository.getById(id);
        } catch (Exception e) {
            throw new Exception("Repository error");
        }
    }

    @Transactional(readOnly = true)
    public List<Member> getMembersData() throws Exception {
        log.info("run getmembersData service");
        try {
            return memberRepository.findAll();
        } catch (Exception e) {
            throw new Exception("Repository error");
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public void addFriend(AddFriendInfo addFriendInfo) throws ParseException, JsonProcessingException {
        log.info("run addFriend service");

        Member member = memberRepository.getById(addFriendInfo.getMemberId());
        Member newFriend = memberRepository.getById(addFriendInfo.getFriendId());

        NewFriendInfo newFriendInfo = new NewFriendInfo(
                newFriend.getId(),
                newFriend.getName(),
                newFriend.getPhone(),
                newFriend.getEmail(),
                newFriend.getBirth()
        );

        //Entity -> String -> JSON
        JSONParser jsonParser = new JSONParser();
        ObjectMapper mapper = new ObjectMapper();


        //해당 밸리데이션 체크 필요
//        if (member.getFriendList().equals("null") || member.getFriendList() == null) {

        log.info("null");
        //Entity to String
        String friendString = mapper.writeValueAsString(newFriendInfo);
        //String to JSON
        Object friendObject = jsonParser.parse(friendString);
        JSONObject friendJson = (JSONObject) friendObject;

        JSONArray jsonArray;
        if (member.getFriendList() == null) jsonArray = new JSONArray();
        else {
            Object obj = jsonParser.parse(member.getFriendList());
            JSONObject jsonObject = (JSONObject) obj;
            jsonArray = (JSONArray) jsonObject.get("dataList");
        }

        JSONObject friendList = new JSONObject();

        jsonArray.add(friendJson);
        friendList.put("dataList", jsonArray);

        member.setFriendList(friendList.toJSONString());
        memberRepository.save(member);
    }
}
