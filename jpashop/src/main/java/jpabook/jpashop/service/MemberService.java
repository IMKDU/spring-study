package jpabook.jpashop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    
    private final MemberRepository memberRepository;

    // RequiredArgsConstructor 어노테이션으로, 파이널 필드 기반, 생성자 메소드 자동구현
    // public MemberService(MemberRepository memberRepository){
    //    this.memberRepository = memberRepository;
    // }
    
    
    /*
     * 1. 회원 가입
     */
    @Transactional
    public Long join(Member member) {
        validateDuplicateMember(member); // 중복회원 검증
        memberRepository.save(member); //영속성 컨텍스트
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    // 2. 회원전체 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    // 3. 회원 1명 조회
    public Member findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }
}
