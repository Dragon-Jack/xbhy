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
    
    public String myUser(String id){
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT " +
                "uf.user_id, " +
                "uf.user_focus_id, " +
                "u.real_name username " +
                "FROM " +
                "userfocus uf " +
                "LEFT JOIN " +
                "`user` u " +
                "on " +
                "uf.user_focus_id=u.id " +
                "where " +
                "user_id=#{id} ");
        return sb.toString();
    }
}
