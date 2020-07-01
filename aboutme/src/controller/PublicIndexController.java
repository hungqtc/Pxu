package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Experience;
import model.bean.Info;
import model.bean.New;
import model.bean.Project;
import model.bean.Skill;
import model.dao.ExperienceDAO;
import model.dao.InfoDAO;
import model.dao.NewDAO;
import model.dao.ProjectDAO;
import model.dao.SkillDAO;
import utils.DefineUtil;
import utils.SortArray;

public class PublicIndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PublicIndexController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProjectDAO projectDAO = new ProjectDAO();
		int countProject = projectDAO.countItem();
		ArrayList<Project> listProject = projectDAO.getItems();
		
		
		NewDAO newDAO = new NewDAO();
		ArrayList<New> listNewsTop = newDAO.getTopItems(DefineUtil.NUMBER_OF_TOP);
		ExperienceDAO experienceDAO = new ExperienceDAO();

		ArrayList<Experience> listExperience = experienceDAO.getItems();
		/* listExperience = SortArray.listSort(listExperience); */
		
		
		SkillDAO skillDAO = new SkillDAO();
		ArrayList<Skill> listSkill = skillDAO.getItems();
		request.setAttribute("countProject", countProject);
		request.setAttribute("listNewsTop", listNewsTop);
		request.setAttribute("listProject", listProject);
		request.setAttribute("listSkill", listSkill);
		request.setAttribute("listExperience", listExperience);
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/public/index.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
