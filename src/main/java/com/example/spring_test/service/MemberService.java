package com.example.spring_test.service;

import com.example.spring_test.model.Member;
import com.example.spring_test.repository.MemberRepository;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {    //회원관리, 추가, 전체회원, 특정회원
    private final MemberRepository memberRepository;

    //    @Autowired
    public MemberService(MemberRepository memberRepository) {

        this.memberRepository = memberRepository;
    }

    /*
     *회원가입
     */
    public Long join(Member member) {
        //같은 이름이 있는 중복 회원x
//        Optional<Member> result = memberRepository.findByName(member.getname());
//        result.ifPresent(m -> {
//            throw new IllegalStateException("이미 존재하는 회원입니다.");
//        });
//                Member member1 = result.get(); 직접 바로 꺼내는 방식 권장하지 않는다.
//        Member member1 = result.orElseGet(); 바로 꺼내는 작업을 한다면 이 메서드를 사용한다.
        validateDuplicateMember(member);    //중복 회원 검증
        memberRepository.save(member, member.getName(), member.getPasswd());
        return member.getId();
    }


    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName()).ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
            // Optional이라는 메서드가 있으면 내용이 복잡해 보이기 때문에 단축시킬 수 있다.
        });
    }

    //전체 회원 출력
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    //특정 회원 출력
    public Optional<Member> findOne(Long memberid) {
        return memberRepository.findById(memberid);
    }

}