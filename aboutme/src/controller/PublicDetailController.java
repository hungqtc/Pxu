package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Comment;
import model.bean.Contact;
import model.bean.New;
import model.dao.CommentDAO;
import model.dao.ContactDAO;
import model.dao.NewDAO;
import utils.CodeMessageUtil;
import utils.DefineUtil;

public class PublicDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PublicDetailController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		NewDAO newDAO = new NewDAO();
		
		ArrayList<New> listNew = newDAO.getItems(id);
		New objNewCat = newDAO.getItem(id);
		CommentDAO commentDAO = new CommentDAO();
		
		ArrayList<Comment> listComment = commentDAO.getItems(id);
		ArrayList<New> listRelatedNews = newDAO.getRelatedItems(objNewCat, DefineUtil.NUMBER_OF_RELATED_NEWS );
		
		//tang view
		HttpSession session = request.getSession();
		String hasVisited = (String) session.getAttribute("hasVisited" + id);
		if (hasVisited == null) {
				session.setAttribute("hasVisited" + id,  "yes");
				session.setMaxInactiveInterval(3600);
				newDAO.increaseView(id);
		}
		
		request.setAttribute("listComment", listComment);
		request.setAttribute("listNew", listNew);
		request.setAttribute("objNewCat", objNewCat);
		request.setAttribute("listRelatedNews", listRelatedNews);
		
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/public/detail.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
	}

}
