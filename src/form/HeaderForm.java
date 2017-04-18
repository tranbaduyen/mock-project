/**
 * 
 */
package form;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import model.bean.Account;
import model.bean.BinhLuan;
import model.bean.SuKienDongGop;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 * @author HCD-Fresher161
 *
 */
public class HeaderForm extends ActionForm{
	private int soLuongBinhLuanMoi;
	private ArrayList<BinhLuan> listBinhLuanMoi;
	
	private int soLuongDongGopMoi;
	private ArrayList<SuKienDongGop> listDongGopMoi;
	
	private String userName;
	private Account account;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	/**
	 * @return the soLuongBinhLuanMoi
	 */
	public int getSoLuongBinhLuanMoi() {
		return soLuongBinhLuanMoi;
	}
	/**
	 * @param soLuongBinhLuanMoi the soLuongBinhLuanMoi to set
	 */
	public void setSoLuongBinhLuanMoi(int soLuongBinhLuanMoi) {
		this.soLuongBinhLuanMoi = soLuongBinhLuanMoi;
	}
	/**
	 * @return the listBinhLuanMoi
	 */
	public ArrayList<BinhLuan> getListBinhLuanMoi() {
		return listBinhLuanMoi;
	}
	/**
	 * @param listBinhLuanMoi the listBinhLuanMoi to set
	 */
	public void setListBinhLuanMoi(ArrayList<BinhLuan> listBinhLuanMoi) {
		this.listBinhLuanMoi = listBinhLuanMoi;
	}
	/**
	 * @return the soLuongDongGopMoi
	 */
	public int getSoLuongDongGopMoi() {
		return soLuongDongGopMoi;
	}
	/**
	 * @param soLuongDongGopMoi the soLuongDongGopMoi to set
	 */
	public void setSoLuongDongGopMoi(int soLuongDongGopMoi) {
		this.soLuongDongGopMoi = soLuongDongGopMoi;
	}
	/**
	 * @return the listDongGopMoi
	 */
	public ArrayList<SuKienDongGop> getListDongGopMoi() {
		return listDongGopMoi;
	}
	/**
	 * @param listDongGopMoi the listDongGopMoi to set
	 */
	public void setListDongGopMoi(ArrayList<SuKienDongGop> listDongGopMoi) {
		this.listDongGopMoi = listDongGopMoi;
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
