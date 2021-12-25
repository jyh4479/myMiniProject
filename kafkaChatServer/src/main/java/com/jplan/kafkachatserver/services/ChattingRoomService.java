package com.jplan.kafkachatserver.services;

import com.jplan.kafkachatserver.entities.ChattingRoom;
import com.jplan.kafkachatserver.repositories.ChattingRoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

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

    @Transactional(rollbackOn = {Exception.class})
    public void createChattingRoom() {

//        try {
        ChattingRoom chattingRoom = new ChattingRoom(); //채팅방 생성
        chattingRoomRepository.save(chattingRoom); //auto 로 증가하는 id 값이 언제 결정되는지 다시 알아보기

        webClient.post()
                .uri("/chattingroom")
                .bodyValue(chattingRoom.getId())
                .retrieve()
//                    .onStatus(HttpStatus::isError, clientResponse -> Mono.error(Exception::new))
                .onStatus(HttpStatus::is4xxClientError, clientResponse -> Mono.error(Exception::new))
                .onStatus(HttpStatus::is5xxServerError, clientResponse -> Mono.error(Exception::new))
                .bodyToMono(Integer.class)
                .block();

//        } catch (Exception e) {
//            log.warning("Error from creating chatting room");
//        }
        //webflux 를 통한 다른 service 와의 통신 생각해기
        //추가적으로 여러 동시에 여러 스레드가 동시에 save 에 접근하는 경우 어떻게 동작할까?
    }
}
