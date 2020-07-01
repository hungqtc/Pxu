package model.bean;

public class Comment {
	private int id;
	private New news;
	private String name;
	private String message;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public New getNews() {
		return news;
	}

	public void setNews(New news) {
		this.news = news;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Comment(int id, New news, String name, String message) {
		super();
		this.id = id;
		this.news = news;
		this.name = name;
		this.message = message;
	}

	public Comment(New news, String name, String message) {
		super();
		this.news = news;
		this.name = name;
		this.message = message;
	}

}
