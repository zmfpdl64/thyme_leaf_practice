package com.example.spring_test.service;

import com.example.spring_test.model.Board;
import com.example.spring_test.repository.BoardRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class BoardService {

    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public void create(Board board) {
        boardRepository.save(board);
    }

    public List<Board> post_list() {
        return boardRepository.findAll();
    }

//    public Optional<Board> findOne(Long id) {
//        return boardRepository.findById(id);
//    }

    public Optional<Board> findtitle(String title) {
        return boardRepository.findByTitle(title);
    }

}
