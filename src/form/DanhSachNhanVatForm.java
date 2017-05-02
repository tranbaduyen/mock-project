/**
 * 
 */
package form;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

import model.bean.GiaiDoan;
import model.bean.NhanVat;
import model.bean.ThoiKy;

/**
 * @author admin
 *
 */
public class DanhSachNhanVatForm extends ActionForm{
	private int maThoiKy;
	private int maGiaiDoan;
	
	private ArrayList<ThoiKy> listThoiKy;
	private ArrayList<GiaiDoan> listGiaiDoan;
	private ArrayList<NhanVat> listNhanVat;
	/**
	 * @return the maThoiKy
	 */
	public int getMaThoiKy() {
		return maThoiKy;
	}
	/**
	 * @param maThoiKy the maThoiKy to set
	 */
	public void setMaThoiKy(int maThoiKy) {
		this.maThoiKy = maThoiKy;
	}
	/**
	 * @return the maGiaiDoan
	 */
	public int getMaGiaiDoan() {
		return maGiaiDoan;
	}
	/**
	 * @param maGiaiDoan the maGiaiDoan to set
	 */
	public void setMaGiaiDoan(int maGiaiDoan) {
		this.maGiaiDoan = maGiaiDoan;
	}
	/**
	 * @return the listThoiKy
	 */
	public ArrayList<ThoiKy> getListThoiKy() {
		return listThoiKy;
	}
	/**
	 * @param listThoiKy the listThoiKy to set
	 */
	public void setListThoiKy(ArrayList<ThoiKy> listThoiKy) {
		this.listThoiKy = listThoiKy;
	}
	/**
	 * @return the listGiaiDoan
	 */
	public ArrayList<GiaiDoan> getListGiaiDoan() {
		return listGiaiDoan;
	}
	/**
	 * @param listGiaiDoan the listGiaiDoan to set
	 */
	public void setListGiaiDoan(ArrayList<GiaiDoan> listGiaiDoan) {
		this.listGiaiDoan = listGiaiDoan;
	}
	/**
	 * @return the listNhanVat
	 */
	public ArrayList<NhanVat> getListNhanVat() {
		return listNhanVat;
	}
	/**
	 * @param listNhanVat the listNhanVat to set
	 */
	public void setListNhanVat(ArrayList<NhanVat> listNhanVat) {
		this.listNhanVat = listNhanVat;
	}
	
	
}
