package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.bean.Category;
import model.bean.New;
import model.dao.CategoryDAO;
import model.dao.NewDAO;
import utils.CodeMessageUtil;
import utils.DefineUtil;
import utils.FileUtil;
@MultipartConfig
public class AdminAddNewsNewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminAddNewsNewController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CategoryDAO catDAO = new CategoryDAO();
		ArrayList<Category> listCat = catDAO.getItems();
		request.setAttribute("listCat", listCat);
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/news/new/add.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		int catId = Integer.parseInt(request.getParameter("category"));
		String preview = request.getParameter("preview");
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
		//multiple
		/*
		 * ArrayList<Part> parts = (ArrayList<Part>)
		 * request.getParts().stream().filter(part ->
		 * "picture".equals(part.getName())).collect(Collectors.toList()); String
		 * fileName = "";
		 * 
		 * //check upload file
		 * 
		 * String dirPath = request.getServletContext().getRealPath("") +
		 * DefineUtil.DIR_UPLOAD;
		 * 
		 * File dir = new File(dirPath); if (!dir.exists()) { dir.mkdirs(); }
		 * 
		 * for (Part part : parts) { fileName =
		 * FileUtil.rename(part.getSubmittedFileName()); String filePath = dirPath +
		 * File.separator + fileName; part.write(filePath); }
		 */
			
		
		
		New objNew = new New(name, preview, detail, fileName, new Category(catId, null));
		NewDAO newDAO = new NewDAO();
		
		
		if (newDAO.addItem(objNew) > 0) {
			response.sendRedirect(request.getContextPath()+"/admin/news/new/index?msg="+CodeMessageUtil.ADD_SUCCESS);
			return;
		} else {
			response.sendRedirect(request.getContextPath()+"/admin/news/new/add?msg="+CodeMessageUtil.ERROR);
			return;
		}
		
	}

}
