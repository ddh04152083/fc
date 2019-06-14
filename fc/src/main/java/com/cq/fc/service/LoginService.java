package com.cq.fc.service;


import com.cq.fc.domain.Login;

public interface LoginService {
    /**
     * 更新或者保存登录信息
     * @param login
     * @return
     */
   Login saveOrUpdatePassword(Login login);


    /**
     *用户进行注册
     * @param login
     * @return
     */
   Login register(Login login);

    /**
     * 通过用户名查询登录信息
     * @param username
     * @return
     */
   Login getLoginByUsername(String username);


   void  deleteLoginByUsername(String username);


}
