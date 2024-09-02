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
    private final EntityManager em;

    // EntityManager 클래스 스프링 빈으로 의존성 삽입 (Dependency Injection | DI)
    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }
    
    @Bean
    public MemberRepository memberRepository() {
        // return new MemoryMemberRepository();
        // return new JdbcMemberRepository(dataSource);
        // return new JdbcTemplateMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    }

}
