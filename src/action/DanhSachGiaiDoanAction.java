/**
 * 
 */
package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.GiaiDoan;
import model.bean.ThoiKi;
import model.bo.GiaiDoanBO;
import model.bo.ThoiKiBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.DanhSachGiaiDoanForm;

/**
 * @author HCD-Fresher161
 *
 */
public class DanhSachGiaiDoanAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		DanhSachGiaiDoanForm danhSachGiaiDoanForm = (DanhSachGiaiDoanForm) form;
		
		//lay danh sach cac thoi ki
		ThoiKiBO thoiKiBO = new ThoiKiBO();
		ArrayList<ThoiKi> listThoiKi = thoiKiBO.getListThoiKi();
		danhSachGiaiDoanForm.setListThoiKi(listThoiKi);
		
		//lay danh sach giai doan
		ArrayList<GiaiDoan> listGiaiDoan;
		GiaiDoanBO giaiDoanBO = new GiaiDoanBO();
		int maThoiKi = danhSachGiaiDoanForm.getMaThoiKi();
		if(maThoiKi==0){
			listGiaiDoan = giaiDoanBO.getListGiaiDoan();
		} else {
			listGiaiDoan = giaiDoanBO.getListGiaiDoan(maThoiKi);
		}
		danhSachGiaiDoanForm.setListGiaiDoan(listGiaiDoan);
		
		return mapping.findForward("dsGiaiDoan");
	}
}
