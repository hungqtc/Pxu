package controller;

import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Experience;
import model.dao.ExperienceDAO;
import utils.CodeMessageUtil;

public class AdminIndexInfomationExperienceController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminIndexInfomationExperienceController() {
		super();

	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ExperienceDAO experienceDAO = new ExperienceDAO();
		ArrayList<Experience> listExperience = experienceDAO.getItems();
		request.setAttribute("listExperience", listExperience);
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/infomation/experience/index.jsp");
		rd.forward(request, response);
	}

	/* Đang sai phần add */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
