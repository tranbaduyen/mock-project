package form;

import java.util.ArrayList;

import model.bean.Account;

import org.apache.struts.action.ActionForm;

public class QuanLyAccountForm extends ActionForm{
	private ArrayList<Account> listAccount;

	/**
	 * @return the listAccount
	 */
	public ArrayList<Account> getListAccount() {
		return listAccount;
	}

	/**
	 * @param listAccount the listAccount to set
	 */
	public void setListAccount(ArrayList<Account> listAccount) {
		this.listAccount = listAccount;
	}

	
}
