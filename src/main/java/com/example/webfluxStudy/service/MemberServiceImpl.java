package com.example.webfluxStudy.service;

import com.example.webfluxStudy.dto.MemberDto;
import com.example.webfluxStudy.entity.Member;
import com.example.webfluxStudy.mapper.MemberMapper;
import com.example.webfluxStudy.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public Mono<MemberDto> saveMember(MemberDto memberDto) {
        Member member = MemberMapper.toMember(memberDto);
        Mono<Member> savedMember = memberRepository.save(member);
        return savedMember
                .map(MemberMapper::toMemberDto);
    }

    @Override
    public Mono<MemberDto> getMember(String memberId) {
        Mono<Member> foundMember = memberRepository.findById(memberId);
        return foundMember
                .map(MemberMapper::toMemberDto)
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Flux<MemberDto> getAllMember() {
        Flux<Member> allMember = memberRepository.findAll();
        return allMember
                .map(MemberMapper::toMemberDto)
                .switchIfEmpty(Flux.empty());
    }

    @Override
    public Mono<MemberDto> updateMember(MemberDto memberDto, String memberId) {

        Mono<Member> updateMember = memberRepository.findById(memberId);

        return updateMember
                .flatMap(memberEntity -> {
                    memberEntity.setLoginId(memberDto.getLoginId());
                    memberEntity.setPassword(memberDto.getPassword());
                    memberEntity.setAge(memberDto.getAge());
                    return memberRepository.save(memberEntity);
                })
                .map(MemberMapper::toMemberDto);
    }

    @Override
    public Mono<Void> deleteMember(String memberId) {
        return memberRepository.deleteById(memberId);
    }

    public void login(String memberId, String password) {

    }
}
