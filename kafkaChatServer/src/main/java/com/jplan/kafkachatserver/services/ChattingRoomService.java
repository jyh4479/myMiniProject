package com.jplan.kafkachatserver.services;

import com.jplan.kafkachatserver.entities.ChattingRoom;
import com.jplan.kafkachatserver.repositories.ChattingRoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import javax.transaction.Transactional;

@Log
@Service
@RequiredArgsConstructor
public class ChattingRoomService {

    private WebClient webClient = WebClient.builder()
            .baseUrl("http://localhost:8010/jplan/memberservice")
            .build();

    private final ChattingRoomRepository chattingRoomRepository;
//    private EntityManager em; --> 동시성때문에 사용하지 않는 것을 권고

    @Transactional(rollbackOn = Exception.class)
    public void createChattingRoom() {


        ChattingRoom chattingRoom = new ChattingRoom();
//        em.getTransaction().begin();
//        em.persist(chattingRoom);
//        em.merge(chattingRoom);
//        em.getTransaction().commit();
        chattingRoomRepository.save(chattingRoom); //auto 로 증가하는 id 값이 언제 결정되는지 다시 알아보기
//        System.out.println(chattingRoom.getId());

        webClient.post()
                .uri("/chattingroom")
                .bodyValue(chattingRoom.getId())
                .retrieve()
                .bodyToMono(Integer.class)
                .block();
        //webflux 를 통한 다른 service 와의 통신 생각해기
        //추가적으로 여러 동시에 여러 스레드가 동시에 save 에 접근하는 경우 어떻게 동작할까?
    }
}
