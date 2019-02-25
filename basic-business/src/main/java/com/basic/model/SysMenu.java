package com.basic.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class SysMenu implements Serializable {
    private Long id;

    private Long parentId;

    private String name;

    private String url;

    private String permission;

    private Byte type;

    private String icon;

    private Integer orderNum;

    private List<SysMenu> children = new ArrayList<>();

    List<SysRole> roleList = new ArrayList<>();

    public void addChild(SysMenu sysMenu){
        children.add(sysMenu);
    }

    public SysMenu() {

    }

    public SysMenu(Long id, Long parentId, String name, String url, String permission, Byte type, String icon, Integer orderNum) {
        this.id = id;
        this.parentId = parentId;
        this.name = name;
        this.url = url;
        this.permission = permission;
        this.type = type;
        this.icon = icon;
        this.orderNum = orderNum;
    }
}