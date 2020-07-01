package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.TinTuc;
import utils.ConnectDBUtil;

public class NewsDAO {
	private Connection conn;
	private Statement st;
	private ResultSet rs;
	private PreparedStatement pst;

	public ArrayList<TinTuc> getItems() {
		ArrayList<TinTuc> listTT = new ArrayList<TinTuc>();

		conn = ConnectDBUtil.getConnection();
		String sql = "SELECT id_tintuc, " + "tentintuc, " + "mota, " + "chitiet, " + "id_danhmuctin "+ "FROM tintuc " // lưu ý dấu cách
																									// cuối câu
				+ "ORDER BY id_tintuc DESC";

		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				TinTuc objTT = new TinTuc(rs.getInt("id_tintuc"), rs.getString("tentintuc"), rs.getString("mota"),
						rs.getString("chitiet"), rs.getInt("id_danhmuctin"));
				listTT.add(objTT);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBUtil.close(rs, st, conn);
		}
		return listTT;
	}

	public ArrayList<TinTuc> getItemsByID(int idCat) {
		ArrayList<TinTuc> listTT = new ArrayList<TinTuc>();

		conn = ConnectDBUtil.getConnection();
		String sql = "SELECT * FROM tintuc WHERE id_danhmuctin = " + idCat;

		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				TinTuc objTT = new TinTuc(rs.getInt("id_tintuc"), rs.getString("tentintuc"), rs.getString("mota"));
				listTT.add(objTT);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBUtil.close(rs, st, conn);
		}
		return listTT;
	}

	public TinTuc getItem(int idNews) {
		TinTuc objTT = null;
		conn = ConnectDBUtil.getConnection();
		String sql = "SELECT id_tintuc, " + "tentintuc, " + "mota, " + "chitiet, " + "id_danhmuctin "+ "FROM tintuc WHERE id_tintuc = ?" ;
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, idNews);
			rs = pst.executeQuery();
			if (rs.next()) {
				objTT = new TinTuc(rs.getInt("id_tintuc"), rs.getString("tentintuc"), rs.getString("mota"),
						rs.getString("chitiet"), rs.getInt("id_danhmuctin"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBUtil.close(rs, pst, conn);
		}

		return objTT;
	}

}
