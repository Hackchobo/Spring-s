package com.green.mimi.cmt.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CmtSelDto {
    private int iboard;
    private int startIdx;
    private int page;
    private int row;
}
