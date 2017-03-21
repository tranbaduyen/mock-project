/**
 * 
 */
package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.NhanVatDongGop;
import model.bean.SuKienDongGop;
import model.bo.NhanVatDongGopBO;
import model.bo.SuKienDongGopBO;
import model.dao.NhanVatDongGopDAO;
import model.dao.SuKienDongGopDAO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.QuanLyDongGopForm;
/**
 * @author HCD-Fresher161
 *
 */
public class QuanLyDongGopAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		QuanLyDongGopForm quanLyDongGopForm = (QuanLyDongGopForm) form;
		
		ArrayList<SuKienDongGop> listSuKienDongGop = null;
		ArrayList<NhanVatDongGop> listNhanVatDongGop = null;
		SuKienDongGopBO suKienDongGopBO = new SuKienDongGopBO();
		NhanVatDongGopBO nhanVatDongGopBO = new NhanVatDongGopBO();
		
		int soLuongSuKienChoDuyet = 0;
		int soLuongNhanVatChoDuyet = 0;
		
		listSuKienDongGop = suKienDongGopBO.getListSuKienDongGop();
		listNhanVatDongGop = nhanVatDongGopBO.getListNhanVatDongGop();
		
		soLuongSuKienChoDuyet = SuKienDongGopDAO.getSoLuongSuKienChoDuyet();
		soLuongNhanVatChoDuyet = NhanVatDongGopDAO.getSoLuongNhanVatChoDuyet();
		
		try {
			quanLyDongGopForm.setListSuKienDongGop(listSuKienDongGop);
			quanLyDongGopForm.setSoLuongSuKienChoDuyet(soLuongSuKienChoDuyet);
			
			quanLyDongGopForm.setListNhanVatDongGop(listNhanVatDongGop);
			quanLyDongGopForm.setSoLuongNhanVatChoDuyet(soLuongNhanVatChoDuyet);
		} catch (NullPointerException npe) {
			System.out.println("Exception in "+ npe);
		}
		return mapping.findForward("dsDongGop");
	}
}
