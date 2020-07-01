package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.xdevapi.Result;

import utils.ConnectDBUtil;

//@WebServlet("/index")
public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public IndexController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		Connection conn = null;
		ResultSet rs = null;
		Statement st = null;

		try {
			conn = ConnectDBUtil.getConnection();
			String sql = "SELECT id_danhmuctin, tendanhmuctin FROM danhmuctin";
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {

				int id = rs.getInt("id_danhmuctin");
				String name = rs.getString("tendanhmuctin");
				out.print("ID: " + id + " Name: " + name);
				out.print("<br/> <hr/>");
			}
			System.out.println(conn);
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectDBUtil.close(rs, st, conn);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
