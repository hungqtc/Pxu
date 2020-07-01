package model.bean;

public class CategoryFather {
	private int id;
	private String name;
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
	public CategoryFather(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public CategoryFather(int id) {
		super();
		this.id = id;
	}
	public CategoryFather(String name) {
		super();
		this.name = name;
	}
	
	
	
	
}
