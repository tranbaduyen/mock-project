package model.bo;

import model.dao.ThongKeDAO;

public class ThongKeBO {
	ThongKeDAO thongKeDAO = new ThongKeDAO();
	
	public int getSoLuongNguoiDung(){
		return thongKeDAO.getSoLuongNguoiDung();
	}
	public int getSoLuongLuotXem(){
		return thongKeDAO.getSoLuongLuotXem();
	}
	public int getSoLuongBaiVietMoi(){
		return thongKeDAO.getSoLuongBaiVietMoi();
	}
	public int getSoLuongBaiViet(){
		return thongKeDAO.getSoLuongBaiViet();
	}
}
