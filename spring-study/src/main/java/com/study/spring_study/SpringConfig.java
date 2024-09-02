package com.study.spring_study;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.study.spring_study.repository.MemoryMemberRepository;
import com.study.spring_study.repository.JdbcMemberRepository;
import com.study.spring_study.repository.JdbcTemplateMemberRepository;
import com.study.spring_study.repository.JpaMemberRepository;
import com.study.spring_study.repository.MemberRepository;

import com.study.spring_study.service.MemberService;

import jakarta.persistence.EntityManager;

@Configuration
public class SpringConfig {

    // private final DataSource dataSource;
    // private final EntityManager em;
    private final MemberRepository memberRepository;

    // EntityManager 클래스 스프링 빈으로 의존성 삽입 (Dependency Injection | DI)
    @Autowired //생성자가 하나일 때는 Autowired 어노테이션 생략가능
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

    // 스프링 데이터 JPA로, 리포지토리 자동 스프링 빈에 등록
    // @Bean
    // public MemberRepository memberRepository() {
    //     // return new MemoryMemberRepository();
    //     // return new JdbcMemberRepository(dataSource);
    //     // return new JdbcTemplateMemberRepository(dataSource);
    //     return new JpaMemberRepository(em);
    // }

}
