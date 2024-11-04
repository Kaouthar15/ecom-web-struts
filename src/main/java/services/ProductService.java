//package services;
//
//import models.Product;
//import repositories.ProductRepository;
//import java.util.List;
//
//public class ProductService {
//
//    private final ProductRepository productRepository = new ProductRepository();
//
//    public List<Product> getAllProducts() {
//    	System.out.println("getAllProducts (services)");
//        return productRepository.findAll();
//    }
//
//    public void addProduct(Product product) {
//    	System.out.println("addProduct (services)");
//        productRepository.save(product);
//    }
//
//    public void updateProduct(Product product) {
//    	System.out.println("updateProduct (services)");
//        productRepository.save(product);
//    }
//
//    public void deleteProduct(Long id) {
//    	System.out.println("deleteProduct (services)");
//        productRepository.delete(id);
//    }
//}
