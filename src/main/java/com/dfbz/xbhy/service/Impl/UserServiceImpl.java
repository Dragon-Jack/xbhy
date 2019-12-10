package com.dfbz.xbhy.service.Impl;

import com.dfbz.xbhy.entity.User;
import com.dfbz.xbhy.mapper.UserMapper;
import com.dfbz.xbhy.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserServiceImpl extends TserviceImpi<User> implements UserService {
    @Autowired
    UserMapper userMapper;


    @Override
    public PageInfo<User> LookUser(Map<String, Object> params) {
        if (StringUtils.isEmpty(params.get("pageNum"))) {
            params.put("pageNum", 1);
        }
        if (StringUtils.isEmpty(params.get("pageSize"))) {
            params.put("pageSize", 5);
        }
        PageHelper.startPage((Integer) params.get("pageNum"), (Integer) params.get("pageSize"));

        List<User> realName = userMapper.LookUser(params);
        PageInfo<User> objectPageInfo = new PageInfo<>(realName);
        return objectPageInfo;
    }

    @Override
    public User toLookUser(String id) {
        User user;
        user = userMapper.selectByPrimaryKey(id);
        String integer = userMapper.FocusNum(id);
        user.setFocus(integer);
        return user;
    }
}
