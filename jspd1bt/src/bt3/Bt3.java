package bt3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/Bt3")
public class Bt3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Bt3() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");

		float tongBanGhi = 57;
		final int soBanGhiCuaTrang = 10;
		float soTrang = tongBanGhi / soBanGhiCuaTrang;
		int tronTang = Math.round(soTrang);
		int tronGiam = (int) Math.floor(soTrang);

		PrintWriter out = response.getWriter();
		out.print("Số trang làm tròn tăng: " + tronTang + "</br>");
		out.print("Số trang làm tròn giảm: " + tronGiam);

	}

}
