package model.bean;

public class Info {
	private int id;
	private String name;
	private String adress;
	private String phoneNumber;
	private String email;
	private String content;
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
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Info(int id, String name, String adress, String phoneNumber, String email, String content) {
		super();
		this.id = id;
		this.name = name;
		this.adress = adress;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.content = content;
	}
	
	
}
