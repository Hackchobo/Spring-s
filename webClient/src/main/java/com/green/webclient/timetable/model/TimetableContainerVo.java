package com.green.webclient.timetable.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@AllArgsConstructor
public class TimetableContainerVo {
    private String date;
    private String year;
    private List<TimetableInfoVo> infoList;
}
