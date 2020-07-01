package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Contact;
import utils.ConnectDBUtil;

public class ContactDAO {
	private Connection conn;
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public ArrayList<Contact> getItems() {
		ArrayList<Contact> listItems = new ArrayList<Contact>();
		
		conn = ConnectDBUtil.getConnection();
		String sql = "SELECT * FROM contacts ORDER BY id DESC";
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String website = rs.getString("website");
				String message = rs.getString("message");
				
				Contact item = new Contact(id, name, email, website, message);
				listItems.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	finally {
			ConnectDBUtil.close(rs, st, conn);
		}
		
		return listItems;
	}

	public int delItem(int id) {
		
		int result = 0;
		conn = ConnectDBUtil.getConnection();
		String sql = "DELETE FROM contacts WHERE id = ?" ;
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

	public int addItem(Contact objContact) {
		
		int result = 0;
		conn = ConnectDBUtil.getConnection();
		String sql = "INSERT INTO contacts(name, email,  website, message) VALUES (?, ?, ?, ?)" ;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objContact.getName());
			pst.setString(2, objContact.getEmail());
			pst.setString(3, objContact.getWebsite());
			pst.setString(4, objContact.getMessage());
			
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBUtil.close(pst, conn);
		}
		return result;
	}
	
	
}
