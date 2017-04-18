/**
 * 
 */
package model.bo;

import java.util.ArrayList;

import model.bean.NhanVatSuKien;
import model.bean.SuKien;
import model.dao.SuKienDAO;

/**
 * @author HCD-Fresher161
 *
 */
public class SuKienBO {
	SuKienDAO suKienDAO = new SuKienDAO();
	public ArrayList<SuKien> getListSuKien() {
		return suKienDAO.getListSuKien();
	}
	
	public ArrayList<SuKien> getListSuKien(int maGiaiDoan) {
		return suKienDAO.getListSuKien(maGiaiDoan);
	}
	
	public ArrayList<SuKien> getListSuKienTK(int top, int type, int time) {
		// TODO Auto-generated method stub
		return suKienDAO.getListSuKienTK(top, type, time);
	}
	
	public int getTongSoLuotXemSuKienTrongNgay(){
		return suKienDAO.getTongSoLuotXemSuKienTrongNgay();
	}
	public int getTongSoLuotXemSuKienTrongTuan(){
		return suKienDAO.getTongSoLuotXemSuKienTrongTuan();
	}
	public int getTongSoLuotXemSuKienTrongThang(){
		return suKienDAO.getTongSoLuotXemSuKienTrongThang();
	}
	public int getTongSoLuotXemSuKienTrongNam(){
		return suKienDAO.getTongSoLuotXemSuKienTrongNam();
	}
	public int getTongSoLuotXemSuKien(){
		return suKienDAO.getTongSoLuotXemSuKien();
	}
	
	/**
	 * Lấy top sự kiện
	 * @return
	 */
	public ArrayList<SuKien> getTopSuKien() {
		return suKienDAO.getTopSuKien();
	}
	/**
	 * Lấy top sự kiện sắp diễn ra
	 * @param ngayDang
	 * @param ngay
	 * @param thang
	 * @return
	 */
	public ArrayList<SuKien> getTopSuKienSDR(String ngayDang, int ngay, int thang) {
		return suKienDAO.getTopSuKienSDR(ngayDang ,ngay,thang);
	}
	
	/**
	 * Lấy top sự kiện mới cập nhật
	 * @return
	 */
	public ArrayList<SuKien> getTopSuKienMoi() {
		return suKienDAO.getTopSuKienMoi();
	}
	public int checkListSK(int id) {
		return suKienDAO.checkListSK(id);
	}
	public String showListSK(int id, int num) {
		return suKienDAO.showListSK(id, num);
	}
	public ArrayList<NhanVatSuKien> getListSuKienT(int id) {	
		return suKienDAO.getListSuKienT(id);
	}

	
	
	
	
	public void themBaiDang(int maThoiKi1, int maGiaiDoan,
			String mucDongGopTen, String tieuDe, String ngayBatDau,
			String ngayKetThuc, String noiDung, String nguon) {
		suKienDAO.themBaiDang(maThoiKi1, maGiaiDoan, mucDongGopTen, tieuDe, ngayBatDau, ngayKetThuc, noiDung, nguon);
		
	}
	
	
	
}
