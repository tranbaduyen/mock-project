/**
 * 
 */
package form;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import model.bean.ThoiKi;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 * @author HCD-Fresher161
 *
 */
public class ThoiKyForm extends ActionForm{
	private int maThoiKi;
	private String tenThoiKi;
	private String noiDung;
	private String action;
	private String submit;
	private ThoiKi thoiKi;
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
	 * @return the thoiKi
	 */
	public ThoiKi getThoiKi() {
		return thoiKi;
	}
	/**
	 * @param thoiKi the thoiKi to set
	 */
	public void setThoiKi(ThoiKi thoiKi) {
		this.thoiKi = thoiKi;
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
