package com.green.mimi.board;

import com.green.mimi.board.model.BoardInsDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/board")
public class BoardController {

    private final BoardService service;

    public BoardController(BoardService service){
        this.service = service;
    }

    @Tag(name = "게시판")
    @PostMapping
    @Operation(summary = "글작성",description = "예시"+
            "title[10]: 글제목,<br>" +
            "ctnt[255]: 본문,<br>" +
            "writer[20]: 작성자,<br>"
            )
    public int PostBoard(@RequestBody BoardInsDto dto){
        return service.insBoard(dto);
    }
}
