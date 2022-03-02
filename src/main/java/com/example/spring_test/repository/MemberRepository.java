package com.example.spring_test.repository;

import com.example.spring_test.model.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member, String name, String passwd);

    Optional<Member> findByName(String name);

    Optional<Member> findByPasswd(String passwd);

    List<Member> findAll();

}
