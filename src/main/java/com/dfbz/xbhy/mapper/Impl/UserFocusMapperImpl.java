package com.dfbz.xbhy.mapper.Impl;

import org.springframework.util.StringUtils;

public class UserFocusMapperImpl {

    public String attention(String id){
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT " +
                "user_id, " +
                "user_focus_id " +
                "FROM " +
                "userfocus ");
        if (!StringUtils.isEmpty(id)){
            sb.append(" where user_id=#{id} ");
        }
        return sb.toString();
    }
}
