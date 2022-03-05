package com.example.spring_test.controller;

import com.example.spring_test.model.Board;
import com.example.spring_test.model.BoardForm;
import com.example.spring_test.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BoardController {

    private BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/post_list")
    public String post_list(Model model) {
        List<Board> result = boardService.post_list();
        model.addAttribute("posts", result);
        return "post/post_list";
    }

    @GetMapping("/post_list/post_create")
    public String post_go_create() {
        return "post/post_create";
    }

    @PostMapping("/post_list/post_create")
    public String post_create(BoardForm boardForm) {
        Board board = new Board();
        board.setTitle(boardForm.getTitle());
        board.setId(boardForm.getId());
        board.setContent(boardForm.getContent());
        boardService.create(board);
        return "redirect:/post_list";
    }

    @GetMapping("/post_list/post_detail")
    public String post_detail(Model model, @RequestParam("id") Long id) {
        Board board = boardService.findOne(id).get();
        model.addAttribute("post", board);
        return "post/post_detail";
    }

}
