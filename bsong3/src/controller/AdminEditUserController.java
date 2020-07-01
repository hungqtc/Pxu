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

public class AdminEditUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
	
	public AdminEditUserController() {
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
		
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (Exception e) {
			response.sendRedirect(request.getContextPath()+"/admin/user/index?msg="+CodeMessageUtil.ERROR_NO_ID);
			return;
		}
		
		HttpSession session = request.getSession();
		User userLogin = (User) session.getAttribute("userInfo");
		//Chi admin moi duoc them nguoi dung
		if ("admin".equals(userLogin.getUsername()) || (id == userLogin.getId())) {
			User objUser = userDAO.getItem(id);
			if (objUser != null) {
				request.setAttribute("objUser", objUser);			
				RequestDispatcher rd = request.getRequestDispatcher("/views/admin/user/edit.jsp");
				rd.forward(request, response);
			} else {
				response.sendRedirect(request.getContextPath()+"/admin/user/index?msg="+CodeMessageUtil.ERROR_HAD_NAME);
				return;
			}
				
			return;
		} else {
			response.sendRedirect(request.getContextPath()+"/admin/user/index?msg="+CodeMessageUtil.ERROR_NO_PERMISSION_EDIT);
			return;
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (Exception e) {
			response.sendRedirect(request.getContextPath()+"/admin/user/index?msg="+CodeMessageUtil.ERROR_NO_ID);
			return;
		}
		HttpSession session = request.getSession();
		User userLogin = (User) session.getAttribute("userInfo");
		if ("admin".equals(userLogin.getUsername()) || (id == userLogin.getId())) {
			//Get old data
			User objUser = userDAO.getItem(id);	
			
			if (objUser == null ) {
				response.sendRedirect(request.getContextPath()+"/admin/user/index?msg="+CodeMessageUtil.ERROR_NO_ID);
				return;
			}
			String password = request.getParameter("password");
			if (" ".equals(password)) {
				password = objUser.getPassword();
			}
			else {
				password = StringUtil.md5(password);
			}
			String fullname = request.getParameter("fullname");
			
			//VALIDATION
			//Set new data
			
			objUser.setPassword(password);
			objUser.setFullname(fullname);
			
			if (userDAO.editItem(objUser) > 0) {
				response.sendRedirect(request.getContextPath()+"/admin/user/index?msg="+CodeMessageUtil.EDIT_SUCCESS);
				return;
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("/views/admin/user/edit.jsp?msg="+CodeMessageUtil.ERROR);
				rd.forward(request, response);
				return;
			}
			} else {
				response.sendRedirect(request.getContextPath()+"/admin/user/index?msg="+CodeMessageUtil.ERROR_NO_PERMISSION_EDIT);
				return;
			}
			
		
		
	}

}
