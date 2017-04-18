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

import form.GiaiDoanForm;

/**
 * @author HCD-Fresher161
 *
 */
public class SuaGiaiDoanAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		GiaiDoanForm giaiDoanForm = (GiaiDoanForm) form;
		
		GiaiDoanBO giaiDoanBO = new GiaiDoanBO();
		
		//lay danh sach cac thoi ki
		ThoiKiBO thoiKiBO = new ThoiKiBO();
		ArrayList<ThoiKi> listThoiKi = thoiKiBO.getListThoiKi();
		giaiDoanForm.setListThoiKi(listThoiKi);
		
		//sua thoi ky
		int maGiaiDoan = giaiDoanForm.getMaThoiKi();
		if("submit".equals(giaiDoanForm.getSubmit())){
			//nhan nut Xac nhan o trang Sua giai doan
			int maThoiKi = giaiDoanForm.getMaThoiKi();
			String tenThoiKi = giaiDoanForm.getTenThoiKi();
			String tenGiaiDoan = giaiDoanForm.getTenGiaiDoan();
			String noiDung = giaiDoanForm.getNoiDung();
			String ngayBatDau = giaiDoanForm.getNgayBatDau();
			String ngayKetThuc = giaiDoanForm.getNgayKetThuc();
			String banDoGiaiDoan = giaiDoanForm.getBanDoGiaiDoan();
			giaiDoanBO.suaGiaiDoan(maGiaiDoan, tenGiaiDoan, ngayBatDau, ngayKetThuc, noiDung, banDoGiaiDoan, maThoiKi);
			return mapping.findForward("suaGDxong");
		} else {														//chuyen sang trang Sua thoi ky
			GiaiDoan giaiDoan = giaiDoanBO.getThongTinGiaiDoan(maGiaiDoan);
			giaiDoanForm.setMaThoiKi(giaiDoan.getMaThoiKi());
			giaiDoanForm.setTenThoiKi(giaiDoan.getTenGiaiDoan());
			giaiDoanForm.setTenThoiKi(giaiDoan.getNgayBatDau());
			giaiDoanForm.setTenThoiKi(giaiDoan.getNgayKetThuc());
			giaiDoanForm.setTenThoiKi(giaiDoan.getBanDoGiaiDoan());
			giaiDoanForm.setTenThoiKi(giaiDoan.getTenThoiKi());
			giaiDoanForm.setNoiDung(giaiDoan.getNoiDung());
			return mapping.findForward("suaGD");
		}
	}
}
