package jpa.jpa_basic.hellojpa;

import jakarta.persistence.*;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        Member member = new Member();
        member.setId(1L);
        member.setName("동작해라.. gitpod");

        em.persist(member);
        Member findMember = em.find(Member.class, 1L);
        System.out.println(findMember.getName());
        
        tx.commit();
        em.close();
        emf.close();
    }
}
