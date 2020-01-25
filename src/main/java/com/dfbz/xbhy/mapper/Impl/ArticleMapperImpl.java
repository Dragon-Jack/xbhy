package com.dfbz.xbhy.mapper.Impl;

import org.springframework.util.StringUtils;

import java.util.Map;

public class ArticleMapperImpl {
    public String selectDetail(String id) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT " +
                "a.id, " +
                "a.title, " +
                "a.content, " +
                "a.browse_count, " +
                "a.publish_date, " +
                "a.publish_real_name, " +
                "a.user_id, " +
                "u.real_name " +
                "FROM " +
                "article AS a " +
                "LEFT JOIN " +
                "`user` u " +
                "on " +
                "a.user_id=u.id " +
                "where " +
                "a.id=#{id}");
        return sb.toString();
    }

    public String selectDetailCount(String id) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT " +
                "COUNT(*) count " +
                "FROM  " +
                "favorite f " +
                "where  " +
                "f.a_id=#{id}");
        return sb.toString();
    }

    public String selectCommonArticle(String id) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT " +
                "f.u_id, " +
                "f.a_id, " +
                " " +
                "u.real_name " +
                "FROM " +
                "favorite AS f " +
                "LEFT JOIN " +
                "`user` u " +
                "on " +
                "f.u_id=u.id " +
                "where " +
                "a_id=#{id}");
        return sb.toString();
    }

    public String myFavorite(Object uid, String aid) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT " +
                "u_id, " +
                "a_id " +
                "FROM " +
                "favorite " +
                "where " +
                "u_id=#{uid}  " +
                "and " +
                "a_id=#{aid} ");
        return sb.toString();
    }

    public String myArt(Integer id, Map<String,Object> params) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT " +
                "a.*, " +
                "u.real_name " +
                "FROM " +
                "favorite f " +
                "LEFT JOIN  " +
                "article a " +
                "on " +
                "f.a_id=a.id " +
                "LEFT JOIN " +
                "`user` u " +
                "on " +
                "u_id=u.id " +
                "where " +
                "u_id=#{id} ");

        if (params.containsKey("title")&& !StringUtils.isEmpty(params.get("title"))) {
            sb.append("and a.title like CONCAT('%','" + params.get("title") + "','%')");
        }
        return sb.toString();
    }
}
