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

public class AdminAddInfomationSkillController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminAddInfomationSkillController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/infomation/skill/add.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		int value = Integer.parseInt(request.getParameter("value"));
		
		Skill objSkill = new Skill(name, value);
		SkillDAO skillDAO = new SkillDAO();
		
		if (skillDAO.addItem(objSkill) > 0) {
			response.sendRedirect(request.getContextPath()+"/admin/infomation/skill/index?msg="+CodeMessageUtil.ADD_SUCCESS);
			return;
		} else {
			response.sendRedirect(request.getContextPath()+"/admin/infomation/skill/index?msg="+CodeMessageUtil.ERROR);
			return;
		}
		
	}

}
