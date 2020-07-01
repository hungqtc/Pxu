package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.User;
import model.bean.User;
import utils.ConnectDBUtil;

public class UserDAO {
	private Connection conn;
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public int addItem(User objUser) {
		int result = 0;
		conn = ConnectDBUtil.getConnection();
		String sql = "INSERT INTO users(username, password, fullname) VALUES (?, ?, ?)" ;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objUser.getUsername());
			pst.setString(2, objUser.getPassword());
			pst.setString(3, objUser.getFullname());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBUtil.close(pst, conn);
		}
		return result;
		
	}

	public ArrayList<User> getItems() {
		ArrayList<User> listItem = new ArrayList<User>();
		conn = ConnectDBUtil.getConnection();
		String sql = "SELECT id, username, fullname FROM users ORDER BY id DESC";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("id");
				String username = rs.getString("username");
				String fullname = rs.getString("fullname");
				User objItem = new User(id, username, fullname);
				
				listItem.add(objItem);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			ConnectDBUtil.close(rs, st, conn);
		}
		return listItem;
		
	}

	public boolean hasUser(String username) {
		conn = ConnectDBUtil.getConnection();
		String sql = "SELECT * FROM users WHERE username = ?" ;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, username);
			rs = pst.executeQuery();
			
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBUtil.close(rs,pst, conn);
		}
		
		return false;
	}

	public User getItem(int id) {
		User objUser = null;
		conn = ConnectDBUtil.getConnection();
		String sql = "SELECT id, username, fullname FROM users WHERE id = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if (rs.next()) {				
				String username = rs.getString("username");
				String fullname = rs.getString("fullname");
				objUser = new User(id, username, fullname);				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			ConnectDBUtil.close(rs, pst, conn);
		}
		return objUser;
	}

	public int editItem(User objUser) {
		int result = 0;
		conn = ConnectDBUtil.getConnection();
		String sql = "UPDATE users SET password = ?,  fullname = ? WHERE id = ?" ;
		try {
			pst = conn.prepareStatement(sql);
			
			pst.setString(1, objUser.getPassword());
			pst.setString(2, objUser.getFullname());
			pst.setInt(3, objUser.getId());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBUtil.close(pst, conn);
		}
		return result;
	}

	public int delItem(int id) {
		
		int result = 0;
		conn = ConnectDBUtil.getConnection();
		String sql = "DELETE FROM users WHERE id = ?" ;
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
	
	public User getItemByUserNamePassword(User user) {
		User objUser = null;
		conn = ConnectDBUtil.getConnection();
		String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, user.getUsername());
			pst.setString(2, user.getPassword());
			rs = pst.executeQuery();
			if (rs.next()) {	
				int id = rs.getInt("id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String fullname = rs.getString("fullname");
				
				objUser = new User(id, username, password, fullname);				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			ConnectDBUtil.close(rs, pst, conn);
		}
		return objUser;
	}
}
