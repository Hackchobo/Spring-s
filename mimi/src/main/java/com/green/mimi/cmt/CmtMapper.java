package com.green.mimi.cmt;

import com.green.mimi.cmt.model.CmtEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CmtMapper {
    int insBoardCmt(CmtEntity entity);
}
