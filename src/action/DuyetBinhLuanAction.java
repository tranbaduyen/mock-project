/**
 * 
 */
package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.BinhLuan;
import model.bean.NhanVat;
import model.bean.SuKien;
import model.bo.BinhLuanBO;
import model.bo.NhanVatBO;
import model.bo.SuKienBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.BinhLuanForm;

/**
 * @author HCD-Fresher161
 *
 */
public class DuyetBinhLuanAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		BinhLuanForm binhLuanForm = (BinhLuanForm) form;
		
		BinhLuanBO binhLuanBO = new BinhLuanBO();
		
		//lay danh sach cac thoi ki
		SuKienBO suKienBO = new SuKienBO();
		ArrayList<SuKien> listSuKien = suKienBO.getListSuKien();
		binhLuanForm.setListSuKien(listSuKien);
		
		//lay danh sach cac giai doan
		NhanVatBO nhanVatBO = new NhanVatBO();
		ArrayList<NhanVat> listNhanVat = nhanVatBO.getListNhanVat();
		binhLuanForm.setListNhanVat(listNhanVat);
		
		
		//sua sinh vien
		int maBinhLuan = binhLuanForm.getMaBinhLuan();
		System.out.println(""+binhLuanForm.getSubmit());
		if("submit".equals(binhLuanForm.getSubmit())){					//nhan nut Xac nhan o trang Them sinh vien
			int pheDuyet = binhLuanForm.getPheDuyet();
			binhLuanBO.duyetBinhLuan(maBinhLuan, pheDuyet);
			return mapping.findForward("duyetBLxong");
		} else {														//chuyen sang trang Sua sinh vien
			BinhLuan binhLuan = binhLuanBO.getThongTinBinhLuan(maBinhLuan);
			binhLuanForm.setUserName(binhLuan.getUserName());
			binhLuanForm.setTen(binhLuan.getTen());
			binhLuanForm.setMaBinhLuan(binhLuan.getMaBinhLuan());
			binhLuanForm.setTenBinhLuan(binhLuan.getTenBinhLuan());
			binhLuanForm.setNgayBinhLuan(binhLuan.getNgayBinhLuan());
			binhLuanForm.setMaSuKien(binhLuan.getMaSuKien());
			binhLuanForm.setMaNhanVat(binhLuan.getMaNhanVat());
			binhLuanForm.setNoiDung(binhLuan.getNoiDung());
			binhLuanForm.setDiemDanhGia(binhLuan.getDiemDanhGia());
			binhLuanForm.setPheDuyet(binhLuan.getPheDuyet());
			return mapping.findForward("duyetBL");
		}
	}
}
