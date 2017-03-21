/**
 * 
 */
package form;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

import model.bean.Account;



/**
 * @author HCD-Fresher161
 *
 */
public class AccountForm extends ActionForm{
	private String userName;
	private String pass;
	private String ten;
	private String email;
	private int phanQuyen;
	private String diaChi;
	private String hinhDaiDien;
	private String action;
	private String submit;
	private Account account;
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the ten
	 */
	public String getTen() {
		return ten;
	}
	/**
	 * @param ten the ten to set
	 */
	public void setTen(String ten) {
		this.ten = ten;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the phanQuyen
	 */
	public int getPhanQuyen() {
		return phanQuyen;
	}
	/**
	 * @param phanQuyen the phanQuyen to set
	 */
	public void setPhanQuyen(int phanQuyen) {
		this.phanQuyen = phanQuyen;
	}
	/**
	 * @return the diaChi
	 */
	public String getDiaChi() {
		return diaChi;
	}
	/**
	 * @param diaChi the diaChi to set
	 */
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
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
	 * @return the account
	 */
	public Account getAccount() {
		return account;
	}
	/**
	 * @param account the account to set
	 */
	public void setAccount(Account account) {
		this.account = account;
	}
	/**
	 * @return the pass
	 */
	public String getPass() {
		return pass;
	}
	/**
	 * @param pass the pass to set
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}
	/**
	 * @return the hinhDaiDien
	 */
	public String getHinhDaiDien() {
		return hinhDaiDien;
	}
	/**
	 * @param hinhDaiDien the hinhDaiDien to set
	 */
	public void setHinhDaiDien(String hinhDaiDien) {
		this.hinhDaiDien = hinhDaiDien;
	}
	
	
}
