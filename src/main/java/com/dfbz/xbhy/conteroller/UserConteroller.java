package com.dfbz.xbhy.conteroller;

import com.dfbz.xbhy.entity.User;
import com.dfbz.xbhy.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserConteroller {
    @Autowired
    UserService userService;

    @RequestMapping("lookUser")
    public PageInfo<User> lookUser(@RequestBody Map<String,Object> params){
        return userService.LookUser(params);
    }
}
