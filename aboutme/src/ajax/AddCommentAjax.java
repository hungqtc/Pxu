package ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Comment;
import model.bean.New;
import model.dao.CommentDAO;

import utils.CodeMessageUtil;

public class AddCommentAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CommentDAO commentDAO;
	
       
    public AddCommentAjax() {
        super();
        commentDAO = new CommentDAO();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("aid"));
		String name = request.getParameter("aname");
		
		String message = request.getParameter("amessage");
		Comment item = new Comment(new New(id), name, message);
		if (commentDAO.addItem(item) > 0) {
			
				ArrayList<Comment> listComment = commentDAO.getItems(id);
				if(listComment.size()>0){
					for(Comment objComment: listComment){
							String picture = request.getContextPath() + "/templates/public/images/loc.png";
			 out.print("<li class=\"comment\">\r\n" + 
			 		"                  <div class=\"vcard bio\">\r\n" + 
			 		"                    <img src="+picture+" alt=\"Image placeholder\">\r\n" + 
			 		"                  </div>\r\n" + 
			 		"                  <div class=\"comment-body\">\r\n" + 
			 		"                    <h3>"+objComment.getName()+"</h3>\r\n" + 
			 		"                    <div class=\"meta\">October 03, 2018 at 2:21pm</div>\r\n" + 
			 		"                    <p>"+objComment.getMessage()+"</p>\r\n" + 
			 		"                  </div>\r\n" + 
			 		"                </li>");
					}}
			return;
		} else {
			out.print("Comment bị lỗi!");
			System.out.println("b");
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
