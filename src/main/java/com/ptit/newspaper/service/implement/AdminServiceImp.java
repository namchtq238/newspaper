package com.ptit.newspaper.service.implement;

import com.ptit.newspaper.api.req.CategoryRequest;
import com.ptit.newspaper.api.res.CategoryResponse;
import com.ptit.newspaper.api.res.UpdateCategoryResponse;
import com.ptit.newspaper.database.mapper.CategoryMapper;
import com.ptit.newspaper.database.model.Category;
import com.ptit.newspaper.database.repository.CategoryRepository;
import com.ptit.newspaper.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AdminServiceImp implements AdminService {
    CategoryRepository categoryRepository;
    CategoryMapper categoryMapper;

    @Override
    public CategoryResponse createCategory(CategoryRequest categoryRequest) {
        return categoryMapper.entityToResponse(categoryRepository.save(categoryMapper.requestToEntity(categoryRequest)));
    }

    @Override
    public List<CategoryResponse> getListCategory() {
        return categoryRepository.findAll().stream().map(categoryMapper::entityToResponse).collect(Collectors.toList());
    }
    @Override
    public UpdateCategoryResponse updateCategory(CategoryRequest req, Long id) {
        Category newUser = categoryMapper.updateToEntity(req);
        Category oldUser= categoryRepository.findById(id).orElse(null);
        if(oldUser != null){
            oldUser.setName(newUser.getName());
        }
        return categoryMapper.entity(categoryRepository.save(newUser));
    }
    @Override
    public Boolean deleteCategory(Long id) {
        if(categoryRepository.existsById(id)){
            categoryRepository.deleteById(id);
            return true;
        }else
            return false;
    }
}
