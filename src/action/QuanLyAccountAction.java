/**
 * 
 */
package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.QuanLyAccountForm;

import model.bean.Account;
import model.bo.AccountBO;
import model.dao.AccountDAO;

/**
 * @author HCD-Fresher161
 *
 */
public class QuanLyAccountAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		QuanLyAccountForm quanLyAccountForm = (QuanLyAccountForm) form;
		ArrayList<Account> listAccount = null;
		AccountBO accountBO = new AccountBO();

		
		listAccount = accountBO.getListAccount();
		try {
			quanLyAccountForm.setListAccount(listAccount);
		} catch (NullPointerException npe) {
			System.out.println("Exception in "+ npe);
		}
		return mapping.findForward("dsAccount");
	}
}
