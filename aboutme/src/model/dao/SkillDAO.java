package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Category;
import model.bean.Skill;
import utils.ConnectDBUtil;

public class SkillDAO {
	private Connection conn;
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public ArrayList<Skill> getItems() {
		ArrayList<Skill> listItems = new ArrayList<Skill>();

		conn = ConnectDBUtil.getConnection();
		String sql = "SELECT * FROM skill";

		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Skill objSkill = new Skill(rs.getInt("id"), rs.getString("name"), rs.getInt("value"));
				listItems.add(objSkill);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBUtil.close(rs, pst, conn);
		}

		return listItems;
	
	}

	public int addItem(Skill objSkill) {
		int result = 0;
		conn = ConnectDBUtil.getConnection();
		String sql = "INSERT INTO skill(name, value) VALUES (?, ?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objSkill.getName());
			pst.setInt(2, objSkill.getValue());
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
		String sql = "DELETE FROM skill WHERE id = ?";
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

	public Skill getItem(int id) {
		Skill objSkill = null;

		conn = ConnectDBUtil.getConnection();
		String sql = "SELECT * FROM skill WHERE id = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if (rs.next()) {
				objSkill = new Skill(rs.getInt("id"), rs.getString("name"), rs.getInt("value"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBUtil.close(pst, conn);
		}

		return objSkill;
	}

	public int editItem(Skill objNewSkill) {
		int result = 0;
		conn = ConnectDBUtil.getConnection();
		String sql = "UPDATE skill SET name = ?, value = ? WHERE id = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objNewSkill.getName());
			pst.setInt(2, objNewSkill.getValue());
			pst.setInt(3, objNewSkill.getId());
			
			result = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBUtil.close(pst, conn);
		}

		return result;
	}
	
}
