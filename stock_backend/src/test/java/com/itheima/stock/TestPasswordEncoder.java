package com.itheima.stock;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class TestPasswordEncoder {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void test01(){
        String pwd="123456";
        String encodePwd = passwordEncoder.encode(pwd);
        System.out.println(encodePwd);
    }

    @Test
    public void test02(){
        String pwd="123456";
        String enPwd= "$2a$10$QrUC/9OhEGI2.zRwDHL8uOOj.L3KlaPPcw0jorN10iXrPPuRUKKha";
        boolean isSucess = passwordEncoder.matches(pwd,enPwd);
        System.out.println(isSucess? "密码匹配成功":"密码匹配失败");
    }


}
