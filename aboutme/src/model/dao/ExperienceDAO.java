package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import model.bean.Contact;
import model.bean.Experience;
import model.bean.Info;
import model.bean.Project;
import utils.ConnectDBUtil;
import utils.DateUtil;

public class ExperienceDAO {
	private Connection conn;
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;
	

	public ArrayList<Experience> getItems() {
		
		ArrayList<Experience> listItems = new ArrayList<Experience>();
		
		conn = ConnectDBUtil.getConnection();
		String sql = "SELECT * FROM experience ORDER BY time ASC";
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				Date time = rs.getDate("time");
				Experience item = new Experience(id, name, time);
				listItems.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	finally {
			ConnectDBUtil.close(rs, st, conn);
		}
		
		return listItems;
	}


	public int addItem(Experience objExperience) {
		
		int result = 0;
		conn = ConnectDBUtil.getConnection();
		String sql = "INSERT INTO experience(name, time) VALUES (?, ?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objExperience.getName());
			pst.setDate(2, DateUtil.convert(objExperience.getTime()));
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBUtil.close(pst, conn);
		}
		return result;
	}


	public Experience getItem(int id) {
		

		Experience objExperience = null;

		conn = ConnectDBUtil.getConnection();
		String sql = "SELECT * FROM experience WHERE id = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if (rs.next()) {
			
			 objExperience = new Experience(rs.getInt("id"), rs.getString("name"),
					rs.getDate("time"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBUtil.close(pst, conn);
		}

		return objExperience;
	}


	public int editItem(Experience objExperience) {
		int result = 0;
		conn = ConnectDBUtil.getConnection();
		String sql = "UPDATE experience SET name = ?, time = ? "
				+ "WHERE id = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objExperience.getName());
			pst.setDate(2, DateUtil.convert(objExperience.getTime()));
			pst.setInt(3, objExperience.getId());
			result = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBUtil.close(pst, conn);
		}

		return result;
	}
}
