package bt4;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/Bt4")
public class Bt4 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Bt4() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		Random rand = new Random();

		int a = rand.nextInt(91) + 10;
		PrintWriter out = response.getWriter();
		out.println("Số a: " + a + "</br>");
		
		if (a % 3 == 0) {
			out.print("Số này chia hết cho 3 </br>");
		} else {
			out.print("Số này không chia hết cho 3 </br>");
		}

		if ((a >= 15) && (a <= 90)) {
			out.println("Số này nằm trong khoảng từ 15 đến 90");
		} else {
			out.println("Số này không nằm trong khoảng từ 15 đến 90");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
