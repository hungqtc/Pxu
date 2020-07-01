package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.bean.Category;
import utils.ConnectDBUtil;

public class AddCatController {
	public static void main(String[] args) {
		//them 1 danh muc vao table: danh muc tin
		//danhmuctin: id,name
		//name?
		Category objCat = new Category(0, "Tin bóng đá");
		String ngayDang = "2019-06-30";
		int tinId = 10;
		Connection conn = ConnectDBUtil.getConnection();
		String sql = "INSERT INTO danhmuctin(TenDanhMucTin) VALUES(?)";
		Statement st = null;
		PreparedStatement pst = null; 
		//thông thường: PreparedStatement
		//TH use Statement: những câu lệnh SQL nó KHÔNG CÓ THAM SỐ
		//SQL INJECTION: bao mat
		int result = 0;
		try {
			pst = conn.prepareStatement(sql); //update, insert, delete (true-false)
			pst.setString(1, objCat.getName());
			result = pst.executeUpdate();
			System.out.println("Result: " + result);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDBUtil.close(pst, conn);
		}
		
	}
}
