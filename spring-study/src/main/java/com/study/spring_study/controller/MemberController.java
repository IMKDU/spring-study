package com.study.spring_study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.study.spring_study.service.MemberService;

@Controller
public class MemberController {

    // 스프링 Bean에 등록하고, 사용해야 한다.
    // private final MemberService memberService = new MemberService();
    private final MemberService memberService;

    // Autowired 는 스프링 Bean에 등록된 인스턴스를 가져다가 준다.
    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

}
