package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Category;
import model.bean.CategoryFather;
import model.dao.CategoryDAO;
import model.dao.CategoryFatherDAO;
import utils.CodeMessageUtil;

public class AdminAddNewsCategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminAddNewsCategoryController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/news/cat/add.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		
		int idCatFather = Integer.parseInt(request.getParameter("type"));
		
		CategoryFatherDAO catFatherDAO = new CategoryFatherDAO();
		CategoryDAO catDAO = new CategoryDAO();
		Category objCat = null;
		CategoryFather objCatFather = null;
		if (request.getParameter("category")!= null ) {
			int category = Integer.parseInt(request.getParameter("category"));
			objCat = new Category(name, new CategoryFather(category));
			
		} else {
			objCat = new Category(name);
			objCatFather = new CategoryFather(name);
			
			catFatherDAO.addItem(objCatFather);
			objCatFather = catFatherDAO.getItemByName(name);
			objCat = new Category(name, new CategoryFather(objCatFather.getId()));
		}
		
		
		if (catDAO.addItem(objCat) > 0   ) {
			response.sendRedirect(request.getContextPath()+"/admin/news/cat/index?msg="+CodeMessageUtil.ADD_SUCCESS);
			return;
		} else {
			response.sendRedirect(request.getContextPath()+"/admin/news/cat/index?msg="+CodeMessageUtil.ERROR);
			return;
		}
		
	}

}
