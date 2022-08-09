package com.ptit.newspaper.service.implement;

import com.ptit.newspaper.api.req.ArticleRequest;
import com.ptit.newspaper.api.req.CategoryRequest;
import com.ptit.newspaper.api.res.ArticleResponse;
import com.ptit.newspaper.api.res.CategoryResponse;
import com.ptit.newspaper.database.mapper.CategoryMapper;
import com.ptit.newspaper.database.model.Article;
import com.ptit.newspaper.database.repository.ArticleRepository;
import com.ptit.newspaper.database.repository.CategoryRepository;
import com.ptit.newspaper.service.AdminService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AdminServiceImp implements AdminService {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    CategoryMapper categoryMapper;


    @Override
    public CategoryResponse createCategory(CategoryRequest categoryRequest) {
        return categoryMapper.entityToResponse(categoryRepository.save(categoryMapper.requestToEntity(categoryRequest)));
    }
    @Override
    public List<CategoryResponse> getListCategory() {
        return categoryRepository.findAll().stream().map(categoryMapper::entityToResponse).collect(Collectors.toList());
    }
}
