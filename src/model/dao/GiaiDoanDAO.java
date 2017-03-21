/**
 * 
 */
package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.GiaiDoan;

/**
 * @author HCD-Fresher161
 * 
 */
public class GiaiDoanDAO {
	DataAccess da = new DataAccess();
	Connection connection = null;
	Statement stmt = null;

	public ArrayList<GiaiDoan> getListGiaiDoan() {
		connection = da.getConnect();
		String sql = "SELECT * FROM GIAIDOAN";
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ArrayList<GiaiDoan> list = new ArrayList<GiaiDoan>();
		GiaiDoan giaiDoan;
		try {
			while (rs.next()) {
				giaiDoan = new GiaiDoan();
				giaiDoan.setMaGiaiDoan(rs.getInt("MAGIAIDOAN"));
				giaiDoan.setTenGiaiDoan(rs.getString("TENGIAIDOAN"));
				list.add(giaiDoan);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}

	public ArrayList<GiaiDoan> getListGiaiDoan(int maThoiKi) {
		connection = da.getConnect();
		String sql = "Select GIAIDOAN.MAGIAIDOAN,GIAIDOAN.TENGIAIDOAN " +
				"from GIAIDOAN inner join THOIKI on GIAIDOAN.MATHOIKI = THOIKI.MATHOIKI " +
				"where GIAIDOAN.MATHOIKI = " + maThoiKi;
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ArrayList<GiaiDoan> list = new ArrayList<GiaiDoan>();
		GiaiDoan giaiDoan;
		try {
			while (rs.next()) {
				giaiDoan = new GiaiDoan();
				giaiDoan.setMaGiaiDoan(rs.getInt("MAGIAIDOAN"));
				giaiDoan.setTenGiaiDoan(rs.getString("TENGIAIDOAN"));
				list.add(giaiDoan);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}
}
