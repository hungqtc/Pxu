package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Category;
import model.dao.CategoryDAO;
import utils.AuthUtil;
import utils.CodeMessageUtil;


public class AdminDelCatController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminDelCatController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!AuthUtil.isLogin(request)) {
			response.sendRedirect(request.getContextPath()+"/auth/login");
			return;
		}
		request.setCharacterEncoding("UTF-8");
		CategoryDAO catDAO = new CategoryDAO();
		
		//validation
		int id = Integer.parseInt(request.getParameter("id"));
		
		if (catDAO.delItem(id) > 0) {
			//redirect admin/cat/index ==> display message
			response.sendRedirect(request.getContextPath()+"/admin/cat/index?msg="+CodeMessageUtil.DELETE_SUCCESS);
			return;
		} else {
			response.sendRedirect(request.getContextPath()+"/admin/cat/index?msg="+CodeMessageUtil.ERROR);
			return;
		}
		
		
		
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		
		
	}

}
