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
import model.bean.Friend;

import model.dao.CatDAO;
import model.dao.FriendsDAO;



@WebServlet("/danh-muc")
public class AnewsDanhMucController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AnewsDanhMucController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CatDAO catDAO = new CatDAO();
		FriendsDAO friendDAO = new FriendsDAO();
		
		int idCat = Integer.parseInt(request.getParameter("cid"));	
		ArrayList<Friend> listFriendbyID = friendDAO.getItemsByID(idCat);
		request.setAttribute("listFriendbyID", listFriendbyID);
		
		
		 
		RequestDispatcher rd = request.getRequestDispatcher("/anews/danh-muc.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
