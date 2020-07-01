package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Category;
import model.bean.CategoryFather;
import utils.ConnectDBUtil;

public class CategoryFatherDAO {
	private Connection conn;
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;

	public ArrayList<CategoryFather> getItems() {
		ArrayList<CategoryFather> listItems = new ArrayList<CategoryFather>();

		conn = ConnectDBUtil.getConnection();
		String sql = "SELECT * FROM categoriesfather";

		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				CategoryFather objCatFather = new CategoryFather(rs.getInt("id"), rs.getString("name"));
				listItems.add(objCatFather);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBUtil.close(rs, pst, conn);
		}

		return listItems;
	}

	public int addItem(CategoryFather objCatFather) {
		int result = 0;
		conn = ConnectDBUtil.getConnection();
		String sql = "INSERT INTO categoriesfather(name) VALUES (?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objCatFather.getName());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBUtil.close(pst, conn);
		}
		return result;
		
	}

	public CategoryFather getItemByName(String name) {
		CategoryFather objCatFather = null;

		conn = ConnectDBUtil.getConnection();
		String sql = "SELECT * FROM categoriesfather WHERE name LIKE ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, "%" + name + "%");
			rs = pst.executeQuery();
			if (rs.next()) {
				objCatFather = new CategoryFather(rs.getInt("id"), rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBUtil.close(pst, conn);
		}

		return objCatFather;
		
	}
}
