package com.example.myshoppingmall.entity;

import com.example.myshoppingmall.constant.Role;
import com.example.myshoppingmall.dto.MemberDto;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

@Entity
@Table(name="member")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member extends BaseEntity{
    @Id
    @Column(name="member_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String address;

    @Enumerated(EnumType.STRING)
    private Role role;

    public static Member createMember(MemberDto memberDto, PasswordEncoder passwordEncoder, boolean isAdmin){
        Role role = Role.USER;
        if(isAdmin){
            role = Role.ADMIN;
        }
        Member member = Member.builder()
                .name(memberDto.getName())
                .email(memberDto.getEmail())
                .password(passwordEncoder.encode(memberDto.getPassword()))
                .address(memberDto.getAddress())
                .role(role)
                .build();
        return member;
    }
}
