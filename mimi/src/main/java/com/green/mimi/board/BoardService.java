package com.green.mimi.board;

import com.green.mimi.board.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    private final BoardMapper mapper;

    @Autowired
    public BoardService(BoardMapper mapper) {
        this.mapper = mapper;
    }

    public int insBoard(BoardInsDto dto) {
        BoardEntity entity = new BoardEntity();
        entity.setTitle(dto.getTitle());
        entity.setCtnt(dto.getCtnt());
        entity.setIuser(dto.getIuser());
        int result = mapper.insBoard(entity);
        if (result ==1) {
            return entity.getIboard();
        }
        return result;
    }
    public List<BoardVo> selBoard(BoardSelDto dto) {
        int startIdx = (dto.getPage() - 1) * dto.getRow();
        dto.setStartIdx(startIdx);
        return mapper.selBoard(dto);
    }

    public int selBoardMaxPage(int row) {
        return mapper.selBoardMaxPage(row);
    }

    public BoardDetailVo selBoardDetail(BoardDetailVo vo){
        return mapper.selBoardDetail(vo);
    }

    public int delBoard(BoardDelDto dto) {
        return mapper.delBoard(dto);
    }

    public int updBoard(BoardUpdDto dto) {
        return mapper.updBoard(dto);
    }

}
