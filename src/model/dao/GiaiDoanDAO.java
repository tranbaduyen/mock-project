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
import model.bean.NhanVatSuKien;
import model.bean.NoiDung;
import model.bean.ThoiKy;

import common.ProcessString;

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
		String sql = "Select gd.MAGIAIDOAN, gd.TENGIAIDOAN, CONVERT(nvarchar,Year(gd.NGAYBATDAU),101) as NGAYBATDAU,CONVERT(nvarchar,Year(gd.NGAYKETTHUC),101) as NGAYKETTHUC,gd.NOIDUNG,gd.BANDOGIAIDOAN,gd.MATHOIKI,tk.TENTHOIKI " +
		"from GIAIDOAN gd inner join THOIKI tk on gd.MATHOIKI = tk.MATHOIKI ";
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
				giaiDoan.setMaThoiKi(rs.getInt("MATHOIKI"));
				giaiDoan.setTenThoiKi(rs.getString("TENTHOIKI"));
				if(rs.getString("NGAYBATDAU")!=null)
					giaiDoan.setNgayBatDau(rs.getString("NGAYBATDAU"));
				else
					giaiDoan.setNgayBatDau("N/A");
				if(rs.getString("NGAYKETTHUC")!=null)
					giaiDoan.setNgayKetThuc(rs.getString("NGAYKETTHUC"));
				else
					giaiDoan.setNgayKetThuc("N/A");
				giaiDoan.setNoiDung(rs.getString("NOIDUNG"));
				giaiDoan.setBanDoGiaiDoan(rs.getString("BANDOGIAIDOAN"));
				list.add(giaiDoan);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}

	public ArrayList<GiaiDoan> getListGiaiDoan(int maThoiKi) {
		connection = da.getConnect();
		String sql = "Select gd.MAGIAIDOAN,gd.TENGIAIDOAN,CONVERT(nvarchar,Year(gd.NGAYBATDAU),101) as NGAYBATDAU, " +
				"CONVERT(nvarchar,Year(gd.NGAYKETTHUC),101) as NGAYKETTHUC,gd.NOIDUNG, " +
				"gd.BANDOGIAIDOAN,tk.MATHOIKI,tk.TENTHOIKI " +
				"from GIAIDOAN gd inner join THOIKI tk on gd.MATHOIKI = tk.MATHOIKI " +
				"where gd.MATHOIKI = " + maThoiKi;
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
				giaiDoan.setTenThoiKi(rs.getString("TENTHOIKI"));
				giaiDoan.setNgayBatDau(rs.getString("NGAYBATDAU"));
				giaiDoan.setNgayKetThuc(rs.getString("NGAYKETTHUC"));
				
				list.add(giaiDoan);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}
	
	public GiaiDoan getThongTinGiaiDoan(int maGiaiDoan) {
		connection = da.getConnect();
		String sql=	String.format("SELECT gd.TenGiaiDoan,CONVERT(nvarchar,Year(gd.NGAYBATDAU),101) as NGAYBATDAU," +
				"CONVERT(nvarchar,Year(gd.NGAYKETTHUC),101) as NGAYKETTHUC, gd.NoiDung, " +
				"gd.BANDOGIAIDOAN, gd.MATHOIKI, gd.MaGiaiDoan "+
					"FROM GIAIDOAN gd " +
					"inner join THOIKI tk on gd.MATHOIKI = tk.MATHOIKI " +
					"WHERE maGiaiDoan = %s", maGiaiDoan);
		System.out.println(sql);
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		GiaiDoan giaiDoan = new GiaiDoan();
		try {
			while(rs.next()){
				giaiDoan.setMaGiaiDoan(maGiaiDoan);
				giaiDoan.setTenGiaiDoan(rs.getString("TENGIAIDOAN"));
				giaiDoan.setTenThoiKi(rs.getString("TENTHOIKI"));
				giaiDoan.setNgayBatDau(rs.getString("NGAYBATDAU"));
				giaiDoan.setNgayKetThuc(rs.getString("NGAYKETTHUC"));
				giaiDoan.setNoiDung(rs.getString("NOIDUNG"));
				giaiDoan.setBanDoGiaiDoan(rs.getString("BANDOGIAIDOAN"));
				giaiDoan.setMaThoiKi(rs.getInt("MATHOIKI"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return giaiDoan;
	}
	public void themGiaiDoan(String tenGiaiDoan,String ngayBatDau, String ngayKetThuc, String noiDung, String banDoGiaiDoan, int maThoiKi) {
		connection = da.getConnect();
		String sql=	String.format("INSERT INTO GIAIDOAN(tenGiaiDoan,ngayBatDau,ngayKetThuc,noiDung,banDoGiaiDoan,maThoiKi) "+
					" VALUES (N'%s','%s','%s',N'%s',N'%s',%s )",tenGiaiDoan, ngayBatDau,ngayKetThuc,noiDung,banDoGiaiDoan ,maThoiKi);
		System.out.println(sql);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void suaGiaiDoan(int maGiaiDoan, String tenGiaiDoan, String ngayBatDau, String ngayKetThuc, String noiDung, String banDoGiaiDoan, int maThoiKi) {
		connection = da.getConnect();
		String sql=	String.format("UPDATE GIAIDOAN "+
					" SET TENGIAIDOAN = N'%s',NGAYBATDAU = '%s',NGAYKETTHUC = '%s' ,NOIDUNG = N'%s',BANDOGIAIDOAN = N'%s' , maThoiKi = %s " +
					" WHERE maGiaiDoan = %s ", tenGiaiDoan,ngayBatDau,ngayKetThuc, noiDung,banDoGiaiDoan, maThoiKi, maGiaiDoan);
		System.out.println(sql);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void xoaGiaiDoan(int maGiaiDoan) {
		connection = da.getConnect();
		String sql=	String.format("DELETE FROM GIAIDOAN WHERE maGiaiDoan = %s", maGiaiDoan);
		System.out.println(sql);
		System.out.println(sql);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 
	 */
	
	
	Statement st=null;
	Connection cnn=null;
	ResultSet rs=null;

	/**
	 * Lấy danh sách giai đoạn từ csdl theo mã thời kỳ
	 * @param id
	 * @return
	 */
	public ArrayList<GiaiDoan> getListGiaiDoanT(int id) {
		cnn=da.getConnect();
		ArrayList<GiaiDoan> list = new ArrayList<GiaiDoan>();
		String sql="Select * from GIAIDOAN where MATHOIKI="+id+"";
		try {
			st=cnn.createStatement();
			rs=st.executeQuery(sql);
			GiaiDoan gd;
			while(rs.next()){
				gd=new GiaiDoan();
				gd.setMaGiaiDoan(rs.getInt("MAGIAIDOAN"));
				gd.setMaThoiKy(rs.getInt("MATHOIKI"));
				gd.setTenGiaiDoan(rs.getString("TENGIAIDOAN"));
				try{
					gd.setNgayBatDau(rs.getDate("NGAYBATDAU").toString().substring(0, 4));
				}catch (Exception e) {
					gd.setNgayBatDau("N/A");
				}
				try{
					gd.setNgayKetThuc(rs.getDate("NGAYKETTHUC").toString().substring(0, 4));
				}catch (Exception e) {
					gd.setNgayKetThuc("N/A");
				}

				String noiDung=rs.getString("NOIDUNG");
				String [] noiDungChia=noiDung.split(" ");

				if(noiDungChia.length>50)
					gd.setNoiDung(ProcessString.catChuoi(noiDungChia, 0, 50));
				else
					gd.setNoiDung(rs.getString("NOIDUNG"));
				gd.setBanDoGiaiDoan(rs.getString("BANDOGIAIDOAN"));
				gd.setHinhAnh(rs.getString("HINHANH"));
				list.add(gd);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * Lấy số lượng giai đoạn theo mã thời kỳ
	 * @param id
	 * @return
	 */
	public ArrayList<String> getPageGiaiDoan(int id) {
		cnn=da.getConnect();
		ArrayList<String> page =new ArrayList<String>();
		String sql="Select count(*) as page from GIAIDOAN where MATHOIKI="+id+"";
		try {
			st=cnn.createStatement();
			rs=st.executeQuery(sql);

			while(rs.next()){
				for(int i=1; i<=rs.getInt("page");i++){
					if (i==1)
						page.add("I");
					if (i==2)
						page.add("II");
					if (i==3)
						page.add("III");
					if (i==4)
						page.add("IV");
					if (i==5)
						page.add("V");
					if (i==6)
						page.add("VI");
					if (i==7)
						page.add("VII");
					if (i==8)
						page.add("VIII");
					if (i==9)
						page.add("IX");
					if (i==10)
						page.add("X");
				}

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return page;
	}

	/**
	 * Lấy số năm chia nhỏ theo 50 năm trong một giai đoạn
	 * @param id
	 * @param type
	 * @return
	 */
	public ArrayList<String> getNamChiaNho(int id, int type) {
		cnn=da.getConnect();
		ArrayList<String> listNam =new ArrayList<String>();
		String sql="Select Year(NGAYBATDAU) as ngaybd, Year(NGAYKETTHUC) as ngaykt from GIAIDOAN where MAGIAIDOAN="+id+"";
		try {
			st=cnn.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()){
				int ngaybd=rs.getInt("ngaybd");
				int ngaykt=rs.getInt("ngaykt");
				int sonam= ngaykt - ngaybd;
				if(sonam%50!=0)
					sonam=(sonam/50)+1;
				else
					sonam=(sonam/50);
				for(int i=0;i<=sonam;i++){
					if(i==0)
						listNam.add(Integer.toString(ngaybd));
					else
						if(i==sonam)
							listNam.add(Integer.toString(ngaykt));
						else{
							ngaybd=ngaybd+50;
							if(checkSuKien(ngaybd, ngaybd+50, type)){
								listNam.add(Integer.toString(ngaybd));

							}
						}
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listNam;
	}

	/**
	 * Kiểm tra trong năm chia nhỏ có tồn tại sự kiện hay không
	 * @param nambd
	 * @param namkt
	 * @param type
	 * @return
	 */
	public boolean checkSuKien(int nambd, int namkt, int type){
		cnn=da.getConnect();
		String sql="";
		if(type==1){
			sql="Select * from SUKIEN where YEAR(NGAYBATDAU)>="+nambd+" and YEAR(NGAYBATDAU)<"+namkt+"";
		}
		else{
			sql="Select * from NHANVAT where YEAR(NAMSINH)>="+nambd+" and YEAR(NAMSINH)<"+namkt+"";
		}
		try {
			st=cnn.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}





	public boolean checkGiaiDoan(int nambd){
		cnn=da.getConnect();
		String sql="Select * from GiaiDoan where year(NGAYBATDAU)="+nambd+"";
		try {
			st=cnn.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	/**
	 * Lấy danh sách nhân vật hoặc sự kiện qua ajax khi click vào năm chia nhỏ
	 * @param nambd
	 * @param namkt
	 * @param type
	 * @return
	 */
	public String getListNVSK(int nambd, int namkt, int type) {
		cnn=da.getConnect();
		String kq="";
		String sql="";
		if(type==1){
			if(checkGiaiDoan(nambd))
				sql="Select * from SUKIEN where YEAR(NGAYBATDAU)>="+nambd+" and YEAR(NGAYBATDAU)<"+namkt+" or(YEAR(NGAYKETTHUC)>="+nambd+" and  YEAR(NGAYKETTHUC)<"+namkt+")";
			else
				sql="Select * from SUKIEN where YEAR(NGAYBATDAU)>="+nambd+" and YEAR(NGAYBATDAU)<"+namkt+"";
			try {
				st=cnn.createStatement();
				rs=st.executeQuery(sql);
				while(rs.next()){
					String noiDung=rs.getString("NOIDUNG");
					String []noiDungChia=noiDung.split(" ");
					int dodai=noiDungChia.length;
					if(dodai>200)
						noiDung= ProcessString.catChuoi(noiDungChia, 0, 100);
					else
						noiDung=rs.getString("NOIDUNG");
					kq+="<div class=\"showmore\">" +
					"<div class=\"timeline-event\"><span class=\"click-sukien\">"+rs.getString("TENSUKIEN")+"</span>" +
					"<a href=\"chi-tet-nhan-vat-su-kien.html?id="+rs.getInt("MASUKIEN")+"&type=1\"><img src=\"css/next.svg\"></a></div>"
					+"<span class=\"tick tick-after\"></span>"
					+"<div class=\"timeline-detail\">"
					+"<div class=\"timeline-full-detail\">"
					+"<p>"+noiDung+"</p>"
					+"<span class=\"cd-read-more-1\">" 
					+"<a href=\"chi-tet-nhan-vat-su-kien.html?id="+rs.getInt("MASUKIEN")+"&type=1\">Đọc tiếp...</a></span>"
					+"</div>"
					+"</div>"
					+"</div>";
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			if(checkGiaiDoan(nambd))
				sql="Select * from NHANVAT where (YEAR(NAMSINH)>="+nambd+" and YEAR(NAMSINH)<"+namkt+") or(YEAR(NAMMAT)>="+nambd+" and  YEAR(NAMMAT)<"+namkt+")";
			else
				sql="Select * from NHANVAT where YEAR(NAMSINH)>="+nambd+" and YEAR(NAMSINH)<"+namkt+"";
			try {
				st=cnn.createStatement();
				rs=st.executeQuery(sql);
				while(rs.next()){
					String noiDung=rs.getString("NOIDUNG");
					if(noiDung.length()>370)
						noiDung= rs.getString("NOIDUNG").substring(0, 370)+" ...";
					else
						noiDung=rs.getString("NOIDUNG");
					kq+="<div class=\"showmore\">" +
					"<div class=\"timeline-event\"><span class=\"click-sukien\">"+rs.getString("TENNHANVAT")+"</span>" +
					"<a href=\"chi-tet-nhan-vat-su-kien.html?id="+rs.getInt("MANHANVAT")+"\"><img src=\"css/next.svg\"></a></div>"
					+"<span class=\"tick tick-after\"></span>"
					+"<div class=\"timeline-detail\">"
					+"<div class=\"timeline-full-detail\">"
					+"<p>"+noiDung+"</p>"
					+"<span class=\"cd-read-more-1\">" 
					+"<a href=\"chi-tet-nhan-vat-su-kien.html?id="+rs.getInt("MANHANVAT")+"\">Đọc tiếp...</a></span>"
					+"</div>"
					+"</div>"
					+"</div>";
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return kq;
	}

	/**
	 * Lấy thông tin giai đoạn theo mã giai đoạn
	 * @param id
	 * @return
	 */
	public GiaiDoan getInfoGiaiDoan(int id) {
		cnn=da.getConnect();
		GiaiDoan giaiDoan=new GiaiDoan();
		String sql="Select * from GIAIDOAN where MAGIAIDOAN="+id+"";
		try {
			st=cnn.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()){
				giaiDoan.setTenGiaiDoan(rs.getString("TENGIAIDOAN"));
				giaiDoan.setNoiDung(rs.getString("NOIDUNG"));
				try{
					giaiDoan.setNgayBatDau(rs.getDate("NGAYBATDAU").toString().substring(0, 4));
				}catch (Exception e) {
					giaiDoan.setNgayBatDau("N/A");
				}
				try{
					giaiDoan.setNgayKetThuc(rs.getDate("NGAYKETTHUC").toString().substring(0, 4));
				}catch (Exception e) {
					giaiDoan.setNgayKetThuc("N/A");
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return giaiDoan;
	}

	/**
	 * Lấy thông tin nhân vật hoặc sự kiện theo id
	 * @param id
	 * @param type
	 * @return
	 */
	public NhanVatSuKien getNhanVatSuKien(int id, int type) {
		cnn=da.getConnect();
		String sql="";
		NhanVatSuKien nhanVatSuKien=new NhanVatSuKien();
		if(type==1){
			sql="Select TENSUKIEN, sk.NOIDUNG, sk.NGAYBATDAU, sk.NGAYKETTHUC, sk.HINHANH, tk.MATHOIKI, TENTHOIKI, gd.MAGIAIDOAN, TENGIAIDOAN from SUKIEN sk inner join GIAIDOAN gd on sk.MAGIAIDOAN = gd.MAGIAIDOAN  inner join THOIKI tk on gd.MATHOIKI=tk.MATHOIKI where sk.MASUKIEN ="+id+"";
			try {
				st=cnn.createStatement();
				rs=st.executeQuery(sql);
				while(rs.next()){
					nhanVatSuKien.setTenNVSK(rs.getString("TENSUKIEN"));
					nhanVatSuKien.setNoiDung(rs.getString("NOIDUNG"));
					try{
						nhanVatSuKien.setNgayDau(rs.getDate("NGAYBATDAU").toString().substring(0, 4));
					}catch (Exception e) {
						nhanVatSuKien.setNgayDau("N/A");
					}
					try{
						nhanVatSuKien.setNgayCuoi(rs.getDate("NGAYKETTHUC").toString().substring(0, 4));
					}catch (Exception e) {
						nhanVatSuKien.setNgayCuoi("N/A");
					}
					nhanVatSuKien.setHinhAnh(rs.getString("HINHANH"));
					nhanVatSuKien.setMaThoiKy(rs.getString("MATHOIKI"));
					nhanVatSuKien.setTenThoiKy(rs.getString("TENTHOIKI"));
					nhanVatSuKien.setMaGiaiDoan(rs.getString("MAGIAIDOAN"));
					nhanVatSuKien.setTenGiaiDoan(rs.getString("TENGIAIDOAN"));
					nhanVatSuKien.setType(1);
					nhanVatSuKien.setTenType("Sự Kiện");

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			sql="Select TENNHANVAT, nv.NOIDUNG, NAMSINH, NAMMAT, nv.HINHANH, THOIKI.MATHOIKI, THOIKI.TENTHOIKI, gd.MAGIAIDOAN, TENGIAIDOAN from NHANVAT nv inner join GIAIDOANNHANVAT gdnv on nv.MANHANVAT=gdnv.MANHANVAT inner join GIAIDOAN gd on gd.MAGIAIDOAN=gdnv.MAGIAIDOAN inner join THOIKI on THOIKI.MATHOIKI= gd.MATHOIKI where nv.MANHANVAT ="+id+"";
			try {
				st=cnn.createStatement();
				rs=st.executeQuery(sql);
				while(rs.next()){
					nhanVatSuKien.setTenNVSK(rs.getString("TENNHANVAT"));
					nhanVatSuKien.setNoiDung(rs.getString("NOIDUNG"));
					try{
						nhanVatSuKien.setNgayDau(rs.getDate("NAMSINH").toString().substring(0, 4));
					}catch (Exception e) {
						nhanVatSuKien.setNgayDau("N/A");
					}
					try{
						nhanVatSuKien.setNgayCuoi(rs.getDate("NAMMAT").toString().substring(0, 4));
					}catch (Exception e) {
						nhanVatSuKien.setNgayCuoi("N/A");
					}
					nhanVatSuKien.setHinhAnh(rs.getString("HINHANH"));
					nhanVatSuKien.setMaThoiKy(rs.getString("MATHOIKI"));
					nhanVatSuKien.setTenThoiKy(rs.getString("TENTHOIKI"));
					nhanVatSuKien.setMaGiaiDoan(rs.getString("MAGIAIDOAN"));
					nhanVatSuKien.setTenGiaiDoan(rs.getString("TENGIAIDOAN"));
					nhanVatSuKien.setType(0);
					nhanVatSuKien.setTenType("Nhân Vật");


				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return nhanVatSuKien;
	}


	/**
	 * Lấy nội dung từ csdl sau đó chia nhỏ thành các trang con mỗi trang 230 ký tự
	 * @param id
	 * @param type
	 * @return
	 */
	public ArrayList<NoiDung> getNoiDung(int id, int type) {
		cnn=da.getConnect();
		String sql="";
		ArrayList<NoiDung> noiDung =new ArrayList<NoiDung>();
		if(type==1)
			sql="Select * from SUKIEN where MASUKIEN="+id+"";
		else
			sql="Select * from NHANVAT where MANHANVAT="+id+"";
		try {
			st=cnn.createStatement();
			rs=st.executeQuery(sql);
			NoiDung nd;
			while(rs.next()){
				String baiviet =rs.getString("NOIDUNG");
				String [] baiVietChia=baiviet.split(" ");
				int dodai=baiVietChia.length;
				int sochu=230;
				int batdau =0;
				int ketthuc=230;
				int trang= dodai/sochu;
				if(trang==0){
					nd=new NoiDung();
					nd.setNoiDung(rs.getString("NOIDUNG"));
					nd.setPage("1");
					noiDung.add(nd);
				}else{
					for(int i=0;i<=trang;i++){
						nd=new NoiDung();
						if(i==trang){
							int bd=(trang)*sochu;
							nd.setNoiDung(ProcessString.catChuoi(baiVietChia,bd, dodai-1));
						}
						else
							nd.setNoiDung(ProcessString.catChuoi(baiVietChia, batdau, ketthuc));
						nd.setPage(Integer.toString(i+1));
						noiDung.add(nd);
						batdau=batdau+sochu;
						ketthuc=ketthuc+sochu;
					}
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return noiDung;
	}

	/**
	 * Lấy thông tin thời kỳ theo id và load ra trang chủ
	 * @param id
	 * @return
	 */
	public ThoiKy getInfoThoiKy(int id) {
		cnn=da.getConnect();
		String sql="Select * from THOIKI where MATHOIKI="+id+"";
		ThoiKy thoiKy=new ThoiKy();
		try {
			st=cnn.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()){
				thoiKy.setMaThoiKy(rs.getInt("MATHOIKI"));
				thoiKy.setTenThoiKy(rs.getString("TENTHOIKI"));
				thoiKy.setNoiDung(rs.getString("NOIDUNG"));
				thoiKy.setHinhAnh(rs.getString("HINHANH"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return thoiKy;
	}

	public void updateLuotXem(int id, int type) {
		cnn=da.getConnect();
		String sql="";
		if(type==1)
			sql="Update SUKIEN set LUOTXEM=LUOTXEM+1 where MASUKIEN="+id+"";
		else
			sql="Update NHANVAT set LUOTXEM=LUOTXEM+1 where MANHANVAT="+id+"";
		try {
			st=cnn.createStatement();
			rs=st.executeQuery(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}


	public ArrayList<GiaiDoan> getListGiaiDoanTAM(int maThoiKi) {
		connection=da.getConnect();
		String sql=	String.format("SELECT G.MAGIAIDOAN, G.TENGIAIDOAN"+
				" FROM   GIAIDOAN G"+
				" WHERE G.MATHOIKI = %s", maThoiKi);
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
			while(rs.next()){
				giaiDoan = new GiaiDoan();
				giaiDoan.setMaGiaiDoan(rs.getInt("MAGIAIDOAN"));
				giaiDoan.setTenGiaiDoan(rs.getString("TENGIAIDOAN"));
				list.add(giaiDoan);
			//	System.out.println(list);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	
	
	

	public ArrayList<GiaiDoan> getListTenGiaiDoan(int maThoiKy) {
		cnn=da.getConnect();
		String sql=	String.format("SELECT G.MAGIAIDOAN, G.TENGIAIDOAN"+
				" FROM   GIAIDOAN G"+
				" WHERE G.MATHOIKI = %s", maThoiKy);
		ResultSet rs = null;
		try {
			st=cnn.createStatement();
			rs=st.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ArrayList<GiaiDoan> list = new ArrayList<GiaiDoan>();
		GiaiDoan giaiDoan;
		try {
			while(rs.next()){
				giaiDoan = new GiaiDoan();
				giaiDoan.setMaGiaiDoan(rs.getInt("MAGIAIDOAN"));
				giaiDoan.setTenGiaiDoan(rs.getString("TENGIAIDOAN"));
				list.add(giaiDoan);
			//	System.out.println(list);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public ArrayList<GiaiDoan> getListGiaiDoanTheoThoiKy(int maThoiKy) {
		cnn=da.getConnect();
		String sql=	String.format("SELECT G.MAGIAIDOAN, G.TENGIAIDOAN"+
				" FROM   GIAIDOAN G"+
				" WHERE G.MATHOIKI = %s", maThoiKy);
		ResultSet rs = null;
		try {
			st=cnn.createStatement();
			rs = st.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ArrayList<GiaiDoan> list = new ArrayList<GiaiDoan>();
		GiaiDoan giaiDoan;
		try {
			while(rs.next()){
				giaiDoan = new GiaiDoan();
				giaiDoan.setMaGiaiDoan(rs.getInt("MAGIAIDOAN"));
				giaiDoan.setTenGiaiDoan(rs.getString("TENGIAIDOAN"));
				list.add(giaiDoan);
			//	System.out.println(list);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		/*System.out.println("Danh sach giai doan");
		System.out.println(list);*/
		return list;
	}
	
	
	
	
	
	
	
	
}
