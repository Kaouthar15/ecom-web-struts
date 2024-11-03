package services;

import models.Category;
import repositories.CategoryRepository; 
import java.util.List;

public class CategoryService {

    private final CategoryRepository categoryRepository = new CategoryRepository();

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    public void updateCategory(Category category) {
        categoryRepository.save(category);
    }

    public void deleteCategory(Long id) {
        categoryRepository.delete(id);
    }
}
