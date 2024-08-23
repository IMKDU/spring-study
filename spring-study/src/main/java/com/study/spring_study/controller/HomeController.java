package com.study.spring_study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // 메인 홈 조회
    @GetMapping("/")
    public String home(){
        return "home";
    }

}
