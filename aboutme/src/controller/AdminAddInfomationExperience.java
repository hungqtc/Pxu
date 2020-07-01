package controller;

import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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

public class AdminAddInfomationExperience extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminAddInfomationExperience() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/infomation/experience/add.jsp");
		rd.forward(request, response);
	}

	/* Đang sai phần add */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String name = request.getParameter("name");
		String day = request.getParameter("day");
		String month = request.getParameter("month");
		String year = request.getParameter("year");
		
		String content = request.getParameter("content");
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		String dateInString = year+'/'+month+'/'+day;
		  
		 formatter.setLenient(false); 
		 Date date = null; 
		
		 try { 
			 date = (Date) formatter.parse(dateInString); 
			 } 
		 catch (ParseException e) { 
	
		  }
		
		 Calendar cal = Calendar.getInstance();
		 cal.setTime(date);
		 System.out.println(cal);
		 
			
		 Experience objExperience = new Experience(0, name, date);
		 ExperienceDAO experienceDAO = new ExperienceDAO();
		 
		  if (experienceDAO.addItem(objExperience) >0 ) { // redirect admin/cat/index => display message
		  response.sendRedirect(request.getContextPath() + "/admin/infomation/experience/index?msg=" + CodeMessageUtil.ADD_SUCCESS); 
		  return; 
		  
		  } else {
		  response.sendRedirect(request.getContextPath() + "/admin/infomation/experience/add?msg=" + CodeMessageUtil.ERROR);
		  return; 
		  }
		 
	}

}
