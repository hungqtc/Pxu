package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CauChaoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CauChaoController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/Bai2/cauchao.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		// Lấy dữ liệu từ Jsp
		String name = request.getParameter("name");

		if ("".equals(name) == false) {
			String Ans = "Câu chào: Chào bạn " + name;
			request.setAttribute("Ans", Ans);
			request.setAttribute("name", name);
			RequestDispatcher rd = request.getRequestDispatcher("/Bai2/cauchao.jsp");
			rd.forward(request, response);
		}
		
		  else { response.sendRedirect(request.getContextPath()+"/Bai2/cauchao.jsp"); }
		 
	}

}
