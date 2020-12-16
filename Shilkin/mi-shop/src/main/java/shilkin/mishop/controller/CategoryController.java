package shilkin.mishop.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shilkin.mishop.dto.CategoryDTO;
import shilkin.mishop.mapper.CategoryMapper;
import shilkin.mishop.service.CategoryService;

import javax.validation.Valid;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    public CategoryController(CategoryService categoryService, CategoryMapper categoryMapper) {
        this.categoryService = categoryService;
        this.categoryMapper = categoryMapper;
    }

    @PostMapping
    public CategoryDTO saveCategory(@RequestBody @Valid CategoryDTO categoryDto) {
        return categoryMapper.toCategoryDTO(categoryService.saveCategory(categoryMapper.toCategory(categoryDto)));
    }
}
