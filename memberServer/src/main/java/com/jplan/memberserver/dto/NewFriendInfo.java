package com.jplan.memberserver.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class NewFriendInfo {
    private String id;
    private String name;
    private String phone;
    private String email;
    private String birth;

    @Builder
    public NewFriendInfo(String id, String name, String phone, String email, String birth) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.birth = birth;
    }
}
