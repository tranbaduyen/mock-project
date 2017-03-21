/**
 * 
 */
package form;

import java.util.ArrayList;

import model.bean.Account;
import model.bean.NhanVatDongGop;
import model.bean.SuKienDongGop;

/**
 * @author HCD-Fresher161
 *
 */
public class QuanLyDongGopForm extends AccountForm{
	private int soLuongSuKienChoDuyet;
	private int soLuongNhanVatChoDuyet;
	private int soLuongGiaiDoanChoDuyet;
	private int soLuongDiaDanhChoDuyet;
	private int soLuongCauChuyenChoDuyet;
	
	private ArrayList<SuKienDongGop> listSuKienDongGop;
	private ArrayList<NhanVatDongGop> listNhanVatDongGop;
	/**
	 * @return the soLuongSuKienChoDuyet
	 */
	public int getSoLuongSuKienChoDuyet() {
		return soLuongSuKienChoDuyet;
	}

	/**
	 * @param soLuongSuKienChoDuyet the soLuongSuKienChoDuyet to set
	 */
	public void setSoLuongSuKienChoDuyet(int soLuongSuKienChoDuyet) {
		this.soLuongSuKienChoDuyet = soLuongSuKienChoDuyet;
	}

	/**
	 * @return the soLuongNhanVatChoDuyet
	 */
	public int getSoLuongNhanVatChoDuyet() {
		return soLuongNhanVatChoDuyet;
	}

	/**
	 * @param soLuongNhanVatChoDuyet the soLuongNhanVatChoDuyet to set
	 */
	public void setSoLuongNhanVatChoDuyet(int soLuongNhanVatChoDuyet) {
		this.soLuongNhanVatChoDuyet = soLuongNhanVatChoDuyet;
	}

	/**
	 * @return the soLuongGiaiDoanChoDuyet
	 */
	public int getSoLuongGiaiDoanChoDuyet() {
		return soLuongGiaiDoanChoDuyet;
	}

	/**
	 * @param soLuongGiaiDoanChoDuyet the soLuongGiaiDoanChoDuyet to set
	 */
	public void setSoLuongGiaiDoanChoDuyet(int soLuongGiaiDoanChoDuyet) {
		this.soLuongGiaiDoanChoDuyet = soLuongGiaiDoanChoDuyet;
	}

	/**
	 * @return the soLuongDiaDanhChoDuyet
	 */
	public int getSoLuongDiaDanhChoDuyet() {
		return soLuongDiaDanhChoDuyet;
	}

	/**
	 * @param soLuongDiaDanhChoDuyet the soLuongDiaDanhChoDuyet to set
	 */
	public void setSoLuongDiaDanhChoDuyet(int soLuongDiaDanhChoDuyet) {
		this.soLuongDiaDanhChoDuyet = soLuongDiaDanhChoDuyet;
	}

	/**
	 * @return the soLuongCauChuyenChoDuyet
	 */
	public int getSoLuongCauChuyenChoDuyet() {
		return soLuongCauChuyenChoDuyet;
	}

	/**
	 * @param soLuongCauChuyenChoDuyet the soLuongCauChuyenChoDuyet to set
	 */
	public void setSoLuongCauChuyenChoDuyet(int soLuongCauChuyenChoDuyet) {
		this.soLuongCauChuyenChoDuyet = soLuongCauChuyenChoDuyet;
	}

	
	/**
	 * @return the listSuKienDongGopt
	 */
	public ArrayList<SuKienDongGop> getListSuKienDongGop() {
		return listSuKienDongGop;
	}

	/**
	 * @param listSuKienDongGopt the listSuKienDongGopt to set
	 */
	public void setListSuKienDongGop(ArrayList<SuKienDongGop> listSuKienDongGop) {
		this.listSuKienDongGop = listSuKienDongGop;
	}

	/**
	 * @return the listNhanVatDongGop
	 */
	public ArrayList<NhanVatDongGop> getListNhanVatDongGop() {
		return listNhanVatDongGop;
	}

	/**
	 * @param listNhanVatDongGop the listNhanVatDongGop to set
	 */
	public void setListNhanVatDongGop(ArrayList<NhanVatDongGop> listNhanVatDongGop) {
		this.listNhanVatDongGop = listNhanVatDongGop;
	}
	
	

}
