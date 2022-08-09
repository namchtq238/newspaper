package com.ptit.newspaper.service;

import com.ptit.newspaper.api.req.CategoryRequest;
import com.ptit.newspaper.api.res.CategoryResponse;
import com.ptit.newspaper.api.res.UserResponse;

import java.util.List;

public interface AdminService {
    CategoryResponse createCategory(CategoryRequest categoryRequest);
    List<CategoryResponse> getListCategory();

    List<UserResponse> getListUser();

    Boolean deleteUser(Long id);
}
