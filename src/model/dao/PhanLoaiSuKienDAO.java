package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import model.bean.PhanLoaiSuKien;
import model.bean.ThoiKi;

public class PhanLoaiSuKienDAO {
	DataAccess da = new DataAccess();
	Connection connection=null;
	Statement stmt=null;
	
	public ArrayList<PhanLoaiSuKien> getListPhanLoaiSuKien() {
		connection = da.getConnect();
		String sql=	"SELECT * FROM PHANLOAISUKIEN";
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ArrayList<PhanLoaiSuKien> list = new ArrayList<PhanLoaiSuKien>();
		PhanLoaiSuKien phanLoaiSuKien;
		try {
			while(rs.next()){
				phanLoaiSuKien = new PhanLoaiSuKien();
				phanLoaiSuKien.setMaPhanLoai(rs.getInt("MAPHANLOAI"));
				phanLoaiSuKien.setTenPhanLoai(rs.getString("TENPHANLOAI"));
				list.add(phanLoaiSuKien);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
