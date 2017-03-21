package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Account;
import model.bo.AccountBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.AccountForm;

public class XoaAccountAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		AccountForm accountForm = (AccountForm) form;

		AccountBO accountBO = new AccountBO();
		
		//xoa sinh vien
		String userName=accountForm.getUserName();
		if("submit".equals(accountForm.getSubmit())){			//nhan nut Xac nhan o trang Xoa sinh vien
			accountBO.xoaAccount(userName);
			return mapping.findForward("xoaTKxong");
		} else {													//chuyen sang trang Xoa sinh vien
			Account account = accountBO.getThongTinAccount(userName);
			accountForm.setTen(account.getTen());
			accountForm.setEmail(account.getEmail());
			accountForm.setDiaChi(account.getDiaChi());
			accountForm.setPhanQuyen(account.getPhanQuyen());
			return mapping.findForward("xoaTK");
		}
	}
}
