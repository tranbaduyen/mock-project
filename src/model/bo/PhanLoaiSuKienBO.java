package model.bo;

import java.util.ArrayList;

import model.bean.PhanLoaiSuKien;
import model.dao.PhanLoaiSuKienDAO;

public class PhanLoaiSuKienBO {
	PhanLoaiSuKienDAO phanLoaiSuKienDAO = new PhanLoaiSuKienDAO();
	public ArrayList<PhanLoaiSuKien> getListPhanLoaiSuKien() {
		return phanLoaiSuKienDAO.getListPhanLoaiSuKien();
	}
}
