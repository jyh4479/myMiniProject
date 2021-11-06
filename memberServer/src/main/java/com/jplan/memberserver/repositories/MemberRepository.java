package com.jplan.memberserver.repositories;

import com.jplan.memberserver.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MemberRepository extends JpaRepository<Member, String> {
}