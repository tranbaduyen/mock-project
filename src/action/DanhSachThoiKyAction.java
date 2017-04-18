/**
 * 
 */
package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.ThoiKi;
import model.bo.ThoiKiBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.DanhSachThoiKyForm;

/**
 * @author HCD-Fresher161
 *
 */
public class DanhSachThoiKyAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		DanhSachThoiKyForm danhSachThoiKyForm = (DanhSachThoiKyForm) form;
		
		//lay danh sach thoi ki
		ArrayList<ThoiKi> listThoiKi;
		ThoiKiBO thoiKiBO = new ThoiKiBO();
		
		listThoiKi = thoiKiBO.getListThoiKi();
		
		danhSachThoiKyForm.setListThoiKi(listThoiKi);
		
		return mapping.findForward("dsThoiKy");
	}
}
