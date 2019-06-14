package com.cq.fc.controller;


import com.cq.fc.domain.Login;
import com.cq.fc.service.LoginService;
import com.cq.fc.utils.Md5Encrypt;
import com.cq.fc.utils.Response;
import com.cq.fc.vo.LoginVo;
import com.cq.fc.vo.RgisterVo;
import com.cq.fc.vo.UpdatePasswordVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@Slf4j
@RestController
@RequestMapping("/log")
@SuppressWarnings("all")
@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
@Api(value = "LoginController|用户登录控制器")
public class LoginController {
    @Autowired
    private LoginService loginService;

    private static final Long ROLE_USER_AUTHORITY_ID = 2L;

    //    @Autowired
//    private AuthorityService authorityService;
    @ApiOperation(value = "修改密码", notes = "修改密码")
    @ApiImplicitParam(name = "login", value = "修改密码", required = true, dataType = "UpdatePasswordVo")
    @PostMapping("/updatePwd")
    public String updatePwd(@RequestBody UpdatePasswordVo login) {
        log.info("login========" + login);
        if ((login.getOri_password() == null || ("".equals(login.getOri_password().trim()))) || ((login.getPassword() == null || ("".equals(login.getPassword().trim())))) || ((login.getRepassword() == null || ("".equals(login.getRepassword().trim()))))) {
            return Response.no.toString();
        } else {
            String orinPawd = Md5Encrypt.Encrypt(login.getOri_password());
            Login log = loginService.getLoginByUsername(login.getUsername());
            if (log.getPassword().equals(orinPawd)) {
                if (login.getPassword().equals(login.getRepassword())) {
                    if (!log.getPassword().equals(Md5Encrypt.Encrypt(login.getPassword()))) {
                        Login res = new Login();
                        res.setId(login.getId());
                        res.setType(Response.user.toString());
                        res.setUsername(login.getUsername());
                        res.setPassword(Md5Encrypt.Encrypt(login.getPassword()));
                        Login login1 = loginService.register(res);
                        System.out.println("login1=========" + login1);
                        if (login1 != null) {
                            return Response.yes.toString();
                        } else {
                            return Response.no.toString();
                        }
                    } else if (log.getPassword().equals(Md5Encrypt.Encrypt(login.getPassword()))) {
                        return Response.yes.toString();
                    } else {
                        return Response.no.toString();
                    }
                } else {
                    return Response.no.toString();
                }
            } else {

                return Response.no.toString();
            }

        }
    }

    /**
     * 注册用户
     *
     * @param login
     * @return
     */
    @ApiOperation(value = "用户注册", notes = "用户注册")
    @ApiImplicitParam(name = "login", value = "注册", required = true, dataType = "RgisterVo")
    @PostMapping("/register")
    public String register(@RequestBody RgisterVo login) {
        System.out.println(login);


        if ((login.getUsername() == null || ("".equals(login.getUsername().trim()))) || ((login.getPassword() == null || ("".equals(login.getPassword().trim())))) || ((login.getRepassword() == null || ("".equals(login.getRepassword().trim()))))) {
            return Response.no.toString();

        } else {
            if (login.getPassword().equals(login.getRepassword())) {
                Login res = new Login();



                res.setUsername(login.getUsername());
                res.setType(Response.user.toString());
                res.setPassword(Md5Encrypt.Encrypt(login.getPassword()));
                Login login1 = loginService.register(res);
                if (login1 != null) {
                    return Response.yes.toString();

                } else {

                    return Response.no.toString();
                }
            } else {
                return Response.no.toString();
            }
        }


    }

    @ApiOperation(value = "修改密码", notes = "用户修改密码")
    @ApiImplicitParam(name = "log", value = "登录信息", required = true, dataType = "LoginVo")
    @PostMapping("/update")
    public String update(@RequestBody LoginVo log) {
        Login login = new Login();
        login.setPassword(log.getPassword());
        login.setUsername(log.getUsername());
        login.setType(log.getType());
        if ((login.getUsername() == null || ("".equals(login.getUsername().trim()))) || ((login.getPassword() == null || ("".equals(login.getPassword().trim()))))) {
            return Response.no.toString();

        } else {
            Login login2 = new Login();
            login2.setUsername(login.getUsername());
            login2.setPassword(Md5Encrypt.Encrypt(login.getPassword()));
            loginService.saveOrUpdatePassword(login2);
            return Response.yes.toString();
        }
    }

    @ApiOperation(value = "获得用户登录信息", notes = "根据用户名获得用户信息")
    @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "Long")
    @GetMapping("/get/{username}")
    public Login getLogin(@PathVariable("username") String username) {
        return loginService.getLoginByUsername(username);
    }


    @PostMapping("/login")
    @ApiOperation(value = "根据登录实体信息进行登录", notes = "")
    @ApiImplicitParam(name = "logi", value = "登录信息", required = true, dataType = "LoginVo")
    public String login(@RequestBody LoginVo logi, HttpSession session) {
        log.info("logi-------------------" + logi);
        Login login = new Login();
        login.setPassword(logi.getPassword());
        login.setUsername(logi.getUsername());
        login.setType(logi.getType());
        log.info("login==================================" + login);
        if ((login.getUsername() == null || ("".equals(login.getUsername().trim()))) || ((login.getPassword() == null || ("".equals(login.getPassword().trim()))))) {
            return Response.no.toString();

        } else {
            Login login1 = loginService.getLoginByUsername(login.getUsername());
            log.info("login1=======" + login1);
            if (login1 == null) {
                return Response.NOREGISTER.toString();
            } else {
                String type = login.getType();
                log.info("type====================" + type);
                String s = Md5Encrypt.Encrypt(login.getPassword());
                if (login1.getPassword().equals(s) && login1.getType().equals(type)) {
                    // log.info(session.getAttribute("username").toString());
                    session.setAttribute("login", login1);
                    log.info("session============" + session.getAttribute("login").toString());
                    return type;
                } else {
                    return Response.no.toString();
                }


            }
        }
    }
}
