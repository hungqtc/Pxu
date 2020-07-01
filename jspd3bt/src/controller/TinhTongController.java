package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TinhTongController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TinhTongController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		String dayso = request.getParameter("dayso");
		String[] arDayso = dayso.split(",");
		
		int tong = 0;
		for (String itemSo : arDayso) {
			int so = Integer.parseInt(itemSo);
			tong += so;
		}
		out.print("Tổng dãy số là: " + tong);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
