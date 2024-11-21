package jpa.jpa_basic.jpashop.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {
    
    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    private String name;

//    @ManyToOne
//    @JoinColumn(name = "TEAM_ID")
//    private Team team;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

    //일대일 관계 예제
    @OneToOne
    @JoinColumn(name = "LOCKER_ID")
    private Locker locker;

    //다대다 관계 예제
    @OneToMany(mappedBy = "member")
    private List<MemberProduct> products = new ArrayList<>();

    private String city;
    private String street;
    private String zipcode;

    // 순수 객체상태를 고려해 양쪽에 값 설정하는 편의 메소드 (객체지향적 설계)
//    public void changeTeam(Team team) {
//        this.team = team;
//        team.getMembers().add(this);
//    }
}
