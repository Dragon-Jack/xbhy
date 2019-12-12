package com.dfbz.xbhy.conteroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ArticleConteroller {

    @RequestMapping("selectarticle")
    public void selectarticle(@RequestParam Map<String, Object> params) {
        System.out.println(params);

    }
}
