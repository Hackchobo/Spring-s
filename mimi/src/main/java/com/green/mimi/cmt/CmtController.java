package com.green.mimi.cmt;

import com.green.mimi.cmt.model.CmtInsDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/board/cmt")
public class CmtController {

    private final CmtService service;

    @Autowired
    public CmtController(CmtService service) {
        this.service = service;
    }

    @PostMapping
    @Operation(summary = "댓글 작성", description = "" +
            "iboard : 게시물 번호,<br>" +
            "iuser : 게시물 작성자 ID 넘버,<br>" +
            "cmt : 댓글 작성,<br>" )
    public int postBoardCmt(@RequestBody CmtInsDto dto){
        return service.insBoardCmt(dto);
    }
}
