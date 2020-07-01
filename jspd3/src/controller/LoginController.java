package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ky thuat forward(chuyen tiep)
		RequestDispatcher rd = request.getRequestDispatcher("/auth/login.jsp");
		rd.forward(request, response);
		// kiem tra xem ngoi dung
		// dang nhap dung hay khong
		// dung:vinaenter, 123456 => chuyen den trang info.jsp
		// =>hien thi thong tin username, fullname
		// sai: => thong bao cho nguoi dung

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if ("vinaenter".equals(username) && "123456".equals(password)) {
			request.setAttribute("username", username);
			request.setAttribute("fullname", "Vinaenter EDU");
			RequestDispatcher rd = request.getRequestDispatcher("/auth/info.jsp");
			rd.forward(request, response);
		} else {
			//chuyen huong
			response.sendRedirect(request.getContextPath()+"/login?msg=Error");
		}
		

	}

}
