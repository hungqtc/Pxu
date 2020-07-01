package model.bean;

import java.sql.Timestamp;

public class New {
	private int id;
	private String name;
	private String preview;
	private String detail;
	private Timestamp dateCreate;
	private String picture;
	private int counter;
	private Category cat;
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
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Timestamp getDateCreate() {
		return dateCreate;
	}
	public void setDateCreate(Timestamp dateCreate) {
		this.dateCreate = dateCreate;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public int getCounter() {
		return counter;
	}
	public void setCounter(int counter) {
		this.counter = counter;
	}
	public Category getCat() {
		return cat;
	}
	public void setCat(Category cat) {
		this.cat = cat;
	}
	public New(int id, String name, String preview, String detail, Timestamp dateCreate, String picture,
			int counter, Category cat) {
		super();
		this.id = id;
		this.name = name;
		this.preview = preview;
		this.detail = detail;
		this.dateCreate = dateCreate;
		this.picture = picture;
		this.counter = counter;
		this.cat = cat;
	}
	
	
	public New(String name, String preview, String detail, String picture, Category cat) {
		super();
		this.name = name;
		this.preview = preview;
		this.detail = detail;
		this.picture = picture;
		this.cat = cat;
	}
	
	
	public New(int id, String name, String preview, String detail, String picture, Category cat) {
		super();
		this.id = id;
		this.name = name;
		this.preview = preview;
		this.detail = detail;
		this.picture = picture;
		this.cat = cat;
	}
	public New() {
		super();
	}
	public New(String name, Category cat) {
		super();
		this.name = name;
		this.cat = cat;
	}
	public New(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public New(int id) {
		super();
		this.id = id;
	}
	public New(String name) {
		super();
		this.name = name;
	}
	
	
}
