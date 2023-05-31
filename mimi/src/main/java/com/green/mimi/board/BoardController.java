package com.green.mimi.board;

import com.green.mimi.board.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
@Tag(name="게시판", description = "")
public class BoardController {

    private final BoardService service;

    @Autowired
    public BoardController(BoardService service) {
        this.service = service;
    }

    @PostMapping
    @Operation(summary = "글쓰기", description = "" +
            "title : [20] 제목,<br>" +
            "ctnt: [100] 게시물,<br>" +
            "iuser: [30] 회원아이디,<br>" )
    public int postBoard(@RequestBody BoardInsDto dto) {
        return service.insBoard(dto);
    }

    @GetMapping
    @Operation(summary = "게시물 보기", description = "" +
            "page : 페이지 번호,<br>" +
            "row: 게시물 나타낼 갯수,<br>")
    public List<BoardVo> getBoard(@RequestParam(defaultValue = "1") int page
            , @RequestParam(defaultValue = "30") int row) {
        BoardSelDto dto = BoardSelDto.builder()
                .page(page)
                .row(row)
                .build();
        return service.selBoard(dto);
    }

    @GetMapping("/maxpage")
    @Operation(summary = "최대 페이지", description = "" +
            "row : 나타내고싶은 페이지수 <br>" )
    public int getBoardMaxPage(@RequestParam int row) {
        return service.selBoardMaxPage(row);
    }

    @GetMapping("/{iboard}")
    @Operation(summary = "게시물 하나씩 보기", description = "" +
            "iboard : 보고싶은 게시물 번호 <br>" )
    public BoardDetailVo BoardDetail(@PathVariable int iboard) {
        BoardDetailVo aa = new BoardDetailVo();
        aa.setIboard(iboard);
        return service.selBoardDetail(aa);
    }

    @DeleteMapping()
    @Operation(summary = "게시물 삭제", description = "" +
            "iboard : 삭제할 게시물 번호<br>" +
            "iuser : 삭제할 유저의 아이디 <br>")
    public int BoardDel(@RequestParam int iboard, @RequestParam int iuser){
        BoardDelDto dto = new BoardDelDto();
        dto.setIboard(iboard);
        dto.setIuser(iuser);
        return service.delBoard(dto);
    }

    @PutMapping()
    @Operation(summary = "게시물 수정", description = "" +
            "iboard : 수정할 게시물 번호<br>" +
            "iuser : 수정할 유저의 아이디 <br>" +
            "title : 수정할 제목 <br>" +
            "ctnt : 수정할 본문 <br>")
    public int updBoard(@RequestBody BoardUpdDto dto){
        return service.updBoard(dto);
    }
}
