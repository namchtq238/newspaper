package com.ptit.newspaper.service;

import com.ptit.newspaper.api.req.ArticleRequest;
import com.ptit.newspaper.api.req.CategoryRequest;
import com.ptit.newspaper.api.res.ArticleResponse;
import com.ptit.newspaper.api.res.CategoryResponse;

import java.util.List;

public interface AdminService {
    CategoryResponse createCategory(CategoryRequest categoryRequest);
    List<CategoryResponse> getListCategory();


}
