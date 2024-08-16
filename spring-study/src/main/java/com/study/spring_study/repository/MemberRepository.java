package com.study.spring_study.repository;

import java.util.List;
import java.util.Optional;

import com.study.spring_study.domain.Member;

/*
 * 회원정보 리포지토리
 */
public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name); 
    List<Member> findAll();
}
