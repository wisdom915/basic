package com.basic.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class SysRole {
    private Long id;

    private String name;

    private String remark;

    private Date createTime;

    private List<SysMenu> menuList;
}