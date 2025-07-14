package com.dev.mvc_spring.service;

import com.dev.mvc_spring.dto.CategoryDto;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<CategoryDto> getAllCategories();
    Optional<CategoryDto> getCategoryById(Long id);
    CategoryDto saveCategory(CategoryDto categoryDto);
    CategoryDto updateCagtegory(Long id, CategoryDto categoryDto);
    void deleteCategory(Long id);
}
