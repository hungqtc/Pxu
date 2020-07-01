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

import exceptions.GreaterThanException;
import object.Hoa;

@WebServlet("/hoa")
public class HoaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HoaController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/Bai2/hoa.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String name = "";
		String id = "";
		float price = 0;
		int quanity = 0;
		//validation form 
		if ("".equals(request.getParameter("id"))) {
			request.setAttribute("msg", "ID không được rỗng");
			forwardError(request, response);
			return;
		}
		if ("".equals(request.getParameter("name"))) {
			request.setAttribute("msg", "Tên hoa không được rỗng");
			forwardError(request, response);
			
			return;
		}
		
		if ("".equals(request.getParameter("quanity"))) {
			request.setAttribute("msg", "Số lượng không được rỗng");
			forwardError(request, response);
			return;
		} else {
			try {
				quanity = Integer.parseInt(request.getParameter("quanity"));
				if (quanity < 0) {
					throw new GreaterThanException("Vui lòng nhập số > 0");
				}
			} catch (NumberFormatException e) {
				request.setAttribute("msg", "Số lượng phải là số");
				forwardError(request, response);
				return;
			}
			
		}
		if ("".equals(request.getParameter("price"))) {
			request.setAttribute("msg", "Giá không được rỗng");
			forwardError(request, response);
			return;
		}
		
		
		/*
		 * HttpSession session = request.getSession(); String name =
		 * request.getParameter("name"); int id =
		 * Integer.parseInt(request.getParameter("id")); int quanity =
		 * Integer.parseInt(request.getParameter("quanity")); long price =
		 * Long.parseLong(request.getParameter("price"));
		 * 
		 * Hoa objHoa = new Hoa(id, name, quanity, price); session.setAttribute("Hoa",
		 * objHoa); ArrayList<Hoa> ListHoa = new ArrayList<Hoa>(); ListHoa.add(objHoa);
		 * 
		 * session.setAttribute("listHoa", ListHoa);
		 */
		RequestDispatcher rd = request.getRequestDispatcher("/Bai2/basket.jsp");
		rd.forward(request, response);
		
		
	}
	public void forwardError(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/Bai2/hoa.jsp?error=Error");
		rd.forward(request, response);
	}
}
