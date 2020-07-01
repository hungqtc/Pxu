package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Comment;
import model.bean.Contact;
import model.dao.CommentDAO;

public class AdminIndexNewsCommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminIndexNewsCommentController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		
		CommentDAO commentDAO = new CommentDAO();
		ArrayList<Comment> listComment = commentDAO.getItems();
		request.setAttribute("listComment", listComment);
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/news/comment/index.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
