package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ThayTheChuoiController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ThayTheChuoiController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/Bai4/thaythechuoi.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		// Lấy dữ liệu từ JSp
		String chuoigoc = request.getParameter("chuoigoc");
		String tugoc = request.getParameter("tugoc");
		String tuthaythe = request.getParameter("tuthaythe");
		
		if (chuoigoc != null) {
			request.setAttribute("chuoigoc", chuoigoc);
			if (tugoc != "" && tuthaythe != "") {
				
				if (chuoigoc.contains(tugoc)) {
					request.setAttribute("tugoc", tugoc);
					request.setAttribute("tuthaythe", tuthaythe);
					String chuoithaythe = chuoigoc.replaceAll(tugoc, tuthaythe);
					request.setAttribute("chuoithaythe", chuoithaythe);
										
				}
				else {
					request.setAttribute("error", "Từ cần thay thế không có. Vui lòng nhập từ khác!");
				}
			}
		 else {
			request.setAttribute("error", "Vui lòng không để trống!");
		} }
			else {
				request.setAttribute("error", "Vui lòng không để trống!");
			}
		RequestDispatcher rd = request.getRequestDispatcher("/Bai4/thaythechuoi.jsp");
		rd.forward(request, response);
	}
	

}
