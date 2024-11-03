package services;

import models.Category;
import repositories.CategoryRepository; 
import java.util.List;

public class CategoryService {

    private final CategoryRepository categoryRepository = new CategoryRepository();

    public List<Category> getAllCategories() {
    	System.out.println("getAllCatogires (services)");
        return categoryRepository.findAll();
        
        
    }

    public void addCategory(Category category) {
    	System.out.println("addCategory (services)");
        categoryRepository.save(category);
    }

    public void updateCategory(Category category) {
    	System.out.println("updateCategory (services)");
        categoryRepository.save(category);
    }

    public void deleteCategory(Long id) {
    	System.out.println("deleteCategory (services)");
        categoryRepository.delete(id);
    }
}
