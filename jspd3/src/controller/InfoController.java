package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/info")
public class InfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InfoController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		PrintWriter out = response.getWriter();
		String hoten = request.getParameter("hoten");
		int tuoi = Integer.valueOf(request.getParameter("tuoi"));
		String chieuCao = request.getParameter("chieucao");

		out.print("Ho ten: " + hoten + "<br/>");
		out.print("Tuoi: " + tuoi + "<br/>");
		out.print("Chieu cao: " + chieuCao + "<br/>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		PrintWriter out = response.getWriter();
		String hoten = request.getParameter("hoten");
		int tuoi = Integer.valueOf(request.getParameter("tuoi"));
		String chieuCao = request.getParameter("chieucao");
		out.print("Do Post" + "<br/>");
		out.print("Ho ten: " + hoten + "<br/>");
		out.print("Tuoi: " + tuoi + "<br/>");
		out.print("Chieu cao: " + chieuCao + "<br/>");
	}

}
