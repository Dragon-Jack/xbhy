package com.dfbz.xbhy.test;


import com.dfbz.xbhy.entity.Favorite;
import com.dfbz.xbhy.mapper.ArticleMapper;
import com.dfbz.xbhy.service.ArticleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class testArticle {

    @Autowired
    ArticleService articleService;
    @Autowired
    ArticleMapper articleMapper;

    @Test
    public void test() {
//        List<String> strings = articleMapper.selectCommonArticle("2");
//        for (String string : strings) {
//            System.out.println(string);
//        }

        List<Favorite> strings = articleMapper.selectCommonArticle("2");
        for (Favorite string : strings) {
            System.out.println(string);
        }
    }
    @Test
    public void TEset(){
        String s = articleService.myFavorite(1, "1");
        System.out.println(s);
    }
}
