package model.bo;

import java.util.ArrayList;

import model.bean.BinhLuan;
import model.bean.SuKien;
import model.dao.BinhLuanDAO;

public class BinhLuanBO {
	BinhLuanDAO binhLuanDAO = new BinhLuanDAO();

	public int getSoLuongBinhLuanChoDuyet() {
		return binhLuanDAO.getSoLuongBinhLuanChoDuyet();
	}
	public int getSoLuongBinhLuanMoi() {
		return binhLuanDAO.getSoLuongBinhLuanMoi();
	}
	public ArrayList<BinhLuan> getListBinhLuan() {
		// TODO Auto-generated method stub
		return binhLuanDAO.getListBinhLuan();
	}
	public ArrayList<BinhLuan> getListBinhLuanMoi() {
		// TODO Auto-generated method stub
		return binhLuanDAO.getListBinhLuanMoi();
	}

	public BinhLuan getThongTinBinhLuan(int maBinhLuan) {
		return binhLuanDAO.getThongTinBinhLuan(maBinhLuan);
	}

	
	public void duyetBinhLuan(int maBinhLuan, int pheDuyet) {
		// TODO Auto-generated method stub
		System.out.println("pheDuyetBO = "+ pheDuyet);
		System.out.println("maBDSKBO = "+ maBinhLuan);
		binhLuanDAO.duyetBinhLuan(maBinhLuan,pheDuyet);
	}
	
	
	

	/**
	 * Lấy danh sách bình luận
	 * @param id
	 * @param type
	 * @return
	 */
	public ArrayList<BinhLuan> getBinhLuan(int id, int type) {
		return binhLuanDAO.getBinhLuan(id, type);
	}

	/**
	 * Thêm bình luận 
	 * @param id
	 * @param type
	 * @param userName
	 * @param ngayDang
	 * @param noiDung
	 * @param typeUser 
	 */
	public void addBinhLuan(int id, int type,String userName, String ngayDang,
			String noiDung, int typeUser) {
		binhLuanDAO.addBinhLuan(id, type, userName,ngayDang, noiDung, typeUser);
		
	}

	/**
	 * Gọi lớp DAO đếm số bình luận
	 * @param id
	 * @param type
	 * @return
	 */
	public int countBinhLuan(int id, int type) {
		return binhLuanDAO.countBinhLuan(id, type);
	}

	/**
	 * Gọi lớp DAO lấy danh sách bình luận
	 * @param id
	 * @param type
	 * @param numComment
	 * @return
	 */
	public String getBinhLuanAjax(int id, int type, int numComment) {
		return binhLuanDAO.getBinhLuanAjax(id, type, numComment);
	}

	/**
	 * Kiểm tra kiểu user
	 * @param userName
	 * @return
	 */
	public int checkTypeUser(String userName) {
		return binhLuanDAO.checkTypeUser(userName);
	}
	
	
	
	
}	
