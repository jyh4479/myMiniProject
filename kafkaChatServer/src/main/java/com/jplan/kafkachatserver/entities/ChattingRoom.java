package com.jplan.kafkachatserver.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "chatting_room")
@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class ChattingRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Builder
//    public ChattingRoom() {
//        this.id = id;
//    }
}
