package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.BinhLuan;
import model.bean.SuKien;
import model.bean.SuKienDongGop;

public class BinhLuanDAO {
	DataAccess da = new DataAccess();
	Connection connection = null;
	Statement stmt = null;
	private static int soLuongBinhLuanChoDuyet = 0;
	private static int soLuongBinhLuanMoi = 0;

	
	/**
	 * @return the soLuongBinhLuanMoi
	 */
	public static int getSoLuongBinhLuanMoi() {
		return soLuongBinhLuanMoi;
	}

	/**
	 * @param soLuongBinhLuanMoi the soLuongBinhLuanMoi to set
	 */
	public  void setSoLuongBinhLuanMoi(int soLuongBinhLuanMoi) {
		this.soLuongBinhLuanMoi = soLuongBinhLuanMoi;
	}

	/**
	 * @return the soLuongBinhLuanChoDuyet
	 */
	public static int getSoLuongBinhLuanChoDuyet() {
		return soLuongBinhLuanChoDuyet;
	}

	/**
	 * @param soLuongBinhLuanChoDuyet the soLuongBinhLuanChoDuyet to set
	 */
	public void setSoLuongBinhLuanChoDuyet(int soLuongBinhLuanChoDuyet) {
		this.soLuongBinhLuanChoDuyet = soLuongBinhLuanChoDuyet;
	}

	public ArrayList<BinhLuan> getListBinhLuan() {
		connection = da.getConnect();
		String sql = "SELECT bl.MABINHLUAN,bl.TENBINHLUAN, " +
				"bl.USERNAME, a.TEN,a.HINHDAIDIEN , CONVERT(nvarchar,bl.NGAYBINHLUAN,103) AS NGAYBINHLUAN, " +
				"bl.NOIDUNG,bl.DIEMDANHGIA, bl.PHEDUYET " +
				"FROM   BINHLUAN bl " +
				"INNER JOIN ACCOUNT AS a ON a.USERNAME = bl.USERNAME " ;
		ResultSet rs = null;
		try {
			System.out.println(sql);
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ArrayList<BinhLuan> list = new ArrayList<BinhLuan>();
		BinhLuan binhLuan;
		try {
			while (rs.next()) {
				binhLuan = new BinhLuan();
				binhLuan.setMaBinhLuan(rs.getInt("MABINHLUAN"));
				binhLuan.setUserName(rs.getString("USERNAME"));
				binhLuan.setTen(rs.getString("TEN"));
				binhLuan.setHinhDaiDien(rs.getString("HINHDAIDIEN"));
				binhLuan.setTenBinhLuan(rs.getString("TENBINHLUAN"));
				binhLuan.setNgayBinhLuan(rs.getString("NGAYBINHLUAN"));
				binhLuan.setNoiDung(rs.getString("NOIDUNG"));
				binhLuan.setDiemDanhGia(rs.getInt("DIEMDANHGIA"));
				binhLuan.setPheDuyet(rs.getInt("PHEDUYET"));
				list.add(binhLuan);
			}
			rs.close();
			String query = "select count(*) as soLuongBinhLuanChoDuyet from BINHLUAN where PHEDUYET = 0";
			System.out.println(query);
			rs = stmt.executeQuery(query);

			if (rs.next())
				this.soLuongBinhLuanChoDuyet = rs.getInt("soLuongBinhLuanChoDuyet");
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
	public ArrayList<BinhLuan> getListBinhLuanMoi() {
		connection = da.getConnect();
		String sql = "SELECT top 5 a.HINHDAIDIEN, CONVERT(nvarchar,bl.NGAYBINHLUAN,103) AS NGAYBINHLUAN,bl.NOIDUNG " +
				"FROM   BINHLUAN bl " +
				"INNER JOIN ACCOUNT AS a ON a.USERNAME = bl.USERNAME " +
				"where DATEDIFF(day,bl.NGAYBINHLUAN,getdate()) <= 1";
		ResultSet rs = null;
		try {
			System.out.println(sql);
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ArrayList<BinhLuan> list = new ArrayList<BinhLuan>();
		BinhLuan binhLuan;
		try {
			while (rs.next()) {
				binhLuan = new BinhLuan();
				binhLuan.setHinhDaiDien(rs.getString("HINHDAIDIEN"));
				binhLuan.setNgayBinhLuan(rs.getString("NGAYBINHLUAN"));
				binhLuan.setNoiDung(rs.getString("NOIDUNG"));

				list.add(binhLuan);
			}
			rs.close();
			String query = "select count(*) as soLuongBinhLuanMoi from BINHLUAN where DATEDIFF(day,NGAYBINHLUAN,getdate()) <= 1 ";
			System.out.println(query);
			rs = stmt.executeQuery(query);

			if (rs.next())
				this.soLuongBinhLuanMoi = rs.getInt("soLuongBinhLuanMoi");
				System.out.println("slblDAO = "+this.soLuongBinhLuanMoi);
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
	public void duyetBinhLuan(int maBinhLuan, int pheDuyet) {
		// TODO Auto-generated method stub
		connection = da.getConnect();
		String sql=	String.format("UPDATE BINHLUAN "+
				" SET pheDuyet = %s " +
				" WHERE MABINHLUAN = %s", pheDuyet, maBinhLuan);
		System.out.println(sql);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public BinhLuan getThongTinBinhLuan(int maBinhLuan) {
		// TODO Auto-generated method stub
		connection = da.getConnect();
		String sql = String.format(
				"select bl.MABINHLUAN,bl.MASUKIEN,bl.MANHANVAT,bl.USERNAME,a.TEN,bl.TENBINHLUAN,CONVERT(nvarchar,bl.NGAYBINHLUAN,103) as NGAYBINHLUAN,bl.NOIDUNG,bl.DIEMDANHGIA, bl.PHEDUYET "
			+ " from BINHLUAN bl inner join ACCOUNT a on a.USERNAME = bl.USERNAME where bl.MABINHLUAN = %s",maBinhLuan);
		ResultSet rs = null;
		try {
			System.out.println(sql);
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		BinhLuan binhLuan = new BinhLuan();
		try {
			while (rs.next()) {
				binhLuan.setMaBinhLuan(rs.getInt("MABINHLUAN"));
				binhLuan.setMaSuKien(rs.getInt("MASUKIEN"));
				binhLuan.setMaNhanVat(rs.getInt("MANHANVAT"));
				binhLuan.setTenBinhLuan(rs.getString("TENBINHLUAN"));
				binhLuan.setUserName(rs.getString("USERNAME"));
				binhLuan.setTen(rs.getString("TEN"));
				binhLuan.setNgayBinhLuan(rs.getString("NGAYBINHLUAN"));
				binhLuan.setNoiDung(rs.getString("NOIDUNG"));
				binhLuan.setDiemDanhGia(rs.getInt("DIEMDANHGIA"));
				binhLuan.setPheDuyet(rs.getInt("PHEDUYET"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return binhLuan;
	}
	
	
	

	
	Statement st=null;
	Connection cnn=null;
	ResultSet rs=null;
	
	/**
	 * Lấy bình luận từ csdl theo id bài viết và kiểu bài viết
	 * @param id
	 * @param type
	 * @return arraylist
	 */
	public ArrayList<BinhLuan> getBinhLuan(int id, int type) {
		cnn=da.getConnect();
		String sql="";
		if(type==1)
			sql="Select top 10 MABINHLUAN, TEN, NOIDUNG, NGAYBINHLUAN, BINHLUAN.USERNAME, HINHDAIDIEN from BINHLUAN inner join ACCOUNT on BINHLUAN.USERNAME = ACCOUNT.USERNAME where MASUKIEN="+id+" and PHEDUYET="+1+" ORDER BY MABINHLUAN DESC;";
		else
			sql="Select top 10 MABINHLUAN, TEN, NOIDUNG, NGAYBINHLUAN, BINHLUAN.USERNAME, HINHDAIDIEN from BINHLUAN inner join ACCOUNT on BINHLUAN.USERNAME = ACCOUNT.USERNAME where MANHANVAT="+id+" and PHEDUYET="+1+" ORDER BY MABINHLUAN DESC;";

		ArrayList<BinhLuan> binhLuan =new ArrayList<BinhLuan>();
		try {
			st=cnn.createStatement();
			rs=st.executeQuery(sql);
			BinhLuan bl;
			while(rs.next()){
				bl=new BinhLuan();
				bl.setMaBinhLuan(rs.getInt("MABINHLUAN"));
				bl.setNoiDung(rs.getString("NOIDUNG"));
				bl.setNgayDang(rs.getString("NGAYBINHLUAN"));
				bl.setHinhDaiDien(rs.getString("HINHDAIDIEN"));
				bl.setUserName(rs.getString("TEN"));
				binhLuan.add(bl);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return binhLuan;
	}

	/**
	 * Thêm bình luận vào csdl
	 * @param id
	 * @param type
	 * @param userName
	 * @param ngayDang
	 * @param noiDung
	 * @param typeUser 
	 */
	public void addBinhLuan(int id, int type, String userName, String ngayDang,
			String noiDung, int typeUser) {

		cnn=da.getConnect();
		String sql="";
		if(type==1)
			if(typeUser==1)
				sql="insert into BINHLUAN(NOIDUNG, NGAYBINHLUAN, USERNAME, MASUKIEN, PHEDUYET) values (N'"+noiDung+"', '"+ngayDang+"', '"+userName+"', "+id+","+1+")";
			else
				sql="insert into BINHLUAN(NOIDUNG, NGAYBINHLUAN, USERNAME, MASUKIEN) values (N'"+noiDung+"', '"+ngayDang+"', '"+userName+"', "+id+")";
		else
			if(typeUser==1)
				sql="insert into BINHLUAN(NOIDUNG, NGAYBINHLUAN, USERNAME, MANHANVAT, PHEDUYET) values (N'"+noiDung+"', '"+ngayDang+"', '"+userName+"', "+id+","+1+")";
			else
				sql="insert into BINHLUAN(NOIDUNG, NGAYBINHLUAN, USERNAME, MANHANVAT) values (N'"+noiDung+"', '"+ngayDang+"', '"+userName+"', "+id+")";
		try {
			st=cnn.createStatement();
			st.executeUpdate(sql);	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	/**
	 * Đếm số bình luận theo id và kiểu bài viết
	 * @param id
	 * @param type
	 * @return
	 */
	public int countBinhLuan(int id, int type) {
		cnn=da.getConnect();
		String sql="";
		int soLuong=0;
		if(type==1)
			sql="Select count(*) as soluong from BINHLUAN where MASUKIEN="+id+" and PHEDUYET="+1+"";
		else
			sql="Select count(*) as soluong from BINHLUAN where MANHANVAT="+id+" and PHEDUYET="+1+"";
		try {
			st=cnn.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()){
				soLuong=rs.getInt("soluong");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return soLuong;
	}

	/**
	 * Lấy bình luận bằng ajax khi click vào xem thêm
	 * @param id
	 * @param type
	 * @param numComment
	 * @return
	 */
	public String getBinhLuanAjax(int id, int type, int numComment) {
		cnn=da.getConnect();
		String sql="";
		String kq="";
		if(type==1)
			sql="Select top "+numComment+" MABINHLUAN, TEN, NOIDUNG, NGAYBINHLUAN, BINHLUAN.USERNAME, HINHDAIDIEN from BINHLUAN inner join ACCOUNT on BINHLUAN.USERNAME = ACCOUNT.USERNAME where MASUKIEN="+id+" and PHEDUYET="+1+" ORDER BY MABINHLUAN DESC;";
		else
			sql="Select top "+numComment+" MABINHLUAN, TEN, NOIDUNG, NGAYBINHLUAN, BINHLUAN.USERNAME, HINHDAIDIEN from BINHLUAN inner join ACCOUNT on BINHLUAN.USERNAME = ACCOUNT.USERNAME where MANHANVAT="+id+" and PHEDUYET="+1+" ORDER BY MABINHLUAN DESC;";

	
		try {
			st=cnn.createStatement();
			rs=st.executeQuery(sql);

			while(rs.next()){
				kq+="<li>" +
				"<img src=\""+rs.getString("HINHDAIDIEN")+"\" class=\"cmt-img\">" +
				"<span class=\"cmt-time\">"+rs.getString("NGAYBINHLUAN")+"</span>" +
				"<div class=\"cmt-name\" title=\""+rs.getString("TEN")+"\">"+rs.getString("TEN")+"</div>" +
				"<div class=\"cmt-content\">"+rs.getString("NOIDUNG")+"</div>" +
				"</li>";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return kq;
	}
	
	public static void main(String[] args) {
		BinhLuanDAO binhLuanDAO=new BinhLuanDAO();
		binhLuanDAO.getBinhLuanAjax(8, 2,15);
	}

	public int checkTypeUser(String userName) {
		cnn=da.getConnect();
		String sql="select PHANQUYEN from ACCOUNT where userName='"+userName+"'";
		int type=0;
		try {
			st=cnn.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()){
				 type=rs.getInt("PHANQUYEN");
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return type;
		
	}
	
	
	
	
	
	
	
	
	
	
}
