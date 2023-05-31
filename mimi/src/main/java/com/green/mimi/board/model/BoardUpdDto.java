package com.green.mimi.board.model;

import lombok.Data;

@Data
public class BoardUpdDto {
    private int iboard;
    private int iuser;
    private String title;
    private String ctnt;
}
