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
import model.bean.New;
import model.dao.CategoryDAO;
import model.dao.NewDAO;
import utils.CodeMessageUtil;
import utils.DefineUtil;
import utils.FileUtil;
@MultipartConfig
public class AdminEditNewsNewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminEditNewsNewController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		NewDAO newDAO = new NewDAO();
		
		CategoryDAO catDAO = new CategoryDAO();
		ArrayList<Category> listCat = catDAO.getItems();
		
		New objOldNew = newDAO.getItem(id);
		request.setAttribute("listCat", listCat);
		request.setAttribute("objOldNew", objOldNew);
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/news/new/edit.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		NewDAO newDAO = new NewDAO();

		int catId = Integer.parseInt(request.getParameter("category"));
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String preview = request.getParameter("preview");
		String detail = request.getParameter("detail");
			
		
		New objOldNew = newDAO.getItem(id);
		
		
		Part part = request.getPart("picture");
		// Lay ten file tu part
		String picture = FileUtil.getName(part);
		String fileName = "";
		if (picture.isEmpty()) {
			fileName = objOldNew.getPicture();
		} else {
			fileName = FileUtil.rename(picture);
		}

		// check upload file
		if (!"".equals(picture)) {
			// Tao thu muc luu anh
			String dirPath = request.getServletContext().getRealPath("") + DefineUtil.DIR_UPLOAD;
			File dir = new File(dirPath);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			
			// Delete old file 
			String oldfilePath = dirPath + File.separator + objOldNew.getPicture();
			File oldFile = new File(oldfilePath);
			if (oldFile.exists()) {
				oldFile.delete();
			}

			String filePath = dirPath + File.separator + fileName;
			part.write(filePath);
		}
		
		New objNewNew = new New(id, name, preview, detail, fileName, new Category(catId));
		
		if (newDAO.editItem(objNewNew) > 0) {
			response.sendRedirect(request.getContextPath()+"/admin/news/new/index?msg="+CodeMessageUtil.EDIT_SUCCESS);
			return;
		} else {
			response.sendRedirect(request.getContextPath()+"/admin/news/new/edit?msg="+CodeMessageUtil.ERROR);
			return;
		}
		
	}

}
