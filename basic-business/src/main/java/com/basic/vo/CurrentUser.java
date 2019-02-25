package com.basic.vo;

import com.basic.model.SysMenu;
import com.basic.model.SysRole;
import com.basic.model.SysUser;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class CurrentUser {

    private SysUser user;
    private List<SysRole> roleList;
    private List<SysMenu> menuList;


    public CurrentUser() {
    }
}
