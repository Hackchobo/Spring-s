package com.green.mimi.board;

import com.green.mimi.board.model.BoardInsDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {
    int insBoard(BoardInsDto dto);
}
