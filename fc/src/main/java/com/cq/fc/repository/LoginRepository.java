package com.cq.fc.repository;


import com.cq.fc.domain.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

public interface LoginRepository extends JpaRepository<Login, Long> {
    /**
     * 通过用户名查看登录信息
     *
     * @param Username
     * @return
     */
    Login getLoginByUsername(String Username);

    @Transactional
    @Modifying
    void deleteByUsername(String username);


}
