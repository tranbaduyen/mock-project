/**
 * 
 */
package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import model.bean.ThoiKi;
import model.bean.ThoiKi;

/**
 * @author HCD-Fresher161
 *
 */
public class ThoiKiDAO {
	DataAccess da = new DataAccess();
	Connection connection=null;
	Statement stmt=null;
	
	public ArrayList<ThoiKi> getListThoiKi() {
		connection = da.getConnect();
		String sql=	"SELECT * FROM THOIKI";
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ArrayList<ThoiKi> list = new ArrayList<ThoiKi>();
		ThoiKi thoiKi;
		try {
			while(rs.next()){
				thoiKi = new ThoiKi();
				thoiKi.setMaThoiKi(rs.getInt("MATHOIKI"));
				thoiKi.setTenThoiKi(rs.getString("TENTHOIKI"));
				thoiKi.setNoiDung(rs.getString("NOIDUNG"));
				list.add(thoiKi);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void themThoiKi(String tenThoiKi, String noiDung) {
		connection = da.getConnect();
		String sql=	String.format("INSERT INTO THOIKI(tenThoiKi,noiDung) "+
					" VALUES ( N'%s',N'%s' )", tenThoiKi, noiDung);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ThoiKi getThongTinThoiKi(int maThoiKi) {
		connection = da.getConnect();
		String sql=	String.format("SELECT maThoiKi,tenThoiKi, noiDung "+
					" FROM THOIKI WHERE maThoiKi = %s", maThoiKi);
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ThoiKi thoiKi = new ThoiKi();
		try {
			while(rs.next()){
				thoiKi.setMaThoiKi(maThoiKi);
				thoiKi.setTenThoiKi(rs.getString("TENTHOIKI"));
				thoiKi.setNoiDung(rs.getString("NOIDUNG"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return thoiKi;
	}

	public void suaThoiKi(int maThoiKi, String tenThoiKi, String noiDung) {
		connection = da.getConnect();
		String sql=	String.format("UPDATE ThoiKi "+
					" SET tenThoiKi = N'%s', Noidung = N'%s' " +
					" WHERE maThoiKi = %s", tenThoiKi, noiDung, maThoiKi);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void xoaThoiKi(int maThoiKi) {
		connection = da.getConnect();
		String sql=	String.format("DELETE FROM ThoiKi WHERE maThoiKi = %s", maThoiKi);
		System.out.println(sql);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
