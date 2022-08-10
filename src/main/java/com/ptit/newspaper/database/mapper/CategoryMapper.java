package com.ptit.newspaper.database.mapper;

import com.ptit.newspaper.api.req.CategoryRequest;
import com.ptit.newspaper.api.res.CategoryResponse;
import com.ptit.newspaper.api.res.UpdateCategoryResponse;
import com.ptit.newspaper.database.model.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category requestToEntity(CategoryRequest categoryRequest);
    CategoryResponse entityToResponse(Category category);
    Category updateToEntity(CategoryRequest categoryRequest);

    UpdateCategoryResponse entity(Category category);
}
