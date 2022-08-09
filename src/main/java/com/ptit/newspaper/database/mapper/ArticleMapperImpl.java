package com.ptit.newspaper.database.mapper;

import com.ptit.newspaper.api.req.ArticleRequest;
import com.ptit.newspaper.api.res.ArticleResponse;
import com.ptit.newspaper.database.model.Article;
import com.ptit.newspaper.database.model.Category;
import com.ptit.newspaper.database.model.Users;
import com.ptit.newspaper.database.repository.CategoryRepository;
import com.ptit.newspaper.database.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;


public class ArticleMapperImpl implements ArticleMapper {


    public Article requestToEntity(ArticleRequest articleRequest) {
        if(articleRequest == null) return null;

        Article article = new Article();

        article.setHeader(articleRequest.getHeader());
        article.setBody(articleRequest.getBody());

        return article;
    }

    @Override
    public ArticleResponse entityToResponse(Article article) {
        if (article == null) return null;

        ArticleResponse articleResponse = new ArticleResponse();

        articleResponse.setId(article.getId());
        articleResponse.setHeader(article.getHeader());
        articleResponse.setBody(article.getBody());
        articleResponse.setUsers_name(article.getUsers().getUsername());

        return articleResponse;
    }
}
