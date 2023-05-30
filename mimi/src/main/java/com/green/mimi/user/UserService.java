package com.green.mimi.user;

import com.green.mimi.user.model.UserInsDto;
import com.green.mimi.user.model.UserLoginDto;
import com.green.mimi.user.model.UserLoginVo;
import com.green.mimi.user.model.UserPatchPwDto;
import com.green.mimi.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
// 콘포먼트는 그냥 빈등록이다.
@Service
public class UserService {
    private final UserMapper mapper;
    private final CommonUtils commonUtils;

    @Autowired
    public UserService(UserMapper mapper, CommonUtils commonUtils){
        this.mapper=mapper;
        this.commonUtils = commonUtils;
    }

    public int insBoard(UserInsDto dto){
        //성별 대문자 변경
        char gender = Character.toUpperCase(dto.getGender()); // 소문자든 대문자든 대문자로 넣어준다.
        if(!(gender =='M' || gender == 'F')){
            return -1;
        } // M,F 값이 아니면 -1을 리턴해주는 구문
        dto.setGender(gender);

        //비밀번호 암호화
        String hadhPw = CommonUtils.encodeSha256(dto.getUpw());
        dto.setUpw(hadhPw);
        try {
            return mapper.insBoard(dto);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

    }

    public int login(UserLoginDto dto){
        UserLoginVo vo = mapper.selUserByUid(dto); // 나올수있는 경우의 값은 2가지이다. uid값이 유니크이기 때문이다.
        if(vo == null) {
            return 2;
        }

        String pwe = CommonUtils.encodeSha256(dto.getUpw());
        if(vo.getUpw().equals(pwe)){
            return 1;
        }
        return 3;
    }

    public int updUserPw(UserPatchPwDto dto){
        String hashedPw=commonUtils.encodeSha256(dto.getUpw());
        dto.setUpw(hashedPw);
        return mapper.updUserPw(dto);
    }


}

