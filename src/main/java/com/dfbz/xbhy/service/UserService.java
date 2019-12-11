package com.dfbz.xbhy.service;

import com.dfbz.xbhy.entity.User;
import com.github.pagehelper.PageInfo;

import javax.servlet.http.HttpSession;
import java.util.Map;

public interface UserService extends Tservice<User> {

    PageInfo<User> LookUser(Map<String ,Object> params, HttpSession session);

    User toLookUser(String id);


}
