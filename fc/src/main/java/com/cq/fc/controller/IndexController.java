package com.cq.fc.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@Api("IndexController|首页控制器")
public class IndexController {
    @ApiOperation(value = "跳转首页", notes = "跳转首页")
    @GetMapping("/")
    public String index() {
        return "redirect:/index.html";
    }
    @ApiOperation(value = "跳转首页", notes = "跳转首页")
    @GetMapping("/login")
    public String login() {
        return "redirect:/index.html";
    }


    @ApiOperation(value = "退出登录", notes = "退出登录")
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        log.info("-------------------------------------------");
        log.info("logout========" + session.getAttribute("login").toString());
        session.removeAttribute("login");
        return "redirect:/index.html";
    }
//    @GetMapping("/login-error")
//    public String loginError( ){
//        return "index.html";
//    }
//    @GetMapping("/main")
//    public String main(){
//        return "main.html";
//    }
}
