package com.jplan.authorizationserver.repositories;

import com.jplan.authorizationserver.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MemberRepository extends JpaRepository<Member, String> {
}
