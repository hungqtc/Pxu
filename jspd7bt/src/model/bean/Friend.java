package model.bean;

public class Friend {
	private int id;
	private String name;
	private String preview;
	private String detail;
	private String date;
	private int fl_id;
	private int count;
	
	
	
	public Friend() {
		super();
	}
	public Friend(int id, String name, String preview, String detail, String date, int fl_id, int count) {
		super();
		this.id = id;
		this.name = name;
		this.preview = preview;
		this.detail = detail;
		this.date = date;
		this.fl_id = fl_id;
		this.count = count;
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getFl_id() {
		return fl_id;
	}
	public void setFl_id(int fl_id) {
		this.fl_id = fl_id;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
	
}
