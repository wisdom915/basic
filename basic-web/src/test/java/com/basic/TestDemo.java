package com.basic;

import com.basic.model.SysUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description
 * @Author wisdomwang
 * @Date 2018/12/11 15:22
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestDemo {

    @Test
    public void sendSimpleEmail() {
        List<SysUser> users = new ArrayList<SysUser>();
        users.add(new SysUser("张三"));
        users.add(new SysUser("李四"));
        users.add(new SysUser("王五"));
        users.forEach((SysUser user) -> System.out.println(user.getUsername()));
    }

    public static void main(String[] args) {
        List<SysUser> users = new ArrayList<SysUser>();
        users.add(new SysUser("张三"));
        users.add(new SysUser("李四"));
        users.add(new SysUser("王五"));
        users.forEach((SysUser user) -> System.out.println(user.getUsername()));
        List<Map> list = new ArrayList<>();
        for(int i = 0;i<5;i++){
            Map map = new HashMap();
            map.put("1"+i,1);
            map.put("2"+i,2);
            map.put("3"+i,3);
            map.put("4"+i,4);
            list.add(map);
        }
        List<SysUser> collect = users.stream().filter(user -> user.getUsername().equals("张三")).collect(Collectors.toList());
        System.out.println("collect=="+collect);
    }
}
