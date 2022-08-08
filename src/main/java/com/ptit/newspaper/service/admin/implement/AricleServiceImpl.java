package com.ptit.newspaper.service.admin.implement;

import com.ptit.newspaper.api.req.ArticleRequest;
import com.ptit.newspaper.api.res.ArticleResponse;
import com.ptit.newspaper.database.mapper.ArticleMapper;
import com.ptit.newspaper.database.model.Article;
import com.ptit.newspaper.database.repository.ArticleRepository;
import com.ptit.newspaper.service.admin.ArticleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AricleServiceImpl implements ArticleService {

    private ArticleRepository articleRepository;

    private ArticleMapper articleMapper;
    @Override
    public List<ArticleResponse> getListArticle() {
        return articleRepository.findAll().stream().map(articleMapper::entityToResponse).collect(Collectors.toList());
    }

    @Override
    public ArticleResponse createArticle(ArticleRequest articleRequest) {
        return articleMapper.entityToResponse(articleRepository.save(articleMapper.requestToEntity(articleRequest)));
    }

    @Override
    public ArticleResponse updateArticle(ArticleRequest articleRequest, Long id) {
        Article newArticle = articleMapper.requestToEntity(articleRequest);
        Article oldArticle = articleRepository.findById(id).orElse(null);
        if(oldArticle != null){
        oldArticle.setHeader(newArticle.getHeader());
        oldArticle.setBody(newArticle.getBody());
        oldArticle.setUsers(newArticle.getUsers());
        oldArticle.setCategory(newArticle.getCategory());
            return articleMapper.entityToResponse(articleRepository.save(oldArticle));
        }

        return articleMapper.entityToResponse(articleRepository.save(newArticle));

    }

    @Override
    public Boolean deleteArticle(Long id) {
        if(articleRepository.existsById(id)){
            articleRepository.deleteById(id);
            return true;
        }else
        return false;
    }
}
