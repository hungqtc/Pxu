package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.TinTuc;
import model.dao.NewsDAO;

public class DetailPublicController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DetailPublicController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int idNews = Integer.parseInt(request.getParameter("did"));
		NewsDAO newsDAO = new NewsDAO();
		
		TinTuc objTT = newsDAO.getItem(idNews);
		request.setAttribute("objTT", objTT);
		RequestDispatcher rd = request.getRequestDispatcher("/anews/detail.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
