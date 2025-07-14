package com.dev.mvc_spring.service.impl;

import com.dev.mvc_spring.builder.GenericBuilder;
import com.dev.mvc_spring.dto.CategoryDto;
import com.dev.mvc_spring.entity.Category;
import com.dev.mvc_spring.repository.CategoryRepository;
import com.dev.mvc_spring.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final GenericBuilder builder;
    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryDto> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(entity -> builder.toDto(entity, CategoryDto.class).orElse(null))
                .filter(dto -> dto != null)
                .toList();
    }

    @Override
    public Optional<CategoryDto> getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .flatMap(entity -> builder.toDto(entity, CategoryDto.class));
    }

    @Override
    public CategoryDto saveCategory(CategoryDto categoryDto) {
        Category entity = builder.toEntity(categoryDto, Category.class);
        Category saved = categoryRepository.save(entity);
        return builder.toDto(saved, CategoryDto.class).orElse(null);
    }

    @Override
    public CategoryDto updateCagtegory(Long id, CategoryDto categoryDto) {
        Category category = categoryRepository.findById(id).orElse(null);
        if (category != null) {
            builder.updateEntity(categoryDto, category);
            Category updated = categoryRepository.save(category);
            return builder.toDto(updated, CategoryDto.class).orElse(null);
        }
        return null;
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }


}
