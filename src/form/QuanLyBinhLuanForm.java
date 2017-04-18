/**
 * 
 */
package form;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import model.bean.BinhLuan;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 * @author HCD-Fresher161
 *
 */
public class QuanLyBinhLuanForm extends ActionForm{
	private int soLuongBinhLuanChoDuyet;
	
	private ArrayList<BinhLuan> listBinhLuan;

	/**
	 * @return the soLuongBinhLuanChoDuyet
	 */
	public int getSoLuongBinhLuanChoDuyet() {
		return soLuongBinhLuanChoDuyet;
	}

	/**
	 * @param soLuongBinhLuanChoDuyet the soLuongBinhLuanChoDuyet to set
	 */
	public void setSoLuongBinhLuanChoDuyet(int soLuongBinhLuanChoDuyet) {
		this.soLuongBinhLuanChoDuyet = soLuongBinhLuanChoDuyet;
	}

	/**
	 * @return the listBinhLuan
	 */
	public ArrayList<BinhLuan> getListBinhLuan() {
		return listBinhLuan;
	}

	/**
	 * @param listBinhLuan the listBinhLuan to set
	 */
	public void setListBinhLuan(ArrayList<BinhLuan> listBinhLuan) {
		this.listBinhLuan = listBinhLuan;
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
