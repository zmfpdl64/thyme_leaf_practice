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
public class MemberController {

    private MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }


    @GetMapping("/")
    public String comhello(Model model, String name, String age) {
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        List<Member> result = memberService.findMembers();
        model.addAttribute("size", result.size());
        return "hello";
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

    @GetMapping("/members")
    public String member_list(Model model) {
        List<Member> result = memberService.findMembers();
        model.addAttribute("members", result);
        return "members/member_list";
    }
}
