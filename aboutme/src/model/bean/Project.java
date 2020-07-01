package model.bean;

public class Project {
	private int id;
	private String name;
	private String preview;
	private String picture;
	private String link;
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
	public String getPreview() {
		return preview;
	}
	public void setPreview(String preview) {
		this.preview = preview;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public Project(int id, String name, String preview, String picture, String link) {
		super();
		this.id = id;
		this.name = name;
		this.preview = preview;
		this.picture = picture;
		this.link = link;
	}
	public Project(String name, String preview, String picture, String link) {
		super();
		this.name = name;
		this.preview = preview;
		this.picture = picture;
		this.link = link;
	}
	
	
}
