package jpa.jpa_basic.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Item {

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
