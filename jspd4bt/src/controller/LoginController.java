package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import object.Account;

@WebServlet("/login")

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	public LoginController() {
		super();
	}
	
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/Bai1/login.jsp");
		rd.forward(request, response);	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Account objAcc = new Account(username, password);
		session.setAttribute("account", objAcc);
		
		session.setAttribute("username", objAcc.getUsername());
		session.setAttribute("password", objAcc.getPassword());
		
		session.setMaxInactiveInterval(60*60*24); //second
		RequestDispatcher rd = request.getRequestDispatcher("/Bai1/welcome.jsp");
		rd.forward(request, response);
	}

}
