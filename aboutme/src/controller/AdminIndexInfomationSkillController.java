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
import model.bean.Skill;
import model.dao.CategoryDAO;
import model.dao.SkillDAO;

public class AdminIndexInfomationSkillController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminIndexInfomationSkillController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		SkillDAO skillDAO = new SkillDAO();
		ArrayList<Skill> listSkill = skillDAO.getItems();
		request.setAttribute("listSkill", listSkill);
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/infomation/skill/index.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
