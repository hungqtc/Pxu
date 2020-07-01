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
import model.bean.Project;
import model.dao.CategoryDAO;
import model.dao.NewDAO;
import model.dao.ProjectDAO;
import utils.CodeMessageUtil;
import utils.DefineUtil;

public class AdminDelInfomationProjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminDelInfomationProjectController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			int id = Integer.parseInt(request.getParameter("id"));
			
			ProjectDAO projectDAO = new ProjectDAO();
			Project objProject = projectDAO.getItem(id);
			//delete file
			String fileName = objProject.getPicture();
			
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
			
			if (projectDAO.delItem(id) > 0) {
				response.sendRedirect(request.getContextPath()+"/admin/infomation/project/index?msg="+CodeMessageUtil.DELETE_SUCCESS);
				return;
			} else {
				response.sendRedirect(request.getContextPath()+"/admin/infomation/project/index?msg="+CodeMessageUtil.ERROR);
				return;
			}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
