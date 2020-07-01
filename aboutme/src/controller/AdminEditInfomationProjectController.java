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
import model.dao.ProjectDAO;
import utils.CodeMessageUtil;
import utils.DefineUtil;
import utils.FileUtil;
@MultipartConfig
public class AdminEditInfomationProjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminEditInfomationProjectController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		ProjectDAO projectDAO = new ProjectDAO(); 
		
		Project objOldProject = projectDAO.getItem(id);
		
		request.setAttribute("objOldProject", objOldProject);
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/infomation/project/edit.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		ProjectDAO projectDAO = new ProjectDAO();
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		String name = request.getParameter("name");
		String preview = request.getParameter("preview");
		String link = request.getParameter("link");
			
		
		Project objOldProject = projectDAO.getItem(id);
		
		
		Part part = request.getPart("picture");
		// Lay ten file tu part
		String picture = FileUtil.getName(part);
		String fileName = "";
		if (picture.isEmpty()) {
			fileName = objOldProject.getPicture();
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
			String oldfilePath = dirPath + File.separator + objOldProject.getPicture();
			File oldFile = new File(oldfilePath);
			if (oldFile.exists()) {
				oldFile.delete();
			}

			String filePath = dirPath + File.separator + fileName;
			part.write(filePath);
		}
		
		Project objNewProject = new Project(id, name, preview, fileName, link);
		
		if (projectDAO.editItem(objNewProject) > 0) {
			response.sendRedirect(request.getContextPath()+"/admin/infomation/project/index?msg="+CodeMessageUtil.EDIT_SUCCESS);
			return;
		} else {
			response.sendRedirect(request.getContextPath()+"/admin/infomation/project/edit?msg="+CodeMessageUtil.ERROR);
			return;
		}
		
	}

}
