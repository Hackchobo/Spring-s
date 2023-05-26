package com.green.board8.board;

import lombok.Data;

@Data
public class BoardEntity { // 순결함을 유지하여야 한다.
    int iboard;
    String title;
    String ctnt;
    String writer;
    String createtimeAt;
    String updatetimeAt;
}
