/**
 * 
 */
package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.ThoiKi;
import model.bo.GiaiDoanBO;
import model.bo.ThoiKiBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.GiaiDoanForm;

/**
 * @author HCD-Fresher161
 *
 */
public class ThemGiaiDoanAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		GiaiDoanForm giaiDoanForm = (GiaiDoanForm) form;
		
		//lay danh sach cac thoi ki
		ThoiKiBO thoiKiBO = new ThoiKiBO();
		ArrayList<ThoiKi> listThoiKi = thoiKiBO.getListThoiKi();
		giaiDoanForm.setListThoiKi(listThoiKi);
		
		System.out.println("action = "+giaiDoanForm.getAction());
		System.out.println("submit = "+giaiDoanForm.getSubmit());
		if("submit".equals(giaiDoanForm.getSubmit())){		//nhan nut Xac nhan o trang Them giai doan
			int maThoiKi = giaiDoanForm.getMaThoiKi();
			String tenGiaiDoan = giaiDoanForm.getTenGiaiDoan();
			String ngayBatDau = giaiDoanForm.getNgayBatDau();
			String ngayKetThuc = giaiDoanForm.getNgayKetThuc();
			String noiDung = giaiDoanForm.getNoiDung();
			String banDoGiaiDoan = giaiDoanForm.getBanDoGiaiDoan();
			GiaiDoanBO giaiDoanBO = new GiaiDoanBO();
			giaiDoanBO.themGiaiDoan(tenGiaiDoan, ngayBatDau, ngayKetThuc, noiDung, banDoGiaiDoan, maThoiKi);
			return mapping.findForward("themGDxong");
		} else {											//chuyen sang trang Them giai doan
			return mapping.findForward("themGD");
		}
	}
}
