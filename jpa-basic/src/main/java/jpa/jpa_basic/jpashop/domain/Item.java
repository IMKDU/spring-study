package jpa.jpa_basic.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
// 1. 상속관계 매핑 시, 조인전략
@Inheritance(strategy = InheritanceType.JOINED)
// 2. 상속관계 매핑 시, 싱글테이블 전략 (Dtype 필수로 설정해줌)
// @Inheritance(strategy = InheritanceType.SINGLE_TABLE)
// 3. 상속관계 매핑 시, 구현클래스마다 테이블 전략
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn // DB 유지관리면에서, 가독성을 높혀줌 (DType)
public abstract class Item {

    @Id @GeneratedValue
    @Column(name = "ITEM_ID")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    // 다대다 매핑으로 설정(강좌 7-5)
    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();
}
