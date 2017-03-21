/**
 * 
 */
package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Account;
import model.bo.AccountBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.AccountForm;
import form.QuanLyAccountForm;


/**
 * @author HCD-Fresher161
 *
 */
public class SuaAccountAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		AccountForm accountForm = (AccountForm) form;
		
		AccountBO accountBO = new AccountBO();
		
		//sua sinh vien
		String userName = accountForm.getUserName();
		if("submit".equals(accountForm.getSubmit())){					//nhan nut Xac nhan o trang Them sinh vien
			String ten= accountForm.getTen();
			String diaChi= accountForm.getDiaChi();
			String email = accountForm.getEmail();
			String hinhDaiDien = accountForm.getHinhDaiDien();
			int phanQuyen = accountForm.getPhanQuyen();
			accountBO.suaAccount(userName, ten, email, diaChi, phanQuyen, hinhDaiDien);
			return mapping.findForward("suaTKxong");
		} else {														//chuyen sang trang Sua sinh vien
			Account account = accountBO.getThongTinAccount(userName);
			accountForm.setTen(account.getTen());
			accountForm.setDiaChi(account.getDiaChi());
			accountForm.setEmail(account.getEmail());
			accountForm.setPhanQuyen(account.getPhanQuyen());
			accountForm.setHinhDaiDien(account.getHinhDaiDien());
			return mapping.findForward("suaTK");
		}
	}
}
