package com.study.spring_study.repository;

import java.util.List;
import java.util.Optional;

import com.study.spring_study.domain.Member;

/*
 * 회원 리포지토리
 *   - 인터페이스로 구성
 *   - DB 특성이 확정되지 않은 가상 시나리오임
 */
public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name); 
    List<Member> findAll();
}
