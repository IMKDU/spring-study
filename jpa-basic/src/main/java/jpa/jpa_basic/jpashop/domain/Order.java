package jpa.jpa_basic.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter @Setter
@Table (name = "ORDERS")
public class Order {

    @Id @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;

    @ManyToOne //JPA를 통한 객체-데이터베이스 연결 (ORM작업)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    // @Column(name = "MEMBER_ID")
    // private Long memberId;

    @OneToMany(mappedBy = "order") // OrderItem 양방향 연관관계 설정 -> 비즈니스 로직에 근거해 설정함
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "DELIVERY_ID")
    private Delivery delivery;

    private Date orderDate;
    private OrderStatus status;

    // 편의 메소드 (주문 리스트 생성)
    public void addOrderItems(OrderItem orderItem){
        orderItem.setOrder(this);
        orderItems.add(orderItem);
    }
}
