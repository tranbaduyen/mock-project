/**
 * 
 */
package form;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import model.bean.LuotXemQui;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 * @author HCD-Fresher161
 *
 */
public class QuanLyDashboardForm extends ActionForm{
	private int soLuongNguoiDung;
	private int soLuongLuotXem;
	private int soLuongBaiVietMoi;
	private int soLuongBaiViet;
	
	private ArrayList<LuotXemQui> listLuotXemQui;
	
	
	
	/**
	 * @return the listLuotXemQui
	 */
	public ArrayList<LuotXemQui> getListLuotXemQui() {
		return listLuotXemQui;
	}
	/**
	 * @param listLuotXemQui the listLuotXemQui to set
	 */
	public void setListLuotXemQui(ArrayList<LuotXemQui> listLuotXemQui) {
		this.listLuotXemQui = listLuotXemQui;
	}
	/**
	 * @return the soLuongNguoiDung
	 */
	public int getSoLuongNguoiDung() {
		return soLuongNguoiDung;
	}
	/**
	 * @param soLuongNguoiDung the soLuongNguoiDung to set
	 */
	public void setSoLuongNguoiDung(int soLuongNguoiDung) {
		this.soLuongNguoiDung = soLuongNguoiDung;
	}
	/**
	 * @return the soLuongLuotXem
	 */
	public int getSoLuongLuotXem() {
		return soLuongLuotXem;
	}
	/**
	 * @param soLuongLuotXem the soLuongLuotXem to set
	 */
	public void setSoLuongLuotXem(int soLuongLuotXem) {
		this.soLuongLuotXem = soLuongLuotXem;
	}
	/**
	 * @return the soLuongBaiVietMoi
	 */
	public int getSoLuongBaiVietMoi() {
		return soLuongBaiVietMoi;
	}
	/**
	 * @param soLuongBaiVietMoi the soLuongBaiVietMoi to set
	 */
	public void setSoLuongBaiVietMoi(int soLuongBaiVietMoi) {
		this.soLuongBaiVietMoi = soLuongBaiVietMoi;
	}
	/**
	 * @return the soLuongBaiViet
	 */
	public int getSoLuongBaiViet() {
		return soLuongBaiViet;
	}
	/**
	 * @param soLuongBaiViet the soLuongBaiViet to set
	 */
	public void setSoLuongBaiViet(int soLuongBaiViet) {
		this.soLuongBaiViet = soLuongBaiViet;
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
