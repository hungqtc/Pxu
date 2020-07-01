package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Category;
import model.bean.New;
import model.bean.New;
import model.dao.CategoryDAO;
import model.dao.NewDAO;
import model.dao.NewDAO;
import utils.CodeMessageUtil;
import utils.DefineUtil;

public class AdminIndexNewsNewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminIndexNewsNewController() {
		super();
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		NewDAO newDAO = new NewDAO();
		// search
		String sname = "";
		int scat = 0;
		if (request.getParameter("sname") != null) {
			// co nhap du lieu => muon tim kiem
			sname = request.getParameter("sname");
		}
		if (request.getParameter("scat") != null) {
			scat = Integer.parseInt(request.getParameter("scat"));
		}

		if (scat > 0) {
			scat = Integer.parseInt(request.getParameter("scat"));
			// co tim kiem danh muc
		}

		New objNew = new New(sname, new Category(scat));
		ArrayList<New> listSearchfirst = newDAO.findAllByIdAndName(objNew);
		int numberOfNews = 0;
		boolean check = false;
		if (scat > 0 || !"".equals(sname))
		{
			numberOfNews = listSearchfirst.size();
			check = true;
			
		} else {
			numberOfNews = newDAO.numberOfItems();
		}
		
		int numberOfPages = (int) Math.ceil((float) numberOfNews / DefineUtil.NUMBER_PER_PAGE);

		int currentPage = 1;
		try {
			currentPage = Integer.parseInt(request.getParameter("page"));
		} catch (Exception e) {

		}
		if (currentPage > numberOfPages || currentPage < 1) {
			currentPage = 1;
		}
		//offset: lay du lieu bat dau tu dong so offset
		//offset = 0: lay tu tin thu 1
		int offset = (currentPage - 1) * DefineUtil.NUMBER_PER_PAGE;

		CategoryDAO catDAO = new CategoryDAO();
		ArrayList<New> listNew = newDAO.getItemsPagination(offset);
		ArrayList<Category> listCat = catDAO.getItems();
		System.out.println(offset);
		System.out.println(numberOfNews);
		
		
		if (check) {
			ArrayList<New> listSearch = newDAO.findAllByIdAndName(objNew, offset);
			listNew = listSearch;
		}
		
		/*
		 * if (listSearch.size() == 0) {
		 * response.sendRedirect(request.getContextPath()+"/admin/news/new/index?msg="+
		 * CodeMessageUtil.ERROR_NO_FIND); return; }
		 */
		
		
		//dem so luong tin listSearch.size
		//so trang 
		//
		
		
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("numberOfPages", numberOfPages);

		request.setAttribute("listNew", listNew);
		request.setAttribute("listCat", listCat);
		request.setAttribute("sname", sname);
		request.setAttribute("scat", scat);
		request.setAttribute("checkSearch", check);
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/news/new/index.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
