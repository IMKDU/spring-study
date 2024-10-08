package jpa.jpa_basic.hellojpa;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

// @Entity
public class Member {

    @Id
    private Long id;

    @Column(name = "name")
    private String username;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP) // Date: 날짜 / TIME: 시간 / TIMESTAMP: 날짜&시간
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Lob //DB의 많은 문자열 타입
    private String description;

    public Member() {
    }


       

    // public void setId(Long id) {
    //     this.id = id;
    // }
    
    // public Long getId(){
    //     return id;
    // }

    // public void setName(String name) {
    //     this.name = name;
    // }
    
    // public String getName(){
    //     return name;
    // }

}
