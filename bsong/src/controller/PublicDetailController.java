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

import model.bean.Song;
import model.dao.SongDAO;
import utils.CodeMessageUtil;

public class PublicDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PublicDetailController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (NumberFormatException e) {
			response.sendRedirect(request.getContextPath()+"/public/index?msg="+CodeMessageUtil.ERROR);
			return;
		}
		
		SongDAO songDAO = new SongDAO();
		
		Song objSong = songDAO.getItem(id);
		if (objSong == null) {
			response.sendRedirect(request.getContextPath()+"/public/index?msg="+CodeMessageUtil.ERROR);
			return;
		} 
		
		//tang view
		HttpSession session = request.getSession();
		String hasVisited = (String) session.getAttribute("hasVisited" + id);
		if (hasVisited == null) {
			session.setAttribute("hasVisited" + id,  "yes");
			session.setMaxInactiveInterval(3600);
			songDAO.increaseView(id);
		}
		
		
		ArrayList<Song> relatedSongs = songDAO.getRelatedSong(objSong, 5);
		
		request.setAttribute("objSong", objSong);
		request.setAttribute("relatedSongs ", relatedSongs );				
		RequestDispatcher rd = request.getRequestDispatcher("/views/public/detail.jsp");
		rd.forward(request, response);
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
