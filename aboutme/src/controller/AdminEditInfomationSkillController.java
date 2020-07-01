package controller;

import java.io.IOException;

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
import utils.CodeMessageUtil;

public class AdminEditInfomationSkillController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminEditInfomationSkillController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		SkillDAO skillDAO = new SkillDAO();
		
		Skill objOldSkill = skillDAO.getItem(id);
		request.setAttribute("objOldSkill", objOldSkill);
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/infomation/skill/edit.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		int value = Integer.parseInt(request.getParameter("value"));
		
		Skill objNewSkill = new Skill(id, name, value);
		SkillDAO skillDAO = new SkillDAO();
		
		if (skillDAO.editItem(objNewSkill) > 0) {
			response.sendRedirect(request.getContextPath()+"/admin/infomation/skill/index?msg="+CodeMessageUtil.EDIT_SUCCESS);
			return;
		} else {
			response.sendRedirect(request.getContextPath()+"admin/infomation/skill/edit?msg="+CodeMessageUtil.ERROR);
			return;
		}
		
	}

}
