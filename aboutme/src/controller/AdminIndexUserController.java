package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.User;

import model.dao.UserDAO;
import utils.AuthUtil;

public class AdminIndexUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;

	public AdminIndexUserController() {
		super();
		userDAO = new UserDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!AuthUtil.isLogin(request)) {
			response.sendRedirect(request.getContextPath()+"/auth/login");
			return;
		}
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		ArrayList<User> listUser = userDAO.getItems();
		request.setAttribute("listUser", listUser);
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/user/index.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
