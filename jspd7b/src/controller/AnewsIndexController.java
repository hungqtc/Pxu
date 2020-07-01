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
import model.bean.TinTuc;
import model.dao.CatDAO;
import model.dao.NewsDAO;


public class AnewsIndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AnewsIndexController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CatDAO catDAO = new CatDAO();
		NewsDAO newsDAO = new NewsDAO();
		
		ArrayList<TinTuc> listTT = newsDAO.getItems();
		request.setAttribute("listTT", listTT);
		
		RequestDispatcher rd = request.getRequestDispatcher("/anews/index.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
