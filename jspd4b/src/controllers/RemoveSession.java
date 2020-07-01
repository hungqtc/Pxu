package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/remove-session")
public class RemoveSession extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RemoveSession() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			HttpSession session = request.getSession();
			//remove 1 session
			//session.removeAttribute("fullName");
			//remove all session
			session.invalidate();
			//remove by stop sever
			//delete Cookies on Web browser
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
