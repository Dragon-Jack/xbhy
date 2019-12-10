package com.dfbz.xbhy.mapper.Impl;

import org.springframework.util.StringUtils;

public class FocusNumMapperImpl {

    public String FocusNum(String id){
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT count(*) from userfocus ");
        if (!StringUtils.isEmpty(id)){
            sb.append(" where user_focus_id=#{id} ");
        }
        return sb.toString();
    }
}
