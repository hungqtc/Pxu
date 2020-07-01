package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Category;
import utils.ConnectDBUtil;

public class CatDAO {
	private Connection conn;
	private Statement st;
	private ResultSet rs;
	
	public ArrayList<Category> getItems() {
		ArrayList<Category> listItem = new ArrayList<Category>();
		conn = ConnectDBUtil.getConnection();
		String sql = "SELECT * FROM danhmuctin";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Category objCat = new Category(rs.getInt("id_danhmuctin"), rs.getString("tendanhmuctin"));
				listItem.add(objCat);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			ConnectDBUtil.close(rs, st, conn);
		}
		return listItem;
	}

	public Category getItem(int idCat) {
		Category objCat = null;
		conn = ConnectDBUtil.getConnection();
		String sql = "SELECT * FROM danhmuctin WHERE id_danhmuctin = " + idCat;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				objCat = new Category(rs.getInt("id_danhmuctin"), rs.getString("tendanhmuctin"));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}  finally {
			ConnectDBUtil.close(rs, st, conn);
		}
		return objCat;
	}

	
}
