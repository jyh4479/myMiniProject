package com.jplan.memberserver.services;

import com.jplan.memberserver.dto.AddFriendInfo;
import com.jplan.memberserver.entities.Member;
import com.jplan.memberserver.repositories.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Log
@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member getMemberData(String id) throws Exception {
        log.info("run getmemberData service");
        try {
            return memberRepository.getById(id);
        } catch (Exception e) {
            throw new Exception("Repository error");
        }
    }

    public List<Member> getMembersData() throws Exception {
        log.info("run getmembersData service");
        try {
            return memberRepository.findAll();
        } catch (Exception e) {
            throw new Exception("Repository error");
        }
    }

    @Transactional(rollbackOn = Exception.class)
    public void addFriend(AddFriendInfo addFriendInfo) throws ParseException {
        log.info("run addFriend service");
        // 1. memberId 와 friendId 검증
        // 2. memberId friendList에 이미 friendId가 포함되어있는지 검증
        // 3.
        Member member = memberRepository.getById(addFriendInfo.getMemberId());

        if (member.getFriendList() == null) {
            log.info("null");
            JSONObject friendList = new JSONObject();
            JSONObject jsonObject = new JSONObject();
            JSONArray jsonArray = new JSONArray();

            jsonObject.put("id", addFriendInfo.getFriendId());
            jsonArray.add(jsonObject);
            friendList.put("dataList", jsonArray);

            member.setFriendList(friendList.toJSONString());

            memberRepository.save(member);
        } else {
            log.info("not null");
            JSONParser jsonParser = new JSONParser();
            Object obj = jsonParser.parse(member.getFriendList());
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray jsonArray = (JSONArray) jsonObject.get("dataList");

            JSONObject newFriend = new JSONObject();
            JSONObject friendList = new JSONObject();
            newFriend.put("id", addFriendInfo.getFriendId());
            jsonArray.add(newFriend);
            friendList.put("dataList", jsonArray);

            member.setFriendList(friendList.toJSONString());

            memberRepository.save(member);
        }

        log.info(addFriendInfo.getFriendId());
        log.info(addFriendInfo.getMemberId());
    }
}
