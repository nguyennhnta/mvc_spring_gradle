package com.dev.mvc_spring.controller;

import com.dev.mvc_spring.dto.CategoryDto;
import com.dev.mvc_spring.dto.PostDto;
import com.dev.mvc_spring.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @GetMapping
    public List<CategoryDto> getAll() {
        return categoryService.getAllCategories();
    }

    // GET /api/category/{id}
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        logger.info("getById");
        return categoryService.getCategoryById(id)
                .map(ResponseEntity::ok) // nếu có -> trả về 200 OK
                .orElseGet(() -> ResponseEntity.notFound().build()); // nếu không có -> 404
    }

    // POST create category
    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid CategoryDto categoryDto) {
        CategoryDto dto  = categoryService.saveCategory(categoryDto);
        return ResponseEntity.ok(dto);
    }

    // PUT update category
    @PutMapping("/{id}")
    public ResponseEntity<?> udpate(@PathVariable("id") Long id, @RequestBody CategoryDto categoryDto) {
        CategoryDto dto = categoryService.updateCagtegory(id, categoryDto);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    // DELETE post
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.ok("Delete success");
    }

    @GetMapping("/test-error-exception")
    public String testError() {
        // Lỗi bất ngờ (chia cho 0)
        int x = 10 / 0;
        return "Không bao giờ tới đây";
    }

}
