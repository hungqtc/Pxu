package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.bean.Info;
import model.bean.Skill;
import utils.ConnectDBUtil;

public class InfoDAO {
	private Connection conn;
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public Info getItem() {
		Info objInfo = null;

		conn = ConnectDBUtil.getConnection();
		String sql = "SELECT * FROM infomation";
		try {
			st = conn.createStatement();
			
			rs = st.executeQuery(sql);
			if (rs.next()) {
				objInfo = new Info(rs.getInt("id"), rs.getString("name"), rs.getString("adress"), 
						rs.getString("phone_number"), rs.getString("email"), rs.getString("content")); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBUtil.close(pst, conn);
		}

		return objInfo;
	}

	public Info getItem(int id) {
		
		Info objInfo = null;

		conn = ConnectDBUtil.getConnection();
		String sql = "SELECT * FROM infomation WHERE id = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if (rs.next()) {
				objInfo = new Info(rs.getInt("id"), rs.getString("name"), rs.getString("adress"), 
						rs.getString("phone_number"), rs.getString("email"), rs.getString("content"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBUtil.close(pst, conn);
		}

		return objInfo;
	}

	public int editItem(Info objNewInfo) {
		int result = 0;
		conn = ConnectDBUtil.getConnection();
		String sql = "UPDATE infomation SET name = ?, adress = ?, phone_number = ?, email = ?, content = ? "
				+ "WHERE id = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objNewInfo.getName());
			pst.setString(2, objNewInfo.getAdress());
			pst.setString(3, objNewInfo.getPhoneNumber());
			pst.setString(4, objNewInfo.getEmail());
			pst.setString(5, objNewInfo.getContent());
			pst.setInt(6, objNewInfo.getId());
			result = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBUtil.close(pst, conn);
		}

		return result;
	}
	
}
