package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.CommentDAO;
import model.dao.ContactDAO;
import utils.AuthUtil;
import utils.CodeMessageUtil;


public class AdminDelNewsCommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	public AdminDelNewsCommentController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		
			CommentDAO commentDAO = new CommentDAO();
			int id = Integer.parseInt(request.getParameter("id"));
			if (commentDAO.delItem(id) > 0) {
				
				response.sendRedirect(request.getContextPath()+"/admin/news/comment?msg="+CodeMessageUtil.DELETE_SUCCESS);
				return;
			} else {
				response.sendRedirect(request.getContextPath()+"/admin/news/comment?msg="+CodeMessageUtil.ERROR);
				return;
			}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
