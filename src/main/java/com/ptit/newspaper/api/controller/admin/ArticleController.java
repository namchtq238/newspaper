package com.ptit.newspaper.api.controller.admin;

import com.ptit.newspaper.api.req.ArticleRequest;
import com.ptit.newspaper.api.res.ArticleResponse;
import com.ptit.newspaper.database.model.Article;
import com.ptit.newspaper.database.repository.ArticleRepository;
import com.ptit.newspaper.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/admin/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private ArticleRepository articleRepository;
    @GetMapping
    List<ArticleResponse> getAllArticle(){
        return articleService.getListArticle();
    }
    @PostMapping
    ArticleResponse createArticle(@RequestBody ArticleRequest articleRequest){
        return articleService.createArticle(articleRequest);

    }

}
