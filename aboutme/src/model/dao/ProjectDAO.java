package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Category;
import model.bean.Project;
import model.bean.Project;
import model.bean.Project;
import utils.ConnectDBUtil;

public class ProjectDAO {
	private Connection conn;
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public ArrayList<Project> getItems() {
		
		
		ArrayList<Project> listItems = new ArrayList<Project>();

		conn = ConnectDBUtil.getConnection();
		String sql = "SELECT * FROM projects";

		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Project objProject = new Project(rs.getInt("id"), rs.getString("name"),
						rs.getString("preview"), rs.getString("picture"), rs.getString("link"));
				listItems.add(objProject);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBUtil.close(rs, pst, conn);
		}

		return listItems;
	}

	public int addItem(Project objProject) {
		
		int result = 0;
		conn = ConnectDBUtil.getConnection();
		String sql = "INSERT INTO projects(name, preview, picture, link) VALUES (?, ?, ?, ?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objProject.getName());
			pst.setString(2, objProject.getPreview());
			pst.setString(3, objProject.getPicture());
			pst.setString(4, objProject.getLink());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBUtil.close(pst, conn);
		}
		return result;
		
	}

	public Project getItem(int id) {
		Project objProject = null;

		conn = ConnectDBUtil.getConnection();
		String sql = "SELECT * FROM projects WHERE id = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if (rs.next()) {
				objProject = new Project(rs.getInt("id"), rs.getString("name"), rs.getString("preview"),
						rs.getString("picture"), rs.getString("link"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBUtil.close(pst, conn);
		}

		return objProject;
	}

	public int delItem(int id) {
		int result = 0;
		conn = ConnectDBUtil.getConnection();
		String sql = "DELETE FROM projects WHERE id = ?";
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

	public int editItem(Project objNewProject) {
		int result = 0;
		conn = ConnectDBUtil.getConnection();
		String sql = "UPDATE projects SET name = ?, preview = ?, picture = ?, link = ? WHERE id = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objNewProject.getName());
			pst.setString(2, objNewProject.getPreview());
			pst.setString(3, objNewProject.getPicture());
			pst.setString(4, objNewProject.getLink());
			pst.setInt(5, objNewProject.getId());
			result = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBUtil.close(pst, conn);
		}

		return result;
	}
	public int countItem() {
		int count = 0;
		conn = ConnectDBUtil.getConnection();
		String sql = "SELECT COUNT(*) AS count FROM projects";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				count = rs.getInt("count");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectDBUtil.close(rs, st, conn);
		}
		
		return count;
	}

}
