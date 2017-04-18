package model.bo;

import java.util.ArrayList;

import model.bean.NhanVat;
import model.bean.NhanVatSuKien;
import model.dao.NhanVatSuKienDAO;

public class NhanVatSuKienBO {
	
	static NhanVatSuKienDAO nhanVatSuKienDAO = new NhanVatSuKienDAO();
	public static ArrayList<NhanVatSuKien> getListSuKienNhanVat(String keyWord) {
		return NhanVatSuKienDAO.getListSuKienNhanVat(keyWord);
	}
	public static ArrayList<NhanVatSuKien> getListNhanVat(String keyWord) {
		return nhanVatSuKienDAO.getListNhanVat(keyWord);
	}
	public static ArrayList<NhanVatSuKien> getListSuKien(String keyWord,
			int maThoiKy) {
		return nhanVatSuKienDAO.getListSuKien(keyWord, maThoiKy);
	}
	public static ArrayList<NhanVatSuKien> getListSuKien(String keyWord,
			int maThoiKy, int maGiaiDoan) {
		return nhanVatSuKienDAO.getListSuKien(keyWord, maThoiKy, maGiaiDoan);
	}
	public static ArrayList<NhanVatSuKien> getListNhanVat(String keyWord,
			int maThoiKy, int maGiaiDoan) {
		return nhanVatSuKienDAO.getListNhanVat(keyWord, maThoiKy, maGiaiDoan);
	}
	public static ArrayList<NhanVatSuKien> getListNhanVat(String keyWord,
			int maThoiKy) {
		return nhanVatSuKienDAO.getListNhanVat(keyWord, maThoiKy);
	}
	public static ArrayList<NhanVatSuKien> getListSuKienNhanVatTheoNam(String keyWord,
			String namBD, String namKT) {
		return nhanVatSuKienDAO.getListSuKienNhanVatTheoNam(keyWord, namBD, namKT);
	}
	public static ArrayList<NhanVatSuKien> getListSuKien(String keyWord) {
		// TODO Auto-generated method stub
		return nhanVatSuKienDAO.getListSuKien(keyWord);
	}

}
