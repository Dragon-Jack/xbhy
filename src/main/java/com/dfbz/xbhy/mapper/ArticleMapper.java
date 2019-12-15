package com.dfbz.xbhy.mapper;

import com.dfbz.xbhy.entity.Article;
import com.dfbz.xbhy.entity.Favorite;
import com.dfbz.xbhy.mapper.Impl.ArticleMapperImpl;
import org.apache.ibatis.annotations.SelectProvider;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface ArticleMapper extends Mapper<Article> {

    @SelectProvider(type = ArticleMapperImpl.class,method ="selectDetail" )
    Article selectDetail(String id);

    @SelectProvider(type = ArticleMapperImpl.class,method ="selectDetailCount" )
    String selectDetailCount(String id);

    @SelectProvider(type = ArticleMapperImpl.class,method ="selectCommonArticle" )
    List<Favorite> selectCommonArticle(String id);

    @SelectProvider(type = ArticleMapperImpl.class,method ="myFavorite" )
    String myFavorite(Object uid,String aid);
}