package com.dfbz.xbhy.mapper.Impl;

import org.springframework.util.StringUtils;

import java.util.Map;

public class UserMapperImpl {

    public String LookUser(Map<String, Object> params) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT " +
                "u.id, " +
                "u.username, " +
                "u.`password`, " +
                "u.email, " +
                "u.real_name, " +
                "u.age, " +
                "u.phone, " +
                "u.gender, " +
                "u.`desc`, " +
                "u.register_time, " +
                "u.login_time, " +
                "u.pic, " +
                "u.look, " +
                "u.is_secret, " +
                "u.dept_name, " +
                "u.dept_id " +
                "FROM " +
                "`user` AS u ");
        if (!StringUtils.isEmpty(params.get("realName"))) {
            sb.append("where real_name LIKE CONCAT('%',#{realName},'%')");
        }

        return sb.toString();
    }
}
