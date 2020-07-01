package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Category;
import model.bean.Experience;
import model.bean.Skill;
import model.dao.CategoryDAO;
import model.dao.ExperienceDAO;
import model.dao.SkillDAO;
import utils.CodeMessageUtil;
import utils.DateUtil;

public class AdminEditInfomationExperienceController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminEditInfomationExperienceController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		ExperienceDAO experienceDAO = new ExperienceDAO();
		
		Experience objOldExperience = experienceDAO.getItem(id);
		String[] dateOldExperience = DateUtil.splitString(objOldExperience);
		
		String a ="03";
		int i = Integer.parseInt(a);
		System.out.println(i);
		
				
		request.setAttribute("objOldExperience", objOldExperience);
		request.setAttribute("dateOldExperience", dateOldExperience);
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/infomation/experience/edit.jsp");
		rd.forward(request, response);
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		String name = request.getParameter("name");
		String day = request.getParameter("day");
		String month = request.getParameter("month");
		String year = request.getParameter("year");
		
		String content = request.getParameter("content");
		System.out.println(year+"/"+month+"/"+day);
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		String dateInString = year+'/'+month+'/'+day;
		  
		 formatter.setLenient(false); 
		 Date date = null; 
		
		 try { 
			 date = (Date) formatter.parse(dateInString); 
			 } 
		 catch (ParseException e) { 
	
		  }
		
		 
		 Experience objExperience = new Experience(id, name, date);
		 ExperienceDAO experienceDAO = new ExperienceDAO();
		 
		  if (experienceDAO.editItem(objExperience) >0 ) { // redirect admin/cat/index => display message
		  response.sendRedirect(request.getContextPath() + "/admin/infomation/experience/index?msg=" + CodeMessageUtil.EDIT_SUCCESS); 
		  return; 
		  
		  } else {
		  response.sendRedirect(request.getContextPath() + "/admin/infomation/experience/edit?msg=" + CodeMessageUtil.ERROR);
		  return; 
		  }
		
	}

}
