package form;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class DangKyForm extends ActionForm{

	private String hoVaTen;
	private String userName;
	private String password;
	private String email;
	private String diaChi;
	private String userNameError;
	private String getSubmit;
	private String passwError;
	private String emailError;
	private String rePassword;
	public String getHoVaTen() {
		return hoVaTen;
	}
	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getUserNameError() {
		return userNameError;
	}
	public void setUserNameError(String userNameError) {
		this.userNameError = userNameError;
	}
	public String getGetSubmit() {
		return getSubmit;
	}
	public void setGetSubmit(String getSubmit) {
		this.getSubmit = getSubmit;
	}
	public String getPasswError() {
		return passwError;
	}
	public void setPasswError(String passwError) {
		this.passwError = passwError;
	}
	public String getEmailError() {
		return emailError;
	}
	public void setEmailError(String emailError) {
		this.emailError = emailError;
	}
	public String getRePassword() {
		return rePassword;
	}
	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
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
