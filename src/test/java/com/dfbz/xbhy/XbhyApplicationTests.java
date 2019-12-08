package com.dfbz.xbhy;

import com.dfbz.xbhy.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

@SpringBootTest
class XbhyApplicationTests {

    @Autowired
    UserMapper userMapper;
    @Test
    void contextLoads() {

    }

}
