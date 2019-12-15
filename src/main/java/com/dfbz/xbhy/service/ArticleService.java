package com.dfbz.xbhy.service;

import com.dfbz.xbhy.entity.Article;
import com.dfbz.xbhy.entity.Favorite;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface ArticleService extends Tservice<Article> {

    PageInfo<Article> selectArticle(Map<String,Object> params);

    Article selectDetail(String id);

    List<Favorite> selectCommonArticle(String id);

    String myFavorite(Object uid,String aid);
}
