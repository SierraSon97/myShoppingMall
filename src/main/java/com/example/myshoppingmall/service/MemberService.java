package com.example.myshoppingmall.service;

import com.example.myshoppingmall.entity.Member;
import com.example.myshoppingmall.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {
    @Autowired
    private final MemberRepository memberRepository;

    public Member saveMember(Member member){
        validateDuplicateMember(member);
        return memberRepository.save(member);
    }

    private void validateDuplicateMember(Member member){
        if(memberRepository.findMemberByEmail(member.getEmail()) != null){
            throw new IllegalStateException("이미 가입된 회원입니다.");
        }
    }
}
