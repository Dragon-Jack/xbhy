package com.dfbz.xbhy.service;

import com.dfbz.xbhy.entity.User;
import com.dfbz.xbhy.entity.UserFocus;
import com.github.pagehelper.PageInfo;

import javax.servlet.http.HttpSession;
import java.util.Map;


public interface UserFocusService extends Tservice<UserFocus> {

    int addAttention(Integer uId,Integer focusId);
    int delAttention(Integer uId, Integer focusId);

    PageInfo<UserFocus> myUser(Map<String ,Object> params, HttpSession session);
}
