package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.User;
import model.dao.UserDAO;
import utils.AuthUtil;
import utils.CodeMessageUtil;
import utils.StringUtil;

public class AdminAddUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private  UserDAO userDAO;

	public AdminAddUserController() {
		super();
		userDAO = new UserDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if (!AuthUtil.isLogin(request)) {
			response.sendRedirect(request.getContextPath()+"/auth/login");
			return;
		}
		
		HttpSession session = request.getSession();
		User userLogin = (User) session.getAttribute("userInfo");
		//Chi admin moi duoc them nguoi dung
		if (!"admin".equals(userLogin.getUsername())) {
			response.sendRedirect(request.getContextPath()+"/admin/user/index?msg="+CodeMessageUtil.ERROR_NO_PERMISSION_ADD);
			return;
		}
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/user/add.jsp");
		rd.forward(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		HttpSession session = request.getSession();
		User userLogin = (User) session.getAttribute("userInfo");
		//Chi admin moi duoc them nguoi dung
		if (!"admin".equals(userLogin.getUsername())) {
			response.sendRedirect(request.getContextPath()+"/admin/user/index?msg="+CodeMessageUtil.ERROR);
			return;
		}
		
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		//get data
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String fullname = request.getParameter("fullname");	
		//VALIDATION 
		if (userDAO.hasUser(username)) {
			RequestDispatcher rd = request.getRequestDispatcher("/views/admin/user/add.jsp?msg="+CodeMessageUtil.ERROR_HAD_NAME);
			rd.forward(request, response);
			return;
		}
		
		password = StringUtil.md5(password);
		
		User objUser = new User(username, password, fullname);
				
		if (userDAO.addItem(objUser) > 0) {
			//redirect admin/cat/index ==> display message
			response.sendRedirect(request.getContextPath()+"/admin/user/index?msg="+CodeMessageUtil.ADD_SUCCESS);
			return;
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/views/admin/user/add.jsp?msg="+CodeMessageUtil.ERROR);
			rd.forward(request, response);
			return;
		}
	}

}
