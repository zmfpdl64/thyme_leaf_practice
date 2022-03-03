package com.example.spring_test.service;

import com.example.spring_test.model.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@SpringBootTest
@Transactional
class MemberServiceTest {

    private MemberService memberService;

    MemberServiceTest(MemberService memberService) {
        this.memberService = memberService;
    }

    @Test
    void join() {
        Member member1 = new Member();
        member1.setId(1L);
        member1.setName("woojin");
        member1.setPasswd("1234");
        memberService.join(member1);
        Member findmember = memberService.findOne(member1.getId()).get();
        System.out.println(findmember.getName());

        Member member2 = new Member();
        member2.setId(2L);
        member2.setName("hansol");
        member2.setPasswd("12345");
        memberService.join(member2);

        Assertions.assertThat(member1.getId()).isEqualTo(member1.getId());
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}