package com.dfbz.xbhy.service;

import com.dfbz.xbhy.entity.User;
import com.github.pagehelper.PageInfo;

import java.util.Map;

public interface UserService extends Tservice<User> {

    PageInfo<User> LookUser(Map<String ,Object> params);

    User toLookUser(String id);
}
