package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bo.DangNhapBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.LoginForm;

public class LoginAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		LoginForm loginForm =(LoginForm) form;
		String userName= loginForm.getUserName();
		String password= loginForm.getPassword();
		String url=loginForm.getUrl();
		DangNhapBO dangNhapBO =new DangNhapBO();
		if(loginForm.getGetSubmit()!=null){
			if(dangNhapBO.checkLogin(userName.trim(), password)){
				HttpSession session = request.getSession();
				session.setAttribute("userName", userName);
				if(dangNhapBO.checkLevel(userName.trim(), password)){
					session.setAttribute("level", userName);
				}
				if(url!=""){
					//url=url.substring(21);
					response.sendRedirect(url);
				}
				else
					return mapping.findForward("success");
			}
			else{
				loginForm.setLoginError("Tên đăng nhập hoặc mật khẩu không chính xác.");
				return mapping.findForward("failure");
			}
		}
		return mapping.findForward("failure");
	}
}
