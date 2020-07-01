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
	//list: getItems
	//Obj: getItem
	//add: addItem..
	//select theo id: getItemById
	public ArrayList<Category> getItems() {
		ArrayList<Category> listItem = new ArrayList<Category>();
		conn = ConnectDBUtil.getConnection();
		String sql = "SELECT * FROM categories ORDER BY id DESC";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Category objItem = new Category(rs.getInt("id"), rs.getString("name"));
				listItem.add(objItem);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			ConnectDBUtil.close(rs, st, conn);
		}
		return listItem;
	}
	public int addItem(Category objCat) {
		int result = 0;
		conn = ConnectDBUtil.getConnection();
		String sql = "INSERT INTO categories(name) VALUES (?)" ;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objCat.getName());
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
		String sql = "DELETE FROM categories WHERE id = ?" ;
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);;
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
		String sql = "SELECT * FROM categories WHERE id =?" ;
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
			ConnectDBUtil.close(rs, pst, conn);
		}
		return objCat;
	}
	public int editItem(Category objCat) {
		int result = 0;
		conn = ConnectDBUtil.getConnection();
		String sql = "UPDATE categories SET name =? WHERE id =?"  ;
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
}
