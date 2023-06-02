package com.green.mimi.user.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserEntity {
    private int iUser;
    private String mainPic;
}
