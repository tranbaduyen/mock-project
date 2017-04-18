/**
 * 
 */
package model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import common.ProcessString;

import model.bean.NhanVat;
import model.bean.NhanVatSuKien;
import model.bean.SuKien;

/**
 * @author HCD-Fresher161
 *
 */
public class NhanVatDAO {
	DataAccess da = new DataAccess();
	Connection connection = null;
	Statement stmt = null;
	
	private int tongSoLuotXemNhanVatTrongNgay = 0;
	private int tongSoLuotXemNhanVatTrongTuan = 0;
	private int tongSoLuotXemNhanVatTrongThang = 0;
	private int tongSoLuotXemNhanVatTrongNam = 0;
	private int tongSoLuotXemNhanVat = 0;

	public ArrayList<NhanVat> getListNhanVat() {
		connection = da.getConnect();
		String sql = "SELECT * FROM NHANVAT";
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ArrayList<NhanVat> list = new ArrayList<NhanVat>();
		NhanVat nhanVat;
		try {
			while (rs.next()) {
				nhanVat = new NhanVat();
				nhanVat.setTenSuKien(rs.getString("TENNHANVAT"));
				nhanVat.setMaSuKien(rs.getInt("MANHANVAT"));
				nhanVat.setNoiDung(rs.getString("NOIDUNG"));
				list.add(nhanVat);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}

	
	
	/////////////////////////////////////////////////////////////////////////
	
	
	
	Statement st=null;
	Connection cnn=null;
	ResultSet rs=null;

	/**
	 * Lấy top nhân vật dựa theo lượt xem
	 * @return
	 */
	public ArrayList<NhanVat> getTopNhanVat() {
		cnn=da.getConnect();
		String sql="select top 5 * from NHANVAT order by MANHANVAT DESC";
		ArrayList<NhanVat> list= new ArrayList<NhanVat>();
		try {
			st=cnn.createStatement();
			rs=st.executeQuery(sql);
			NhanVat nv;
			while(rs.next()){
				nv=new NhanVat();
				nv.setMaNhanVat(rs.getInt("MANHANVAT"));
				nv.setTenNhanVat(rs.getString("TENNHANVAT"));
				list.add(nv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<NhanVat> getNhanVatMoi() {
		cnn=da.getConnect();
		String sql="select top 5 * from NHANVAT order by MANHANVAT DESC";
		ArrayList<NhanVat> list= new ArrayList<NhanVat>();
		try {
			st=cnn.createStatement();
			rs=st.executeQuery(sql);
			NhanVat nv;
			while(rs.next()){
				nv=new NhanVat();
				nv.setMaNhanVat(rs.getInt("MANHANVAT"));
				nv.setTenNhanVat(rs.getString("TENNHANVAT"));
				nv.setHinhAnh(rs.getString("HINHANH"));
				String noiDung= rs.getString("NOIDUNG");
				if(noiDung.length()>200)
					nv.setNoiDung(rs.getString("NOIDUNG").substring(0, 200));
				else
					nv.setNoiDung(rs.getString("NOIDUNG"));
				list.add(nv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<NhanVatSuKien> getListNhanVat(int id) {
		cnn=da.getConnect();
		String sql="select TOP 7 nv.MANHANVAT, nv.TENNHANVAT, NOIDUNG, HINHANH, year(TUNGAY) as TUNGAY, year(DENNGAY) as DENNGAY from GIAIDOANNHANVAT gdnv inner join NHANVAT nv on gdnv.MANHANVAT=nv.MANHANVAT where MAGIAIDOAN="+id+" order by TUNGAY ASC";
		ArrayList<NhanVatSuKien> list= new ArrayList<NhanVatSuKien>();
		try {
			st=cnn.createStatement();
			rs=st.executeQuery(sql);
			NhanVatSuKien nvsk;
			while(rs.next()){
				nvsk=new NhanVatSuKien();
				nvsk.setMaNVSK(rs.getInt("MANHANVAT"));
				nvsk.setTenNVSK(rs.getString("TENNHANVAT"));
				nvsk.setHinhAnh(rs.getString("HINHANH"));
				nvsk.setNgayDau(Integer.toString(rs.getInt("TUNGAY")));
				nvsk.setNgayCuoi(Integer.toString(rs.getInt("DENNGAY")));
				String noiDung= rs.getString("NOIDUNG");

				String [] noiDungChia=noiDung.split(" ");
				if(noiDungChia.length>50)
					nvsk.setNoiDung(ProcessString.catChuoi(noiDungChia, 0, 50));
				else
					nvsk.setNoiDung(rs.getString("NOIDUNG"));
				list.add(nvsk);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public int checkListNV(int id) {

		cnn=da.getConnect();
		String sql="select count(*) as num from GIAIDOANNHANVAT where MAGIAIDOAN="+id+"";
		int num =0;
		try {
			st=cnn.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()){
				num=rs.getInt("num");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}


	public static void main(String[] args) {
		NhanVatDAO nv=new NhanVatDAO();
		System.out.println(nv.checkListNV(7));
	}

	public String showListNV(int id, int num) {
		cnn=da.getConnect();
		String sql="select TOP "+num+" nv.MANHANVAT, nv.TENNHANVAT, NOIDUNG, HINHANH, year(TUNGAY) as TUNGAY, year(DENNGAY) as DENNGAY from GIAIDOANNHANVAT gdnv inner join NHANVAT nv on gdnv.MANHANVAT=nv.MANHANVAT where MAGIAIDOAN="+id+" order by TUNGAY ASC";
		String kq="";
		try {
			st=cnn.createStatement();
			rs=st.executeQuery(sql);

			while(rs.next()){

				String noiDung= rs.getString("NOIDUNG");
				String [] noiDungChia=noiDung.split(" ");
				String nd="";
				if(noiDungChia.length>50)
					nd=ProcessString.catChuoi(noiDungChia, 0, 50);
				else
					nd=rs.getString("NOIDUNG");
				kq+="<div class=\"nv-timeline-block\">"+
				"<div class=\"nv-timeline-img nv-picture\">"+
				"<div class=\"img-border\"></div>"+
				"<a title=\""+rs.getString("TENNHANVAT")+"\" href=\"chi-tet-nhan-vat-su-kien.html?id="+rs.getInt("MANHANVAT")+"\">"+
				"<img class=\"nv-season_img\" src=\""+rs.getString("HINHANH")+"\"></a></div>"+
				"<div class=\"nv-timeline-content\">"+
				"<div class=\"date\">"+Integer.toString(rs.getInt("TUNGAY"))+" - "+Integer.toString(rs.getInt("DENNGAY"))+"</div>"+
				"<div style=\"clear: both;\"></div>"+
				"<p class=\"nv-detail\">"+nd+""+
				"</p>"+
				"<h2 class=\"nv-title\">" +
				"<a title=\""+rs.getString("TENNHANVAT")+"\" href=\"chi-tet-nhan-vat-su-kien.html?id="+rs.getInt("MANHANVAT")+"\">"+rs.getString("TENNHANVAT")+"</a></h2>"+
				"</div></div>";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}

	public int getTongSoLuotXemNhanVatTrongNgay() {
		connection = da.getConnect();
		String sql="select sum(NGAYHIENTAI) as tongSoLuotXemNhanVatTrongNgay from DEMLUOTXEM where MANHANVAT IS NOT NULL";
		int num =0;
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				tongSoLuotXemNhanVatTrongNgay = rs.getInt("tongSoLuotXemNhanVatTrongNgay");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return tongSoLuotXemNhanVatTrongNgay;
	}

	public void setTongSoLuotXemNhanVatTrongNgay(int tongSoLuotXemNhanVatTrongNgay) {
		this.tongSoLuotXemNhanVatTrongNgay = tongSoLuotXemNhanVatTrongNgay;
	}

	public int getTongSoLuotXemNhanVatTrongTuan() {
		connection = da.getConnect();
		String sql="select sum(TUAN) as tongSoLuotXemNhanVatTrongTuan from DEMLUOTXEM where MANHANVAT IS NOT NULL";
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				tongSoLuotXemNhanVatTrongTuan = rs.getInt("tongSoLuotXemNhanVatTrongTuan");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return tongSoLuotXemNhanVatTrongTuan;
	}

	public void setTongSoLuotXemNhanVatTrongTuan(int tongSoLuotXemNhanVatTrongTuan) {
		this.tongSoLuotXemNhanVatTrongTuan = tongSoLuotXemNhanVatTrongTuan;
	}

	public int getTongSoLuotXemNhanVatTrongThang() {
		connection = da.getConnect();
		String sql="select sum(THANG) as tongSoLuotXemNhanVatTrongThang from DEMLUOTXEM where MANHANVAT IS NOT NULL";
		int num =0;
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				tongSoLuotXemNhanVatTrongThang = rs.getInt("tongSoLuotXemNhanVatTrongThang");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return tongSoLuotXemNhanVatTrongThang;
	}

	public void setTongSoLuotXemNhanVatTrongThang(int tongSoLuotXemNhanVatTrongThang) {
		this.tongSoLuotXemNhanVatTrongThang = tongSoLuotXemNhanVatTrongThang;
	}

	public int getTongSoLuotXemNhanVatTrongNam() {
		connection = da.getConnect();
		String sql="select sum(NAM) as tongSoLuotXemNhanVatTrongNam from DEMLUOTXEM where MANHANVAT IS NOT NULL";
		int num =0;
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				tongSoLuotXemNhanVatTrongNam = rs.getInt("tongSoLuotXemNhanVatTrongNam");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return tongSoLuotXemNhanVatTrongNam;
	}

	public void setTongSoLuotXemNhanVatTrongNam(int tongSoLuotXemNhanVatTrongNam) {
		this.tongSoLuotXemNhanVatTrongNam = tongSoLuotXemNhanVatTrongNam;
	}

	public int getTongSoLuotXemNhanVat() {
		connection = da.getConnect();
		String sql="select sum(TATCA) as tongSoLuotXemNhanVat from DEMLUOTXEM where MANHANVAT IS NOT NULL";
		int num =0;
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				tongSoLuotXemNhanVat = rs.getInt("tongSoLuotXemNhanVat");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return tongSoLuotXemNhanVat;
	}

	public void setTongSoLuotXemNhanVat(int tongSoLuotXemNhanVat) {
		this.tongSoLuotXemNhanVat = tongSoLuotXemNhanVat;
	}

	public void themBaiDang(int maThoiKi, int maGiaiDoan, String mucDongGopTen, String tieuDe, String namSinh,
			String namMat, String noiDung, String nguon) {
		connection = da.getConnect();
		CallableStatement cs = null;
		try {
			cs = connection.prepareCall("{call insertnhanvat(?,?,?,?,?)}");
			cs.setString(1, tieuDe);
			cs.setString(2, namSinh);
			cs.setString(3, namMat);
			cs.setString(4, noiDung);
			cs.setString(5, nguon);
			
			cs.executeUpdate();
			
			System.out.println(cs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				cs.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	
	
	
	

	
	
	
	
	
}
