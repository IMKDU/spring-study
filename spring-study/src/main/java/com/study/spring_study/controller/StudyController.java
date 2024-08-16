package com.study.spring_study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudyController {

    /*
     * 1. MVC, model, controller, view의 이해를 위한 기본 메소드 실습 with. thymeleaf 템플릿엔진 
     */
    // "/hello" 매핑되어, hello 메소드 동작
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    /*
     * 2. MVC와 템플릿 엔진 파라미터 응용 메소드 실습
     */
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    /*
     * 3. API 메소드 실습
     */
    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name){
        return name;
    }

    /*
     * 3.1 API 응답객체 메소드 실습
     */
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    // 클라이언트 API 응답용 Model 객체선언
    static class Hello{
        private String name;

        public String getName(){
            return name;
        }

        public void setName(String name){
            this.name = name;
        }
    }


}
