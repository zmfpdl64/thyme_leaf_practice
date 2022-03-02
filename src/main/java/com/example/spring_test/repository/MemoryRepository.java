package com.example.spring_test.repository;

import com.example.spring_test.model.Member;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class MemoryRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 1L;

    @Override
    public Member save(Member member, String name, String passwd) {
        member.setName(name);
        member.setPasswd(passwd);
        store.put(sequence++, member);
        return member;
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream().filter(member -> member.getName().equals(name)).findAny();
    }

    @Override
    public Optional<Member> findByPasswd(String passwd) {

        return store.values().stream().filter(member -> member.getPasswd().equals(passwd)).findAny();
    }

    @Override
    public List<Member> findAll() {
        List<Member> result = new ArrayList<Member>(store.values());
        return result;
    }
}
