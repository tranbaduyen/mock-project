package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.NhanVat;
import model.bean.SuKien;
import model.bo.NhanVatBO;
import model.bo.SuKienBO;
import model.dao.NhanVatDongGopDAO;
import model.dao.SuKienDAO;
import model.dao.SuKienDongGopDAO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.ThongKeForm;

public class ThongKeAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		ThongKeForm thongKeForm = (ThongKeForm) form;
		
		ArrayList<SuKien> listSuKienTKNgay = null;
		ArrayList<SuKien> listSuKienTKTuan = null;
		ArrayList<SuKien> listSuKienTKThang = null;
		ArrayList<SuKien> listSuKienTKNam = null;
		ArrayList<SuKien> listSuKienTK = null;
		
		ArrayList<NhanVat> listNhanVatTK = null;
		SuKienBO suKienBO = new SuKienBO();
		NhanVatBO nhanVatBO = new NhanVatBO();
		
		int top = 5;
		int type = 0;
		
		int tongSoLuotXemSuKien = 0;
		int tongSoLuotXemSuKienTrongNgay = 0;
		int tongSoLuotXemSuKienTrongTuan = 0;
		int tongSoLuotXemSuKienTrongThang = 0;
		int tongSoLuotXemSuKienTrongNam = 0;
		
		int tongSoLuotXemNhanVat = 0;
		int tongSoLuotXemNhanVatTrongNgay = 0;
		int tongSoLuotXemNhanVatTrongTuan = 0;
		int tongSoLuotXemNhanVatTrongThang = 0;
		int tongSoLuotXemNhanVatTrongNam = 0;
		
		if(type==0){	
			listSuKienTKNgay = suKienBO.getListSuKienTK(top, type, 0);
			listSuKienTKTuan = suKienBO.getListSuKienTK(top, type, 1);
			listSuKienTKThang = suKienBO.getListSuKienTK(top, type, 2);
			listSuKienTKNam = suKienBO.getListSuKienTK(top, type, 3);
			listSuKienTK = suKienBO.getListSuKienTK(top, type, 4);
			
			tongSoLuotXemSuKienTrongNgay = suKienBO.getTongSoLuotXemSuKienTrongNgay();
			tongSoLuotXemSuKienTrongTuan = suKienBO.getTongSoLuotXemSuKienTrongTuan();
			tongSoLuotXemSuKienTrongThang = suKienBO.getTongSoLuotXemSuKienTrongThang();
			tongSoLuotXemSuKienTrongNam = suKienBO.getTongSoLuotXemSuKienTrongNam();
			tongSoLuotXemSuKien = suKienBO.getTongSoLuotXemSuKien();
			
			tongSoLuotXemNhanVatTrongNgay = nhanVatBO.getTongSoLuotXemNhanVatTrongNgay();
			tongSoLuotXemNhanVatTrongTuan = nhanVatBO.getTongSoLuotXemNhanVatTrongTuan();
			tongSoLuotXemNhanVatTrongThang = nhanVatBO.getTongSoLuotXemNhanVatTrongThang();
			tongSoLuotXemNhanVatTrongNam = nhanVatBO.getTongSoLuotXemNhanVatTrongNam();
			tongSoLuotXemNhanVat = nhanVatBO.getTongSoLuotXemNhanVat();
	
			try {
				thongKeForm.setListSuKienTKNgay(listSuKienTKNgay);
				thongKeForm.setListSuKienTKTuan(listSuKienTKTuan);
				thongKeForm.setListSuKienTKThang(listSuKienTKThang);
				thongKeForm.setListSuKienTKNam(listSuKienTKNam);
				thongKeForm.setListSuKienTK(listSuKienTK);
				thongKeForm.setTongSoLuotXemSuKienTrongNgay(tongSoLuotXemSuKienTrongNgay);
				thongKeForm.setTongSoLuotXemSuKienTrongTuan(tongSoLuotXemSuKienTrongTuan);
				thongKeForm.setTongSoLuotXemSuKienTrongThang(tongSoLuotXemSuKienTrongThang);
				thongKeForm.setTongSoLuotXemSuKienTrongNam(tongSoLuotXemSuKienTrongNam);
				thongKeForm.setTongSoLuotXemSuKien(tongSoLuotXemSuKien);
				
				thongKeForm.setTongSoLuotXemNhanVatTrongNgay(tongSoLuotXemNhanVatTrongNgay);
				thongKeForm.setTongSoLuotXemNhanVatTrongTuan(tongSoLuotXemNhanVatTrongTuan);
				thongKeForm.setTongSoLuotXemNhanVatTrongThang(tongSoLuotXemNhanVatTrongThang);
				thongKeForm.setTongSoLuotXemNhanVatTrongNam(tongSoLuotXemNhanVatTrongNam);
				thongKeForm.setTongSoLuotXemNhanVat(tongSoLuotXemNhanVat);
			} catch (NullPointerException npe) {
				System.out.println("Exception in "+ npe);
			}
		}
		else {
			listSuKienTKNgay = suKienBO.getListSuKienTK(top, type, 0);
			listSuKienTKTuan = suKienBO.getListSuKienTK(top, type, 1);
			listSuKienTKThang = suKienBO.getListSuKienTK(top, type, 2);
			listSuKienTKNam = suKienBO.getListSuKienTK(top, type, 3);
			listSuKienTK = suKienBO.getListSuKienTK(top, type, 4);
			
			tongSoLuotXemNhanVatTrongNgay = nhanVatBO.getTongSoLuotXemNhanVatTrongNgay();
			tongSoLuotXemNhanVatTrongTuan = nhanVatBO.getTongSoLuotXemNhanVatTrongTuan();
			tongSoLuotXemNhanVatTrongThang = nhanVatBO.getTongSoLuotXemNhanVatTrongThang();
			tongSoLuotXemNhanVatTrongNam = nhanVatBO.getTongSoLuotXemNhanVatTrongNam();
			tongSoLuotXemNhanVat = nhanVatBO.getTongSoLuotXemNhanVat();
			//listNhanVatTK = nhanVatBO.getListNhanVaTK(top, type, time);
	
			try {
				thongKeForm.setListSuKienTKNgay(listSuKienTKNgay);
				thongKeForm.setListSuKienTKTuan(listSuKienTKTuan);
				thongKeForm.setListSuKienTKThang(listSuKienTKThang);
				thongKeForm.setListSuKienTKNam(listSuKienTKNam);
				thongKeForm.setListSuKienTK(listSuKienTK);
				thongKeForm.setTongSoLuotXemNhanVatTrongNgay(tongSoLuotXemNhanVatTrongNgay);
				thongKeForm.setTongSoLuotXemNhanVatTrongTuan(tongSoLuotXemNhanVatTrongTuan);
				thongKeForm.setTongSoLuotXemNhanVatTrongThang(tongSoLuotXemNhanVatTrongThang);
				thongKeForm.setTongSoLuotXemNhanVatTrongNam(tongSoLuotXemNhanVatTrongNam);
				thongKeForm.setTongSoLuotXemNhanVat(tongSoLuotXemNhanVat);
				
			} catch (NullPointerException npe) {
				System.out.println("Exception in "+ npe);
			}
		}
		return mapping.findForward("dsThongKe");
	}
}
