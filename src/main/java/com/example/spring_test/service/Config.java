package com.example.spring_test.service;

import com.example.spring_test.repository.JpaBoardRepository;
import com.example.spring_test.repository.JpaMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import java.sql.SQLException;

@Configuration
public class Config {

    private EntityManager em;

    public Config(EntityManager em) {
        this.em = em;
    }

    @Bean
    public MemberService memberService() throws SQLException {
        return new MemberService(new JpaMemberRepository(em));
    }

    @Bean
    public BoardService boardService() throws SQLException {
        return new BoardService(new JpaBoardRepository(em));
    }
}
