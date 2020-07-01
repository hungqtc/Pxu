package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Category;
import model.bean.Comment;
import model.bean.Contact;
import model.bean.New;
import utils.ConnectDBUtil;

public class CommentDAO {
	private Connection conn;
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;

	public int addItem(Comment objComment) {

		int result = 0;
		conn = ConnectDBUtil.getConnection();
		String sql = "INSERT INTO comment(news_id, message, user_name) VALUES (?, ?, ?)" ;
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, objComment.getNews().getId());
			pst.setString(2, objComment.getMessage());
			pst.setString(3, objComment.getName());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBUtil.close(pst, conn);
		}
		return result;
	}

	public ArrayList<Comment> getItems() {
		
		ArrayList<Comment> listItems = new ArrayList<Comment>();
		
		conn = ConnectDBUtil.getConnection();
		String sql = "SELECT c.id, c.message, c.user_name, n.name AS news_name FROM comment AS c"
				+ " INNER jOIN news AS n"
				+ " ON c.news_id = n.id"
				+ " ORDER BY id DESC";
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("id");
				String userName = rs.getString("user_name");
				String newsName = rs.getString("news_name");
				String message = rs.getString("message");
				
				Comment objComment = new Comment(id, new New(newsName), userName , message);
				listItems.add(objComment);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	finally {
			ConnectDBUtil.close(rs, st, conn);
		}
		
		return listItems;
	}

	public int delItem(int id) {
		int result = 0;
		conn = ConnectDBUtil.getConnection();
		String sql = "DELETE FROM comment WHERE id = ?" ;
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBUtil.close(pst, conn);
		}
		return result;
	}

	public ArrayList<Comment> getItems(int id) {
		ArrayList<Comment> listItems = new ArrayList<Comment>();

		conn = ConnectDBUtil.getConnection();
		String sql = "SELECT c.id, c.message, c.user_name, n.name AS news_name, news_id FROM comment AS c"
				+ " INNER jOIN news AS n"
				+ " ON c.news_id = n.id"
				+ " WHERE news_id = ?"
				+ " ORDER BY id ASC";

		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			while (rs.next()) {
				
				String userName = rs.getString("user_name");
				String newsName = rs.getString("news_name");
				String message = rs.getString("message");
				
				Comment objComment = new Comment(rs.getInt("id"), new New(rs.getInt("news_id"), newsName) ,userName , message);
				listItems.add(objComment);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBUtil.close(rs, pst, conn);
		}

		return listItems;
	}
}
