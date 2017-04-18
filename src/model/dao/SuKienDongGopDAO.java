package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import model.bean.SuKien;
import model.bean.SuKienDongGop;

public class SuKienDongGopDAO {
	DataAccess da = new DataAccess();
	Connection connection = null;
	Statement stmt = null;
	private static int soLuongSuKienChoDuyet = 0;
	private static int soLuongSuKienMoi = 0;
	
	
	/**
	 * @return the soLuongSuKienMoi
	 */
	public static int getSoLuongSuKienMoi() {
		return soLuongSuKienMoi;
	}

	/**
	 * @param soLuongSuKienMoi the soLuongSuKienMoi to set
	 */
	public void setSoLuongSuKienMoi(int soLuongSuKienMoi) {
		this.soLuongSuKienMoi = soLuongSuKienMoi;
	}

	/**
	 * @return the soLuongSuKienChoDuyet
	 */
	public static int getSoLuongSuKienChoDuyet() {
		return soLuongSuKienChoDuyet;
	}

	/**
	 * @param soLuongSuKienChoDuyet
	 *            the soLuongSuKienChoDuyet to set
	 */
	public void setSoLuongSuKienChoDuyet(int soLuongSuKienChoDuyet) {
		this.soLuongSuKienChoDuyet = soLuongSuKienChoDuyet;
	}

	public ArrayList<SuKienDongGop> getListSuKienDongGop() {
		connection = da.getConnect();
		String sql = "SELECT bdsk.MABDSK, bdsk.MASUKIEN, bdsk.USERNAME, a.TEN, CONVERT(nvarchar,bdsk.NGAYDANG,103) AS NGAYDANG, bdsk.NGUON, bdsk.PHEDUYET "
				+ " FROM   BAIDANGSUKIEN bdsk INNER JOIN ACCOUNT AS a ON a.USERNAME = bdsk.USERNAME";
		ResultSet rs = null;
		try {
			System.out.println(sql);
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ArrayList<SuKienDongGop> list = new ArrayList<SuKienDongGop>();
		SuKienDongGop suKienDongGop;
		try {
			while (rs.next()) {
				suKienDongGop = new SuKienDongGop();
				suKienDongGop.setMaBDSK(rs.getInt("MABDSK"));
				suKienDongGop.setMaSuKien(rs.getString("MASUKIEN"));
				suKienDongGop.setUserName(rs.getString("USERNAME"));
				suKienDongGop.setTen(rs.getString("TEN"));
				suKienDongGop.setNgayDang(rs.getString("NGAYDANG"));
				suKienDongGop.setNguon(rs.getString("NGUON"));
				suKienDongGop.setPheDuyet(rs.getInt("PHEDUYET"));
				list.add(suKienDongGop);
			}
			rs.close();
			String query = "select count(*) as soLuongSuKienChoDuyet from BAIDANGSUKIEN where PHEDUYET = 0";
			System.out.println(query);
			rs = stmt.executeQuery(query);

			if (rs.next())
				this.soLuongSuKienChoDuyet = rs.getInt("soLuongSuKienChoDuyet");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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
	public ArrayList<SuKienDongGop> getListSuKienMoi() {
		connection = da.getConnect();
		String sql = "SELECT top 5 a.HINHDAIDIEN, CONVERT(nvarchar,bdsk.NGAYDANG,103) AS NGAYDANG "
				+ " FROM   BAIDANGSUKIEN bdsk INNER JOIN ACCOUNT AS a ON a.USERNAME = bdsk.USERNAME"
				+ " where DATEDIFF(day,NGAYDANG,getdate()) <= 3 ";
		ResultSet rs = null;
		try {
			System.out.println(sql);
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ArrayList<SuKienDongGop> list = new ArrayList<SuKienDongGop>();
		SuKienDongGop suKienDongGop;
		try {
			while (rs.next()) {
				suKienDongGop = new SuKienDongGop();
				suKienDongGop.setHinhDaiDien(rs.getString("HINHDAIDIEN"));
				suKienDongGop.setNgayDang(rs.getString("NGAYDANG"));
				list.add(suKienDongGop);
			}
			rs.close();
			String query = "select count(*) as soLuongSuKienMoi from BAIDANGSUKIEN where DATEDIFF(day,NGAYDANG,getdate()) <= 3";
			System.out.println(query);
			rs = stmt.executeQuery(query);

			if (rs.next())
				this.soLuongSuKienMoi = rs.getInt("soLuongSuKienMoi");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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
	public SuKienDongGop getThongTinSuKienDongGop(int maBDSK) {
		// TODO Auto-generated method stub
		connection = da.getConnect();
		String sql = String.format(
				"SELECT bdsk.MABDSK, bdsk.MASUKIEN, bdsk.USERNAME, a.TEN, CONVERT(nvarchar,bdsk.NGAYDANG,103) AS NGAYDANG, bdsk.NGUON, bdsk.PHEDUYET "
						+ " FROM   BAIDANGSUKIEN bdsk INNER JOIN ACCOUNT a ON a.USERNAME = bdsk.USERNAME WHERE MABDSK = %s",
				maBDSK);
		ResultSet rs = null;
		try {
			System.out.println(sql);
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		SuKienDongGop suKienDongGop = new SuKienDongGop();
		try {
			while (rs.next()) {
				suKienDongGop.setMaBDSK(rs.getInt("MABDSK"));
				suKienDongGop.setMaSuKien(rs.getString("MASUKIEN"));
				suKienDongGop.setUserName(rs.getString("USERNAME"));
				suKienDongGop.setTen(rs.getString("TEN"));
				suKienDongGop.setNgayDang(rs.getString("NGAYDANG"));
				suKienDongGop.setNguon(rs.getString("NGUON"));
				suKienDongGop.setPheDuyet(rs.getInt("PHEDUYET"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return suKienDongGop;
	}

	public SuKien getThongTinSuKien(int maBDSK) {
		// TODO Auto-generated method stub
		connection = da.getConnect();
		String sql = String.format(
				"select tk.MATHOIKI,gd.MAGIAIDOAN,sk.MASUKIEN,sk.TENSUKIEN,CONVERT(nvarchar,Year(sk.NGAYBATDAU),101) as NGAYBATDAU,CONVERT(nvarchar,Year(sk.NGAYKETTHUC),101) as NGAYKETTHUC,sk.MAGIAIDOAN,sk.MAPHANLOAI,sk.HINHANH,sk.NOIDUNG,bdsk.NGUON, bdsk.PHEDUYET "
						+ "FROM   BAIDANGSUKIEN bdsk "
						+ "inner join SUKIEN sk on bdsk.MASUKIEN = sk.MASUKIEN "
						+ "inner join PHANLOAISUKIEN plsk on plsk.MAPHANLOAI = sk.MAPHANLOAI "
						+ "inner join GIAIDOAN gd on gd.MAGIAIDOAN = sk.MAGIAIDOAN "
						+ "inner join THOIKI tk on tk.MATHOIKI = gd.MATHOIKI " + "WHERE MABDSK = %s", maBDSK);
		ResultSet rs = null;
		try {
			System.out.println(sql);
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		SuKien suKien = new SuKien();
		try {
			while (rs.next()) {
				suKien.setMaThoiKi(rs.getInt("MATHOIKI"));
				suKien.setMaGiaiDoan(rs.getInt("MAGIAIDOAN"));
				suKien.setMaSuKien(rs.getInt("MASUKIEN"));
				suKien.setTenSuKien(rs.getString("TENSUKIEN"));
				suKien.setMaPhanLoai(rs.getInt("MAPHANLOAI"));
				suKien.setMaGiaiDoan(rs.getInt("MAGIAIDOAN"));
				suKien.setNgayBatDau(rs.getString("NGAYBATDAU"));
				suKien.setNgayKetThuc(rs.getString("NGAYKETTHUC"));
				suKien.setNoiDung(rs.getString("NOIDUNG"));
				suKien.setNguon(rs.getString("NGUON"));
				suKien.setPheDuyet(rs.getInt("PHEDUYET"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return suKien;
	}
	public void duyetSuKienDongGop(int maBDSK, int pheDuyet) {
		// TODO Auto-generated method stub
		connection = da.getConnect();
		String sql=	String.format("UPDATE BAIDANGSUKIEN "+
				" SET pheDuyet = %s " +
				" WHERE MABDSK = %s", pheDuyet, maBDSK);
		System.out.println(sql);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void duyetSuKienDongGop(int maBDSK, int maSuKien, String tenSuKien, String ngayBatDau, String ngayKetThuc,
			String hinhAnh, String nguon, String noiDung, int maThoiKi, int maGiaiDoan, int maPhanLoai, int pheDuyet) {
		// TODO Auto-generated method stub
		connection = da.getConnect();
		String sql=	String.format("UPDATE SUKIEN "+
				" SET TENSUKIEN = N'%s', ngayBatDau = N'%s', ngayKetThuc = N'%s', hinhAnh = N'%s', nguon = N'%s', noiDung = N'%s', maThoiKi = %s, maGiaiDoan = %s, maPhanLoai = %s, pheDuyet = %s " +
				" WHERE MASUKIEN = %s", maBDSK, tenSuKien, ngayBatDau, ngayKetThuc, hinhAnh, nguon,noiDung,maThoiKi,maGiaiDoan,maPhanLoai,pheDuyet);
		System.out.println(sql);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
