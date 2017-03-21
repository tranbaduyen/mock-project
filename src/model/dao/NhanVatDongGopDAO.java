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
public class NhanVatDongGopDAO {
	DataAccess da = new DataAccess();
	Connection connection=null;
	Statement stmt=null;
	
	private static int soLuongNhanVatChoDuyet = 0;

	/**
	 * @return the soLuongNhanVatChoDuyet
	 */
	public static int getSoLuongNhanVatChoDuyet() {
		return soLuongNhanVatChoDuyet;
	}

	/**
	 * @param soLuongNhanVatChoDuyet the soLuongNhanVatChoDuyet to set
	 */
	public static void setSoLuongNhanVatChoDuyet(int soLuongNhanVatChoDuyet) {
		NhanVatDongGopDAO.soLuongNhanVatChoDuyet = soLuongNhanVatChoDuyet;
	}
	
	public ArrayList<NhanVatDongGop> getListNhanVatDongGop() {
		connection = da.getConnect();
		String sql = "SELECT bdnv.MABDNV, bdnv.MANHANVAT, bdnv.USERNAME, a.TEN, CONVERT(nvarchar,bdnv.NGAYDANG,103) AS NGAYDANG, bdnv.NGUON, bdnv.PHEDUYET "+
		" FROM BAIDANGNHANVAT bdnv INNER JOIN ACCOUNT AS a ON a.USERNAME = bdnv.USERNAME";
		ResultSet rs = null;
		try {
			System.out.println(sql);
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		ArrayList<NhanVatDongGop> list = new ArrayList<NhanVatDongGop>();
		NhanVatDongGop nhanVatDongGop;
		try {
			while (rs.next()) {
				nhanVatDongGop = new NhanVatDongGop();
				nhanVatDongGop.setMaBDNV(rs.getInt("MABDNV"));
				nhanVatDongGop.setMaNhanVat(rs.getString("MANHANVAT"));
				nhanVatDongGop.setUserName(rs.getString("USERNAME"));
				nhanVatDongGop.setTen(rs.getString("TEN"));
				nhanVatDongGop.setNgayDang(rs.getString("NGAYDANG"));
				nhanVatDongGop.setNguon(rs.getString("NGUON"));
				nhanVatDongGop.setPheDuyet(rs.getInt("PHEDUYET"));
				list.add(nhanVatDongGop);
			}
			rs.close();
			String query = "select count(*) as soLuongNhanVatChoDuyet from BAIDANGNHANVAT where PHEDUYET = 0";
			System.out.println(query);
			rs = stmt.executeQuery(query);
			
			if (rs.next())
				this.soLuongNhanVatChoDuyet = rs.getInt("soLuongNhanVatChoDuyet");
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
			return list;
	}
	public NhanVatDongGop getThongTinNhanVatDongGop(int maBDNV) {
		// TODO Auto-generated method stub
		connection = da.getConnect();
		String sql=	String.format("SELECT bdnv.MABDNV, bdnv.MANHANVAT, bdnv.USERNAME, a.TEN, CONVERT(nvarchar,bdnv.NGAYDANG,103) AS NGAYDANG, bdnv.NGUON, bdnv.PHEDUYET "+
		" FROM BAIDANGNHANVAT bdnv INNER JOIN ACCOUNT a ON a.USERNAME = bdsk.USERNAME WHERE MABDNV = '%s'", maBDNV);
		ResultSet rs = null;
		try {
			System.out.println(sql);
			Statement stmt = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		NhanVatDongGop nhanVatDongGop = new NhanVatDongGop();
		try {
			while(rs.next()){
				nhanVatDongGop.setMaBDNV(rs.getInt("MABDNV"));
				nhanVatDongGop.setMaNhanVat(rs.getString("MANHANVAT"));
				nhanVatDongGop.setUserName(rs.getString("USERNAME"));
				nhanVatDongGop.setTen(rs.getString("TEN"));
				nhanVatDongGop.setNgayDang(rs.getString("NGAYDANG"));
				nhanVatDongGop.setNguon(rs.getString("NGUON"));
				nhanVatDongGop.setPheDuyet(rs.getInt("PHEDUYET"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nhanVatDongGop;
	}
}
