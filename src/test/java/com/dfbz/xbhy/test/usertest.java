package com.dfbz.xbhy.test;

import com.dfbz.xbhy.entity.User;
import com.dfbz.xbhy.mapper.UserMapper;
import com.dfbz.xbhy.service.UserService;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;

@SpringBootTest
public class usertest {

    @Autowired
    UserMapper userMapper;
    @Autowired
    UserService userService;
    @Test
    public void testuser(){
//        System.out.println(userMapper.LookUser("东"));
        HashMap<String, Object> o = new HashMap<>();
        o.put("realName", "东");
        PageInfo<User> userPageInfo = userService.LookUser(o);
        System.out.println(userPageInfo);
    }
}
