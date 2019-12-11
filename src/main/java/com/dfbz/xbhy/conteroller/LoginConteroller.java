package com.dfbz.xbhy.conteroller;

import com.dfbz.xbhy.entity.User;
import com.dfbz.xbhy.result.Result;
import com.dfbz.xbhy.service.UserService;
import com.dfbz.xbhy.utils.Md5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

@RestController
public class LoginConteroller {

    @Autowired
    UserService userService;

    @RequestMapping("login")
    public Result login(@RequestBody Map<String, Object> params, HttpSession session) {
        Result result = new Result();       //返回结果的类
        User user = new User();
        user.setUsername((String) params.get("username"));      //把前端输入的用户账号设置到user实体类
        String password =(String) params.get("password");   //前端获取到的密码
        String encrypt = Md5.encrypt(password);     //把前端输入的密码加密
        User u = null;
        if (params.size() > 0) {
            u = userService.selectOne(user);           //通过用户账号查找用户
        } else {
            result.setMsg("请输入账号密码");
            return result;
        }
        if (params.containsKey("checkbox") && params.get("checkbox").equals(true)) {       //勾选了免密登录
            if (!StringUtils.isEmpty(params.get("checkCode"))&&params.get("checkCode").equals(session.getAttribute("code"))) {    //校验验证码
                if (u.getPassword().equals(encrypt)) {    //验证密码
                    session.setAttribute("Free", u.getId());
                    session.setMaxInactiveInterval(7*60*60);
                    return null;
                } else {
                    result.setMsg("密码不正确");
                    return result;
                }
            } else {
                result.setMsg("验证码不能为空或错误");
                return result;
            }
        } else {     //未勾选免密登录
            if (!StringUtils.isEmpty(params.get("checkCode"))&&params.get("checkCode").equals(session.getAttribute("code"))) {    //校验验证码
                if (u.getPassword().equals(encrypt)) {
                    session.setAttribute("userId", u.getId());
                    return null;
                } else {
                    result.setMsg("密码不正确");
                    return result;
                }
            } else {
                result.setMsg("验证码不能为空或错误");
                return result;
            }

        }
    }

    @RequestMapping("getSession")
    public String getSession(HttpSession session) {
        Enumeration<String> attributeNames = session.getAttributeNames();
        String s=null;
        while (attributeNames.hasMoreElements()){
            s = attributeNames.nextElement();
        }
            return s;
    }
}
