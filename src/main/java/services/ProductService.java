package services;

import models.Product;
import repositories.ProductRepository;
import java.util.List;

public class ProductService {

    private final ProductRepository productRepository = new ProductRepository();

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public void updateProduct(Product product) {
        productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.delete(id);
    }
}
