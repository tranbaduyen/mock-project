package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.ThoiKy;

public class ThoiKyDAO {

	DataAccess da=new DataAccess();
	Statement st=null;
	Connection cnn=null;
	ResultSet rs=null;
	
	
	/**
	 * Lấy dannh sách thời kỳ hiển thị ra trang chủ
	 * @return
	 */
	public ArrayList<ThoiKy> getListThoiKy() {
		cnn=da.getConnect();
		String sql="select * from THOIKI";
		ArrayList<ThoiKy> list =new ArrayList<ThoiKy>();
		try {
			st=cnn.createStatement();
			rs=st.executeQuery(sql);
			ThoiKy tk;
			while(rs.next()){
				tk=new ThoiKy();
				tk.setMaThoiKy(rs.getInt("MATHOIKI"));
				tk.setTenThoiKy(rs.getString("TENTHOIKI"));
				tk.setNoiDung(rs.getString("NOIDUNG"));
				tk.setHinhAnh(rs.getString("HINHANH"));
				tk.setThoiGian(rs.getString("THOIGIAN"));
				list.add(tk);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}


}
