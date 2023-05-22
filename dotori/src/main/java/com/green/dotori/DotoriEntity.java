package com.green.dotori;

import lombok.Data;

@Data
public class DotoriEntity {
    private int idoto;
    private String title;
    private String main;
    private String writer;
    private String createTime;
    private String updateTime;
}
