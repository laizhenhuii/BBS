package com.bbs;
import org.jasypt.encryption.StringEncryptor;
import org.testng.annotations.AfterTest;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.Test;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class test {

    //注入StringEncryptor
    @Autowired
    StringEncryptor encryptor;

    @Test
    public void encry() {
        //加密root
        String username = encryptor.encrypt("root");
        System.out.println(username);
        //加密123456
        String password = encryptor.encrypt("123456");
        System.out.println(password);
    }
}