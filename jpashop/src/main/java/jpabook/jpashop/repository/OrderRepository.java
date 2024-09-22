package jpabook.jpashop.repository;

import jakarta.persistence.EntityManager;
import jpabook.jpashop.domain.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderRepository {

    private final EntityManager em;

    public void save(Order order){
        em.persist(order);
    }

    // 주문 한 건 조회
    public Order findOne(Long id){
        return em.find(Order.class, id);
    }

    // 주문 전체 조회 -> 동적쿼리로 작업해야함. 나중에 설명
//    public List<Order> findAll(OrderSerch orderSerch){}



}
