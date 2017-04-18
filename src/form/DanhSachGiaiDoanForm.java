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
public class DanhSachGiaiDoanForm extends ActionForm{
	
	private int maThoiKi;
	private ArrayList<ThoiKi> listThoiKi;
	private ArrayList<GiaiDoan> listGiaiDoan;
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
