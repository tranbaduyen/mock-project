package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.SuKienDongGop;

public class SuKienDongGopDAO {
	DataAccess da = new DataAccess();
	Connection connection=null;
	Statement stmt=null;
	private static int soLuongSuKienChoDuyet = 0;
	
	
	/**
	 * @return the soLuongSuKienChoDuyet
	 */
	public static int getSoLuongSuKienChoDuyet() {
		return soLuongSuKienChoDuyet;
	}

	/**
	 * @param soLuongSuKienChoDuyet the soLuongSuKienChoDuyet to set
	 */
	public void setSoLuongSuKienChoDuyet(int soLuongSuKienChoDuyet) {
		this.soLuongSuKienChoDuyet = soLuongSuKienChoDuyet;
	}
	

	public ArrayList<SuKienDongGop> getListSuKienDongGop() {
		connection = da.getConnect();
		String sql = "SELECT bdsk.MABDSK, bdsk.MASUKIEN, bdsk.USERNAME, a.TEN, CONVERT(nvarchar,bdsk.NGAYDANG,103) AS NGAYDANG, bdsk.NGUON, bdsk.PHEDUYET "+
		" FROM   BAIDANGSUKIEN bdsk INNER JOIN ACCOUNT AS a ON a.USERNAME = bdsk.USERNAME";
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

	public SuKienDongGop getThongTinSuKienDongGop(int maBDSK) {
		// TODO Auto-generated method stub
		connection = da.getConnect();
		String sql=	String.format("SELECT bdsk.MABDSK, bdsk.MASUKIEN, bdsk.USERNAME, a.TEN, CONVERT(nvarchar,bdsk.NGAYDANG,103) AS NGAYDANG, bdsk.NGUON, bdsk.PHEDUYET "+
		" FROM   BAIDANGSUKIEN bdsk INNER JOIN ACCOUNT a ON a.USERNAME = bdsk.USERNAME WHERE MABDSK = '%s'", maBDSK);
		ResultSet rs = null;
		try {
			System.out.println(sql);
			Statement stmt = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		SuKienDongGop suKienDongGop = new SuKienDongGop();
		try {
			while(rs.next()){
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
}
