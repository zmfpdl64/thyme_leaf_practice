package com.example.spring_test.repository;

import com.example.spring_test.model.Board;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
public class JpaBoardRepository implements BoardRepository {
    private final EntityManager em;

    public JpaBoardRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Board save(Board board) {
        em.persist(board);
        return board;
    }

    @Override
    public Optional<Board> findById(Long id) {
        Board board = em.find(Board.class, id);
        return Optional.ofNullable(board);
    }

    @Override
    public Optional<Board> findByTitle(String title) {
        List<Board> result = em.createQuery("select m from Board m where m.title = :title", Board.class).setParameter("name", title).getResultList();

        return result.stream().findAny();
    }

    @Override
    public List<Board> findAll() {
        List<Board> result = em.createQuery("select m from Board m", Board.class).getResultList();
        return result;
    }
}
