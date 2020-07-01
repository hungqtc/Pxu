package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HinhTronController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HinhTronController() {
		super();

	}
	public static final float PI = 3.14f;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/Bai3/hinhtron.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		// Lấy dữ liệu từ JSp
		String bankinh = request.getParameter("bankinh").trim();
		String dientich = request.getParameter("dientich").trim();
		if (("".equals(bankinh) && "".equals(dientich))) {
			response.sendRedirect(request.getContextPath()+"/hinh-tron?msg=0");
			return;
		}
		if ((!"".equals(bankinh) && !"".equals(dientich))) {
			response.sendRedirect(request.getContextPath()+"/hinh-tron?msg=1");
			return;
		}
		double bk = 0;
		double dt = 0;
		try {
			if("".equals(dientich)) {
				//tinh dien tich
				 bk = Double.parseDouble(bankinh);
				 dt = bk * bk * PI;
			}
			else {
				dt = Double.parseDouble(dientich);
				bk = Math.sqrt(dt/PI);
			}
		} catch (NumberFormatException e) {
			response.sendRedirect(request.getContextPath()+"/hinh-tron?msg=2");
			return;
		}
		
		request.setAttribute("dienTich", dt);
		request.setAttribute("banKinh", bk);
		
		RequestDispatcher rd = request.getRequestDispatcher("/Bai3/hinhtron.jsp");
		rd.forward(request, response);

		// Kiểm tra điều kiện
		
	/*	if (("".equals(bankinh) && "".equals(dientich)) || (!"".equals(bankinh) && !"".equals(dientich))) {
			
			//request.setAttribute("error", "Vui lòng nhập 1 trong 2 ô");
		} else {
			if ("".equals(bankinh)) {
								
				try {
					double bk = Double.parseDouble(bankinh);
					
					double dt = bk * bk * 3.14;
					// Làm tròn 2 chữ số
					dt = (double) Math.round(dt * 100)/100;
					request.setAttribute("bankinh", bk);
					request.setAttribute("dientich", dt);
				} catch (Exception e) {
					request.setAttribute("error", "Vui lòng nhập đúng kiểu dữ liệu");
				}

				
			} else {
				
				
				try {
					double dt = Double.parseDouble(dientich);
					double bk = Math.sqrt(dt/3.14);
					bk = (double) Math.round(bk * 100) / 100;
					request.setAttribute("bankinh", bk);
					request.setAttribute("dientich", dt);
					
				} catch (Exception e) {
					request.setAttribute("error", "Vui lòng nhập đúng kiểu dữ liệu");
				}
			
			}
		}

		RequestDispatcher rd = request.getRequestDispatcher("/Bai3/hinhtron.jsp");
		rd.forward(request, response);

	}*/
	
	}
}
