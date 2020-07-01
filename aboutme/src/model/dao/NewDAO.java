package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Category;
import model.bean.New;
import model.bean.New;
import utils.ConnectDBUtil;
import utils.DefineUtil;

public class NewDAO {
	private Connection conn;
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;

	public ArrayList<New> getItems() {

		ArrayList<New> listNew = new ArrayList<New>();

		conn = ConnectDBUtil.getConnection();
		String sql = "SELECT n.id, n.name AS newName, n.preview, n.detail, n.date_create, n.picture, n.counter, n.cat_id, c.name AS catName "
				+ "FROM news AS n " + "INNER JOIN categories AS c " + "ON c.id = n.cat_id " + "ORDER BY n.id DESC";

		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				New objNew = new New(rs.getInt("id"), rs.getString("newName"), rs.getString("preview"),
						rs.getString("detail"), rs.getTimestamp("date_create"), rs.getString("picture"),
						rs.getInt("counter"), new Category(rs.getInt("cat_id"), rs.getString("catName")));
				listNew.add(objNew);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBUtil.close(rs, st, conn);
		}

		return listNew;
	}

	public int addItem(New objNew) {
		int result = 0;
		conn = ConnectDBUtil.getConnection();
		String sql = "INSERT INTO news(name, preview, detail, picture, cat_id) VALUES (?, ?, ?, ?, ?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objNew.getName());
			pst.setString(2, objNew.getPreview());
			pst.setString(3, objNew.getDetail());
			pst.setString(4, objNew.getPicture());
			pst.setInt(5, objNew.getCat().getId());
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
		String sql = "DELETE FROM news WHERE id = ?";
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

	public New getItem(int id) {
		New objNew = null;
		conn = ConnectDBUtil.getConnection();
		String sql = "SELECT * FROM news WHERE id = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if (rs.next()) {
				objNew = new New(rs.getInt("id"), rs.getString("name"), rs.getString("preview"), rs.getString("detail"),
						rs.getTimestamp("date_create"), rs.getString("picture"), rs.getInt("counter"),
						new Category(rs.getInt("cat_id"), null));

			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectDBUtil.close(rs, pst, conn);
		}
		return objNew;

	}

	public int editItem(New objNewNew) {
		int result = 0;
		conn = ConnectDBUtil.getConnection();
		String sql = "UPDATE news SET name = ?, preview = ?, detail = ?, picture = ?, cat_id = ? WHERE id = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objNewNew.getName());
			pst.setString(2, objNewNew.getPreview());
			pst.setString(3, objNewNew.getDetail());
			pst.setString(4, objNewNew.getPicture());
			pst.setInt(5, objNewNew.getCat().getId());
			pst.setInt(6, objNewNew.getId());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBUtil.close(pst, conn);
		}
		return result;
	}

	public ArrayList<New> getTopItems(int numberOfTop) {
		
		ArrayList<New> listNew = new ArrayList<New>();

		conn = ConnectDBUtil.getConnection();
		String sql = "SELECT n.id, n.name AS newName, n.preview, n.detail, n.date_create, n.picture, n.counter, n.cat_id, c.name AS catName "
				+ "FROM news AS n " + "INNER JOIN categories AS c " + "ON c.id = n.cat_id " 
				
				+ "ORDER BY n.id DESC " 
				+ "LIMIT 3";

		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				New objNew = new New(rs.getInt("id"), rs.getString("newName"), rs.getString("preview"),
						rs.getString("detail"), rs.getTimestamp("date_create"), rs.getString("picture"),
						rs.getInt("counter"), new Category(rs.getInt("cat_id"), rs.getString("catName")));
				listNew.add(objNew);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBUtil.close(rs, st, conn);
		}

		return listNew;
	}

	public ArrayList<New> findAllByIdAndName(New objNew) {
		ArrayList<New> listItem = new ArrayList<New>();
		conn = ConnectDBUtil.getConnection();
		String sql = "SELECT n.id, n.name AS newName, n.preview, n.detail, n.date_create, n.picture, n.counter, n.cat_id, c.name AS catName "
				+ "FROM news AS n " + "INNER JOIN categories AS c " 
				+ "ON c.id = n.cat_id " 
				+ "WHERE 1 ";
				
		
			if (!"".equals(objNew.getName())) {
				sql += "AND n.name LIKE ?";
			} 
			if (objNew.getCat().getId() > 0) {
				sql += "AND n.cat_id = ?";
			}
			sql += " ORDER BY n.id DESC";
		try {
			pst = conn.prepareStatement(sql);
			if (!"".equals(objNew.getName()) && (objNew.getCat().getId() > 0)) {
				pst.setString(1, "%" + objNew.getName() + "%");
				pst.setInt(2, objNew.getCat().getId());
			} else if (!"".equals(objNew.getName()) && (objNew.getCat().getId() == 0)) {
				pst.setString(1, "%" + objNew.getName() + "%");
			} else if ("".equals(objNew.getName()) && (objNew.getCat().getId() > 0)) {
				pst.setInt(1, objNew.getCat().getId());
			}
			
			rs = pst.executeQuery();
			while (rs.next()) { // dua vao ten cot cua cau lenh truy van ra ve New
				New objItem = new New(rs.getInt("id"), rs.getString("newName"), rs.getString("preview"),
						rs.getString("detail"), rs.getTimestamp("date_create"), rs.getString("picture"),
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

	public int numberOfItems() {
		conn = ConnectDBUtil.getConnection();
		String sql = "SELECT COUNT(*) AS count FROM news ";
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
		String sql = "SELECT COUNT(*) AS count FROM news WHERE cat_id = ? ";
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

	public ArrayList<New> getItemsPagination(int offset) {
		ArrayList<New> listItem = new ArrayList<New>();
		conn = ConnectDBUtil.getConnection();
		String sql = "SELECT n.id, n.name AS newName, n.preview, n.detail, n.date_create, n.picture, n.counter, n.cat_id, c.name AS catName "
				+ "FROM news AS n " + "INNER JOIN categories AS c " + "ON c.id = n.cat_id " 
				
				+ "ORDER BY n.id  DESC LIMIT ?, ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, offset);
			pst.setInt(2, DefineUtil.NUMBER_PER_PAGE);
			rs = pst.executeQuery();
			while (rs.next()) {
				// dua vao ten cot cua cau lenh truy van ra ve
				New objItem = new New(rs.getInt("id"), rs.getString("newName"), rs.getString("preview"),
						rs.getString("detail"), rs.getTimestamp("date_create"), rs.getString("picture"),
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

	public ArrayList<New> getItemsByCategoryPagination(int offset, int catId) {
		ArrayList<New> listItem = new ArrayList<New>();
		conn = ConnectDBUtil.getConnection();
		String sql = "SELECT n.id, n.name AS newName, n.preview, n.detail, n.date_create, n.picture, n.counter, n.cat_id, c.name AS catName "
				+ "FROM news AS n " + "INNER JOIN categories AS c " + "ON c.id = n.cat_id " 
				+ "WHERE cat_id = ? "
				+ "ORDER BY n.id  DESC LIMIT ?, ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, catId);
			pst.setInt(2, offset);
			pst.setInt(3, DefineUtil.NUMBER_PER_PAGE);
			rs = pst.executeQuery();
			while (rs.next()) {
				// dua vao ten cot cua cau lenh truy van ra ve
				New objItem = new New(rs.getInt("id"), rs.getString("newName"), rs.getString("preview"),
						rs.getString("detail"), rs.getTimestamp("date_create"), rs.getString("picture"),
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

	public ArrayList<New> getItems(int id) {
		
		ArrayList<New> listNew = new ArrayList<New>();

		conn = ConnectDBUtil.getConnection();
		String sql = "SELECT n.id, n.name AS newName, n.preview, n.detail, n.date_create, n.picture, n.counter, n.cat_id, c.name AS catName "
				+ "FROM news AS n " + "INNER JOIN categories AS c " + "ON c.id = n.cat_id " 
				
				+ "WHERE n.id = ? "
				+ "ORDER BY n.id DESC";

		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			while (rs.next()) {
				New objNew = new New(rs.getInt("id"), rs.getString("newName"), rs.getString("preview"),
						rs.getString("detail"), rs.getTimestamp("date_create"), rs.getString("picture"),
						rs.getInt("counter"), new Category(rs.getInt("cat_id"), rs.getString("catName")));
				listNew.add(objNew);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBUtil.close(rs, pst, conn);
		}

		return listNew;
	}

	public ArrayList<New> getRelatedItems(New objNewCat, int numberOfRelatedNews) {
		
		ArrayList<New> listNew = new ArrayList<New>();

		conn = ConnectDBUtil.getConnection();
		String sql = "SELECT n.id, n.name AS newName, n.preview, n.detail, n.date_create, n.picture, n.counter, n.cat_id, c.name AS catName "
				+ "FROM news AS n " + "INNER JOIN categories AS c " 
				+ "ON c.id = n.cat_id " 
				
				+ "WHERE cat_id = ? && n.id != ? "
				+ "ORDER BY n.id DESC LIMIT ?";

		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, objNewCat.getCat().getId());
			pst.setInt(2, objNewCat.getId());
			pst.setInt(3, numberOfRelatedNews);
			rs = pst.executeQuery();
			while (rs.next()) {
				New objNew = new New(rs.getInt("id"), rs.getString("newName"), rs.getString("preview"),
						rs.getString("detail"), rs.getTimestamp("date_create"), rs.getString("picture"),
						rs.getInt("counter"), new Category(rs.getInt("cat_id"), rs.getString("catName")));
				listNew.add(objNew);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBUtil.close(rs, pst, conn);
		}

		return listNew;
	}

	public void increaseView(int id) {
		conn = ConnectDBUtil.getConnection();
		String sql = "UPDATE news SET counter = counter + 1 WHERE id =?";
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

	public ArrayList<New> findAllByIdAndName(New objNew, int offset) {
		ArrayList<New> listItem = new ArrayList<New>();
		conn = ConnectDBUtil.getConnection();
		String sql = "SELECT n.id, n.name AS newName, n.preview, n.detail, n.date_create, n.picture, n.counter, n.cat_id, c.name AS catName "
				+ "FROM news AS n " + "INNER JOIN categories AS c " 
				+ "ON c.id = n.cat_id " 
				+ "WHERE 1 ";
				
		
			if (!"".equals(objNew.getName())) {
				sql += "AND n.name LIKE ?";
			} 
			if (objNew.getCat().getId() > 0) {
				sql += "AND n.cat_id = ?";
			}
			sql += " ORDER BY n.id DESC LIMIT ?, ?";
		try {
			pst = conn.prepareStatement(sql);
			if (!"".equals(objNew.getName()) && (objNew.getCat().getId() > 0)) {
				pst.setString(1, "%" + objNew.getName() + "%");
				pst.setInt(2, objNew.getCat().getId());
				pst.setInt(3, offset);
				pst.setInt(4, DefineUtil.NUMBER_PER_PAGE);
			} else if (!"".equals(objNew.getName()) && (objNew.getCat().getId() == 0)) {
				pst.setString(1, "%" + objNew.getName() + "%");
				pst.setInt(2, offset);
				pst.setInt(3, DefineUtil.NUMBER_PER_PAGE);
			} else if ("".equals(objNew.getName()) && (objNew.getCat().getId() > 0)) {
				pst.setInt(1, objNew.getCat().getId());
				pst.setInt(2, offset);
				pst.setInt(3, DefineUtil.NUMBER_PER_PAGE);
			}
			
			rs = pst.executeQuery();
			while (rs.next()) { // dua vao ten cot cua cau lenh truy van ra ve New
				New objItem = new New(rs.getInt("id"), rs.getString("newName"), rs.getString("preview"),
						rs.getString("detail"), rs.getTimestamp("date_create"), rs.getString("picture"),
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

	

}
