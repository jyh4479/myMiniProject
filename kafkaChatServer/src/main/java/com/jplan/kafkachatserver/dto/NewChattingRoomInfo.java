package com.jplan.kafkachatserver.dto;

import lombok.Data;

import java.util.List;

@Data
public class NewChattingRoomInfo {
    private Long id;
    private List<Member> memberList;
}
