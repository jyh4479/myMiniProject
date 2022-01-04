package com.jplan.memberserver.entities;

import com.fasterxml.jackson.annotation.JsonRawValue;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "member")
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column
    private String name;

    @Column
    private String phone;

    @Column
    private String email;

    @Column
    private String birth;

    @Column
    private String password;

    @Column
    private String membership;

    @Column
    @JsonRawValue
    private String friendList;

    @Column
    @JsonRawValue
    private String chattingRoomList;

    @Builder
    public Member(String id, String name, String phone, String email, String birth, String password, String membership, String friendList, String chattingRoomList) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.birth = birth;
        this.password = password;
        this.membership = membership;
        this.friendList = friendList;
        this.chattingRoomList = chattingRoomList;
    }
}
