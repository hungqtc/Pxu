package controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Category;
import model.bean.New;
import model.dao.CategoryDAO;
import model.dao.NewDAO;
import utils.CodeMessageUtil;
import utils.DefineUtil;

public class AdminDelNewsNewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminDelNewsNewController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			int id = Integer.parseInt(request.getParameter("id"));
			
			NewDAO newDAO = new NewDAO();
			New objNew = newDAO.getItem(id);
			//delete file
			String fileName = objNew.getPicture();
			
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
				
			}
			
			if (newDAO.delItem(id) > 0) {
				response.sendRedirect(request.getContextPath()+"/admin/news/new/index?msg="+CodeMessageUtil.DELETE_SUCCESS);
				return;
			} else {
				response.sendRedirect(request.getContextPath()+"/admin/news/new/index?msg="+CodeMessageUtil.ERROR);
				return;
			}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
