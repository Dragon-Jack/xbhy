package com.dfbz.xbhy.service;

import com.dfbz.xbhy.entity.UserFocus;


public interface UserFocusService extends Tservice<UserFocus> {

    int addAttention(Integer uId,Integer focusId);
    int delAttention(Integer uId, Integer focusId);
}
