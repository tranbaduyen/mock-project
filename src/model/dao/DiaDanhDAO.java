/**
 * 
 */
package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.BinhLuan;
import model.bean.DiaDanh;

/**
 * @author admin
 *
 */
public class DiaDanhDAO {
	DataAccess da = new DataAccess();
	Connection connection=null;
	Statement stmt=null;
	
	public ArrayList<DiaDanh> getListDiaDanh() {
		connection = da.getConnect();
		String sql = "SELECT * FROM DIADANH" ;
		ResultSet rs = null;
		try {
			System.out.println(sql);
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ArrayList<DiaDanh> list = new ArrayList<DiaDanh>();
		DiaDanh diaDanh;
		try {
			while (rs.next()) {
				diaDanh = new DiaDanh();
				diaDanh.setMaDiaDanh(rs.getInt("MADIADANH"));
				diaDanh.setTenDiaDanh(rs.getString("TENDIADANH"));
				diaDanh.setHinhAnh(rs.getString("HINHANH"));
				diaDanh.setNoiDung(rs.getString("NOIDUNG"));
				diaDanh.setViDo(rs.getFloat("VIDO"));
				diaDanh.setKinhDo(rs.getFloat("KINHDO"));
				list.add(diaDanh);
			}
			rs.close();
			
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
	
	public DiaDanh getThongTinDiaDanh(int maDiaDanh) {
		// TODO Auto-generated method stub
		connection = da.getConnect();
		String sql = String.format(
				"select dd.MADIADANH, dd.TENDIADANH, dd.NOIDUNG, dd.HINHANH, dd.VIDO, dd.KINHDO "
			+ " from DIADANH dd where dd.MADIADANH = %s",maDiaDanh);
		ResultSet rs = null;
		try {
			System.out.println(sql);
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		DiaDanh diaDanh = new DiaDanh();
		try {
			while (rs.next()) {
				diaDanh.setMaDiaDanh(rs.getInt("MANOIDUNG"));
				diaDanh.setTenDiaDanh(rs.getString("TENDIADANH"));
				diaDanh.setHinhAnh(rs.getString("HINHANH"));
				diaDanh.setNoiDung(rs.getString("NOIDUNG"));
				diaDanh.setViDo(rs.getFloat("VIDO"));
				diaDanh.setKinhDo(rs.getFloat("KINHDO"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return diaDanh;
	}
}
