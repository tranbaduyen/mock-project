package model.bo;

import model.dao.DanhGiaDAO;

public class DanhGiaBO {

	DanhGiaDAO danhGiaDAO =new DanhGiaDAO();
	public void updateDanhGia(int id, int type, String userName, int diem) {
		danhGiaDAO.updateDanhGia(id, type, userName, diem);
		
	}
	public boolean checkDanhGia(int id, int type, String userName) {
		
		return danhGiaDAO.checkDanhGia(id, type, userName);
	}
	public void insertDanhGia(int id, int type, String userName, int diem) {
		danhGiaDAO.insertDanhGia(id, type, userName, diem);
		
	}
	public String getDiemTB(int id, int type) {
		return danhGiaDAO.getDiemTB(id, type);
	}
	public String getDiem(int id, int type, String userName) {
		return danhGiaDAO.getDiem(id, type, userName);
	}

}
