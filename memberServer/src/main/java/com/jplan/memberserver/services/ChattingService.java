package com.jplan.memberserver.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jplan.memberserver.dto.MemberId;
import com.jplan.memberserver.dto.NewChattingRoomInfo;
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
public class ChattingService {
    private final MemberRepository memberRepository;

    @Transactional(rollbackFor = Exception.class)
    public void addChattingRoom(NewChattingRoomInfo newChattingRoomInfo) throws ParseException {
        Long roomId = newChattingRoomInfo.getId();
        List<MemberId> memberList = newChattingRoomInfo.getMemberList();


        JSONParser jsonParser = new JSONParser();
        ObjectMapper mapper = new ObjectMapper();

        for (MemberId memberId : memberList) {
            Member member = memberRepository.getById(memberId.getId());

            JSONArray jsonArray;
            if (member.getChattingRoomList() == null) jsonArray = new JSONArray();
            else {
                Object obj = jsonParser.parse(member.getChattingRoomList());
                JSONObject jsonObject = (JSONObject) obj;
                jsonArray = (JSONArray) jsonObject.get("dataList");
            }

            JSONObject chattingList = new JSONObject();

            JSONObject newRoomInfo = new JSONObject();
            newRoomInfo.put("id", roomId);

            jsonArray.add(newRoomInfo);
            chattingList.put("dataList", jsonArray);

            member.setChattingRoomList(chattingList.toJSONString());
            memberRepository.save(member);

        }
    }

    public void testPrint() {
        log.info("HIHI");
    }
}
