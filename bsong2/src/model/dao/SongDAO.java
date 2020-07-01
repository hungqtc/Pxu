package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Song;
import utils.ConnectDBUtil;

public class SongDAO {
	private Connection conn;
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;

	public ArrayList<Song> getItems() {
		ArrayList<Song> listSong = new ArrayList<Song>();
		conn = ConnectDBUtil.getConnection();
		String sql = "SELECT * FROM songs ORDER BY id DESC";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Song objSong = new Song(rs.getInt("id"), rs.getString("name"), rs.getString("preview_text"),
						rs.getString("detail_text"), rs.getString("date_create"), rs.getString("picture"),
						rs.getInt("counter"), rs.getInt("cat_id"));
				listSong.add(objSong);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectDBUtil.close(rs, st, conn);
		}
		return listSong;
	}

	public ArrayList<Song> getItemsByID(int catId) {
		ArrayList<Song> listSong = new ArrayList<Song>();
		conn = ConnectDBUtil.getConnection();
		String sql = "SELECT * FROM songs WHERE cat_id = " + catId;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Song objSong = new Song(rs.getInt("id"), rs.getString("name"), rs.getString("preview_text"),
						rs.getString("detail_text"), rs.getString("date_create"), rs.getString("picture"),
						rs.getInt("counter"), rs.getInt("cat_id"));
				listSong.add(objSong);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectDBUtil.close(rs, st, conn);
		}
		return listSong;
	}

	public Song getItem(int songId) {
		Song objSong = null;
		conn = ConnectDBUtil.getConnection();
		String sql = "SELECT * FROM songs WHERE cat_id = " + songId;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				objSong = new Song(rs.getInt("id"), rs.getString("name"), rs.getString("preview_text"),
						rs.getString("detail_text"), rs.getString("date_create"), rs.getString("picture"),
						rs.getInt("counter"), rs.getInt("cat_id"));

			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectDBUtil.close(rs, st, conn);
		}

		return objSong;
	}
}
