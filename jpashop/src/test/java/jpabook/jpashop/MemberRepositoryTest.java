package jpabook.jpashop;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {

    @Autowired MemberRepository MemberRepository;
    
    @Test
    @Transactional // 스프링 "모든 쿼리는 트랙잭션 내에서 처리"
    public void testMember() throws Exception {
        //given
        Member member = new Member();
        member.setUserName("member A");


        //when
        Long saveId = MemberRepository.save(member);
        Member findMember = MemberRepository.find(saveId);

        //then
        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
        Assertions.assertThat(findMember.getUserName()).isEqualTo(member.getUserName());
    

    }
}
