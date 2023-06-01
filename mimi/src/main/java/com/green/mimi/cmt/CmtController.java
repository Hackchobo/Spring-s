package com.green.mimi.cmt;

import com.green.mimi.cmt.model.*;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/board")
public class CmtController {

    private final CmtService service;

    @Autowired
    public CmtController(CmtService service) {
        this.service = service;
    }

    @PostMapping("/{iboard}/cmt")
    @Operation(summary = "댓글 작성", description = "" +
            "iboard : 게시물 번호,<br>" +
            "iuser : 게시물 작성자 ID 넘버,<br>" +
            "cmt : 댓글 작성,<br>" )
    public int postBoardCmt(@PathVariable int iboard
                            ,@RequestBody CmtInsDto dto){ // 스웨거 때문에 InsDto를 받게 된다. (원래는 엔티티를 받아도 되지만)
        CmtEntity entity = new CmtEntity();
        entity.setIboard(iboard);
        entity.setIuser(dto.getIuser());
        entity.setCtnt(dto.getCtnt());
        return service.insBoardCmt(entity);
    }

    @GetMapping("/{iboard}/cmt")
    public CmtRes getBoardCmt(@PathVariable int iboard
            ,@RequestParam @Min(value = 1) int page
            , @RequestParam(defaultValue = "5") int row) {
        CmtSelDto dto = CmtSelDto.builder()
                .iboard(iboard)
                .page(page)
                .row(row)
                .build();
        return service.selBoardCmt(dto);
    }

    @DeleteMapping("/cmt/{iboardCmt}")
    public int delBoardCmt(@PathVariable int iboardCmt
                        , @RequestParam int iuser){
        CmtDelDto dto = new CmtDelDto();
        dto.setIboardCmt(iboardCmt);
        dto.setIuser(iuser);
        return service.delBoardCmt(dto);
    }

    @PutMapping("/cmt/{iboardCmt}")
    public int updBoardCmt(@PathVariable int iboardCmt,
                           @RequestBody CmtUpdDto dto) {
                CmtEntity entity = new CmtEntity();
                entity.setIboardCmt(iboardCmt);
                entity.setIuser(dto.getIuser());
                entity.setCtnt(dto.getCtnt());
                return service.updBoardCmt(entity);
    }

}
