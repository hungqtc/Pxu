package model.bean;

public class Category {
	private int id;
	private String name;
	private CategoryFather catFather;
	
	public Category(int id) {
		super();
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Category(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Category(String name) {
		super();
		this.name = name;
	}

	public CategoryFather getCatFather() {
		return catFather;
	}

	public void setCatFather(CategoryFather catFather) {
		this.catFather = catFather;
	}

	public Category(int id, String name, CategoryFather catFather) {
		super();
		this.id = id;
		this.name = name;
		this.catFather = catFather;
	}

	public Category(String name, CategoryFather catFather) {
		super();
		this.name = name;
		this.catFather = catFather;
	}
	
	
	
	
}
