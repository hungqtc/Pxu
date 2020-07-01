package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.bean.Category;
import model.bean.Song;
import model.dao.CategoryDAO;
import model.dao.SongDAO;
import utils.AuthUtil;
import utils.CodeMessageUtil;
import utils.DefineUtil;
import utils.FileUtil;
@MultipartConfig

public class AdminAddSongController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminAddSongController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!AuthUtil.isLogin(request)) {
			response.sendRedirect(request.getContextPath()+"/auth/login");
			return;
		}
		//lay danh sach cac danh muc
		CategoryDAO catDAO = new CategoryDAO();
		ArrayList<Category> listCat = catDAO.getItems();
		request.setAttribute("listCat", listCat);
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/song/add.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		CategoryDAO catDAO = new CategoryDAO();
		String name = request.getParameter("name");
		int catId = Integer.parseInt(request.getParameter("category"));
		String description = request.getParameter("preview");
		String detail = request.getParameter("detail");
		
		Part part = request.getPart("picture");
		String fileName = FileUtil.rename(part.getSubmittedFileName());
		
		//check upload file
		if (!"".equals(fileName)) {
			String dirPath = request.getServletContext().getRealPath("")  + DefineUtil.DIR_UPLOAD;
			
			File dir = new File(dirPath);
			if (!dir.exists()) {
				dir.mkdirs();
			} 
			String filePath = dirPath + File.separator + fileName;
			part.write(filePath);
		}
		
		Song objSong = new Song(name, description, detail, fileName, new Category(catId, null));
		
		//validation
		 SongDAO songDAO = new SongDAO();
		 
		if (songDAO.addItem(objSong) > 0) {
			//redirect admin/cat/index ==> display message
			response.sendRedirect(request.getContextPath()+"/admin/song/index?msg="+CodeMessageUtil.ADD_SUCCESS);
			return;
		} else {
			response.sendRedirect(request.getContextPath()+"/admin/song/add?msg="+CodeMessageUtil.ERROR);
			return;
		}
		
	}

}
