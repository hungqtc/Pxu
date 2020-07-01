package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.ContactDAO;
import utils.AuthUtil;
import utils.CodeMessageUtil;


public class AdminDelContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ContactDAO contactDAO;

	public AdminDelContactController() {
		super();
		contactDAO = new ContactDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			if (!AuthUtil.isLogin(request)) {
			response.sendRedirect(request.getContextPath()+"/auth/login");
			return;
			}
			int id = Integer.parseInt(request.getParameter("id"));
			if (contactDAO.delItem(id) > 0) {
				
				response.sendRedirect(request.getContextPath()+"/admin/contact?msg="+CodeMessageUtil.DELETE_SUCCESS);
				return;
			} else {
				response.sendRedirect(request.getContextPath()+"/admin/contact?msg="+CodeMessageUtil.ERROR);
				return;
			}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
