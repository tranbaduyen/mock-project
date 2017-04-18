package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.DangKyBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import common.ProcessString;

import form.DangKyForm;

public class DangKyAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		DangKyForm dangKyForm =(DangKyForm) form;
		DangKyBO dangKyBO =new DangKyBO();
		request.setCharacterEncoding("UTF-8");
		if(dangKyForm.getGetSubmit()!=null){
			String hoVaTen= dangKyForm.getHoVaTen();
			String userName=dangKyForm.getUserName();
			String password =dangKyForm.getPassword();
			String rePassword =dangKyForm.getRePassword();
			String email=dangKyForm.getEmail();
			String diaChi=dangKyForm.getDiaChi();
			if("".equals(userName.trim())){
				dangKyForm.setUserNameError("Tên đăng nhập không được bỏ trống");
				return mapping.findForward("failure");
			}else
				if(!ProcessString.checkUserName(userName)){
					dangKyForm.setUserNameError("Tên đăng nhập không được sử dụng ký tự đặc biệt");
					return mapping.findForward("failure");
				}
				else
					if("".equals(password.trim())){
						dangKyForm.setPasswError("Mật khẩu không được bỏ trống");
						return mapping.findForward("failure");
					}
					else
						if(!password.equals(rePassword)){
							dangKyForm.setPasswError("Mật khẩu không trùng khớp");
							return mapping.findForward("failure");
						}else
							if(!ProcessString.checkEmail(email)){
								dangKyForm.setEmailError("Email không đúng vui kiểm tra lại");
								return mapping.findForward("failure");
							}
			if(dangKyBO.checkUserName(userName)==true){
				dangKyForm.setUserNameError("Tên đăng nhập đã tồn tại.");
				return mapping.findForward("failure");
			}
			dangKyBO.insertUser(userName,password,hoVaTen,email,diaChi);
			return mapping.findForward("success");
		}
		return mapping.findForward("failure");
	}
}
