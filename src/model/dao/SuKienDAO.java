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

import model.bean.NhanVatSuKien;
import model.bean.SuKien;

/**
 * @author HCD-Fresher161
 *
 */
public class SuKienDAO {
	DataAccess da = new DataAccess();
	Connection connection = null;
	Statement stmt = null;
	Statement stmt1 = null;
	
	private int tongSoLuotXemSuKienTrongNgay = 0;
	private int tongSoLuotXemSuKienTrongTuan = 0;
	private int tongSoLuotXemSuKienTrongThang = 0;
	private int tongSoLuotXemSuKienTrongNam = 0;
	private int tongSoLuotXemSuKien = 0;
	
	public ArrayList<SuKien> getListSuKien() {
		connection = da.getConnect();
		String sql = "SELECT * FROM SuKien";
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ArrayList<SuKien> list = new ArrayList<SuKien>();
		SuKien suKien;
		try {
			while (rs.next()) {
				suKien = new SuKien();
				suKien.setMaGiaiDoan(rs.getInt("MAGIAIDOAN"));
				suKien.setTenSuKien(rs.getString("TENSUKIEN"));
				suKien.setMaSuKien(rs.getInt("MASUKIEN"));
				suKien.setNoiDung(rs.getString("NOIDUNG"));
				list.add(suKien);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}

	public ArrayList<SuKien> getListSuKien(int maGiaiDoan) {
		connection = da.getConnect();
		String sql = "Select SUKIEN.*, GIAIDOAN.TENGIAIDOAN " +
		"from SUKIEN inner join GIAIDOAN on GIAIDOAN.MAGIAIDOAN = SUKIEN.MAGIAIDOAN " +
		"where SUKIEN.MAGIAIDOAN = " + maGiaiDoan;
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ArrayList<SuKien> list = new ArrayList<SuKien>();
		SuKien suKien;
		try {
			while (rs.next()) {
				suKien = new SuKien();
				suKien.setMaGiaiDoan(rs.getInt("MAGIAIDOAN"));
				suKien.setTenSuKien(rs.getString("TENSUKIEN"));
				suKien.setMaSuKien(rs.getInt("MASUKIEN"));
				suKien.setNoiDung(rs.getString("NOIDUNG"));
				list.add(suKien);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<SuKien> getListSuKienTK(int top, int type, int time) {
		// TODO Auto-generated method stub
		connection = da.getConnect();
		
		ArrayList<SuKien> list = new ArrayList<SuKien>();
		SuKien suKien;
		System.out.println("top = "+top+" type "+type+" time = "+time);
		if(type==0&&time==0){
			ResultSet rs = null;
			String sql = "select top "+ top +" sk.MASUKIEN,sk.TENSUKIEN,dlx.NGAYHIENTAI " +
					"from DEMLUOTXEM dlx " +
					"inner join SUKIEN sk on sk.MASUKIEN = dlx.MASUKIEN "+
					"order by dlx.NGAYHIENTAI desc";
			System.out.println(sql);
			try {
				stmt = connection.createStatement();
				stmt1 = connection.createStatement();
				rs = stmt.executeQuery(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				while (rs.next()) {
					suKien = new SuKien();
					suKien.setMaSuKien(rs.getInt("MASUKIEN"));
					suKien.setTenSuKien(rs.getString("TENSUKIEN"));
					suKien.setSoLuongLuotXemNgay(rs.getInt("NGAYHIENTAI"));
					list.add(suKien);
				}
				rs.close();
				String query = "select sum(NGAYHIENTAI) as tongSoLuotXemSuKienTrongNgay from DEMLUOTXEM where MASUKIEN IS NOT NULL";
				System.out.println(query);
				rs = stmt1.executeQuery(query);
					
				if (rs.next())
					this.tongSoLuotXemSuKienTrongNgay = rs.getInt("tongSoLuotXemSuKienTrongNgay");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(type==0&&time==1){
			ResultSet rs = null;
			String sql = "select top "+ top +" sk.MASUKIEN,sk.TENSUKIEN,dlx.TUAN " +
					"from DEMLUOTXEM dlx " +
					"inner join SUKIEN sk on sk.MASUKIEN = dlx.MASUKIEN "+
					"order by dlx.TUAN desc";
			try {
				stmt = connection.createStatement();
				stmt1 = connection.createStatement();
				rs = stmt.executeQuery(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				while (rs.next()) {
					suKien = new SuKien();
					suKien.setMaSuKien(rs.getInt("MASUKIEN"));
					suKien.setTenSuKien(rs.getString("TENSUKIEN"));
					suKien.setSoLuongLuotXemTuan(rs.getInt("TUAN"));
					list.add(suKien);
				}
				rs.close();
				String query = "select sum(TUAN) as tongSoLuotXemSuKienTrongTuan from DEMLUOTXEM where MASUKIEN IS NOT NULL";
				System.out.println(query);
				rs = stmt1.executeQuery(query);

				if (rs.next())
					this.tongSoLuotXemSuKienTrongTuan = rs.getInt("tongSoLuotXemSuKienTrongTuan");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(type==0&&time==2){
			ResultSet rs = null;
			String sql = "select top "+ top +" sk.MASUKIEN,sk.TENSUKIEN,dlx.THANG " +
					"from DEMLUOTXEM dlx " +
					"inner join SUKIEN sk on sk.MASUKIEN = dlx.MASUKIEN "+
					"order by dlx.THANG desc";
			try {
				stmt = connection.createStatement();
				stmt1 = connection.createStatement();
				rs = stmt1.executeQuery(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				while (rs.next()) {
					suKien = new SuKien();
					suKien.setMaSuKien(rs.getInt("MASUKIEN"));
					suKien.setTenSuKien(rs.getString("TENSUKIEN"));
					suKien.setSoLuongLuotXemThang(rs.getInt("THANG"));
					list.add(suKien);
				}
				rs.close();
				String query = "select sum(THANG) as tongSoLuotXemSuKienTrongThang from DEMLUOTXEM where MASUKIEN IS NOT NULL";
				System.out.println(query);
				rs = stmt.executeQuery(query);

				if (rs.next())
					this.tongSoLuotXemSuKienTrongThang = rs.getInt("tongSoLuotXemSuKienTrongThang");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(type==0&&time==3){
			ResultSet rs = null;
			String sql = "select top "+ top +" sk.MASUKIEN,sk.TENSUKIEN,dlx.NAM " +
					"from DEMLUOTXEM dlx " +
					"inner join SUKIEN sk on sk.MASUKIEN = dlx.MASUKIEN "+
					"order by dlx.NAM desc";
			try {
				stmt = connection.createStatement();
				stmt1 = connection.createStatement();
				rs = stmt.executeQuery(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				while (rs.next()) {
					suKien = new SuKien();
					suKien.setMaSuKien(rs.getInt("MASUKIEN"));
					suKien.setTenSuKien(rs.getString("TENSUKIEN"));
					suKien.setSoLuongLuotXemNam(rs.getInt("NAM"));
					list.add(suKien);
				}
				rs.close();
				String query = "select sum(NAM) as tongSoLuotXemSuKienTrongNam from DEMLUOTXEM where MASUKIEN IS NOT NULL";
				System.out.println(query);
				rs = stmt.executeQuery(query);

				if (rs.next())
					this.tongSoLuotXemSuKienTrongNam = rs.getInt("tongSoLuotXemSuKienTrongNam");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(type==0&&time==4){
			ResultSet rs = null;
			String sql = "select top "+ top +" sk.MASUKIEN,sk.TENSUKIEN,dlx.TATCA " +
					"from DEMLUOTXEM dlx " +
					"inner join SUKIEN sk on sk.MASUKIEN = dlx.MASUKIEN "+
					"order by dlx.TATCA desc";
			try {
				stmt = connection.createStatement();
				stmt1 = connection.createStatement();
				rs = stmt.executeQuery(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				while (rs.next()) {
					suKien = new SuKien();
					suKien.setMaSuKien(rs.getInt("MASUKIEN"));
					suKien.setTenSuKien(rs.getString("TENSUKIEN"));
					suKien.setSoLuongLuotXem(rs.getInt("TATCA"));
					list.add(suKien);
				}
				rs.close();
				String query = "select sum(TATCA) as tongSoLuotXemSuKien from DEMLUOTXEM where MASUKIEN IS NOT NULL";
				System.out.println(query);
				rs = stmt1.executeQuery(query);

				if (rs.next())
					this.tongSoLuotXemSuKien = rs.getInt("tongSoLuotXemSuKien");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	/**
	 * @return the tongSoLuotXemSuKienTrongNgay
	 */
	public int getTongSoLuotXemSuKienTrongNgay() {
		return this.tongSoLuotXemSuKienTrongNgay;
	}

	/**
	 * @param tongSoLuotXemSuKienTrongNgay the tongSoLuotXemSuKienTrongNgay to set
	 */
	public void setTongSoLuotXemSuKienTrongNgay(int tongSoLuotXemSuKienTrongNgay) {
		this.tongSoLuotXemSuKienTrongNgay = tongSoLuotXemSuKienTrongNgay;
	}

	/**
	 * @return the tongSoLuotXemSuKienTrongTuan
	 */
	public int getTongSoLuotXemSuKienTrongTuan() {
		return tongSoLuotXemSuKienTrongTuan;
	}

	/**
	 * @param tongSoLuotXemSuKienTrongTuan the tongSoLuotXemSuKienTrongTuan to set
	 */
	public void setTongSoLuotXemSuKienTrongTuan(int tongSoLuotXemSuKienTrongTuan) {
		this.tongSoLuotXemSuKienTrongTuan = tongSoLuotXemSuKienTrongTuan;
	}

	/**
	 * @return the tongSoLuotXemSuKienTrongThang
	 */
	public int getTongSoLuotXemSuKienTrongThang() {
		return tongSoLuotXemSuKienTrongThang;
	}

	/**
	 * @param tongSoLuotXemSuKienTrongThang the tongSoLuotXemSuKienTrongThang to set
	 */
	public void setTongSoLuotXemSuKienTrongThang(int tongSoLuotXemSuKienTrongThang) {
		this.tongSoLuotXemSuKienTrongThang = tongSoLuotXemSuKienTrongThang;
	}

	/**
	 * @return the tongSoLuotXemSuKienTrongNam
	 */
	public int getTongSoLuotXemSuKienTrongNam() {
		return tongSoLuotXemSuKienTrongNam;
	}

	/**
	 * @param tongSoLuotXemSuKienTrongNam the tongSoLuotXemSuKienTrongNam to set
	 */
	public void setTongSoLuotXemSuKienTrongNam(int tongSoLuotXemSuKienTrongNam) {
		this.tongSoLuotXemSuKienTrongNam = tongSoLuotXemSuKienTrongNam;
	}

	/**
	 * @return the tongSoLuotXemSuKien
	 */
	public int getTongSoLuotXemSuKien() {
		return tongSoLuotXemSuKien;
	}

	/**
	 * @param tongSoLuotXemSuKien the tongSoLuotXemSuKien to set
	 */
	public void setTongSoLuotXemSuKien(int tongSoLuotXemSuKien) {
		this.tongSoLuotXemSuKien = tongSoLuotXemSuKien;
	}

	
	
	/*--------------------------------------------------------------------------*/
	
	
	
	Statement st=null;
	Connection cnn=null;
	ResultSet rs=null;
	
	/**
	 * Láº¥y danh sÃ¡ch top 5 sá»± kiá»‡n Ä‘Æ°á»£c xem nhiá»�u nháº¥t
	 * @return
	 */
	public ArrayList<SuKien> getTopSuKien() {
		cnn=da.getConnect();
		String sql="select top 5 * from SUKIEN order by masukien DESC";
		ArrayList<SuKien> list= new ArrayList<SuKien>();
		try {
			st=cnn.createStatement();
			rs=st.executeQuery(sql);
			SuKien sk;
			while(rs.next()){
				sk=new SuKien();
				sk.setMaSuKien(rs.getInt("MASUKIEN"));
				sk.setTenSuKien(rs.getString("TENSUKIEN"));
				list.add(sk);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * Láº¥y top 3 sá»± kiá»‡n sáº¯p diá»…n ra trong quÃ¡ khá»© dá»±a theo ngÃ y vÃ  thÃ¡ng hiá»‡n táº¡i
	 * @param ngayDang
	 * @param ngay
	 * @param thang
	 * @return
	 */
	public ArrayList<SuKien> getTopSuKienSDR(String ngayDang, int ngay, int thang) {
		cnn=da.getConnect();
		String sql="select top 3 * from SUKIEN where day(NGAYBATDAU) <="+ngay+"";
		ArrayList<SuKien> list= new ArrayList<SuKien>();
		try {
			st=cnn.createStatement();
			rs=st.executeQuery(sql);
			SuKien sk;
			while(rs.next()){
				sk=new SuKien();
				sk.setMaSuKien(rs.getInt("MASUKIEN"));
				sk.setTenSuKien(rs.getString("TENSUKIEN"));
				list.add(sk);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public static void main(String[] args) {
		SuKienDAO sk=new SuKienDAO();
		sk.getTopSuKienSDR("10", 1,1);
	}

	public ArrayList<SuKien> getTopSuKienMoi() {
		cnn=da.getConnect();
		String sql="select top 5 * from SUKIEN order by MASUKIEN DESC";
		ArrayList<SuKien> list= new ArrayList<SuKien>();
		try {
			st=cnn.createStatement();
			rs=st.executeQuery(sql);
			SuKien sk;
			while(rs.next()){
				sk=new SuKien();
				sk.setMaSuKien(rs.getInt("MASUKIEN"));
				sk.setTenSuKien(rs.getString("TENSUKIEN"));
				sk.setHinhAnh(rs.getString("HINHANH"));
				String noiDung= rs.getString("NOIDUNG");
				if(noiDung.length()>200)
					sk.setNoiDung(rs.getString("NOIDUNG").substring(0, 200));
				else
					sk.setNoiDung(rs.getString("NOIDUNG"));
				list.add(sk);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public int checkListSK(int id) {
		cnn=da.getConnect();
		String sql="select count(*) as num from SUKIEN where MAGIAIDOAN="+id+"";
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

	public String showListSK(int id, int num) {
		cnn=da.getConnect();
		String sql="select TOP "+num+" sk.MASUKIEN, TENSUKIEN, sk.NOIDUNG, sk.HINHANH, YEAR(sk.NGAYBATDAU) as TUNGAY, year(sk.NGAYKETTHUC) as DENNGAY from SUKIEN sk inner join GIAIDOAN gd on sk.MAGIAIDOAN= gd.MAGIAIDOAN where sk.MAGIAIDOAN="+id+" order by sk.NGAYBATDAU ASC";
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
				"<a title=\""+rs.getString("TENSUKIEN")+"\" href=\"chi-tet-nhan-vat-su-kien.html?id="+rs.getInt("MASUKIEN")+"&type=1\">"+
				"<img class=\"nv-season_img\" src=\""+rs.getString("HINHANH")+"\"></a></div>"+
				"<div class=\"nv-timeline-content\">"+
				"<div class=\"date\">"+Integer.toString(rs.getInt("TUNGAY"))+" - "+Integer.toString(rs.getInt("DENNGAY"))+"</div>"+
				"<div style=\"clear: both;\"></div>"+
				"<p class=\"nv-detail\">"+nd+""+
				"</p>"+
				"<h2 class=\"nv-title\">" +
				"<a title=\""+rs.getString("TENSUKIEN")+"\" href=\"chi-tet-nhan-vat-su-kien.html?id="+rs.getInt("MASUKIEN")+"&type=1\">"+rs.getString("TENSUKIEN")+"</a></h2>"+
				"</div></div>";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}

	public ArrayList<NhanVatSuKien> getListSuKienT(int id) {
		cnn=da.getConnect();
		String sql="select TOP 7 sk.MASUKIEN, TENSUKIEN, sk.NOIDUNG, sk.HINHANH, YEAR(sk.NGAYBATDAU) as TUNGAY, year(sk.NGAYKETTHUC) as DENNGAY from SUKIEN sk inner join GIAIDOAN gd on sk.MAGIAIDOAN= gd.MAGIAIDOAN where sk.MAGIAIDOAN="+id+" order by sk.NGAYBATDAU ASC";
		ArrayList<NhanVatSuKien> list= new ArrayList<NhanVatSuKien>();
		try {
			st=cnn.createStatement();
			rs=st.executeQuery(sql);
			NhanVatSuKien nvsk;
			while(rs.next()){
				nvsk=new NhanVatSuKien();
				nvsk.setMaNVSK(rs.getInt("MASUKIEN"));
				nvsk.setTenNVSK(rs.getString("TENSUKIEN"));
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

	public void themBaiDang(int maThoiKi1, int maGiaiDoan, String mucDongGopTen, String tieuDe, String ngayBatDau,
			String ngayKetThuc, String noiDung, String nguon) {
		connection=da.getConnect();
		CallableStatement cs = null;
		try {
			cs = connection.prepareCall("{call insertsukien(?,?,?,?,?,?)}");
			cs.setString(1, tieuDe);
			cs.setString(2, ngayBatDau);
			cs.setString(3, ngayKetThuc);
			cs.setString(4, noiDung);
			cs.setString(5, nguon);
			cs.setInt(6, maGiaiDoan);
			cs.executeUpdate();
			
			System.out.println(cs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(cs!=null)
					cs.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
