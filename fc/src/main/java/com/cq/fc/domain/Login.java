package com.cq.fc.domain;



import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;


@Entity
@Getter
@Setter
@ToString
public class Login implements  Serializable {
    private static final long serialVersionUID = 2L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotEmpty(message = "用户名不能为空")
    @Size(max = 20)
    @Column(nullable = false, length = 20) // 映射为字段，值不能为空
    private String username;
    @NotEmpty(message = "密码不能为空")
    @Size(max = 100)
    @Column(nullable = false, length = 100) // 映射为字段，值不能为空
    private String password;
    @NotEmpty(message = "身份类型")
    @Size(max = 20)
    @Column(nullable = false, length = 20) // 映射为字段，值不能为空
     private String type;






}
