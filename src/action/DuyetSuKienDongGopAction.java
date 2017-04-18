/**
 * 
 */
package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.GiaiDoan;
import model.bean.PhanLoaiSuKien;
import model.bean.SuKien;
import model.bean.ThoiKi;
import model.bo.GiaiDoanBO;
import model.bo.PhanLoaiSuKienBO;
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
		
		//lay danh sach cac giai doan
		GiaiDoanBO giaiDoanBO = new GiaiDoanBO();
		ArrayList<GiaiDoan> listGiaiDoan = giaiDoanBO.getListGiaiDoan();
		baiDongGopForm.setListGiaiDoan(listGiaiDoan);
		
		//lay danh sach cac phan loai
		PhanLoaiSuKienBO phanLoaiSuKienBO = new PhanLoaiSuKienBO();
		ArrayList<PhanLoaiSuKien> listPhanLoaiSuKien = phanLoaiSuKienBO.getListPhanLoaiSuKien();
		baiDongGopForm.setListPhanLoaiSuKien(listPhanLoaiSuKien);
		
		//sua sinh vien
		int maBDSK = baiDongGopForm.getMaBDSK();
		int maSuKien = baiDongGopForm.getMaSuKien();
		System.out.println(""+baiDongGopForm.getSubmit());
		if("submit".equals(baiDongGopForm.getSubmit())){					//nhan nut Xac nhan o trang Them sinh vien
			String tenSuKien= baiDongGopForm.getTenSuKien();
			String ngayBatDau= baiDongGopForm.getNgayBatDau();
			String ngayKetThuc = baiDongGopForm.getNgayKetThuc();
			String hinhAnh = baiDongGopForm.getHinhAnh();
			String nguon = baiDongGopForm.getNguon();
			int maThoiKi = baiDongGopForm.getMaThoiKi();
			int maGiaiDoan = baiDongGopForm.getMaGiaiDoan();
			int pheDuyet = baiDongGopForm.getPheDuyet();
			int maPhanLoai = baiDongGopForm.getMaPhanLoai();
			suKienDongGopBO.duyetSuKienDongGop(maBDSK, pheDuyet);
			return mapping.findForward("duyetSKxong");
		} else {														//chuyen sang trang Sua sinh vien
			SuKien suKien = suKienDongGopBO.getThongTinSuKien(maBDSK);
			baiDongGopForm.setMaSuKien(suKien.getMaSuKien());
			baiDongGopForm.setTenSuKien(suKien.getTenSuKien());
			baiDongGopForm.setNgayBatDau(suKien.getNgayBatDau());
			baiDongGopForm.setNgayKetThuc(suKien.getNgayKetThuc());
			baiDongGopForm.setMaGiaiDoan(suKien.getMaGiaiDoan());
			baiDongGopForm.setMaThoiKi(suKien.getMaThoiKi());
			baiDongGopForm.setMaPhanLoai(suKien.getMaPhanLoai());
			baiDongGopForm.setHinhAnh(suKien.getHinhAnh());
			baiDongGopForm.setNoiDung(suKien.getNoiDung());
			baiDongGopForm.setNguon(suKien.getNguon());
			baiDongGopForm.setPheDuyet(suKien.getPheDuyet());
			return mapping.findForward("duyetSK");
		}
	}
}
