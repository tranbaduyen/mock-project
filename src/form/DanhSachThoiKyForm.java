/**
 * 
 */
package form;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import model.bean.ThoiKi;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 * @author HCD-Fresher161
 *
 */
public class DanhSachThoiKyForm extends ActionForm{
	private ArrayList<ThoiKi> listThoiKi;

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
