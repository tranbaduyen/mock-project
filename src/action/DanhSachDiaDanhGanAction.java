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

import form.DanhSachDiaDanhGanForm;
import model.bean.DiaDanh;
import model.bo.DiaDanhBO;

/**
 * @author admin
 *
 */
public class DanhSachDiaDanhGanAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		DanhSachDiaDanhGanForm danhSachDiaDanhGanForm = (DanhSachDiaDanhGanForm) form;
		
		//lay danh sach giai doan
		ArrayList<DiaDanh> listDiaDanh;
		DiaDanhBO diaDanhBO = new DiaDanhBO();
		
		listDiaDanh = diaDanhBO.getListDiaDanhGan();
		
		danhSachDiaDanhGanForm.setListDiaDanhGan(listDiaDanh);
		
		return mapping.findForward("dsDiaDanhGan");
	}
}
