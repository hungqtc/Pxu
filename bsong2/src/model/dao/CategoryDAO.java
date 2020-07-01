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
}
