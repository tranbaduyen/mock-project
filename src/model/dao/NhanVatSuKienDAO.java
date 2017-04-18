package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import com.sun.jmx.snmp.SnmpUsmKeyHandler;

import model.bean.NhanVat;
import model.bean.NhanVatSuKien;
import model.bean.SuKien;

public class NhanVatSuKienDAO {

	static DataAccess da=new DataAccess();
	static Statement st=null;
	static Connection cnn=null;
	static ResultSet rs=null;
	/**
	 * Lấy danh sách sự kiện và nhân vật theo ký tự được nhập vào
	 * @param keyWord
	 * @return
	 */
	public static ArrayList<NhanVatSuKien> getListSuKienNhanVat(String keyWord) {
		cnn=da.getConnect();

		String sql = "SELECT MASUKIEN, TENSUKIEN, NOIDUNG FROM SUKIEN "+				
				"WHERE  TENSUKIEN LIKE N'%"+keyWord+"%' "
				+ "OR NOIDUNG LIKE N'%"+keyWord+"%'";
		System.out.println("sql list su kien keyword"+sql);



		String sql2 = "SELECT MANHANVAT, TENNHANVAT, NOIDUNG FROM NHANVAT "+					
				"WHERE  TENNHANVAT LIKE N'%"+keyWord+"%' "
				+ "OR NOIDUNG LIKE N'%"+keyWord+"%'";
		System.out.println("sql list nhan vat keyword :"+sql2);

		ArrayList<NhanVatSuKien> listSuKienNhanVat = new ArrayList<NhanVatSuKien>();
		try {
			st=cnn.createStatement();
			rs = st.executeQuery(sql);
			NhanVatSuKien ns;
			while (rs.next()) {
				ns = new NhanVatSuKien();
				ns.setMaNVSK(rs.getInt("MASUKIEN"));
				ns.setType(1);
				ns.setTenSuKien(rs.getString("TENSUKIEN"));
				ns.setNoiDung(rs.getString("NOIDUNG"));	
				String noiDung = rs.getString("NOIDUNG");
				if(noiDung.length()>100)
					ns.setNoiDung(rs.getString("NOIDUNG").substring(0, 100));
				else
					ns.setNoiDung(rs.getString("NOIDUNG"));
				listSuKienNhanVat.add(ns);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		try {
			st = cnn.createStatement();
			rs = st.executeQuery(sql2);
			NhanVatSuKien ns;
			while (rs.next()) {
				ns = new NhanVatSuKien();
				ns.setMaNVSK(rs.getInt("MANHANVAT"));
				ns.setType(0);
				ns.setTenSuKien(rs.getString("TENNHANVAT"));
				ns.setNoiDung(rs.getString("NOIDUNG"));
				String noiDung = rs.getString("NOIDUNG");
				if(noiDung.length()>100)
					ns.setNoiDung(rs.getString("NOIDUNG").substring(0, 100));
				else
					ns.setNoiDung(rs.getString("NOIDUNG"));
				listSuKienNhanVat.add(ns);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		System.out.println(listSuKienNhanVat);
		return listSuKienNhanVat;

	}
	/**
	 * Lấy danh sách sự kiện theo tự khóa được nhập
	 * @param keyWord
	 * @return
	 */
	public ArrayList<NhanVatSuKien> getListSuKien(String keyWord){
		cnn=da.getConnect();

		String sql = "SELECT MASUKIEN, TENSUKIEN, NOIDUNG FROM SUKIEN "+				
				"WHERE TENSUKIEN LIKE N'%"+keyWord+"%' "
				+ "OR NOIDUNG LIKE N'%"+keyWord+"%'";
		System.out.println("sql list su kien keyword"+sql);
		ArrayList<NhanVatSuKien> listSuKienNhanVat = new ArrayList<NhanVatSuKien>();
		try {
			st=cnn.createStatement();
			rs = st.executeQuery(sql);
			NhanVatSuKien ns;
			while (rs.next()) {
				ns = new NhanVatSuKien();
				ns.setMaNVSK(rs.getInt("MASUKIEN"));
				ns.setType(1);
				ns.setTenSuKien(rs.getString("TENSUKIEN"));
				ns.setNoiDung(rs.getString("NOIDUNG"));
				String noiDung = rs.getString("NOIDUNG");
				if(noiDung.length()>100)
					ns.setNoiDung(rs.getString("NOIDUNG").substring(0, 100));
				else
					ns.setNoiDung(rs.getString("NOIDUNG"));
				listSuKienNhanVat.add(ns);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listSuKienNhanVat;
	}

	/**
	 * Lấy danh sách sự kiện theo ký tự được nhập và khi chọn thời kỳ	
	 * @param keyWord
	 * @param maThoiKy
	 * @return
	 */
	public ArrayList<NhanVatSuKien> getListSuKien(String keyWord, int maThoiKy) {
		cnn = da.getConnect();
		String sql ="SELECT S.MASUKIEN, S.TENSUKIEN, S.NOIDUNG FROM SUKIEN AS S " +
				"INNER JOIN GIAIDOAN AS G ON S.MAGIAIDOAN = G.MAGIAIDOAN " +
				"WHERE (S.TENGIAIDOAN LIKE N'%"+keyWord+"%' "
				+ "OR S.NOIDUNG LIKE N'%"+keyWord+"%') "+
				"AND G.MATHOIKI = " + maThoiKy+"" ;
		System.out.println("sql list su kien theo thoi ki"+sql);
		ArrayList<NhanVatSuKien> lisSuKien = new ArrayList<NhanVatSuKien>();
		try {
			st = cnn.createStatement();
			rs = st.executeQuery(sql);
			NhanVatSuKien ns;
			while (rs.next()) {
				ns = new NhanVatSuKien();
				ns.setMaNVSK(rs.getInt("MASUKIEN"));
				ns.setType(1);
				ns.setTenSuKien(rs.getString("TENSUKIEN"));
				ns.setNoiDung(rs.getString("NOIDUNG"));
				String noiDung = rs.getString("NOIDUNG");
				if(noiDung.length()>100)
					ns.setNoiDung(rs.getString("NOIDUNG").substring(0, 100));
				else
					ns.setNoiDung(rs.getString("NOIDUNG"));
				lisSuKien.add(ns);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lisSuKien;
	}

	/**
	 * Lấy danh sách sự kiện theo ký tự được nhập vào khi chọn thời kì và giai đoạn
	 * @param keyWord
	 * @param maThoiKy
	 * @param maGiaiDoan
	 * @return
	 */
	public ArrayList<NhanVatSuKien> getListSuKien(String keyWord, int maThoiKy,
			int maGiaiDoan) {
		cnn = da.getConnect();
		String sql = "SELECT S.MASUKIEN, S.TENSUKIEN, S.NOIDUNG, S.MAGIAIDOAN FROM SUKIEN AS S "+
				"INNER JOIN GIAIDOAN AS G ON S.MAGIAIDOAN = G.MAGIAIDOAN "+
				"WHERE G.MATHOIKI = "+ maThoiKy+
				" AND G.MAGIAIDOAN = "+ maGiaiDoan+
				" AND ( S.TENSUKIEN LIKE N'%"+keyWord+"%' "
				+ "OR S.NOIDUNG LIKE N'%"+keyWord+"%')";

		System.out.println("sql list su kien theo thoi ki va giai doan: "+sql);
		ArrayList<NhanVatSuKien> listSuKien = new ArrayList<NhanVatSuKien>();
		try {
			st = cnn.createStatement();
			rs = st.executeQuery(sql);
			NhanVatSuKien ns;
			while(rs.next()){
				ns = new NhanVatSuKien();
				ns.setMaNVSK(rs.getInt("MASUKIEN"));
				ns.setType(1);
				ns.setTenSuKien(rs.getString("TENSUKIEN"));
				ns.setNoiDung(rs.getString("NOIDUNG"));
				String noiDung = rs.getString("NOIDUNG");
				if(noiDung.length()>100)
					ns.setNoiDung(rs.getString("NOIDUNG").substring(0, 100));
				else
					ns.setNoiDung(rs.getString("NOIDUNG"));
				listSuKien.add(ns);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listSuKien;
	}

	/**
	 * lấy danh sách nhân vật theo ký tự được nhập vào
	 * @param keyWord
	 * @return
	 */
	public ArrayList<NhanVatSuKien> getListNhanVat(String keyWord) {
		cnn = da.getConnect();
		String sql = "SELECT MANHANVAT, TENNHANVAT, NOIDUNG FROM NHANVAT "+					
				"WHERE TENNHANVAT LIKE N'%"+keyWord+"%' "
				+ "OR NOIDUNG LIKE N'%"+keyWord+"%'";
		System.out.println("sql list nhan vat keyword :"+sql);

		ArrayList<NhanVatSuKien> listNhanVat = new ArrayList<NhanVatSuKien>();
		try {
			st = cnn.createStatement();
			rs = st.executeQuery(sql);
			NhanVatSuKien ns;
			while (rs.next()) {
				ns = new NhanVatSuKien();
				ns.setMaNVSK(rs.getInt("MANHANVAT"));
				ns.setType(0);
				ns.setTenSuKien(rs.getString("TENNHANVAT"));
				ns.setNoiDung(rs.getString("NOIDUNG"));
				String noiDung = rs.getString("NOIDUNG");
				if(noiDung.length()>100)
					ns.setNoiDung(rs.getString("NOIDUNG").substring(0, 100));
				else
					ns.setNoiDung(rs.getString("NOIDUNG"));
				listNhanVat.add(ns);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listNhanVat;
	}
	/**
	 * Lấy danh sách nhân vật theo ký tự được nhập vào và khi chọn giai đoạn với thời kỳ
	 * @param keyWord
	 * @param maThoiKy
	 * @param maGiaiDoan
	 * @return
	 */
	public ArrayList<NhanVatSuKien> getListNhanVat(String keyWord,
			int maThoiKy, int maGiaiDoan) {
		cnn = da.getConnect();
		String sql = "SELECT N.MANHANVAT, N.TENNHANVAT, N.NOIDUNG FROM NHANVAT AS N "+
				"INNER JOIN GIAIDOANNHANVAT AS GN ON N.MANHANVAT = GN.MANHANVAT "+
				"INNER JOIN GIAIDOAN AS G ON GN.MAGIAIDOAN = G.MAGIAIDOAN "+
				"WHERE G.MATHOIKI = "+ maThoiKy+
				" AND G.MAGIAIDOAN = "+ maGiaiDoan+
				" AND ( N.TENNHANVAT LIKE N'%"+keyWord+"%' "
				+ "OR N.NOIDUNG LIKE N'%"+keyWord+"%')";

		System.out.println("sql list nhan vat theo thoi ki va giai doan: "+sql);
		ArrayList<NhanVatSuKien> listNhanVat = new ArrayList<NhanVatSuKien>();
		try {
			st = cnn.createStatement();
			rs = st.executeQuery(sql);
			NhanVatSuKien ns;
			while(rs.next()){
				ns = new NhanVatSuKien();
				ns.setMaNVSK(rs.getInt("MANHANVAT"));
				ns.setType(0);
				ns.setTenSuKien(rs.getString("TENNHANVAT"));
				ns.setNoiDung(rs.getString("NOIDUNG"));
				String noiDung = rs.getString("NOIDUNG");
				if(noiDung.length()>100)
					ns.setNoiDung(rs.getString("NOIDUNG").substring(0, 100));
				else
					ns.setNoiDung(rs.getString("NOIDUNG"));
				listNhanVat.add(ns);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listNhanVat;
	}
	/**
	 * Lấy danh sách nhân vật theo ký tự được nhập vào khi chọn thời kỳ
	 * @param keyWord
	 * @param maThoiKy
	 * @return
	 */
	public ArrayList<NhanVatSuKien> getListNhanVat(String keyWord, int maThoiKy) {
		cnn = da.getConnect();
		String sql = "SELECT N.MANHANVAT, N.TENNHANVAT, N.NOIDUNG FROM NHANVAT AS N "+
				"INNER JOIN GIAIDOANNHANVAT AS GN ON N.MANHANVAT = GN.MANHANVAT "+
				"INNER JOIN GIAIDOAN AS G ON GN.MAGIAIDOAN = G.MAGIAIDOAN "+
				"WHERE G.MATHOIKI = "+ maThoiKy+
				" AND ( N.TENNHANVAT LIKE N'%"+keyWord+"%' "
				+ "OR N.NOIDUNG LIKE N'%"+keyWord+"%')";

		System.out.println("sql list nhan vat theo thoi ki: "+sql);
		ArrayList<NhanVatSuKien> listNhanVat = new ArrayList<NhanVatSuKien>();
		try {
			st = cnn.createStatement();
			rs = st.executeQuery(sql);
			NhanVatSuKien ns;
			while(rs.next()){
				ns = new NhanVatSuKien();
				ns.setMaNVSK(rs.getInt("MANHANVAT"));
				ns.setType(0);
				ns.setTenSuKien(rs.getString("TENNHANVAT"));
				ns.setNoiDung(rs.getString("NOIDUNG"));
				String noiDung = rs.getString("NOIDUNG");
				if(noiDung.length()>100)
					ns.setNoiDung(rs.getString("NOIDUNG").substring(0, 100));
				else
					ns.setNoiDung(rs.getString("NOIDUNG"));
				listNhanVat.add(ns);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listNhanVat;
	}
	/**
	 * Lấy danh sách sự kiện và nhân vật theo ký tự được nhập vào và khi chọn khoảng thời gian nào đó
	 * Sự kiện diễn ra có ngày bắt đầu và ngày kết thúc nằm trong khoảng thời gian nhập vào
	 * Nhân vật có năm sinh và năm mất trong khoảng thời gian được nhập vào
	 * @param keyWord
	 * @param namBD
	 * @param namKT
	 * @return
	 */
	public ArrayList<NhanVatSuKien> getListSuKienNhanVatTheoNam(String keyWord,
			String namBD, String namKT) {
		cnn = da.getConnect();
		String sql = "SELECT MASUKIEN, TENSUKIEN, NOIDUNG FROM SUKIEN " +
				"WHERE ( TENSUKIEN LIKE N'%"+keyWord+"%' OR NOIDUNG LIKE N'%"+keyWord+"%') "+
				"AND (YEAR(NGAYBATDAU) >= "+namBD+" " +
				"AND YEAR(NGAYKETTHUC) <= "+namKT+")" ;

		String sql2 = "SELECT MANHANVAT, TENNHANVAT, NOIDUNG FROM NHANVAT " +
				"WHERE (TENNHANVAT LIKE N'%"+keyWord+"%' OR NOIDUNG LIKE N'%"+keyWord+"%') "+
				"AND (YEAR(NAMSINH) >= '"+namBD+"' " +
				"AND YEAR(NAMMAT) <= '"+namKT+"')" ;
		System.out.println("sql list nhan vat theo nam"+sql);

		System.out.println("sql list su kien theo nam: "+ sql);
		ArrayList<NhanVatSuKien> listSuKienNhanVatTheoNam = new ArrayList<NhanVatSuKien>();
		try {
			st = cnn.createStatement();
			rs = st.executeQuery(sql);
			NhanVatSuKien ns;
			while(rs.next()){
				ns = new NhanVatSuKien();
				ns.setMaNVSK(rs.getInt("MANHANVAT"));
				ns.setType(0);
				ns.setTenSuKien(rs.getString("TENSUKIEN"));
				ns.setNoiDung(rs.getString("NOIDUNG"));
				String noiDung = rs.getString("NOIDUNG");
				if(noiDung.length()>100)
					ns.setNoiDung(rs.getString("NOIDUNG").substring(0, 100));
				else
					ns.setNoiDung(rs.getString("NOIDUNG"));
				listSuKienNhanVatTheoNam.add(ns);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			st = cnn.createStatement();
			rs = st.executeQuery(sql2);
			NhanVatSuKien ns;
			while(rs.next()){
				ns = new NhanVatSuKien();
				ns.setMaNVSK(rs.getInt("MANHANVAT"));
				ns.setType(0);
				ns.setTenSuKien(rs.getString("TENNHANVAT"));
				ns.setNoiDung(rs.getString("NOIDUNG"));
				String noiDung = rs.getString("NOIDUNG");
				if(noiDung.length()>100)
					ns.setNoiDung(rs.getString("NOIDUNG").substring(0, 100));
				else
					ns.setNoiDung(rs.getString("NOIDUNG"));
				listSuKienNhanVatTheoNam.add(ns);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listSuKienNhanVatTheoNam;
	}

	public static void main(String[] args) {
		NhanVatSuKienDAO nv=new NhanVatSuKienDAO();
		nv.getListNhanVat("Bà triệu");
		
		
		
		
		
	}
}
