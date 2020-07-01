package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Comment;
import model.bean.Contact;
import model.bean.New;
import model.dao.CommentDAO;
import model.dao.ContactDAO;
import utils.CodeMessageUtil;

public class PublicCommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PublicCommentController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/public/detail.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//get Data
		int idNews = Integer.parseInt(request.getParameter("idNews"));
		System.out.println(idNews);
		String name = request.getParameter("name");
		String message = request.getParameter("message");
		
		CommentDAO commentDAO = new CommentDAO();
		
		Comment objComment = new Comment(new New(idNews), name, message);
		if (commentDAO.addItem(objComment) > 0) {
			response.sendRedirect(request.getContextPath()+"/views/public/detail.jsp?msg="+CodeMessageUtil.ADD_SUCCESS);
			return;
		} else {
			response.sendRedirect(request.getContextPath()+"/views/public/detail.jsp?msg="+CodeMessageUtil.ERROR);
			return;
		}
		
	}

}
