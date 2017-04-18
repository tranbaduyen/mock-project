/**
 * 
 */
package model.bo;

import java.util.ArrayList;

import model.bean.NhanVat;
import model.bean.NhanVatSuKien;
import model.dao.NhanVatDAO;

/**
 * @author HCD-Fresher161
 *
 */
public class NhanVatBO {
	NhanVatDAO nhanVatDAO = new NhanVatDAO();
	public ArrayList<NhanVat> getListNhanVat() {
		return nhanVatDAO.getListNhanVat();
	}
//	public ArrayList<NhanVat> getListNhanVat(int maGiaiDoan) {
//		return nhanVatDAO.getListNhanVat(maGiaiDoan);
//	}
//	public ArrayList<NhanVat> getListNhanVat(int maSuKien) {
//		return nhanVatDAO.getListNhanVat(maSuKien);
//	}
	public ArrayList<NhanVat> getListNhanVaTK(int top, int type) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int getTongSoLuotXemNhanVatTrongNgay(){
		return nhanVatDAO.getTongSoLuotXemNhanVatTrongNgay();
	}
	public int getTongSoLuotXemNhanVatTrongTuan(){
		return nhanVatDAO.getTongSoLuotXemNhanVatTrongTuan();
	}
	public int getTongSoLuotXemNhanVatTrongThang(){
		return nhanVatDAO.getTongSoLuotXemNhanVatTrongThang();
	}
	public int getTongSoLuotXemNhanVatTrongNam(){
		return nhanVatDAO.getTongSoLuotXemNhanVatTrongNam();
	}
	public int getTongSoLuotXemNhanVat(){
		return nhanVatDAO.getTongSoLuotXemNhanVat();
	}
	
	/**
	 * Láº¥y top nhÃ¢n váº­t Ä‘Æ°á»£c xem nhiá»�u nháº¥t
	 * @return
	 */
	public ArrayList<NhanVat> getTopNhanVat() {
		return nhanVatDAO.getTopNhanVat();
	}

	/**
	 * Láº¥y danh sÃ¡ch nhÃ¢n váº­t má»›i cáº­p nháº­t
	 * @return
	 */
	public ArrayList<NhanVat> getNhanVatMoi() {
		return nhanVatDAO.getNhanVatMoi();
	}

	public ArrayList<NhanVatSuKien> getListNhanVat(int id) {
		return nhanVatDAO.getListNhanVat(id);
	}

	public int checkListNV(int id) {
		return nhanVatDAO.checkListNV(id);
	}

	public String showListNV(int id, int num) {
		return nhanVatDAO.showListNV(id, num);
	}
	
	
	public void themBaiDang(int maThoiKi, int maGiaiDoan,
			String mucDongGopTen, String tieuDe, String namSinh, String namMat,
			String noiDung, String nguon) {
		nhanVatDAO.themBaiDang(maThoiKi, maGiaiDoan,mucDongGopTen, tieuDe, namSinh, namMat, noiDung, nguon);
	}
	
}
