package form;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import model.bean.Account;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

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
