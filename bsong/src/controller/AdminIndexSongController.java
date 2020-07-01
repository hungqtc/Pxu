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
import utils.AuthUtil;
import utils.CodeMessageUtil;
import utils.DefineUtil;

public class AdminIndexSongController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminIndexSongController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!AuthUtil.isLogin(request)) {
			response.sendRedirect(request.getContextPath() + "/auth/login");
			return;
		}
		SongDAO songDAO = new SongDAO();
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

		Song song = new Song(sname, new Category(scat));
		ArrayList<Song> listSearch = songDAO.findAllByIdAndName(song);

		int numberOfSongs = songDAO.numberOfItems();
		int numberOfPages = (int) Math.ceil((float) numberOfSongs / DefineUtil.NUMBER_PER_PAGE);

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
		ArrayList<Song> listSong = songDAO.getItemsPagination(offset);
		ArrayList<Category> listCat = catDAO.getItems();

		if (scat > 0 || !"".equals(sname))
		{
			listSong = listSearch;
			
		}
		if (listSearch.size() == 0) {
			response.sendRedirect(request.getContextPath()+"/admin/song/index?msg="+CodeMessageUtil.ERROR_NO_FIND);
			return;
		}

		request.setAttribute("currentPage", currentPage);
		request.setAttribute("numberOfPages", numberOfPages);

		request.setAttribute("listSong", listSong);
		request.setAttribute("listCat", listCat);

		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/song/index.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
