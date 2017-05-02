package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.DanhSachNhanVatForm;
import model.bean.NhanVat;
import model.bo.NhanVatBO;

public class DanhSachNhanVatAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		DanhSachNhanVatForm danhSachNhanVatForm = (DanhSachNhanVatForm) form;
		
		ArrayList<NhanVat> listNhanVat;
		NhanVatBO nhanVatBO = new NhanVatBO();
		listNhanVat = nhanVatBO.getListNhanVat();
		
		danhSachNhanVatForm.setListNhanVat(listNhanVat);
		
		return mapping.findForward("dsNhanVat");
	}
}
