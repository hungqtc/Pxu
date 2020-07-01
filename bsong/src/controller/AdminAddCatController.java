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

public class AdminAddCatController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminAddCatController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!AuthUtil.isLogin(request)) {
			response.sendRedirect(request.getContextPath()+"/auth/login");
			return;
		}		
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/cat/add.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		CategoryDAO catDAO = new CategoryDAO();
		String name = request.getParameter("name");
		//validation
		Category objCat = new Category(name);
		if (catDAO.addItem(objCat) > 0) {
			//redirect admin/cat/index ==> display message
			response.sendRedirect(request.getContextPath()+"/admin/cat/index?msg="+CodeMessageUtil.ADD_SUCCESS);
			return;
		} else {
			response.sendRedirect(request.getContextPath()+"/admin/cat/add?msg="+CodeMessageUtil.ERROR);
		}
		
	}

}
