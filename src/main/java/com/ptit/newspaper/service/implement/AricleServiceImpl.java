package com.ptit.newspaper.service.implement;

import com.ptit.newspaper.api.req.ArticleRequest;
import com.ptit.newspaper.api.res.ArticleResponse;
import com.ptit.newspaper.database.mapper.ArticleMapper;
import com.ptit.newspaper.database.mapper.ArticleMapperImpl;
import com.ptit.newspaper.database.model.Article;
import com.ptit.newspaper.database.repository.ArticleRepository;
import com.ptit.newspaper.database.repository.CategoryRepository;
import com.ptit.newspaper.database.repository.UserRepository;
import com.ptit.newspaper.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AricleServiceImpl implements ArticleService {
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    private ArticleMapper articleMapper;

    public AricleServiceImpl() {
        this.articleMapper =  new ArticleMapperImpl();
    }

    @Override
    public List<ArticleResponse> getListArticle() {
        return articleRepository.findAll().stream().map(articleMapper::entityToResponse).collect(Collectors.toList());
    }

    @Override
    public ArticleResponse createArticle(ArticleRequest articleRequest) {
        Article article = articleMapper.requestToEntity(articleRequest);
        article.setUsers(userRepository.findById(articleRequest.getUsers_id()).get());
        article.setCategory(categoryRepository.findById(articleRequest.getCategory_id()).get());
        return articleMapper.entityToResponse(articleRepository.save(article));
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
