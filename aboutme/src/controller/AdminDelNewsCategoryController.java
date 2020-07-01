package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Category;
import model.dao.CategoryDAO;
import utils.CodeMessageUtil;

public class AdminDelNewsCategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminDelNewsCategoryController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			int id = Integer.parseInt(request.getParameter("id"));
			
			CategoryDAO catDAO = new CategoryDAO();
			
			if (catDAO.delItem(id) > 0) {
				response.sendRedirect(request.getContextPath()+"/admin/news/cat/index?msg="+CodeMessageUtil.DELETE_SUCCESS);
				return;
			} else {
				response.sendRedirect(request.getContextPath()+"/admin/news/cat/index?msg="+CodeMessageUtil.ERROR);
				return;
			}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
