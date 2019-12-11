package com.dfbz.xbhy.service.Impl;

import com.dfbz.xbhy.entity.UserFocus;
import com.dfbz.xbhy.mapper.UserFocusMapper;
import com.dfbz.xbhy.service.UserFocusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserFocusServiceImpl extends TserviceImpi<UserFocus> implements UserFocusService {
    @Autowired
    UserFocusMapper focusMapper;
    @Override
    public int addAttention(Integer uId, Integer focusId) {
        UserFocus userFocus = new UserFocus();
        userFocus.setUserId(uId);
        userFocus.setUserFocusId(focusId);
        return focusMapper.insertSelective(userFocus);
    }

    @Override
    public int delAttention(Integer uId, Integer focusId) {
        UserFocus userFocus = new UserFocus();
        userFocus.setUserId(uId);
        userFocus.setUserFocusId(focusId);
        return focusMapper.delete(userFocus);
    }
}
