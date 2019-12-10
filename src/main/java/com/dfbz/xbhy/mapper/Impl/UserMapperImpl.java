package com.dfbz.xbhy.mapper.Impl;

import org.springframework.util.StringUtils;

import java.util.Map;

public class UserMapperImpl {

    public String LookUser(Map<String, Object> params) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT " +
               " * "+
                " FROM " +
                " `user` ");
        if (params.containsKey("realName")&&!StringUtils.isEmpty(params.get("realName"))) {
            sb.append(" where real_name LIKE CONCAT('%',#{realName},'%') ");
        }

        return sb.toString();
    }
}
