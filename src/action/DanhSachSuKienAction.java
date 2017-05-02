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

import form.DanhSachSuKienForm;
import model.bean.GiaiDoan;
import model.bean.SuKien;
import model.bo.GiaiDoanBO;
import model.bo.SuKienBO;

/**
 * @author HCD-Fresher161
 *
 */
public class DanhSachSuKienAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		DanhSachSuKienForm danhSachSuKienForm = (DanhSachSuKienForm) form;
		
		//lay danh sach giai doan
		ArrayList<GiaiDoan> listGiaiDoan;
		GiaiDoanBO giaiDoanBO = new GiaiDoanBO();
		listGiaiDoan = giaiDoanBO.getListGiaiDoan();
		danhSachSuKienForm.setListGiaiDoan(listGiaiDoan);
		
		ArrayList<SuKien> listSuKien;
		SuKienBO suKienBO = new SuKienBO();
		int maGiaiDoan = danhSachSuKienForm.getMaGiaiDoan();
		if(maGiaiDoan==0){
			listSuKien = suKienBO.getListSuKien();
		} else {
			listSuKien = suKienBO.getListSuKien(maGiaiDoan);
		}
		danhSachSuKienForm.setListSuKien(listSuKien);
		
		
		return mapping.findForward("dsSuKien");
	}
}
