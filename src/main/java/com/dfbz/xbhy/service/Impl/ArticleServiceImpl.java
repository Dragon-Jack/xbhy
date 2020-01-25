package com.dfbz.xbhy.service.Impl;

import com.dfbz.xbhy.entity.Article;
import com.dfbz.xbhy.entity.Favorite;
import com.dfbz.xbhy.mapper.ArticleMapper;
import com.dfbz.xbhy.service.ArticleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ArticleServiceImpl extends TserviceImpi<Article> implements ArticleService {

    @Autowired
    ArticleMapper articleMapper;

    @Autowired
    SolrClient solrClient;

    @Override
    public PageInfo<Article> selectArticle(Map<String, Object> params) {

        if (StringUtils.isEmpty(params.get("pageNum"))) {
            params.put("pageNum", 1);
        }
        if (StringUtils.isEmpty(params.get("pageSize"))) {
            params.put("pageSize", 5);
        }
        PageHelper.startPage((Integer) params.get("pageNum"), (Integer) params.get("pageSize"));
        //数据库查询的信息
        List<Article> articles = articleMapper.selectAll();

        if (params.containsKey("title") && !StringUtils.isEmpty(params.get("title"))) {
            //高亮信息
            SolrQuery entries = new SolrQuery();
            entries.set("q", (String) params.get("title"));

            entries.setHighlight(true);
            //设置高亮域
            entries.addHighlightField("title");
            entries.addHighlightField("content");
            //设置高亮
            entries.setHighlightSimplePre("<font style='color:red';>");
            entries.setHighlightSimplePost("</font>");
            QueryResponse query = null;
            try {
                query = solrClient.query(entries);
                solrClient.commit();
            } catch (SolrServerException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
//            solr结果集
            List<Article> beans = query.getBeans(Article.class);
//            高亮数据
            Map<String, Map<String, List<String>>> highlighting = query.getHighlighting();

            for (Article bean : beans) {
                for (Article article : articles) {  //遍历高亮数据
                    article.setTitle(highlighting.get(bean.getId()).get("title").get(0));
                    article.setContent(highlighting.get(bean.getId()).get("content").get(0));
                }
            }
        }

        PageInfo<Article> articlePageInfo = new PageInfo<>(articles);

        return articlePageInfo;
    }

    @Override
    public Article selectDetail(String id) {

        Article article = articleMapper.selectDetail(id);
        String s = articleMapper.selectDetailCount(id);
        article.setCount(s);
        return article;
    }

    @Override
    public List<Favorite> selectCommonArticle(String id) {

        return articleMapper.selectCommonArticle(id);
    }

    @Override
    public String myFavorite(Object uid, String aid) {
        return articleMapper.myFavorite(uid,aid);
    }

    @Override
    public PageInfo<Article> myArt(Integer id, Map<String, Object> params) {
        if (StringUtils.isEmpty(params.get("pageNum"))) {
            params.put("pageNum", 1);
        }
        if (StringUtils.isEmpty(params.get("pageSize"))) {
            params.put("pageSize", 5);
        }
        PageHelper.startPage((Integer) params.get("pageNum"), (Integer) params.get("pageSize"));
        List<Article> articles = articleMapper.myArt(id, params);

        for (Article article : articles) {
            String s = articleMapper.selectDetailCount(article.getId());
            article.setCount(s);
        }
        PageInfo<Article> articlePageInfo = new PageInfo<>(articles);
        return articlePageInfo;
    }

}
