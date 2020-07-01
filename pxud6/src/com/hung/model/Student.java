package com.hung.model;

public class Student {
	private int id;
	private String name;
	private String address;
	private String email;
	private Grade grade;

	public int getId() {
		return id;
	}

	public Student(int id, String name, String address, String email, Grade grade) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.email = email;
		this.grade = grade;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Student() {
		super();
	}

}
