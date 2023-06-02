package com.green.mimi.user;

import com.green.mimi.user.model.*;
import com.green.mimi.utils.FileUtils;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int insUser(UserInsDto dto);
    UserLoginVo selUserByUid(UserLoginDto dto);
    int updUserPw(UserPatchPwDto dto);
    int updUserPic(UserPatchPicDto dto);
}
