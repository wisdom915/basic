package com.basic.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;


@Getter
@Setter
@ToString
@EqualsAndHashCode
public class SysUser {
    private Long id;

    private String username;

    private String nickname;

    private String password;

    private String salt;

    private String email;

    private String mobile;

    private Byte status;

    private Long deptId;

    private Date createTime;

    public SysUser() {
    }

    public SysUser(String username) {
        this.username = username;
    }
}