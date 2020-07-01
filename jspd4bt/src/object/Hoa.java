package object;

public class Hoa {
	private int idHoa;
	private String tenHoa;
	private int soLuong;
	private long giaBan;

	public int getIdHoa() {
		return idHoa;
	}

	public void setIdHoa(int idHoa) {
		this.idHoa = idHoa;
	}

	public String getTenHoa() {
		return tenHoa;
	}

	public void setTenHoa(String tenHoa) {
		this.tenHoa = tenHoa;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public long getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(long giaBan) {
		this.giaBan = giaBan;
	}

	public Hoa(int idHoa, String tenHoa, int soLuong, long giaBan) {
		super();
		this.idHoa = idHoa;
		this.tenHoa = tenHoa;
		this.soLuong = soLuong;
		this.giaBan = giaBan;
	}

	public Hoa() {
		super();
	}
	public long totalPrice() {
		return  (this.giaBan * this.soLuong);
	}
}
