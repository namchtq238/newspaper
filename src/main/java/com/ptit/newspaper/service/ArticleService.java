package com.ptit.newspaper.service;

import com.ptit.newspaper.api.req.ArticleRequest;
import com.ptit.newspaper.api.res.ArticleResponse;

import java.util.List;

public interface ArticleService  {
    List<ArticleResponse> getListArticle();
    ArticleResponse createArticle(ArticleRequest articleRequest);

    ArticleResponse updateArticle(ArticleRequest articleRequest, Long id);

    Boolean deleteArticle(Long id);
}
