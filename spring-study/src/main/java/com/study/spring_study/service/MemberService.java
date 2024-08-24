package com.study.spring_study.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.spring_study.domain.Member;
import com.study.spring_study.repository.MemberRepository;

// @Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    // DI 주입 | 의존성 주입
    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    /*
     * <서비스 형식>
     * Service 에서는 비즈니스 로직 상호작용이므로,
     * 비즈니스 로직에 근거한 변수, 메소드, 주석을
     * 클라이언트 친화적 네이밍으로 관리한다.
     */

    /*
     * 1. 회원가입
     */
    public Long join(Member member){
        
        validateDuplicateMember(member); // 중복 회원검증
        memberRepository.save(member);
        return member.getId();
    }

    // Validation - 중복 회원검증
    public void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
            .ifPresent( m -> {
                throw new IllegalStateException("이미 존재하는 회원입니다.");
            });
    }

    /*
     * 2. 전체 회원조회
     */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    /*
     * 3. 회원 조회
     */
    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }


}
