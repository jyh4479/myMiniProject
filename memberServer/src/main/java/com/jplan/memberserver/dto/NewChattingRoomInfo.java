package com.jplan.memberserver.dto;

import lombok.Data;

import java.util.List;

@Data
public class NewChattingRoomInfo {
    private Long id;
    private List<MemberId> memberList;
}
