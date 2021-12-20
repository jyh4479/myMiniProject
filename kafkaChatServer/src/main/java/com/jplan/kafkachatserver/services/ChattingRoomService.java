package com.jplan.kafkachatserver.services;

import com.jplan.kafkachatserver.entities.ChattingRoom;
import com.jplan.kafkachatserver.repositories.ChattingRoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

@Log
@Service
@RequiredArgsConstructor
public class ChattingRoomService {

    private final ChattingRoomRepository chattingRoomRepository;

    public void createChattingRoom() {
        ChattingRoom chattingRoom = new ChattingRoom();
        chattingRoomRepository.save(chattingRoom);
    }
}
