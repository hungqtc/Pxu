package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Category;
import model.bean.Contact;
import model.bean.New;
import model.dao.CategoryDAO;
import model.dao.ContactDAO;
import model.dao.NewDAO;
import utils.CodeMessageUtil;
import utils.DefineUtil;

public class PublicCatController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PublicCatController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		NewDAO newDAO = new NewDAO();
		int numberOfNews = newDAO.numberOfItems(id);
		int numberOfPages = (int) Math.ceil((float) numberOfNews / DefineUtil.NUMBER_PER_PAGE);
		int currentPage = 1;
		try {
			currentPage = Integer.parseInt(request.getParameter("page"));
		} catch (Exception e) {

		}
		if (currentPage > numberOfPages || currentPage < 1) {
			currentPage = 1;
		}
		int offset = (currentPage - 1) * DefineUtil.NUMBER_PER_PAGE;
		
		
		CategoryDAO catDAO = new CategoryDAO();
		ArrayList<New> listNew = newDAO.getItemsByCategoryPagination(offset, id);
		Category category = catDAO.getItem(id);
		
		
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("numberOfPages", numberOfPages);

		request.setAttribute("listNew", listNew);
		request.setAttribute("category", category);
		RequestDispatcher rd = request.getRequestDispatcher("/views/public/cat.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
	}

}
