package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DangNhapDAO {

	DataAccess da=new DataAccess();
	Statement st=null;
	Connection cnn=null;
	ResultSet rs=null;
	
	/**
	 * Kiểm tra đăng nhập
	 * @param userName
	 * @param password
	 * @return
	 */
	public boolean checkLogin(String userName, String password) {
		cnn=da.getConnect();
		String sql="select * from ACCOUNT where USERNAME='"+userName+"' and pass='"+password+"'";
		try {
			st=cnn.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Kiểm tra phân quyền
	 * @param userName
	 * @param password
	 */
	public boolean checkLevel(String userName, String password) {
		cnn=da.getConnect();
		String sql="select * from ACCOUNT where USERNAME='"+userName+"' and pass='"+password+"' and PHANQUYEN=1";
		try {
			st=cnn.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	public static void main(String[] args) {
		DangNhapDAO dn=new DangNhapDAO();
		System.out.println( dn.checkLevel("chau", "123"));
	}

}
