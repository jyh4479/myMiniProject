package com.jplan.memberserver.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "member")
@Data
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
}
