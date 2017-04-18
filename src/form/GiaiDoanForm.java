/**
 * 
 */
package form;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import model.bean.GiaiDoan;
import model.bean.ThoiKi;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 * @author HCD-Fresher161
 *
 */
public class GiaiDoanForm extends ActionForm{
	
	private int maGiaiDoan;
	private int maThoiKi;
	private String tenThoiKi;
	private String tenGiaiDoan;
	private String ngayBatDau;
	private String ngayKetThuc;
	private String noiDung;
	private String banDoGiaiDoan;
	private String hinhAnh;
	private String submit;
	private String add;
	private String action;
	
	private ArrayList<ThoiKi> listThoiKi;
	private ArrayList<GiaiDoan> listGiaiDoan;
	
	
	
	/**
	 * @return the listThoiKi
	 */
	public ArrayList<ThoiKi> getListThoiKi() {
		return listThoiKi;
	}



	/**
	 * @param listThoiKi the listThoiKi to set
	 */
	public void setListThoiKi(ArrayList<ThoiKi> listThoiKi) {
		this.listThoiKi = listThoiKi;
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
	 * @return the maThoiKi
	 */
	public int getMaThoiKi() {
		return maThoiKi;
	}



	/**
	 * @param maThoiKi the maThoiKi to set
	 */
	public void setMaThoiKi(int maThoiKi) {
		this.maThoiKi = maThoiKi;
	}



	/**
	 * @return the tenThoiKi
	 */
	public String getTenThoiKi() {
		return tenThoiKi;
	}



	/**
	 * @param tenThoiKi the tenThoiKi to set
	 */
	public void setTenThoiKi(String tenThoiKi) {
		this.tenThoiKi = tenThoiKi;
	}



	/**
	 * @return the tenGiaiDoan
	 */
	public String getTenGiaiDoan() {
		return tenGiaiDoan;
	}



	/**
	 * @param tenGiaiDoan the tenGiaiDoan to set
	 */
	public void setTenGiaiDoan(String tenGiaiDoan) {
		this.tenGiaiDoan = tenGiaiDoan;
	}



	/**
	 * @return the ngayBatDau
	 */
	public String getNgayBatDau() {
		return ngayBatDau;
	}



	/**
	 * @param ngayBatDau the ngayBatDau to set
	 */
	public void setNgayBatDau(String ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}



	/**
	 * @return the ngayKetThuc
	 */
	public String getNgayKetThuc() {
		return ngayKetThuc;
	}



	/**
	 * @param ngayKetThuc the ngayKetThuc to set
	 */
	public void setNgayKetThuc(String ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}



	/**
	 * @return the noiDung
	 */
	public String getNoiDung() {
		return noiDung;
	}



	/**
	 * @param noiDung the noiDung to set
	 */
	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}



	/**
	 * @return the banDoGiaiDoan
	 */
	public String getBanDoGiaiDoan() {
		return banDoGiaiDoan;
	}



	/**
	 * @param banDoGiaiDoan the banDoGiaiDoan to set
	 */
	public void setBanDoGiaiDoan(String banDoGiaiDoan) {
		this.banDoGiaiDoan = banDoGiaiDoan;
	}



	/**
	 * @return the hinhAnh
	 */
	public String getHinhAnh() {
		return hinhAnh;
	}



	/**
	 * @param hinhAnh the hinhAnh to set
	 */
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}



	/**
	 * @return the submit
	 */
	public String getSubmit() {
		return submit;
	}



	/**
	 * @param submit the submit to set
	 */
	public void setSubmit(String submit) {
		this.submit = submit;
	}



	/**
	 * @return the action
	 */
	public String getAction() {
		return action;
	}



	/**
	 * @param action the action to set
	 */
	public void setAction(String action) {
		this.action = action;
	}

	
	
	/**
	 * @return the add
	 */
	public String getAdd() {
		return add;
	}



	/**
	 * @param add the add to set
	 */
	public void setAdd(String add) {
		this.add = add;
	}



	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// TODO Auto-generated method stub
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
