package bt2;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/Bt2")
public class Bt2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Bt2() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		String tenHoa = "Hoa mẫu đơn";
		int giaBan = 120000;
		int soLuong = 4;
		int thanhTien = giaBan * soLuong;
		
		
		String pattern = "###,###.###";
		DecimalFormat decimalFormat = new DecimalFormat(pattern);
		String format1 = decimalFormat.format(giaBan);
		String format2 = decimalFormat.format(thanhTien);
	    
		
		PrintWriter out = response.getWriter();
		out.print("<p>Tên hoa: " + tenHoa + "</p>");
		out.print("<p>Giá bán: " + format1 + " VNĐ -- Số lượng: " + soLuong + "</p>");
		out.print("<p>Thành tiền: " + format2 + " VNĐ</p>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
