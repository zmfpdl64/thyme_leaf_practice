package com.example.spring_test.controller;

import com.example.spring_test.repository.JpaBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BoardController {

    private JpaBoardRepository jpaBoardRepository;

    //    @Autowired
    public BoardController(JpaBoardRepository jpaBoardRepository) {
        this.jpaBoardRepository = jpaBoardRepository;
    }

}
