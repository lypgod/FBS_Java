package com.lypgod.fbs.Model.Entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	private Integer id;

    @Column(nullable=false, unique=true)
    @NotBlank(message = "用户名不能为空")
    @Size(max=5, message = "用户名长度不能大于5")
	private String userName;

    @NotBlank(message = "密码不能为空")
	private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
