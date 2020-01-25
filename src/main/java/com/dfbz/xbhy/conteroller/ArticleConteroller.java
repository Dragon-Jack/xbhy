package com.dfbz.xbhy.conteroller;

import com.dfbz.xbhy.entity.Article;
import com.dfbz.xbhy.entity.Favorite;
import com.dfbz.xbhy.entity.User;
import com.dfbz.xbhy.mapper.FavoriteMapper;
import com.dfbz.xbhy.result.Result;
import com.dfbz.xbhy.service.ArticleService;
import com.dfbz.xbhy.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class ArticleConteroller {
    @Autowired
    ArticleService articleService;
    @Autowired
    FavoriteMapper favoriteMapper;
    @Autowired
    UserService userService;

    @RequestMapping("/selectArticle")
    public PageInfo<Article> selectArticle(@RequestBody Map<String,Object> params) {
        return articleService.selectArticle(params);
    }
    @RequestMapping("/detail")
    public Article selectArticleDetail(String id) {
        return articleService.selectDetail(id);
    }

    @RequestMapping("/common")
    public List<Favorite> selectCommonArticle(String id) {
        return articleService.selectCommonArticle(id);
    }

    @RequestMapping("/myFavorite")
    public String myFavorite(HttpSession session, @RequestParam String aid) {
        return articleService.myFavorite(session.getAttribute("userId"),aid);
    }

    @RequestMapping("/add")
    public Result add(HttpSession session, @RequestParam Integer aid) {
        Result result = new Result();
        Favorite favorite = new Favorite();
        favorite.setuId(Integer.valueOf((Integer) session.getAttribute("userId")));
        favorite.setaId(aid);
        favoriteMapper.insert(favorite);
        result.setMsg("收藏成功");
        return result;
    }

    @RequestMapping("/del")
    public Result del(HttpSession session, @RequestParam Integer aid) {
        Result result = new Result();
        Favorite favorite = new Favorite();
        favorite.setuId(Integer.valueOf((Integer) session.getAttribute("userId")));
        favorite.setaId(aid);
        favoriteMapper.delete(favorite);
        result.setMsg("取消成功");
        return result;
    }

    @RequestMapping("/addArt")
    public Result del(HttpSession session, @RequestParam Map<String,Object> params) {
        User user = userService.selectByPrimaryKey(session.getAttribute("userId"));
        Article article = new Article();
        article.setTitle((String) params.get("title"));
        article.setContent((String) params.get("content"));
        article.setBrowseCount(0);
        article.setPublishDate(new Date());
        article.setUserId((Integer) session.getAttribute("userId"));
        article.setPublishRealName(user.getRealName());
        articleService.insertSelective(article);

        Result result = new Result();
        result.setMsg("发布成功");
        return result;
    }
    @RequestMapping("/myArt")
    public PageInfo<Article> myArt(HttpSession session, @RequestBody Map<String,Object> params) {

        PageInfo<Article> userIp = articleService.myArt(Integer.valueOf((Integer)session.getAttribute("userId")),params);
        return userIp;
    }

}
