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
import utils.CodeMessageUtil;

public class AdminEditNewsCategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminEditNewsCategoryController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		CategoryDAO catDAO = new CategoryDAO();
		
		Category objOldCat = catDAO.getItem(id);
		request.setAttribute("objOldCat", objOldCat);
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/news/cat/edit.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		
		Category objNewCat = new Category(id, name);
		CategoryDAO catDAO = new CategoryDAO();
		
		if (catDAO.editItem(objNewCat) > 0) {
			response.sendRedirect(request.getContextPath()+"/admin/news/cat/index?msg="+CodeMessageUtil.EDIT_SUCCESS);
			return;
		} else {
			response.sendRedirect(request.getContextPath()+"/admin/news/cat/edit?msg="+CodeMessageUtil.ERROR);
			return;
		}
		
	}

}
