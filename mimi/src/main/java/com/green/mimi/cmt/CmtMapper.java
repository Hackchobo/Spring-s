package com.green.mimi.cmt;

import com.green.mimi.cmt.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CmtMapper {
    int insBoardCmt(CmtEntity entity);
    List<CmtVo> selBoardCmt(CmtSelDto dto);
    int selBoardCmtRowCountByIBoard(int iboard);
    int delBoardCmt(CmtDelDto dto);
    int updBoardCmt(CmtEntity entity);
}
