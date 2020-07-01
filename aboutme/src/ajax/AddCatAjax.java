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

import model.bean.CategoryFather;
import model.bean.Comment;
import model.bean.New;
import model.dao.CategoryFatherDAO;
import model.dao.CommentDAO;

import utils.CodeMessageUtil;

public class AddCatAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
       
    public AddCatAjax() {
        super();
        
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		String atype = request.getParameter("atype");
		CategoryFatherDAO catFatherDAO = new CategoryFatherDAO();
		ArrayList<CategoryFather> listCatFather = catFatherDAO.getItems();
		
		if (atype.equalsIgnoreCase("1")) {
			 out.print("<select  name=\"category\" >"); 
			for (CategoryFather objCatFather : listCatFather) {
			 out.print(
					 "<option value="+objCatFather.getId()+">"+objCatFather.getName()+"</option>\r\n"
					 );
			}
			 out.print("</select>"); 
			return;
		} 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
