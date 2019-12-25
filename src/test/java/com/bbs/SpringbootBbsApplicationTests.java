package com.bbs;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Driver;

@SpringBootTest
class SpringbootBbsApplicationTests {

    @Test
    void contextLoads() {
        System.out.println(Driver.class);
    }

}
