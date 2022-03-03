package com.example.spring_test.controller;

import com.example.spring_test.repository.JpaMemberRepository;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private JpaMemberRepository jpaMemberRepository;

    public MemberController(JpaMemberRepository jpaMemberRepository) {
        this.jpaMemberRepository = jpaMemberRepository;
    }


}
