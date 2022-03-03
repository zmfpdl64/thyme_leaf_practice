package com.example.spring_test.repository;

import com.example.spring_test.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BoardRepository {
    Board save(Board board);

    Optional<Board> findById(Long id);

    Optional<Board> findByTitle(String title);

    List<Board> findAll();

}
