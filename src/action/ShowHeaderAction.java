/**
 * 
 */
package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Account;
import model.bean.BinhLuan;
import model.bean.SuKienDongGop;
import model.bo.AccountBO;
import model.bo.BinhLuanBO;
import model.bo.SuKienDongGopBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.HeaderForm;

/**
 * @author HCD-Fresher161
 *
 */
public class ShowHeaderAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		HeaderForm headerForm = (HeaderForm) form;
		
		
		if(request.getSession(false).getAttribute("userName")!=null && request.getSession(false).getAttribute("level")!=null){
			String userName=request.getSession(false).getAttribute("userName").toString();
		
		AccountBO accountBO =new AccountBO();
		Account account =  accountBO.getThongTinAccount(userName);
		
		headerForm.setAccount(account);
		
		ArrayList<BinhLuan> listBinhLuanMoi = null;
		BinhLuanBO binhLuanBO = new BinhLuanBO();
		
		ArrayList<SuKienDongGop> listSuKienMoi = null;
		SuKienDongGopBO suKienDongGopBO = new SuKienDongGopBO();
		
		int soLuongBinhLuanMoi = 0;
		int soLuongDongGopMoi = 0;
		
		soLuongBinhLuanMoi = binhLuanBO.getSoLuongBinhLuanMoi();
		listBinhLuanMoi = binhLuanBO.getListBinhLuanMoi();
		
		soLuongDongGopMoi = suKienDongGopBO.getSoLuongSuKienMoi();
		listSuKienMoi = suKienDongGopBO.getListSuKienMoi();
		
		try {
			headerForm.setSoLuongBinhLuanMoi(soLuongBinhLuanMoi);
			headerForm.setListBinhLuanMoi(listBinhLuanMoi);
			
			headerForm.setSoLuongDongGopMoi(soLuongDongGopMoi);
			headerForm.setListDongGopMoi(listSuKienMoi);
		} catch (NullPointerException npe) {
			System.out.println("Exception in "+ npe);
		}
		return mapping.findForward("showHeader");
		}
		else{
			 response.sendRedirect("index.html"); 
		}
		return mapping.findForward("showHeader");
	}
	
}

