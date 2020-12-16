package shilkin.mishop.mapper;

import org.springframework.stereotype.Component;
import shilkin.mishop.dto.CategoryDTO;
import shilkin.mishop.model.Category;

@Component
public class CategoryMapper {
    public CategoryDTO toCategoryDTO(Category category) {
        if (category == null) {
            return null;
        }
        CategoryDTO dto = new CategoryDTO();
        dto.setId(category.getId());
        dto.setName(category.getName());
        if (category.getParentCategory() != null) {
            dto.setParentCategoryId(category.getParentCategory().getId());
        }
        return dto;
    }

    public Category toCategory(CategoryDTO categoryDto) {
        if (categoryDto == null) {
            return null;
        }
        Category category = new Category();
        category.setId(categoryDto.getId());
        category.setName(categoryDto.getName());
        if (categoryDto.getParentCategoryId() != null) {
            Category parentCategory = new Category();
            parentCategory.setId(categoryDto.getParentCategoryId());
            category.setParentCategory(parentCategory);
        }
        return category;
    }
}
