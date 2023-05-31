package com.green.mimi.user;

import com.green.mimi.user.model.UserInsDto;
import com.green.mimi.user.model.UserLoginDto;
import com.green.mimi.user.model.UserLoginVo;
import com.green.mimi.user.model.UserPatchPwDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int insUser(UserInsDto dto);
    UserLoginVo selUserByUid(UserLoginDto dto);
    int updUserPw(UserPatchPwDto dto);
}
