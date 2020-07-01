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
import model.bean.Project;
import model.bean.Skill;
import model.dao.CategoryDAO;
import model.dao.ProjectDAO;
import model.dao.SkillDAO;

public class AdminIndexInfomationProjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminIndexInfomationProjectController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ProjectDAO projectDAO = new ProjectDAO();
		ArrayList<Project> listProject = projectDAO.getItems();
		request.setAttribute("listProject", listProject);
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/infomation/project/index.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
