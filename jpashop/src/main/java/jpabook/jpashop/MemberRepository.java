package jpabook.jpashop;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class MemberRepository {

    @PersistenceContext // DI 주입 어노테이션
    private EntityManager em;

    public Long save(Member member) {
        em.persist(member);
        return member.getId(); // 사이드 이펙트 메소드 -> return 값 거의 만들지 않음
        // 커맨드와 쿼리를 분리한다.
    }

    public Member find(Long id) {
        return em.find(Member.class, id);
    }
    


}
