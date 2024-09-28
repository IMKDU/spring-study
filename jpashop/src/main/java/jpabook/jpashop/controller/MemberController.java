package jpabook.jpashop.controller;

import jakarta.validation.Valid;
import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    /**
     * 회원가입 뷰 전환
     */
    @GetMapping("/members/new")
    public String createForm(Model model) {
        model.addAttribute("memberForm", new MemberForm()); // Controller -> View (Model 기반으로 하여금 데이터 이동)
        return "members/createMemberForm";
    }

    /**
     * 회원 생성
     */
    @PostMapping("/members/new")
    public String createMember(@Valid MemberForm form, BindingResult result) {
        if (result.hasErrors()) { //thymeleaf 엔진과 스프링 부트는 Integrate 높게 형성됨.
            return "members/createMemberForm";
        }

        Member member = new Member();
        Address address = new Address(form.getCity(), form.getStreet(), form.getZipcode());

        member.setAddress(address);
        member.setName(form.getName());
        memberService.join(member);

        return "redirect:/";
    }

    /**
     * 회원 목록조회
     */
    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        log.info("is this passed?");
        return "members/memberList";
    }
    
}
