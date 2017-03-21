/**
 * 
 */
package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.NhanVatDongGop;
import model.bean.SuKienDongGop;

/**
 * @author HCD-Fresher161
 *
 */
public class ThongKeDAO {
	DataAccess da = new DataAccess();
	Connection connection=null;
	Statement stmt=null;
	Statement stmt1=null;
	Statement stmt2=null;
	Statement stmt3=null;
	Statement stmt4=null;
	
	private  int soLuongNguoiDung = 0;
	private  int soLuongLuotXem = 0;
	private  int soLuongBaiVietMoi = 0;
	private  int soLuongBaiViet = 0;
	
	/**
	 * @return the soLuongNguoiDung
	 */
	public int getSoLuongNguoiDung() {
		connection = da.getConnect();
		String sql = "SELECT count(*) AS soLuongNguoiDung from ACCOUNT";
		ResultSet rs = null;
		try {
			System.out.println(sql);
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				this.soLuongNguoiDung = rs.getInt("soLuongNguoiDung");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (stmt != null)
					stmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
			return soLuongNguoiDung;
	}
	/**
	 * @param soLuongNguoiDung the soLuongNguoiDung to set
	 */
	public  void setSoLuongNguoiDung(int soLuongNguoiDung) {
		this.soLuongNguoiDung = soLuongNguoiDung;
	}
	/**
	 * @return the soLuongLuotXem
	 */
	public  int getSoLuongLuotXem() {
		connection = da.getConnect();
		String sql = "SELECT sum(TATCA) AS soLuongLuotXem FROM DEMLUOTXEM";
		ResultSet rs = null;
		try {
			System.out.println(sql);
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				this.soLuongLuotXem = rs.getInt("soLuongLuotXem");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (stmt != null)
					stmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return soLuongLuotXem;
	}
	/**
	 * @param soLuongLuotXem the soLuongLuotXem to set
	 */
	public void setSoLuongLuotXem(int soLuongLuotXem) {
		this.soLuongLuotXem = soLuongLuotXem;
	}
	/**
	 * @return the soLuongBaiVietMoi
	 */
	public  int getSoLuongBaiVietMoi() {
		connection = da.getConnect();
		String sql1 = "SELECT count(*) AS soLuongBDSK FROM BAIDANGSUKIEN WHERE DATEDIFF(day,NGAYDANG,getdate()) <= 7";
		String sql2 = "SELECT count(*) AS soLuongBDNV FROM BAIDANGNHANVAT WHERE DATEDIFF(day,NGAYDANG,getdate()) <= 7";
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		int soLuongBDSK = 0;
		int soLuongBDNV = 0;
		try {
			System.out.println(sql1);
			stmt = connection.createStatement();
			rs1 = stmt.executeQuery(sql1);
			System.out.println(sql2);
			stmt1 = connection.createStatement();
			rs2 = stmt1.executeQuery(sql2);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while (rs1.next()) {
				soLuongBDSK = rs1.getInt("soLuongBDSK");
			}
			while (rs2.next()) {
				soLuongBDNV = rs2.getInt("soLuongBDNV");
			}
			
			this.soLuongBaiVietMoi = soLuongBDSK + soLuongBDNV ;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (stmt != null)
					stmt.close();
				if (stmt1 != null)
					stmt1.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return soLuongBaiVietMoi;
	}
	/**
	 * @param soLuongBaiVietMoi the soLuongBaiVietMoi to set
	 */
	public  void setSoLuongBaiVietMoi(int soLuongBaiVietMoi) {
		this.soLuongBaiVietMoi = soLuongBaiVietMoi;
	}
	/**
	 * @return the soLuongBaiViet
	 */
	public  int getSoLuongBaiViet() {
		connection = da.getConnect();
		String sql1 = "SELECT count(*) AS soLuongSuKien FROM SUKIEN";
		String sql2 = "SELECT count(*) AS soLuongNhanVat FROM NHANVAT";
		String sql3 = "SELECT count(*) AS soLuongBDSK FROM BAIDANGSUKIEN";
		String sql4 = "SELECT count(*) AS soLuongBDNV FROM BAIDANGNHANVAT";
		String sql5 = "SELECT count(*) AS soLuongDiaDanh FROM DIADANH";
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		ResultSet rs3 = null;
		ResultSet rs4 = null;
		ResultSet rs5 = null;
		int soLuongSuKien = 0;
		int soLuongNhanVat = 0;
		int soLuongBDSK = 0;
		int soLuongBDNV = 0;
		int soLuongDiaDanh = 0;
		try {
			System.out.println(sql1);
			stmt = connection.createStatement();
			rs1 = stmt.executeQuery(sql1);
			System.out.println(sql2);
			stmt1 = connection.createStatement();
			rs2 = stmt1.executeQuery(sql2);
			System.out.println(sql3);
			stmt2 = connection.createStatement();
			rs3 = stmt2.executeQuery(sql3);
			System.out.println(sql4);
			stmt3 = connection.createStatement();
			rs4 = stmt3.executeQuery(sql4);
			System.out.println(sql5);
			stmt4 = connection.createStatement();
			rs5 = stmt4.executeQuery(sql5);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while (rs1.next()) {
				soLuongSuKien = rs1.getInt("soLuongSuKien");
			}
			while (rs2.next()) {
				soLuongNhanVat = rs2.getInt("soLuongNhanVat");
			}
			while (rs3.next()) {
				soLuongBDSK = rs3.getInt("soLuongBDSK");
			}
			while (rs4.next()) {
				soLuongBDNV = rs4.getInt("soLuongBDNV");
			}
			while (rs5.next()) {
				soLuongDiaDanh = rs5.getInt("soLuongDiaDanh");
			}
			this.soLuongBaiViet = soLuongSuKien + soLuongNhanVat + soLuongBDSK + soLuongBDNV + soLuongDiaDanh;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (stmt != null)
					stmt.close();
				if (stmt1 != null)
					stmt1.close();
				if (stmt2 != null)
					stmt2.close();
				if (stmt3 != null)
					stmt3.close();
				if (stmt4 != null)
					stmt4.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return soLuongBaiViet;
	}
	/**
	 * @param soLuongBaiViet the soLuongBaiViet to set
	 */
	public  void setSoLuongBaiViet(int soLuongBaiViet) {
		this.soLuongBaiViet = soLuongBaiViet;
	}
	
	
	
}
