package com.green.board8.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/board"})
public class BoardController {

    private BoardService service;

    @Autowired
    public BoardController (BoardService service) {
        this.service = service;
    }

}
