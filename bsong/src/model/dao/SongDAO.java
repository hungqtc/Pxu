package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Category;
import model.bean.Song;
import utils.ConnectDBUtil;
import utils.DefineUtil;

public class SongDAO {
	private Connection conn;
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;

	// list: getItems
	// Obj: getItem
	// add: addItem..
	// select theo id: getItemById
	public ArrayList<Song> getItems() {
		ArrayList<Song> listItem = new ArrayList<Song>();
		conn = ConnectDBUtil.getConnection();
		String sql = "SELECT s.id, s.name AS songName, s.preview_text, s.detail_text, s.date_create, s.picture, s.counter, s.cat_id, c.name AS catName "
				+ "FROM songs AS s " + "INNER JOIN categories AS c " + "ON c.id = s.cat_id " + "ORDER BY s.id DESC";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				// dua vao ten cot cua cau lenh truy van ra ve
				Song objItem = new Song(rs.getInt("id"), rs.getString("songName"), rs.getString("preview_text"),
						rs.getString("detail_text"), rs.getTimestamp("date_create"), rs.getString("picture"),
						rs.getInt("counter"), new Category(rs.getInt("cat_id"), rs.getString("catName")));
				listItem.add(objItem);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectDBUtil.close(rs, st, conn);
		}
		return listItem;
	}

	public ArrayList<Song> getItems(int number) {
		ArrayList<Song> listItem = new ArrayList<Song>();
		conn = ConnectDBUtil.getConnection();
		String sql = "SELECT s.id, s.name AS songName, s.preview_text, s.detail_text, s.date_create, s.picture, s.counter, s.cat_id, c.name AS catName "
				+ "FROM songs AS s " + "INNER JOIN categories AS c " + "ON c.id = s.cat_id "
				+ "ORDER BY s.id DESC LIMIT ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, number);
			rs = pst.executeQuery();
			while (rs.next()) {
				// dua vao ten cot cua cau lenh truy van ra ve
				Song objItem = new Song(rs.getInt("id"), rs.getString("songName"), rs.getString("preview_text"),
						rs.getString("detail_text"), rs.getTimestamp("date_create"), rs.getString("picture"),
						rs.getInt("counter"), new Category(rs.getInt("cat_id"), rs.getString("catName")));
				listItem.add(objItem);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectDBUtil.close(rs, pst, conn);
		}
		return listItem;
	}

	public int addItem(Song objSong) {
		int result = 0;
		conn = ConnectDBUtil.getConnection();
		String sql = "INSERT INTO songs(name, preview_text, detail_text, picture, cat_id) VALUES (?, ?, ?, ?, ?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objSong.getName());
			pst.setString(2, objSong.getDescription());
			pst.setString(3, objSong.getDetail());
			pst.setString(4, objSong.getPicture());
			pst.setInt(5, objSong.getCat().getId());
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
		String sql = "DELETE FROM songs WHERE id = ?";
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

	public Song getItem(int id) {
		Song objSong = null;
		conn = ConnectDBUtil.getConnection();
		String sql = "SELECT * FROM songs WHERE id = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if (rs.next()) {
				objSong = new Song(rs.getInt("id"), rs.getString("name"), rs.getString("preview_text"),
						rs.getString("detail_text"), rs.getTimestamp("date_create"), rs.getString("picture"),
						rs.getInt("counter"), new Category(rs.getInt("cat_id"), null));

			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectDBUtil.close(rs, pst, conn);
		}
		return objSong;
	}

	public int editItem(Song objSong) {
		int result = 0;
		conn = ConnectDBUtil.getConnection();
		String sql = "UPDATE songs SET name = ?, preview_text = ?, detail_text = ?, picture = ?, cat_id = ? WHERE id = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objSong.getName());
			pst.setString(2, objSong.getDescription());
			pst.setString(3, objSong.getDetail());
			pst.setString(4, objSong.getPicture());
			pst.setInt(5, objSong.getCat().getId());
			pst.setInt(6, objSong.getId());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBUtil.close(pst, conn);
		}
		return result;
	}

	public ArrayList<Song> getRelatedSong(Song objSong, int number) {

		ArrayList<Song> listItem = new ArrayList<Song>();
		conn = ConnectDBUtil.getConnection();
		String sql = "SELECT s.id, s.name AS songName, s.preview_text, s.detail_text, s.date_create, s.picture, s.counter, s.cat_id, c.name AS catName "
				+ "FROM songs AS s " + "INNER JOIN categories AS c " + "ON c.id = s.cat_id "
				+ "WHERE cat_id = ? && s.id != ? " + "ORDER BY s.id DESC LIMIT ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, objSong.getCat().getId());
			pst.setInt(2, objSong.getId());
			pst.setInt(3, number);
			rs = pst.executeQuery();
			while (rs.next()) {
				// dua vao ten cot cua cau lenh truy van ra ve
				Song objItem = new Song(rs.getInt("id"), rs.getString("songName"), rs.getString("preview_text"),
						rs.getString("detail_text"), rs.getTimestamp("date_create"), rs.getString("picture"),
						rs.getInt("counter"), new Category(rs.getInt("cat_id"), rs.getString("catName")));
				listItem.add(objItem);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectDBUtil.close(rs, pst, conn);
		}
		return listItem;
	}

	public ArrayList<Song> getItemsByID(int catId) {
		ArrayList<Song> listItem = new ArrayList<Song>();
		conn = ConnectDBUtil.getConnection();
		String sql = "SELECT s.id, s.name AS songName, s.preview_text, s.detail_text, s.date_create, s.picture, s.counter, s.cat_id, c.name AS catName "
				+ "FROM songs AS s " + "INNER JOIN categories AS c " + "ON c.id = s.cat_id " + "WHERE cat_id = ? "
				+ "ORDER BY s.id DESC ";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, catId);
			rs = pst.executeQuery();
			while (rs.next()) {
				// dua vao ten cot cua cau lenh truy van ra ve
				Song objItem = new Song(rs.getInt("id"), rs.getString("songName"), rs.getString("preview_text"),
						rs.getString("detail_text"), rs.getTimestamp("date_create"), rs.getString("picture"),
						rs.getInt("counter"), new Category(rs.getInt("cat_id"), rs.getString("catName")));
				listItem.add(objItem);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectDBUtil.close(rs, pst, conn);
		}
		return listItem;

	}

	public void increaseView(int id) {

		conn = ConnectDBUtil.getConnection();
		String sql = "UPDATE songs SET counter = counter + 1 WHERE id =?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBUtil.close(pst, conn);
		}

	}

	public int numberOfItems() {
		conn = ConnectDBUtil.getConnection();
		String sql = "SELECT COUNT(*) AS count FROM songs ";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				int count = rs.getInt("count");
				return count;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectDBUtil.close(rs, st, conn);
		}
		return 0;
	}

	public int numberOfItems(int catId) {
		conn = ConnectDBUtil.getConnection();
		String sql = "SELECT COUNT(*) AS count FROM songs WHERE cat_id = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, catId);
			rs = pst.executeQuery();
			if (rs.next()) {
				int count = rs.getInt("count");
				return count;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectDBUtil.close(rs, pst, conn);
		}
		return 0;
	}

	public ArrayList<Song> getItemsPagination(int offset) {
		ArrayList<Song> listItem = new ArrayList<Song>();
		conn = ConnectDBUtil.getConnection();
		String sql = "SELECT s.id, s.name AS songName, s.preview_text, s.detail_text, s.date_create, s.picture, s.counter, s.cat_id, c.name AS catName "
				+ "FROM songs AS s " + "INNER JOIN categories AS c " + "ON c.id = s.cat_id "
				+ "ORDER BY s.id DESC LIMIT ?, ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, offset);
			pst.setInt(2, DefineUtil.NUMBER_PER_PAGE);
			rs = pst.executeQuery();
			while (rs.next()) {
				// dua vao ten cot cua cau lenh truy van ra ve
				Song objItem = new Song(rs.getInt("id"), rs.getString("songName"), rs.getString("preview_text"),
						rs.getString("detail_text"), rs.getTimestamp("date_create"), rs.getString("picture"),
						rs.getInt("counter"), new Category(rs.getInt("cat_id"), rs.getString("catName")));
				listItem.add(objItem);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectDBUtil.close(rs, pst, conn);
		}
		return listItem;
	}

	public ArrayList<Song> getItemsByIDPagination(int offset, int catId) {
		ArrayList<Song> listItem = new ArrayList<Song>();
		conn = ConnectDBUtil.getConnection();
		String sql = "SELECT s.id, s.name AS songName, s.preview_text, s.detail_text, s.date_create, s.picture, s.counter, s.cat_id, c.name AS catName "
				+ "FROM songs AS s " + "INNER JOIN categories AS c " + "ON c.id = s.cat_id " + "WHERE cat_id = ? "
				+ "ORDER BY s.id DESC LIMIT ?, ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, catId);
			pst.setInt(2, offset);
			pst.setInt(3, DefineUtil.NUMBER_PER_PAGE);
			rs = pst.executeQuery();
			while (rs.next()) {
				// dua vao ten cot cua cau lenh truy van ra ve
				Song objItem = new Song(rs.getInt("id"), rs.getString("songName"), rs.getString("preview_text"),
						rs.getString("detail_text"), rs.getTimestamp("date_create"), rs.getString("picture"),
						rs.getInt("counter"), new Category(rs.getInt("cat_id"), rs.getString("catName")));
				listItem.add(objItem);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectDBUtil.close(rs, pst, conn);
		}
		return listItem;
	}

	public ArrayList<Song> findAllByIdAndName(Song song) {

		ArrayList<Song> listItem = new ArrayList<Song>();
		conn = ConnectDBUtil.getConnection();
		String sql = "SELECT s.id, s.name AS songName, s.preview_text, s.detail_text, s.date_create, s.picture, s.counter, s.cat_id, c.name AS catName "
				+ "FROM songs AS s " 
				+ "INNER JOIN categories AS c " 
				+ "ON c.id = s.cat_id " 
				+ "WHERE 1 ";
				
		
			if (!"".equals(song.getName())) {
				sql += "AND s.name LIKE ?";
			} 
			if (song.getCat().getId() > 0) {
				sql += "AND s.cat_id = ?";
			}
			sql += " ORDER BY s.id DESC";
		try {
			pst = conn.prepareStatement(sql);
			if (!"".equals(song.getName()) && (song.getCat().getId() > 0)) {
				pst.setString(1, "%" + song.getName() + "%");
				pst.setInt(2, song.getCat().getId());
			} else if (!"".equals(song.getName()) && (song.getCat().getId() == 0)) {
				pst.setString(1, "%" + song.getName() + "%");
			} else if ("".equals(song.getName()) && (song.getCat().getId() > 0)) {
				pst.setInt(1, song.getCat().getId());
			}
			
			rs = pst.executeQuery();
			while (rs.next()) { // dua vao ten cot cua cau lenh truy van ra ve Song
				Song objItem = new Song(rs.getInt("id"), rs.getString("songName"), rs.getString("preview_text"),
						rs.getString("detail_text"), rs.getTimestamp("date_create"), rs.getString("picture"),
						rs.getInt("counter"), new Category(rs.getInt("cat_id"), rs.getString("catName")));
				listItem.add(objItem);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectDBUtil.close(rs, pst, conn);
		}
		return listItem;
	}

	public int countItem() {
		int count = 0;
		conn = ConnectDBUtil.getConnection();
		String sql = "SELECT COUNT(*) AS count FROM songs";
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
