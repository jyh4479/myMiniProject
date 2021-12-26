package com.jplan.memberserver.dto;

import lombok.Data;

import java.util.ArrayList;

@Data
public class NewChattingRoomInfo {
    private Long id;
    private ArrayList<String> memberList;
}
