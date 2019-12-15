package com.dfbz.xbhy.test;

import com.dfbz.xbhy.entity.Article;
import com.dfbz.xbhy.entity.UserFocus;
import com.dfbz.xbhy.service.ArticleService;
import com.dfbz.xbhy.service.UserFocusService;
import com.github.pagehelper.PageInfo;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class testsolr {
    @Autowired
    SolrClient solrClient;
    @Autowired
    ArticleService articleService;
    @Autowired
    UserFocusService userFocusService;

    @Test
    public void testsolr() throws IOException, SolrServerException {
        SolrQuery entries = new SolrQuery();
        entries.set("q", "学会自立");

        entries.setHighlight(true);
        //设置高亮域
        entries.addHighlightField("title");
        entries.addHighlightField("content");
        //设置高亮
        entries.setHighlightSimplePre("<1111>");
        entries.setHighlightSimplePost("</2222>");
        QueryResponse query = solrClient.query(entries);

        List<Article> beans = query.getBeans(Article.class);
        for (Article bean : beans) {
            System.out.println(bean);
        }
        Map<String, Map<String, List<String>>> highlighting = query.getHighlighting();
        for (Article bean : beans) {
            String title = highlighting.get(bean.getId()).get("title").get(0);
            String title1 = highlighting.get(bean.getId()).get("content").get(0);

            System.out.println(title);
            System.out.println(title1);
        }
    }


    @Test
    public void test2() {
        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("title","学会");
        PageInfo<Article> articlePageInfo = articleService.selectArticle(objectObjectHashMap);
        System.out.println(articlePageInfo);
    }
}
