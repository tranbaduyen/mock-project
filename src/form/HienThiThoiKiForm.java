package form;

import org.apache.struts.action.ActionForm;

public class HienThiThoiKiForm extends ActionForm {
	private int maThoiKy;
	private String tenThoiKy; 
	private String noiDung;
	private String submit;
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	private String action;
	public int getMaThoiKi() {
		return maThoiKy;
	}
	public void setMaThoiKi(int maThoiKi) {
		this.maThoiKy = maThoiKi;
	}
	public String getTenThoiKi() {
		return tenThoiKy;
	}
	public void setTenThoiKi(String tenThoiKi) {
		this.tenThoiKy = tenThoiKi;
	}
	public String getNoiDung() {
		return noiDung;
	}
	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

}
