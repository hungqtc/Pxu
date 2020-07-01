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
import model.bean.Song;
import model.dao.CategoryDAO;
import model.dao.SongDAO;
import utils.CodeMessageUtil;
import utils.DefineUtil;

public class PublicCatController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PublicCatController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CategoryDAO catDAO = new CategoryDAO();
		SongDAO songDAO = new SongDAO();
		
		int id = 0;
		int currentPage = 1;
		try {
			id = Integer.parseInt(request.getParameter("id"));
			
		} catch (NumberFormatException e) {
			response.sendRedirect(request.getContextPath()+ "/404");
			return;
		}
		try {
			currentPage = Integer.parseInt(request.getParameter("page"));
		} catch (Exception e) {
			currentPage = 1;
		}
		Category listCat = catDAO.getItem(id);
		if (listCat == null) {
			response.sendRedirect(request.getContextPath()+ "/404");
			return;
		}
		
		int numberOfSongs = songDAO.numberOfItems(id);
		int numberOfPages =	(int) Math.ceil((float)numberOfSongs / DefineUtil.NUMBER_PER_PAGE) ;
		
		if (currentPage > numberOfPages || currentPage < 1) {
			currentPage = 1;
		}
		
		int offset = (currentPage - 1) * DefineUtil.NUMBER_PER_PAGE;
		
		ArrayList<Song> listSongByID = songDAO.getItemsByIDPagination(offset,id);
		
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("numberOfPages", numberOfPages);
		request.setAttribute("listCat", listCat);
		request.setAttribute("listSongById", listSongByID);
		RequestDispatcher rd = request.getRequestDispatcher("/views/public/cat.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
