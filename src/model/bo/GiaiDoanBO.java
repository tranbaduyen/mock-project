/**
 * 
 */
package model.bo;

import java.util.ArrayList;

import model.bean.GiaiDoan;
import model.bean.NhanVatSuKien;
import model.bean.NoiDung;
import model.bean.ThoiKi;
import model.bean.ThoiKy;
import model.dao.GiaiDoanDAO;

/**
 * @author HCD-Fresher161
 *
 */
public class GiaiDoanBO {
	GiaiDoanDAO giaiDoanDAO = new GiaiDoanDAO();
	
	public ArrayList<GiaiDoan> getListGiaiDoan (){
		return giaiDoanDAO.getListGiaiDoan();
	}
	
	public ArrayList<GiaiDoan> getListGiaiDoan (int maThoiKi){
		return giaiDoanDAO.getListGiaiDoan(maThoiKi);
	}
	
	public void themGiaiDoan(String tenGiaiDoan,String ngayBatDau,String ngayKetThuc, String noiDung,String banDoGiaiDoan, int maThoiKi) {
		// TODO Auto-generated method stub
		giaiDoanDAO.themGiaiDoan(tenGiaiDoan, ngayBatDau, ngayKetThuc, noiDung, banDoGiaiDoan, maThoiKi);
	}
	
	public void suaGiaiDoan(int maGiaiDoan, String tenGiaiDoan,String ngayBatDau,String ngayKetThuc, String noiDung,String banDoGiaiDoan, int maThoiKi) {
		// TODO Auto-generated method stub
		giaiDoanDAO.suaGiaiDoan(maGiaiDoan, tenGiaiDoan, ngayBatDau, ngayKetThuc, noiDung, banDoGiaiDoan, maThoiKi);
	}

	public GiaiDoan getThongTinGiaiDoan(int maGiaiDoan) {
		// TODO Auto-generated method stub
		return giaiDoanDAO.getThongTinGiaiDoan(maGiaiDoan);
	}
	
	
	

	/**
	 * Lấy danh sách giai đoạn theo mã thời kỳ
	 * @param id
	 * @return
	 */
	public ArrayList<GiaiDoan> getListGiaiDoanT(int id) {
		return giaiDoanDAO.getListGiaiDoanT(id);
	}
	
	/**
	 * Lấy số lượng giai đoạn có trong thời kỳ
	 * @param id
	 * @return
	 */
	public ArrayList<String> getPageGiaiDoan(int id) {
		return giaiDoanDAO.getPageGiaiDoan(id);
	}
	
	/**
	 * Lấy năm chia nhỏ trong giai đoạn
	 * @param id
	 * @param type
	 * @return
	 */
	public ArrayList<String> getNamChiaNho(int id, int type) {
		return giaiDoanDAO.getNamChiaNho(id, type);
	}
	
	/**
	 * Lấy danh sách nhân vật hoặc sự kiện
	 * @param nambd
	 * @param namkt
	 * @param type
	 * @return
	 */
	public String getListNVSK(int nambd, int namkt, int type) {
		
		return giaiDoanDAO.getListNVSK(nambd, namkt, type);
	}
	
	/**
	 * Lấy thông tin giai đoạn
	 * @param id
	 * @return
	 */
	public GiaiDoan getInfoGiaiDoan(int id) {
		return giaiDoanDAO.getInfoGiaiDoan(id);
	}
	
	/**
	 * Lấy thông tin nhân vật hoặc sự kiện
	 * @param id
	 * @param type
	 * @return
	 */
	public NhanVatSuKien getNhanVatSuKien(int id, int type) {
		return giaiDoanDAO.getNhanVatSuKien(id, type);
	}
	
	/**
	 * Lấy nội dung nhân vật hoặc sự kiện
	 * @param id
	 * @param type
	 * @return
	 */
	public ArrayList<NoiDung> getNoiDung(int id, int type) {
		return giaiDoanDAO.getNoiDung(id, type);
	}
	
	/**
	 * Lấy thông tin thời kỳ
	 * @param id
	 * @return
	 */
	public ThoiKy getInfoThoiKy(int id) {
		return giaiDoanDAO.getInfoThoiKy(id);
	}

	/**
	 * Cập nhật lượt xem
	 */
	public void updateLuotXem(int id, int type) {
		giaiDoanDAO.updateLuotXem(id, type);
		
	}
	
	
	
	public ArrayList<GiaiDoan> getListGiaiDoanTAM(int maThoiKi) {
		return giaiDoanDAO.getListGiaiDoanTAM(maThoiKi);
	}
	
	
	public ArrayList<GiaiDoan> getListTenGiaiDoan(int maThoiKy) {
		return giaiDoanDAO.getListTenGiaiDoan(maThoiKy);
	}

	public ArrayList<GiaiDoan> getListGiaiDoanTheoThoiKy(int maThoiKy) {
		return giaiDoanDAO.getListGiaiDoanTheoThoiKy(maThoiKy);
	}
	
	
}
