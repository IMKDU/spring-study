package jpabook.jpashop.service;

import jakarta.persistence.EntityManager;
import jpabook.jpashop.domain.*;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import jpabook.jpashop.repository.MemberRepository;
import jpabook.jpashop.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;

    /**
     * 주문
     */
    @Transactional
    public Long order(Long memberId, Long itemId, int count){

        // 엔티티 조회
        Member member = memberRepository.findOne(memberId);
        Item item = itemRepository.findOne(itemId);

        // 배송정보 생성 - 회원 정보의 주소정보로 입력 (임의로 수행)
        Delivery delivery = new Delivery();
        delivery.setAddress(member.getAddress());

        // 주문상품 생성
        OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), count);

        // 주문 생성
        Order order = Order.createOrder(member, delivery, orderItem);

        // 주문 저장 -> CascadeType.ALL 정의된 칼럼 값은 자동으로 em.persist 수행됨.
        /**
         * Cascade는 참조하는 객체가 제한될 때, 사용한다.
         * 남발해서 사용하는 건 DB 상, 이상한 값이 삽입될 여지가 있다.
         */
        orderRepository.save(order);
        return order.getId();
    }

    /**
     * 주문취소
     */
    @Transactional
    public void cancelOrder(Long orderId){
        
        // 주문 엔티티 조회
        Order order = orderRepository.findOne(orderId);
        // 주문 취소
        order.cancel();
//        orderRepository.save(order); // JPA가 변경내역 감지로, DB에 자동으로 UPDATE 쿼리문 생성해서 날려줌. / 강력한 JPA
    }

    /**
     * 검색
     * */
/*
    public List<Order> serchOrder(OrderSerch orderSerch){
        return orderRepository.findAll(orderSerch);
    }
*/

}