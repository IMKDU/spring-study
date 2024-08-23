package com.study.spring_study.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.*;


import com.study.spring_study.domain.Member;
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

    // 1. 회원가입 뷰 조회
    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    // 2. 회원가입 등록
    @PostMapping("/members/new")
    public String create(MemberForm form){

        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }
    
    // 3. 회원목록 조회
    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }


}
