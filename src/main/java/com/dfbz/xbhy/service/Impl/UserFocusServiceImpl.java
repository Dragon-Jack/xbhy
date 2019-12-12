package com.dfbz.xbhy.service.Impl;

import com.dfbz.xbhy.entity.User;
import com.dfbz.xbhy.entity.UserFocus;
import com.dfbz.xbhy.mapper.UserFocusMapper;
import com.dfbz.xbhy.service.UserFocusService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

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

    @Override
    public PageInfo<UserFocus> myUser(Map<String, Object> params, HttpSession session) {
        if (StringUtils.isEmpty(params.get("pageNum"))) {
            params.put("pageNum", 1);
        }
        if (StringUtils.isEmpty(params.get("pageSize"))) {
            params.put("pageSize", 5);
        }
        PageHelper.startPage((Integer) params.get("pageNum"), (Integer) params.get("pageSize"));
        List<UserFocus> userId = focusMapper.myUser(session.getAttribute("userId").toString());
        PageInfo<UserFocus> userPageInfo = new PageInfo<>(userId);
        return userPageInfo;
    }


}
