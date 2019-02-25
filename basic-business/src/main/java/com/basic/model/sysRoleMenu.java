package com.basic.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class sysRoleMenu {
    private Long id;

    private Long roleId;

    private Long menuId;

}