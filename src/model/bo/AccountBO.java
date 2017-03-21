/**
 * 
 */
package model.bo;

import java.util.ArrayList;

import model.bean.Account;
import model.dao.AccountDAO;

/**
 * @author HCD-Fresher161
 *
 */
public class AccountBO {
	AccountDAO accountDAO = new AccountDAO();
	
	public ArrayList<Account> getListAccount() {
		return accountDAO.getListAccount();
	}
	public void suaAccount(String userName, String ten, String email, String diaChi, int phanQuyen, String hinhDaiDien) {
		// TODO Auto-generated method stub
		accountDAO.suaAccount(userName, ten, email, diaChi, phanQuyen, hinhDaiDien);
	}
	public Account getThongTinAccount(String userName) {
		return accountDAO.getThongTinAccount(userName);
	}

	public void xoaAccount(String userName) {
		accountDAO.xoaAccount(userName);
	}

}
