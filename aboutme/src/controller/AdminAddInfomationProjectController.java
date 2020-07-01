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
import model.bean.Project;
import model.dao.CategoryDAO;
import model.dao.NewDAO;
import model.dao.ProjectDAO;
import utils.CodeMessageUtil;
import utils.DefineUtil;
import utils.FileUtil;
@MultipartConfig
public class AdminAddInfomationProjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminAddInfomationProjectController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/infomation/project/add.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String link = request.getParameter("link");
		String preview = request.getParameter("preview");
		
		
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
		
		Project objProject = new Project(name, preview, fileName, link);
		ProjectDAO projectDAO = new ProjectDAO();
		
		if (projectDAO.addItem(objProject) > 0) {
			response.sendRedirect(request.getContextPath()+"/admin/infomation/project/index?msg="+CodeMessageUtil.ADD_SUCCESS);
			return;
		} else {
			response.sendRedirect(request.getContextPath()+"/admin/infomation/project/add?msg="+CodeMessageUtil.ERROR);
			return;
		}
		
	}

}
