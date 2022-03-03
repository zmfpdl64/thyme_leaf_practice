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

    @GetMapping("/")
    public String comhello(Model model, String name, String age) {
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        List<Member> result = memberService.findMembers();
        model.addAttribute("size", result.size());
        return "hello";
    }

    @GetMapping("/layout")
    public String join() {
        return "layout/join";
    }

    @PostMapping("/join/login")
    public String join(MemberForm memberForm) {
        Member member = new Member();
        member.setName(memberForm.getName());
        member.setPasswd(memberForm.getPasswd());
        return "redirect:/";
    }

    @GetMapping("/login/login")
    public String login() {
        return "login/login";
    }

    @PostMapping("/login/login")
    public String login_post(MemberForm memberform) {
        Member member = new Member();
        member.setName(memberform.getName());
        member.setPasswd(memberform.getPasswd());
        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/post_list")
    public String post_list() {
        return "post/post_list";
    }

    @GetMapping("/post_list/post_create")
    public String post_go_create() {
        return "post/post_create";
    }

    @PostMapping("/post_list/post_create")
    public String post_create() {
        return "redirect:/post_list";
    }

    @GetMapping("/members")
    public String member_list(Model model) {
        List<Member> result = memberService.findMembers();
        model.addAttribute("members", result);
        return "members/member_list";
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
