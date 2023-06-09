package com.green.mimi.cmt.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class CmtRes {
    private int maxPage;
    private int row;
    private int isMore; //0 댓글 더 없음, 1 댓글 더 있음
    private List<CmtVo> list;
}
