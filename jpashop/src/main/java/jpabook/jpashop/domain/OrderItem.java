package jpabook.jpashop.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jpabook.jpashop.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class OrderItem {

    @Id @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id") // 외래키 지정 1. 상품_id
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY) // 다대일 관계 매핑
    @JoinColumn(name = "order_id") // 외래키 지정 2. 주문_id
    private Order order;

    private int orderPrice; //주문 가격
    private int count; //주문 수량


}