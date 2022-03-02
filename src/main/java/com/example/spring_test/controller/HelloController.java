package com.example.spring_test.controller;

import com.example.spring_test.model.Member;
import com.example.spring_test.model.MemberForm;
import com.example.spring_test.repository.MemoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class HelloController {

    private MemoryRepository store;

    public HelloController(MemoryRepository store) {
        this.store = store;
    }

    @GetMapping("/test")
    public String test() {
        return "test/b";
    }

    @GetMapping("/")
    public String comhello(Model model, String name, String age) {
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        List<Member> result = store.findAll();
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
        store.save(member, member.getName(), member.getPasswd());
//        Optional<Member> member1 = store.findByName(member.getName());
//        System.out.println();
        return "redirect:/";
    }

    @GetMapping("/members")
    public String member_list(Model model) {
        List<Member> result = store.findAll();
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
