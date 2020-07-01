package controller;

import java.io.File;
import java.io.IOException;

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


public class AdminDelSongController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminDelSongController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!AuthUtil.isLogin(request)) {
			response.sendRedirect(request.getContextPath()+"/auth/login");
			return;
		}
		request.setCharacterEncoding("UTF-8");
		SongDAO songDAO = new SongDAO();
		
		//delete file
		
		
		int id = Integer.parseInt(request.getParameter("id"));
		Song objSong = songDAO.getItem(id);
		String fileName = objSong.getPicture();
		
		if (!"".equals(fileName)) {
			String dirPath = request.getServletContext().getRealPath("")  + DefineUtil.DIR_UPLOAD;
			
			File dir = new File(dirPath);
			if (!dir.exists()) {
				dir.mkdirs();
			} 
			String filePath = dirPath + File.separator + fileName;
			File file = new File(filePath);
			if (file.exists()) {
				file.delete();
			}
			System.out.println(filePath);
		}
		//delete tin
		if (songDAO.delItem(id) > 0) {
			//redirect admin/cat/index ==> display message
			response.sendRedirect(request.getContextPath()+"/admin/song/index?msg="+CodeMessageUtil.DELETE_SUCCESS);
			return;
		} else {
			response.sendRedirect(request.getContextPath()+"/admin/song/index?msg="+CodeMessageUtil.ERROR);
			return;
		}
		
		
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		
		
	}

}
