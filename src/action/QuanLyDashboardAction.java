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
import model.bo.ThongKeBO;
import model.dao.NhanVatDongGopDAO;
import model.dao.SuKienDongGopDAO;
import model.dao.ThongKeDAO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.QuanLyDashboardForm;

/**
 * @author HCD-Fresher161
 *
 */
public class QuanLyDashboardAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		QuanLyDashboardForm quanLyDashboardForm = (QuanLyDashboardForm) form;
		
		ThongKeBO thongKeBO = new ThongKeBO();
		
		int soLuongNguoiDung = 0;
		int soLuongLuotXem = 0;
		int soLuongBaiVietMoi = 0;
		int soLuongBaiViet = 0;
		
		soLuongNguoiDung = thongKeBO.getSoLuongNguoiDung();
		soLuongLuotXem = thongKeBO.getSoLuongLuotXem();
		soLuongBaiVietMoi = thongKeBO.getSoLuongBaiVietMoi();
		soLuongBaiViet = thongKeBO.getSoLuongBaiViet();
		
		try {
			quanLyDashboardForm.setSoLuongNguoiDung(soLuongNguoiDung);
			quanLyDashboardForm.setSoLuongLuotXem(soLuongLuotXem);
			quanLyDashboardForm.setSoLuongBaiVietMoi(soLuongBaiVietMoi);
			quanLyDashboardForm.setSoLuongBaiViet(soLuongBaiViet);
		} catch (NullPointerException npe) {
			System.out.println("Exception in "+ npe);
		}
		return mapping.findForward("qlDashboard");
	}
}
