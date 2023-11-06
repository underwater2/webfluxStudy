package com.example.webfluxStudy.mapper;

import com.example.webfluxStudy.dto.MemberDto;
import com.example.webfluxStudy.entity.Member;

public class MemberMapper {

    public static MemberDto toMemberDto(Member member) {
        return new MemberDto(
                member.getId(),
                member.getLoginId(),
                member.getPassword(),
                member.getAge()
        );
    }

    public static Member toMember(MemberDto memberDto) {
        return new Member(
                memberDto.getId(),
                memberDto.getLoginId(),
                memberDto.getPassword(),
                memberDto.getAge()
        );
    }
}
