package com.green.mimi.cmt.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CmtVo {
    private int iboardCmt;
    private int iboard;
    private int iuser;
    private String ctnt;
    private String createdAt;
    private String writer;
    private String writerMainPic;
}
