package jpa.jpa_basic.jpashop;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jpa.jpa_basic.jpashop.domain.*;

public class JpaMain {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Order order = new Order();
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);

            Item order_item = new Item();
            order_item.setName("Cake");
            orderItem.setItem(order_item);

            order.addOrderItems(orderItem);
            Member order_member = new Member();
            order_member.setName("홍길동");
            order.setMember(order_member);

            em.persist(order_member);
            em.persist(order_item);
            em.persist(orderItem);
            em.persist(order);


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();

    }
}