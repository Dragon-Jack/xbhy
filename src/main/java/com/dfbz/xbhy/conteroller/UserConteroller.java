package com.dfbz.xbhy.conteroller;

import com.dfbz.xbhy.entity.User;
import com.dfbz.xbhy.entity.UserFocus;
import com.dfbz.xbhy.result.Result;
import com.dfbz.xbhy.service.UserFocusService;
import com.dfbz.xbhy.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
public class UserConteroller {
    @Autowired
    UserService userService;

    @Autowired
    UserFocusService focusService;

    @RequestMapping("lookUser")
    public PageInfo<User> lookUser(@RequestBody Map<String,Object> params, HttpSession session){
        session.getAttribute("userId");
        return userService.LookUser(params,session);
    }

    @RequestMapping("toLookUser")
    public User toLookUser(@RequestParam String id){
        return userService.toLookUser(id);
    }

    @RequestMapping("toAttention")
    public Result toAttention(@RequestParam Integer yesId,@RequestParam Integer focusId,HttpSession session){
        Result result = new Result();
        Integer id =(Integer) session.getAttribute("userId");

        if (yesId.equals(0)){
             focusService.addAttention(id, focusId);
             result.setMsg("关注成功");
        }else {
            focusService.delAttention(id, focusId);
            result.setMsg("取消关注");
        }
        return result;
    }


    @RequestMapping("myUser")
    public PageInfo<UserFocus> myUser(@RequestBody Map<String,Object> params,HttpSession session){
        return focusService.myUser(params,session);
    }

    @RequestMapping("lookmyUser")
    public User lookmyUser(String id){
        return userService.toLookUser(id);
    }

    @RequestMapping("delMyUser")
    public Result delMyUser(Integer uId,Integer focusId){
        Result result = new Result();
        focusService.delAttention(uId, focusId);
        result.setMsg("取消关注");

        return result;
    }



}
