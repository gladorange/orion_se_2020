package shilkin.mishop.service;

import org.springframework.stereotype.Service;
import shilkin.mishop.model.Category;
import shilkin.mishop.repository.CategoryRepository;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }
}
