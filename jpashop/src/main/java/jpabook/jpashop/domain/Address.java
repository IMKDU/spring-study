package jpabook.jpashop.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class Address {

    private String city;
    private String street;
    private String zipcode;

    // JPA 특성 상 (리플렉션) 생성자 정의
    // 생성자에서 값을 모두 초기화해서 변경불가능한 클래스로 만들기
    protected Address() { 
    }

    // 외부 Address 객체 선언 시, 하단 생성자로 호출
    public Address(String city, String street, String zipcode){
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
