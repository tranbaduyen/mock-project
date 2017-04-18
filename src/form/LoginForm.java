package form;

import org.apache.struts.action.ActionForm;

public class LoginForm extends ActionForm{

	  private String password;
	  private String userName;
	  private String loginError;
	  private String getSubmit;
	  private String url;
	  
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getLoginError() {
		return loginError;
	}
	public void setLoginError(String loginError) {
		this.loginError = loginError;
	}
	public String getGetSubmit() {
		return getSubmit;
	}
	public void setGetSubmit(String getSubmit) {
		this.getSubmit = getSubmit;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	  
	
}
