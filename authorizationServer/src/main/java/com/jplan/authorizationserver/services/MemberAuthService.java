package com.jplan.authorizationserver.services;

import com.jplan.authorizationserver.repositories.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberAuthService {

    private final MemberRepository memberRepository;

    public boolean memberCheck(String id, String password) {

        /* repository check logic */

        if (true/* DB select logic */) return true;
        else return false;
    }
}
