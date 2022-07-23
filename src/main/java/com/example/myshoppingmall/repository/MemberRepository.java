package com.example.myshoppingmall.repository;

import com.example.myshoppingmall.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findMemberByEmail(String email);
}
