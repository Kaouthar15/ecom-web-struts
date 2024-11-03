package models;

public class Product {
    
    private Long id;
    private String name;
    private double price;
    private String photo;
    private Category category;

    // Default constructor
    public Product() {}

    public Product(long long1, String string, double double1, String string2, long long2) {
		// TODO Auto-generated constructor stub
	}

	public Product(String name2, double price2, String photo2, Long categoryId) {
		// TODO Auto-generated constructor stub
	}

	// Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

	public long getCategoryId() {
		// TODO Auto-generated method stub
		return 0;
	}

}
