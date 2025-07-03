package net.kegui.start.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import cn.dev33.satoken.stp.StpUtil;
import jakarta.validation.Valid;
import net.kegui.start.dto.LoginDto;
import net.kegui.start.service.LoginService;
import net.kegui.start.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("logout")
    public String logout(){
        StpUtil.logout();
        return "success";
    }

    @SaIgnore
    @PostMapping("login")
    public LoginVo login(@Valid @RequestBody LoginDto loginDto){
        return loginService.login(loginDto);
    }

}
