package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DangKyDAO {

	DataAccess da=new DataAccess();
	Statement st=null;
	Connection cnn=null;
	ResultSet rs=null;
	
	/**
	 * Kiểm tra username khi đăng ký đã tồn tại hay chưa
	 * @param userName
	 * @return
	 */
	public boolean checkUserName(String userName) {
		cnn=da.getConnect();
		String sql="select * from ACCOUNT where USERNAME='"+userName+"'";
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
	 * Thêm user vào csdl khi thông tin chính xác
	 * @param userName
	 * @param password
	 * @param hoVaTen
	 * @param email
	 * @param diaChi
	 */
	public void insertUser(String userName, String password, String hoVaTen,
			String email, String diaChi) {
		cnn=da.getConnect();
		String hinhMacDinh="image/default.jpg";
		String sql="insert into ACCOUNT values('"+userName+"', '"+password+"', N'"+hoVaTen+"', '"+email+"', N'"+diaChi+"',"+0+", '"+hinhMacDinh+"')";
		try {
			st=cnn.createStatement();
			st.executeUpdate(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
