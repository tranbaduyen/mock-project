/**
 * 
 */
package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.GiaiDoan;
import model.bean.NhanVat;
import model.bean.SuKien;
import model.bean.ThoiKi;
import model.bo.GiaiDoanBO;
import model.bo.NhanVatDongGopBO;
import model.bo.SuKienBO;
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
public class DuyetNhanVatDongGopAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		BaiDongGopForm baiDongGopForm = (BaiDongGopForm) form;
		
		NhanVatDongGopBO nhanVatDongGopBO = new NhanVatDongGopBO();
		
		//lay danh sach cac thoi ki
		ThoiKiBO thoiKiBO = new ThoiKiBO();
		ArrayList<ThoiKi> listThoiKi = thoiKiBO.getListThoiKi();
		baiDongGopForm.setListThoiKi(listThoiKi);
		
		//lay danh sach cac giai doan
		GiaiDoanBO giaiDoanBO = new GiaiDoanBO();
		ArrayList<GiaiDoan> listGiaiDoan = giaiDoanBO.getListGiaiDoan();
		baiDongGopForm.setListGiaiDoan(listGiaiDoan);
		
		//lay danh sach cac su kien
		SuKienBO suKienBO = new SuKienBO();
		ArrayList<SuKien> listSuKien = suKienBO.getListSuKien();
		baiDongGopForm.setListSuKien(listSuKien);
		
		//sua sinh vien
		int maBDNV = baiDongGopForm.getMaBDNV();
		int maNhanVat = baiDongGopForm.getMaNhanVat();
		System.out.println(""+baiDongGopForm.getSubmit());
		if("submit".equals(baiDongGopForm.getSubmit())){					//nhan nut Xac nhan o trang Them sinh vien
			String tenNhanVat= baiDongGopForm.getTenNhanVat();
			String namSinh= baiDongGopForm.getNamSinh();
			String namMat = baiDongGopForm.getNamMat();
			String hinhAnh = baiDongGopForm.getHinhAnh();
			String nguon = baiDongGopForm.getNguon();
			int maThoiKi = baiDongGopForm.getMaThoiKi();
			int maGiaiDoan = baiDongGopForm.getMaGiaiDoan();
			int pheDuyet = baiDongGopForm.getPheDuyet();
			int maSuKien = baiDongGopForm.getMaSuKien();
			nhanVatDongGopBO.duyetNhanVatDongGop(maBDNV, pheDuyet);
			return mapping.findForward("duyetNVxong");
		} else {														//chuyen sang trang Sua sinh vien
			NhanVat nhanVat = nhanVatDongGopBO.getThongTinNhanVat(maBDNV);
			baiDongGopForm.setMaGDNV(nhanVat.getMaGDNV());
			baiDongGopForm.setMaSKNV(nhanVat.getMaSKNV());
			baiDongGopForm.setMaNhanVat(nhanVat.getMaNhanVat());
			baiDongGopForm.setTenNhanVat(nhanVat.getTenNhanVat());
			baiDongGopForm.setNamSinh(nhanVat.getNamSinh());
			baiDongGopForm.setNamMat(nhanVat.getNamMat());
			baiDongGopForm.setTuNgayGDNV(nhanVat.getTuNgayGDNV());
			baiDongGopForm.setDenNgayGDNV(nhanVat.getDenNgayGDNV());
			baiDongGopForm.setTuNgaySKNV(nhanVat.getTuNgaySKNV());
			baiDongGopForm.setDenNgaySKNV(nhanVat.getDenNgaySKNV());
			baiDongGopForm.setMaGiaiDoan(nhanVat.getMaGiaiDoan());
			baiDongGopForm.setMaThoiKi(nhanVat.getMaThoiKi());
			baiDongGopForm.setMaSuKien(nhanVat.getMaSuKien());
			baiDongGopForm.setHinhAnh(nhanVat.getHinhAnh());
			baiDongGopForm.setNoiDung(nhanVat.getNoiDung());
			baiDongGopForm.setNguon(nhanVat.getNguon());
			baiDongGopForm.setPheDuyet(nhanVat.getPheDuyet());
			return mapping.findForward("duyetNV");
		}
	}
}
