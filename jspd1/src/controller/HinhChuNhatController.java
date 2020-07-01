package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/HinhChuNhatController")
public class HinhChuNhatController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HinhChuNhatController() {
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
		
		Random rand = new Random();
		int numb1 = rand.nextInt(21) + 20;
		int numb2 = rand.nextInt(21) + 20;
		int sum = numb1 + numb2;
		
		PrintWriter out = response.getWriter();
		out.print("<h2>Chương trình tính tổng 2 số ngẫu nhiên</h2>");
		out.print("<p>So thu nhat: <span style='color:red'>" + numb1 +"</span></p>");
		out.print("<p>So thu nhat: " + numb2 + "</p>");
		out.append("<h4>Tong la: " + sum + "</h4>");

	}

}
