package com.example.spring_test.controller;

import com.example.spring_test.model.Member;
import com.example.spring_test.model.MemberForm;
import com.example.spring_test.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HelloController {
    //동작 순서도 Bean으로 등록한 값을 Controller에서 생성자로 받아 등록한다.
    private MemberService memberService;

    public HelloController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/test")
    public String test() {
        return "test/b";
    }


    @GetMapping("/all")
    public String all() {
        return "join/all";
    }

    @GetMapping("/goodnews")
    public String goodnews() {
        String a = "w";

        return "goodnews";
    }
}
