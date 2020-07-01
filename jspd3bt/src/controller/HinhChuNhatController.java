package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HinhChuNhatController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HinhChuNhatController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		int chieudai = Integer.parseInt(request.getParameter("chieudai"));
		int chieurong = Integer.parseInt(request.getParameter("chieurong"));
		int chuvi = (chieudai + chieurong) * 2;
		float dientich = chieudai * chieurong;
		
		out.print("Chu vi: " + chuvi + "<br>");
		out.print("Diện tích: " + dientich + "<br>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
