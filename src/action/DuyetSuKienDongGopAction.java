/**
 * 
 */
package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.GiaiDoan;
import model.bean.SuKien;
import model.bean.ThoiKi;
import model.bo.GiaiDoanBO;
import model.bo.SuKienDongGopBO;
import model.bo.ThoiKiBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.BaiDongGopForm;

/**
 * @author HCD-Fresher161
 *
 */
public class DuyetSuKienDongGopAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		BaiDongGopForm baiDongGopForm = (BaiDongGopForm) form;
		
		SuKienDongGopBO suKienDongGopBO = new SuKienDongGopBO();
		
		//lay danh sach cac thoi ki
		ThoiKiBO thoiKiBO = new ThoiKiBO();
		ArrayList<ThoiKi> listThoiKi = thoiKiBO.getListThoiKi();
		baiDongGopForm.setListThoiKi(listThoiKi);
		
		//lay danh sach cac thoi ki
		GiaiDoanBO giaiDoanBO = new GiaiDoanBO();
		ArrayList<GiaiDoan> listGiaiDoan = giaiDoanBO.getListGiaiDoan();
		baiDongGopForm.setListGiaiDoan(listGiaiDoan);
		
		//sua sinh vien
		int maBDSK = baiDongGopForm.getMaBDSK();
		if("submitSK".equals(baiDongGopForm.getSubmitSK())){					//nhan nut Xac nhan o trang Them sinh vien
			String tenSuKien= baiDongGopForm.getTenSuKien();
			String ngayBatDau= baiDongGopForm.getNgayBatDau();
			String ngayKetThuc = baiDongGopForm.getNgayKetThuc();
			String hinhAnh = baiDongGopForm.getHinhAnh();
			int maThoiKi = baiDongGopForm.getMaThoiKi();
			int maGiaiDoan = baiDongGopForm.getMaGiaiDoan();
			int pheDuyet = baiDongGopForm.getPheDuyet();
			//suKienDongGopBO.duyetSuKienDongGop(maBDSK, maSuKien, userName, ngayDang, nguon, pheDuyet);
			return mapping.findForward("duyetSKxong");
		} else {														//chuyen sang trang Sua sinh vien
			SuKien suKien = suKienDongGopBO.getThongTinSuKien(maSuKien);
			baiDongGopForm.setTen(account.getTen());
			baiDongGopForm.setDiaChi(account.getDiaChi());
			baiDongGopForm.setEmail(account.getEmail());
			baiDongGopForm.setPhanQuyen(account.getPhanQuyen());
			baiDongGopForm.setHinhDaiDien(account.getHinhDaiDien());
			return mapping.findForward("duyetSK");
		}
	}
}
