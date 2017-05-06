/**
 * 
 */
package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import model.bean.NhanVat;
import model.bean.NhanVatDongGop;

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
		String sql = "SELECT bdnv.MABDNV, bdnv.MANHANVAT, bdnv.USERNAME, a.TEN,a.EMAIL, CONVERT(nvarchar,bdnv.NGAYDANG,103) AS NGAYDANG, bdnv.NGUON, bdnv.PHEDUYET "+
		" FROM BAIDANGNHANVAT bdnv INNER JOIN ACCOUNT AS a ON a.USERNAME = bdnv.USERNAME " +
		" WHERE a.PHANQUYEN = 0 ";
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
				nhanVatDongGop.setEmail(rs.getString("EMAIL"));
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
	public NhanVat getThongTinNhanVat(int maBDNV) {
		// TODO Auto-generated method stub
		connection = da.getConnect();
		String sql = String.format(
				"select tk.MATHOIKI,gd.MAGIAIDOAN,sk.MASUKIEN,a.EMAIL,nv.MANHANVAT,nv.TENNHANVAT, " +
				"CONVERT(nvarchar,nv.NAMSINH,101) as NAMSINH, CONVERT(nvarchar,nv.NAMMAT,101) as NAMMAT, " +
				"CONVERT(nvarchar,gdnv.TUNGAY,101) as TUNGAYGDNV,CONVERT(nvarchar,gdnv.DENNGAY,101) as DENNGAYGDNV, " +
				"CONVERT(nvarchar,sknv.TUNGAY,101) as TUNGAYSKNV,CONVERT(nvarchar,sknv.DENNGAY,101) as DENNGAYSKNV, " +
				"bdnv.MABDNV,gdnv.MAGDNV,sknv.MASKNV,nv.HINHANH,nv.NOIDUNG,bdnv.NGUON, bdnv.PHEDUYET " +
				"FROM   BAIDANGNHANVAT bdnv " +
				"inner join ACCOUNT a on bdnv.USERNAME = a.USERNAME " +
				"inner join NHANVAT nv on bdnv.MANHANVAT = nv.MANHANVAT " +
				"inner join SUKIENNHANVAT sknv on sknv.MANHANVAT = nv.MANHANVAT " +
				"inner join SUKIEN sk on sk.MASUKIEN = sknv.MASUKIEN " +
				"inner join GIAIDOANNHANVAT gdnv on gdnv.MANHANVAT = nv.MANHANVAT " +
				"inner join GIAIDOAN gd on gdnv.MAGIAIDOAN = gd.MAGIAIDOAN " +
				"inner join THOIKI tk on tk.MATHOIKI = gd.MATHOIKI " +
				"WHERE bdnv.MABDNV = %s ", maBDNV);
		ResultSet rs = null;
		try {
			System.out.println(sql);
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		NhanVat nhanVat = new NhanVat();
		try {
			while (rs.next()) {
				nhanVat.setMaSKNV(rs.getInt("MASKNV"));
				nhanVat.setMaGDNV(rs.getInt("MAGDNV"));
				nhanVat.setMaBDNV(rs.getInt("MABDNV"));
				nhanVat.setMaThoiKi(rs.getInt("MATHOIKI"));
				nhanVat.setMaGiaiDoan(rs.getInt("MAGIAIDOAN"));
				nhanVat.setMaSuKien(rs.getInt("MASUKIEN"));
				nhanVat.setMaNhanVat(rs.getInt("MANHANVAT"));
				nhanVat.setTenNhanVat(rs.getString("TENNHANVAT"));
				nhanVat.setMaGiaiDoan(rs.getInt("MAGIAIDOAN"));
				if(rs.getString("NAMSINH")!=null)
					nhanVat.setNamSinh(rs.getString("NAMSINH"));
				else
					nhanVat.setNamSinh("N/A");
				if(rs.getString("NAMMAT")!=null)
					nhanVat.setNamMat(rs.getString("NAMMAT"));
				else
					nhanVat.setNamMat("N/A");
				nhanVat.setTuNgaySKNV(rs.getString("TUNGAYSKNV"));
				nhanVat.setDenNgaySKNV(rs.getString("DENNGAYSKNV"));
				nhanVat.setTuNgayGDNV(rs.getString("TUNGAYGDNV"));
				nhanVat.setDenNgayGDNV(rs.getString("DENNGAYGDNV"));
				nhanVat.setNoiDung(rs.getString("NOIDUNG"));
				nhanVat.setEmail(rs.getString("EMAIL"));
				nhanVat.setHinhAnh(rs.getString("HINHANH"));
				nhanVat.setNguon(rs.getString("NGUON"));
				nhanVat.setPheDuyet(rs.getInt("PHEDUYET"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nhanVat;
	}

	public void duyetNhanVatDongGop(int maBDNV, int pheDuyet) {
		// TODO Auto-generated method stub
		connection = da.getConnect();
		String sql=	String.format("UPDATE BAIDANGNHANVAT "+
				" SET pheDuyet = %s " +
				" WHERE MABDNV = %s", pheDuyet, maBDNV);
		System.out.println(sql);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
