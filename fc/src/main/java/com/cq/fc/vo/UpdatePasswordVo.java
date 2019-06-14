package com.cq.fc.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Setter
@Getter
public class UpdatePasswordVo implements Serializable {
    private long id;
    private String ori_password;
    private String username;
    private String password;
    private String repassword;
}
