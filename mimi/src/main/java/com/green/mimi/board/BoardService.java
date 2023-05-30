package com.green.mimi.board;

import com.green.mimi.board.model.BoardInsDto;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
    private final BoardMapper mapper;

    public BoardService(BoardMapper mapper){
        this.mapper = mapper;
    }

    public int insBoard(BoardInsDto dto){
        return mapper.insBoard(dto);
    }
}
