package com.green.mimi.user.model;

import lombok.Data;

@Data
public class UserEntity {
    private int iuser;
    private String uid;
    private String upw;
    private String nm;
    private String gender;
    private String addr;
    private String main_pic;
    private String created_at;
    private String updated_at;

}
