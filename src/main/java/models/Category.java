package models;


public class Category {

    private Long id;
    private String name;
    private String description;
    

    // Constructors
	public Category() {
		// TODO Auto-generated constructor stub
	}

	public Category(String name2, String description2) {
		// TODO Auto-generated constructor stub
	}

	public Category(long long1, String string, String string2) {
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
