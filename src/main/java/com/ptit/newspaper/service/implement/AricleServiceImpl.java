package com.ptit.newspaper.service.implement;

import com.ptit.newspaper.api.req.ArticleRequest;
import com.ptit.newspaper.api.res.ArticleResponse;
import com.ptit.newspaper.database.model.Article;
import com.ptit.newspaper.database.repository.ArticleRepository;
import com.ptit.newspaper.database.repository.CategoryRepository;
import com.ptit.newspaper.database.repository.UserRepository;
import com.ptit.newspaper.service.ArticleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AricleServiceImpl implements ArticleService {
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CategoryRepository categoryRepository;


    @Autowired
    private final ModelMapper mapper;

    public AricleServiceImpl(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<ArticleResponse> getListArticle() {
        List<ArticleResponse> result = new ArrayList<>();
        List<Article> listArticle = articleRepository.findAll();
        for(Article article : listArticle){
            ArticleResponse articleResponse = mapper.map(article,ArticleResponse.class);
            result.add(articleResponse);
        }
        return result;
    }

    @Override
    public ArticleResponse createArticle(ArticleRequest articleRequest) {


        Article article = mapper.map(articleRequest,Article.class);
        article.setUsers(userRepository.findById(articleRequest.getUsersId()).get());
        article.setCategory(categoryRepository.findById(articleRequest.getCategoryId()).get());

        return mapper.map(articleRepository.save(article), ArticleResponse.class);

    }

    @Override
    public ArticleResponse updateArticle(ArticleRequest articleRequest, Long id) {
        Article newArticle = mapper.map(articleRequest,Article.class);
        newArticle.setUsers(userRepository.findById(articleRequest.getUsersId()).get());
        newArticle.setCategory(categoryRepository.findById(articleRequest.getCategoryId()).get());


        Article oldArticle = articleRepository.findById(id).orElse(null);
        if(oldArticle != null){
        oldArticle.setHeader(newArticle.getHeader());
        oldArticle.setBody(newArticle.getBody());
        oldArticle.setUsers(newArticle.getUsers());
        oldArticle.setCategory(newArticle.getCategory());
            return mapper.map(articleRepository.save(oldArticle),ArticleResponse.class);
        }

        return mapper.map(articleRepository.save(newArticle),ArticleResponse.class);

    }

    @Override
    public Boolean deleteArticle(Long id) {
        if(articleRepository.existsById(id)){
            articleRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
