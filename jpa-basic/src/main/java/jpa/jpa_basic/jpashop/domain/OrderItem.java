package jpa.jpa_basic.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class OrderItem {

    @Id @GeneratedValue
    @Column(name = "ORDER_ITEM_ID")
    private Long id;

    @ManyToOne // JPA를 통한 객체-데이터베이스 연결 (ORM작업)
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    @ManyToOne // JPA를 통한 객체-데이터베이스 연결 (ORM작업)
    @JoinColumn(name = "ITEM_ID")
    private Item item;

    private int orderPrice;
    private int count;
}
