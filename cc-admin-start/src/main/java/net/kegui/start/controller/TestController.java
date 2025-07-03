package net.kegui.start.controller;

import cn.dev33.satoken.stp.StpUtil;
import net.kegui.framework.core.api.annotation.OriginalResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 会被Advice包装
    @GetMapping("/")
    public String test(){
        return "Test";
    }

    // 不被Advice包装
    @GetMapping("/test")
    @OriginalResponse
    public String test2(){
        return "Test2";
    }

    // 测试db
    @GetMapping("/db")
    public Object testDb(){
        return jdbcTemplate.queryForList("select 1;");
    }

    // 未登录测试
    @GetMapping("/noLogin")
    public Object noLogin(){
        return StpUtil.isLogin();
    }

//    // 登录测试
//    @GetMapping("/login")
//    public Object login(){
//        StpUtil.login(10001);
//        return "do sth...";
//    }

}
