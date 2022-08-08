package com.ptit.newspaper.database.mapper;

import com.ptit.newspaper.api.req.ArticleRequest;
import com.ptit.newspaper.api.res.ArticleResponse;
import com.ptit.newspaper.database.model.Article;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ArticleMapper {
    Article requestToEntity(ArticleRequest articleRequest);
    ArticleResponse entityToResponse(Article article);
}
