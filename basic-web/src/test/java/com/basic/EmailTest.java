package com.basic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description
 * @Author wisdomwang
 * @Date 2018/12/11 15:22
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmailTest {
    @Value("${spring.mail.username}")
    private String userName;
    @Autowired
    private JavaMailSender javaMailSender;
    @Test
    public void sendSimpleEmail(){
        SimpleMailMessage message=new SimpleMailMessage();
        message.setFrom(userName);
        //发送者
        message.setTo("1178127167@qq.com");
        //接收者
        message.setSubject("啦啦啦");
        //邮件主题
        message.setText("快要下班了哟   智");
        //邮件内容
        javaMailSender.send(message);
    }
}
