package com.green.mimi.board;

import com.green.mimi.board.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    int insBoard(BoardEntity dto);
    List<BoardVo> selBoard(BoardSelDto dto);
    int selBoardMaxPage(int row); // int OOO 해도 상관 없음
    BoardDetailVo selBoardDetail(BoardDetailVo vo);
    int delBoard(BoardDelDto dto);
    int updBoard(BoardUpdDto dto);
}
