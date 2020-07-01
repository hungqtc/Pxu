package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectDBUtil {
	private static Connection conn;
	private static final String USER = "root";
	private static final String PASSWORD = "BDFoia86581";  
	private static final String URl = "jdbc:mysql://node215593-aboutmehung.j.layershift.co.uk/aboutme?useUnicode=true&characterEncoding=UTF-8";
	//node215593-aboutmehung.j.layershift.co.uk
	//BDFoia86581
	public static Connection getConnection() {
		// load the driver
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			// create object connection
			conn = DriverManager.getConnection(URl, USER, PASSWORD);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return conn;

	}

	public static void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void close(Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void close(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void close(ResultSet rs, Statement st, Connection conn) {
		close(rs);
		close(st);
		close(conn);
	}
	public static void close(ResultSet rs, PreparedStatement pst, Connection conn) {
		close(rs);
		close(pst);
		close(conn);
	}
	public static void close(Statement st, Connection conn) {
		close(st);
		close(conn);
	}
	public static void close(PreparedStatement pst, Connection conn) {
		close(pst);
		close(conn);
	}
}
