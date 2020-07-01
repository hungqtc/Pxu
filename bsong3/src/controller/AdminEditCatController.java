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

public class AdminEditCatController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminEditCatController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!AuthUtil.isLogin(request)) {
			response.sendRedirect(request.getContextPath()+"/auth/login");
			return;
		}
		CategoryDAO catDAO = new CategoryDAO();
		int id = Integer.parseInt(request.getParameter("id"));
		
		Category objCatOld = catDAO.getItem(id);
		request.setAttribute("objCatOld", objCatOld);
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/cat/edit.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		CategoryDAO catDAO = new CategoryDAO();
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		//validation
		Category objCat = new Category(id, name);
		if (catDAO.editItem(objCat) > 0) {
			//redirect admin/cat/index ==> display message
			response.sendRedirect(request.getContextPath()+"/admin/cat/index?msg="+CodeMessageUtil.EDIT_SUCCESS);
			return;
		} else {
			response.sendRedirect(request.getContextPath()+"/admin/cat/edit?id="+id+"&msg="+CodeMessageUtil.ERROR);
		}
		
	}
	

}
