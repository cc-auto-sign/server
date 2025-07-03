package net.kegui.start.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import net.kegui.start.dto.LoginDto;
import net.kegui.start.service.LoginService;
import net.kegui.start.vo.LoginVo;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Override
    public LoginVo login(LoginDto loginDto) {
        // login

        // 生成token
        StpUtil.login(1,)
        return null;
    }
}
