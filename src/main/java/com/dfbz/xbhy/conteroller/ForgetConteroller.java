package com.dfbz.xbhy.conteroller;


import com.dfbz.xbhy.entity.User;
import com.dfbz.xbhy.result.Result;
import com.dfbz.xbhy.service.UserService;
import com.dfbz.xbhy.utils.Email;
import com.dfbz.xbhy.utils.Md5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
public class ForgetConteroller {

    @Autowired
    UserService userService;

    @RequestMapping("verify")
    @ResponseBody
    public Result verify(@RequestParam String email, HttpSession session) {
        Integer code = (int) ((Math.random() * 9 + 1) * 1000);
        Email.send(email, code);
        session.setAttribute("email", code);
        session.setMaxInactiveInterval(60);
        Result result = new Result();
        result.setMsg("发送成功,有效期60秒");
        return result;
    }

    @RequestMapping("forget")
    @ResponseBody
    public Result forget(@RequestBody Map<String, Object> params, HttpSession session) {
        Result result = new Result();
        User user = new User();
        user.setUsername((String) params.get("username"));
        User user1 = userService.selectOne(user);

        //验证码校验
        if (session.getAttribute("email").toString().equals(params.get("verify").toString())) {
            //新旧密码匹配
            if (!user1.getPassword() .equals(params.get("pw"))) {
                user1.setPassword(Md5.encrypt((String) params.get("pw")));  //加密
                userService.updateByPrimaryKeySelective(user1);
                result.setMsg("修改成功");
                return result;
            } else {
                result.setMsg("新密码不能与久密码一致");
            }
        } else {
            result.setMsg("验证码不正确");
        }
        return null;
    }
}
