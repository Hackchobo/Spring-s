package com.green.mimi.user;

import com.green.mimi.user.model.UserInsDto;
import com.green.mimi.user.model.UserLoginDto;
import com.green.mimi.user.model.UserPatchPwDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService service;

    @Autowired
    public UserController(UserService service){
        this.service = service;
    }

    @PostMapping
    @Operation(summary = "회원가입",description = ""+
            "uid:[20] 회원 아이디,<br>" +
            "upw:[100] 회원 비밀번호,<br>" +
            "nm:[30] 회원명,<br>" +
            "gender:[20] 회원 성별(M:남성,F:여성),<br>" +
            "addr:[100] 회원 주소")
    public int postUser(@RequestBody UserInsDto dto){
        return service.insBoard(dto);
    }

    @PostMapping("/login")
    @Operation(summary = "로그인", description = ""+
            "리턴값:" +
            "(1)로그인 성공," +
            "(2)로그인 없음," +
            "(3)비밀번호 다름")
    public int postLoginUser(@RequestBody UserLoginDto dto){
        return service.login(dto);
    }

    @PatchMapping("/pw")
    public int PachUser(@RequestBody UserPatchPwDto dto){
        return service.updUserPw(dto);
    }
}
