package com.cq.fc.service.impl;


import com.cq.fc.domain.Login;
import com.cq.fc.repository.LoginRepository;
import com.cq.fc.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户登录注册管理接口的实现
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginRepository loginRepository;

    @Transactional
    @Override
    public Login saveOrUpdatePassword(Login login) {
        return loginRepository.save(login);
    }

    @Transactional
    @Override
    public Login register(Login login) {
        return loginRepository.save(login);
    }

    @Override
    public Login getLoginByUsername(String username) {
        return loginRepository.getLoginByUsername(username);
    }



    @Override
    public void deleteLoginByUsername(String username) {
        loginRepository.deleteByUsername(username);
    }


}
