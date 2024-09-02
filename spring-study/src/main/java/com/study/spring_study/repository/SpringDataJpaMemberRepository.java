package com.study.spring_study.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.spring_study.domain.Member;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    // 공통 메소드 X -> 인터페이스 메소드 추가선언
    Optional<Member> findByName(String name);
}

