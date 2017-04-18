package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DanhGiaDAO {

	DataAccess da=new DataAccess();
	Statement st=null;
	Connection cnn=null;
	ResultSet rs=null;
	public void updateDanhGia(int id, int type, String userName, int diem) {
		cnn=da.getConnect();
		String sql="";
		if(type==1)
			sql="update DANHGIA set DIEMDANHGIA="+diem+" where USERNAME='"+userName+"' and MASUKIEN="+id+"";
		else
			sql="update DANHGIA set DIEMDANHGIA="+diem+" where USERNAME='"+userName+"' and MANHANVAT="+id+"";
		try {
			st=cnn.createStatement();
			st.executeUpdate(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void insertDanhGia(int id, int type, String userName, int diem){
		cnn=da.getConnect();
		String sql="";
		if(type==1)
			sql="Insert into DANHGIA(USERNAME,MASUKIEN,DIEMDANHGIA) values('"+userName+"',"+id+","+diem+")";
		else
			sql="Insert into DANHGIA(USERNAME,MANHANVAT,DIEMDANHGIA) values('"+userName+"',"+id+","+diem+")";
		try {
			st=cnn.createStatement();
			st.executeUpdate(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public boolean checkDanhGia(int id, int type, String userName){
		
		cnn=da.getConnect();
		String sql="";
		if(type==1)
			sql="Select * from DANHGIA where USERNAME='"+userName+"' and MASUKIEN="+id+"";
		else
			sql="Select * from DANHGIA where USERNAME='"+userName+"' and MANHANVAT="+id+"";
		try {
			st=cnn.createStatement();
			rs= st.executeQuery(sql);
			while(rs.next()){
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public String getDiemTB(int id, int type) {
		
		cnn=da.getConnect();
		String sql="";
		String kq="0";
		if(type==1)
			sql="select avg(DIEMDANHGIA) as diem from DANHGIA where MASUKIEN="+id+"";
		else
			sql="select avg(DIEMDANHGIA) as diem from DANHGIA where MANHANVAT="+id+"";
		try {
			st=cnn.createStatement();
			rs= st.executeQuery(sql);
			while(rs.next()){
				kq= Integer.toString(rs.getInt("diem"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}
	public String getDiem(int id, int type, String userName) {
		cnn=da.getConnect();
		String sql="";
		String kq="0";
		if(type==1)
			sql="select avg(DIEMDANHGIA) as diem from DANHGIA where MASUKIEN="+id+" and USERNAME='"+userName+"'";
		else
			sql="select avg(DIEMDANHGIA) as diem from DANHGIA where MANHANVAT="+id+" and USERNAME='"+userName+"'";
		try {
			st=cnn.createStatement();
			rs= st.executeQuery(sql);
			while(rs.next()){
				kq= Integer.toString(rs.getInt("diem"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}

}
