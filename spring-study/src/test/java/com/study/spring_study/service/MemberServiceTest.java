package com.study.spring_study.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.study.spring_study.domain.Member;
import com.study.spring_study.repository.MemoryMemberRepository;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    // Test 케이스 실행 전, DI 주입
    @BeforeEach
    public void BeforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }

    // Test 메소드는 한글로 네이밍허용한다.
    /*  
     *  <Test 케이스 템플릿>
     *  1. Given
     *  뭘 제공하는가? , 선언했는가?
     * 
     *  2. When
     *  뭘 했을 때
     * 
     *  3. Then
     *  잘 되는가?
     */
    @Test
    public void 회원가입() throws Exception {
        //Given
        Member member = new Member();
        member.setName("hello");

        //When
        Long saveId = memberService.join(member);

        //Then
        Member findMember = memberRepository.findById(saveId).get();
        assertEquals(findMember.getName(), member.getName());
    }

    @Test
    public void 중복_회원_예외() throws Exception {
        //Given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //When
        memberService.join(member1);
        // 예외처리 (assertThrows 문)
        IllegalStateException e = assertThrows(IllegalStateException.class, 
                () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }
/*  
 *      예외 처리 (try-catch 문)
 *      try {
 *          memberService.join(member2);
 *      } catch(IllegalStateException e){
 *          assertThat(e.getMessage()).isEquals("이미 존재하는 회원입니다.");
 *      }
 */
        

}
