package com.ptit.newspaper.service;

import com.ptit.newspaper.api.req.CategoryRequest;
import com.ptit.newspaper.api.res.CategoryResponse;
import com.ptit.newspaper.api.res.UpdateCategoryResponse;

import java.util.List;

public interface AdminService {
    CategoryResponse createCategory(CategoryRequest categoryRequest);
    List<CategoryResponse> getListCategory();
    UpdateCategoryResponse updateCategory(CategoryRequest req, Long id);

    Boolean deleteCategory(Long id);

}
