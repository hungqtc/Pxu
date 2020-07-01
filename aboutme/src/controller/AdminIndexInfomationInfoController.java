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
import model.bean.Info;
import model.bean.Skill;
import model.dao.CategoryDAO;
import model.dao.InfoDAO;
import model.dao.SkillDAO;

public class AdminIndexInfomationInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminIndexInfomationInfoController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		InfoDAO infoDAO = new InfoDAO();
		Info objInfo = infoDAO.getItem();
		request.setAttribute("objInfo", objInfo);
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/infomation/info/index.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
