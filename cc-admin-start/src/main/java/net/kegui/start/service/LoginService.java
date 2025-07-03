package net.kegui.start.service;

import net.kegui.start.dto.LoginDto;
import net.kegui.start.vo.LoginVo;

public interface LoginService {
    /**
     * 登录
     * @param loginDto
     */
    LoginVo login(LoginDto loginDto);
}
