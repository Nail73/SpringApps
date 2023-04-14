package org.example.service;

import lombok.AllArgsConstructor;
import org.example.entity.Category;
import org.example.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

   public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category updateCategory(long id, Category category) {
        Category existingCategory = categoryRepository.findById(id).orElse(null);
        existingCategory.setName(category.getName());
        existingCategory.setDescription(category.getDescription());
        return categoryRepository.save(existingCategory);
    }

    public void deleteCategory(long id) {
        categoryRepository.deleteById(id);
    }

    public Category getCategoryById(long id) {
        return categoryRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Category not found - " + id));
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
