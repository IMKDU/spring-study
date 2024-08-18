package com.study.spring_study.repository;


import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import com.study.spring_study.domain.Member;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    // 콜백 메소드 | Test 메소드 호출 후, 마지막으로 호출
    // 테스트 시, 리포지토리에 저장된 객체를 초기화 시켜 중복되는 객체를 제거
    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    // 1. 회원 생성 테스트
    @Test
    public void save() {

        // 회원 생성
        Member member = new Member();
        member.setName("spring");
        repository.save(member);

        // 리포지토리 회원 조회
        Member result = repository.findById(member.getId()).get(); //Optional 에서 값은 get() 메소드로 꺼냄

        // 테스트 회원과 리포지토리 회원 일치하는지 검증 
        // System.out.println("result = " + (result ==));
        // Assertions.assertEquals(member, result);
        assertThat(member).isEqualTo(result);
    }

    // 2. 회원 이름으로 조회 테스트
    @Test
    public void findByName(){

        // 회원 1,2 생성
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        // 리포지토리 회원1 조회
        Member result = repository.findByName("spring1").get();

        // 이름으로 테스트회원1과 리포지토리 회원1 일치하는지 검증
        assertThat(result).isEqualTo(member1);
    }

    // 3. 모든 회원 조회 테스트
    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }

}
