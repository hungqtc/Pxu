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

public class AdminDelUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
	
	public AdminDelUserController() {
		super();
		userDAO = new UserDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!AuthUtil.isLogin(request)) {
			response.sendRedirect(request.getContextPath()+"/auth/login");
			return;
		}
		
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (Exception e) {
			response.sendRedirect(request.getContextPath()+"/admin/user/index?msg="+CodeMessageUtil.ERROR_NO_ID);
			return;
		}
		
		HttpSession session = request.getSession();
		User userLogin = (User) session.getAttribute("userInfo");
		
		User user = userDAO.getItem(id);
		if ("admin".equals(userLogin.getUsername())) {
			if (userDAO.delItem(id) > 0) {
				response.sendRedirect(request.getContextPath()+"/admin/user/index?msg="+CodeMessageUtil.DELETE_SUCCESS);
				return;
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("/views/admin/user/index.jsp?msg="+CodeMessageUtil.ERROR);
				rd.forward(request, response);
				return;
			}
		} else {
			response.sendRedirect(request.getContextPath()+"/admin/user/index?msg="+CodeMessageUtil.ERROR_NO_PERMISSION_DELETE);
			return;
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
