/**
 * 
 */
package model.bo;

import java.util.ArrayList;

import model.bean.SuKien;
import model.bean.SuKienDongGop;
import model.dao.SuKienDongGopDAO;

/**
 * @author HCD-Fresher161
 * 
 */
public class SuKienDongGopBO {
	SuKienDongGopDAO suKienDongGopDAO = new SuKienDongGopDAO();

	public int getSoLuongSuKienMoi() {
		return suKienDongGopDAO.getSoLuongSuKienMoi();
	}
	
	public int getSoLuongSuKienChoDuyet() {
		return suKienDongGopDAO.getSoLuongSuKienChoDuyet();
	}

	public SuKienDongGop getThongTinSuKienDongGop(int maBDSK) {
		return suKienDongGopDAO.getThongTinSuKienDongGop(maBDSK);
	}

	public ArrayList<SuKienDongGop> getListSuKienDongGop() {
		// TODO Auto-generated method stub
		return suKienDongGopDAO.getListSuKienDongGop();
	}
	public ArrayList<SuKienDongGop> getListSuKienMoi() {
		// TODO Auto-generated method stub
		return suKienDongGopDAO.getListSuKienMoi();
	}
	public SuKien getThongTinSuKien(int maBDSK) {
		return suKienDongGopDAO.getThongTinSuKien(maBDSK);
	}

	public void duyetSuKienDongGop(int maBDSK, int maSuKien, String tenSuKien, String ngayBatDau, String ngayKetThuc,
			String hinhAnh, String nguon,String noiDung, int maThoiKi, int maGiaiDoan, int maPhanLoai, int pheDuyet) {
		// TODO Auto-generated method stub
		suKienDongGopDAO.duyetSuKienDongGop(maBDSK, maSuKien, tenSuKien, ngayBatDau, ngayKetThuc, hinhAnh, nguon,
				noiDung,maThoiKi, maGiaiDoan, maPhanLoai, pheDuyet);
	}
	public void duyetSuKienDongGop(int maBDSK, int pheDuyet) {
		// TODO Auto-generated method stub
		System.out.println("pheDuyetBO = "+ pheDuyet);
		System.out.println("maBDSKBO = "+ maBDSK);
		suKienDongGopDAO.duyetSuKienDongGop(maBDSK,pheDuyet);
	}
}
