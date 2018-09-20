package dishes;


public class Dish {
	private String id;
	private String name;
	private String category;
	private String type;
	private String description;

	
	public Dish() {
		super();
	}

	public Dish(String name, String category, String type) {
		super();
		this.name = name;
		this.category = category;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public String getCategory() {
		return category;
	}

	public String getType() {
		return type;
	}

	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Dish [id=" + id + ", name=" + name + ", category=" + category + ", type=" + type + ", description="
				+ description + "]";
	}

}
