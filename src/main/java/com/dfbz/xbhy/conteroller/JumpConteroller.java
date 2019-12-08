package com.dfbz.xbhy.conteroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JumpConteroller{

    //登录
    @RequestMapping("")
    public String toLogin(){
        return "html/index";
    }
    //忘记密码
    @RequestMapping("toForget")
    public String forget(){
       return "html/forget";
    }
    //注册
    @RequestMapping("toRegister")
    public String register(){
       return "html/register";
    }

    //主页
    @RequestMapping("home")
    public String home(){
        return "html/html/home";
    }

    @RequestMapping("article")
    public String article(){
        return "html/html/article";
    }

    @RequestMapping("article_add")
    public String article_add(){
        return "html/html/article_add";
    }

    @RequestMapping("article_collect")
    public String article_collect(){
        return "html/html/article_collect";
    }

    @RequestMapping("article_detail")
    public String article_detail(){
        return "html/html/article_detail";
    }

    @RequestMapping("department")
    public String department(){
        return "html/html/department";
    }

    @RequestMapping("meeting")
    public String meeting(){
        return "html/html/meeting";
    }

    @RequestMapping("meeting_add")
    public String meeting_add(){
        return "html/html/meeting_add";
    }

    @RequestMapping("meeting_detail")
    public String meeting_detail(){
        return "html/html/meeting_detail";
    }

    @RequestMapping("my_user")
    public String my_user(){
        return "html/html/my_user";
    }

    @RequestMapping("user")
    public String user(){
        return "html/html/user";
    }

    @RequestMapping("user_detail")
    public String user_detail(){
        return "html/html/user_detail";
    }

    @RequestMapping("user_look")
    public String user_look(){
        return "html/html/user_look";
    }
}
