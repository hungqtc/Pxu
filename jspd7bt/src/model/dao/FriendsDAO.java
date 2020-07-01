package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Friend;


import utils.ConnectDBUtil;

public class FriendsDAO {
	private Connection conn;
	private Statement st;
	private ResultSet rs;

	public ArrayList<Friend> getItems() {
		ArrayList<Friend> listFriends = new ArrayList<Friend>();

		conn = ConnectDBUtil.getConnection();
		String sql = "SELECT fid, " + "fname, " + "preview, " + "detail, " + "date_create, " 
		+ "fl_id, " + "count_number " + "FROM friends " 	
			+ "ORDER BY fid DESC";

		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Friend objFr = new Friend(rs.getInt("fid"), rs.getString("fname"), rs.getString("preview"),
						rs.getString("detail"), rs.getString("date_create"), rs.getInt("fl_id"), rs.getInt("count_number"));
				listFriends.add(objFr);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBUtil.close(rs, st, conn);
		}
		return listFriends;
	}

	public ArrayList<Friend> getItemsByID(int idCat) {
		ArrayList<Friend> listFriends = new ArrayList<Friend>();

		conn = ConnectDBUtil.getConnection();
		String sql = "SELECT * FROM friends WHERE fl_id= " + idCat;

		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Friend objFr = new Friend(rs.getInt("fid"), rs.getString("fname"), rs.getString("preview"),
						rs.getString("detail"), rs.getString("date_create"), rs.getInt("fl_id"), rs.getInt("count_number"));
				listFriends.add(objFr);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBUtil.close(rs, st, conn);
		}
		return listFriends;
	}

	/*
	 * public Friends getItem(int idNews) { Friends objTT = null; conn =
	 * ConnectDBUtil.getConnection(); String sql = "SELECT id_Friends, " +
	 * "tenFriends, " + "mota, " + "chitiet, " + "id_danhmuctin "+
	 * "FROM Friends WHERE id_Friends = " + idNews; try { st = conn.createStatement();
	 * rs = st.executeQuery(sql); if (rs.next()) { objTT = new
	 * Friends(rs.getInt("id_Friends"), rs.getString("tenFriends"),
	 * rs.getString("mota"), rs.getString("chitiet"), rs.getInt("id_danhmuctin")); }
	 * } catch (SQLException e) { e.printStackTrace(); } finally {
	 * ConnectDBUtil.close(rs, st, conn); }
	 * 
	 * return objTT; }
	 */

}
