package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Category;
import utils.ConnectDBUtil;

public class CategoryDAO {
	private Connection conn;
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;

	public ArrayList<Category> getItems() {
		ArrayList<Category> listItems = new ArrayList<Category>();

		conn = ConnectDBUtil.getConnection();
		String sql = "SELECT * FROM categories";

		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Category objCat = new Category(rs.getInt("id"), rs.getString("name"));
				listItems.add(objCat);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBUtil.close(rs, pst, conn);
		}

		return listItems;
	}

	public int addItem(Category objCat) {
		int result = 0;
		conn = ConnectDBUtil.getConnection();
		String sql = "INSERT INTO categories(name, id_father) VALUES (?, ?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objCat.getName());
			pst.setInt(2, objCat.getCatFather().getId());
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
		String sql = "DELETE FROM categories WHERE id = ?";
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

	public Category getItem(int id) {
		Category objCat = null;

		conn = ConnectDBUtil.getConnection();
		String sql = "SELECT * FROM categories WHERE id = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if (rs.next()) {
				objCat = new Category(rs.getInt("id"), rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBUtil.close(pst, conn);
		}

		return objCat;
	}

	public int editItem(Category objCat) {
		int result = 0;
		conn = ConnectDBUtil.getConnection();
		String sql = "UPDATE categories SET name = ? WHERE id = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objCat.getName());
			pst.setInt(2, objCat.getId());
			result = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBUtil.close(pst, conn);
		}

		return result;
	}
	
	public ArrayList<Category> getItemsByFather(int idCatFather) {
		ArrayList<Category> listItems = new ArrayList<Category>();

		conn = ConnectDBUtil.getConnection();
		String sql = "SELECT c.id, c.name FROM categoriesfather AS cf"
				+ " INNER JOIN categories AS c"
				+ " ON cf.id = c.id_father"
				+ " WHERE cf.id = ?";

		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, idCatFather);
			rs = pst.executeQuery();
			
			while (rs.next()) {
				Category objCat = new Category(rs.getInt("id"), rs.getString("name"));
				listItems.add(objCat);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBUtil.close(rs, pst, conn);
		}

		return listItems;
	}

}
