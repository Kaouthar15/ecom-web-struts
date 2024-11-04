//package models;
//
//import models.Category;
//
//public class Product {
//
//    private Long id;
//    private String name;
//    private double price;
//    private String photo;
//    private Category category;
//
//    // Default constructor
//    public Product() {}
//
//    // Constructor that initializes all fields
//    public Product(Long id, String name, double price, String photo, Category category) {
//        this.id = id;
//        this.name = name;
//        this.price = price;
//        this.photo = photo;
//        this.category = category;
//    }
//
//    // Constructor that initializes fields excluding Category
//    public Product(String name, double price, String photo, Long categoryId) {
//        this.name = name;
//        this.price = price;
//        this.photo = photo;
//        // Assuming you have a method to find a Category by its ID
//        this.category = findCategoryById(categoryId); // Replace with your actual method to get a Category
//    }
//
//    // Example method to find a Category by ID (implement as needed)
//    private Category findCategoryById(Long categoryId) {
//        // Your logic to fetch category from the database or repository
//        return null; // Return the found Category or null if not found
//    }
//
//    // Getters and Setters
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public double getPrice() {
//        return price;
//    }
//
//    public void setPrice(double price) {
//        this.price = price;
//    }
//
//    public String getPhoto() {
//        return photo;
//    }
//
//    public void setPhoto(String photo) {
//        this.photo = photo;
//    }
//
//    public Category getCategory() {
//        return category;
//    }
//
//    public void setCategory(Category category) {
//        this.category = category;
//    }
//
//    public Long getCategoryId() {
//        return (category != null) ? category.getId() : null; // Assuming Category has a getId() method
//    }
//}
