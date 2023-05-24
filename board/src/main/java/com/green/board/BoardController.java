package com.green.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // for문이 돌면 안된다.
@RequestMapping("/board")
public class BoardController {


    private final BoardService service; //DI(Defenders injection)
    // 싱글톤을 알아서 생성해줌

    @Autowired //
    public BoardController(BoardService service){
        this.service = service;
    }

    @PostMapping // 옛날에는 없었다. 에혀
    public int boardPost(@RequestBody BoardEntity entity) {
        System.out.println(entity);
        return service.insBoard(entity);            // for문이 돌면 안된다.
    }

    @GetMapping
    public List<BoardEntity> boardGetAll() {
        return service.selBoardAll();
    }

    @GetMapping("/{iboard}")
    public BoardEntity boardGetById(@PathVariable int iboard) {
        BoardEntity entity = new BoardEntity();
        entity.setIboard(iboard);
        System.out.println(iboard);
        return service.selBoardById(entity);
    }

    @PutMapping
    public int boardPut(@RequestBody BoardEntity entity){
        System.out.println(entity);
        return service.updBoard(entity);
    }

    @DeleteMapping("/{iboard}")
    public int boardDel(@PathVariable int iboard) {
        BoardEntity entity = new BoardEntity();
        entity.setIboard(iboard);
        System.out.println(iboard);
        return service.delBoard(entity);
    }

}
