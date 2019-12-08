package com.dfbz.xbhy.conteroller;


import com.dfbz.xbhy.entity.User;
import com.dfbz.xbhy.result.Result;
import com.dfbz.xbhy.service.UserService;
import com.dfbz.xbhy.utils.Md5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class RegisterConteroller {

    @Autowired
    UserService userService;

    @RequestMapping("register")
    public Result register(@RequestBody User user) {
        Result result = new Result();
        user.setPassword(Md5.encrypt(user.getPassword()));
        int i = userService.insertSelective(user);

        if (i > 0) {
            result.setMsg("注册成功");
            return result;
        }
        result.setMsg("注册失败");
        return result;
    }

    @RequestMapping("verifypw")
    public Integer verifypw(@RequestBody Map<String, Object> params) {
        if (!params.get("fixpw").equals(params.get("password"))) {
            return 1;
        }
        return null;
    }
}
