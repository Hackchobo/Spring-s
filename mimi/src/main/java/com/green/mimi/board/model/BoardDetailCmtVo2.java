package com.green.mimi.board.model;

import com.green.mimi.cmt.model.CmtRes;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BoardDetailCmtVo2 {
    private BoardDetailVo board;
    private CmtRes cmt;
}
