package com.green.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // 빈등록
public class BoardService {

    @Autowired
    private BoardMapper mapper;


    public int insBoard(BoardEntity entity) {
        System.out.println("service-insBoard");
        return mapper.insBoard(entity);
    }

    public List<BoardEntity> selBoardAll() {
        return mapper.selBoardAll();
    }

    public BoardEntity selBoardById(BoardEntity entity){
        return mapper.selBoardById(entity);
    }

    public int updBoard(BoardEntity entity) {
        System.out.println("service-updBoard");
        return mapper.updBoard(entity);
    }

    public int delBoard(BoardEntity iboard) {
       return mapper.delBoard(iboard);
    }
}
