package com.green.webclient.timetable.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;

@ToString
public class TimetableInfoVo {
    private String schoolNm;
    private String semester;
    private String dayAndNight;
    private String grade;
    private String classNm;

    @JsonProperty("schoolNm") // 줄때는 자바단에 적혀있는데로
    public String getSchoolNm() {
        return schoolNm;
    }
    @JsonProperty("SCHUL_NM") // 받을때는 데이터에 적혀있는 값으로
    public void setSchoolNm(String schoolNm) {
        this.schoolNm = schoolNm;
    }

    public String getSemester() {
        return semester;
    }
    @JsonProperty("SEM")
    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getDayAndNight() {
        return dayAndNight;
    }
    @JsonProperty("DGHT_CRSE_SC_NM")
    public void setDayAndNight(String dayAndNight) {
        this.dayAndNight = dayAndNight;
    }

    public String getGrade() {
        return grade;
    }
    @JsonProperty("GRADE")
    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getClassNm() {
        return classNm;
    }
    @JsonProperty("CLASS_NM")
    public void setClassNm(String classNm) {
        this.classNm = classNm;
    }
}
