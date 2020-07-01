package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Category;
import model.bean.Info;
import model.bean.Skill;
import model.dao.CategoryDAO;
import model.dao.InfoDAO;
import model.dao.SkillDAO;
import utils.CodeMessageUtil;

public class AdminEditInfomationInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminEditInfomationInfoController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		InfoDAO infoDAO = new InfoDAO();
		
		Info objOldInfo = infoDAO.getItem(id);
		request.setAttribute("objOldInfo", objOldInfo);
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/infomation/info/edit.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		String name = request.getParameter("name");
		String adress = request.getParameter("adress");
		String phoneNumber = request.getParameter("phonenumber");
		String email = request.getParameter("email");
		String content = request.getParameter("content");
		
		Info objNewInfo = new Info(id, name, adress, phoneNumber, email, content);
		InfoDAO infoDAO = new InfoDAO();
		
		if (infoDAO.editItem(objNewInfo) > 0) {
			response.sendRedirect(request.getContextPath()+"/admin/infomation/info/index?msg="+CodeMessageUtil.EDIT_SUCCESS);
			return;
		} else {
			response.sendRedirect(request.getContextPath()+"/admin/infomation/info/edit?msg="+CodeMessageUtil.ERROR);
			return;
		}
		
	}

}
