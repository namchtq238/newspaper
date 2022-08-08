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

@Component
public class ArticleMapperImpl implements ArticleMapper {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Article requestToEntity(ArticleRequest articleRequest) {
        if(articleRequest == null) return null;

        Article article = new Article();

        Category category = categoryRepository.findById(articleRequest.getCategory_id()).orElse(null);

        Users users = userRepository.findById(articleRequest.getUsers_id()).orElse(null);
        article.setHeader(articleRequest.getHeader());
        article.setBody(articleRequest.getBody());
        article.setUsers(users);
        article.setCategory(category);

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
