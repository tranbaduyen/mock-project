package action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.bean.NhanVat;
import model.bean.SuKien;
import model.bean.ThoiKy;
import model.bo.NhanVatBO;
import model.bo.SuKienBO;
import model.bo.ThoiKyBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.IndexForm;

public class IndexAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		IndexForm indexForm =(IndexForm) form;
		NhanVatBO nhanVatBO =new NhanVatBO();
		SuKienBO suKienBO =new SuKienBO();
		ThoiKyBO thoiKyBO =new ThoiKyBO();
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		String ngayDang=dateFormat.format(date);
		int ngay=date.getDay();
		int thang =date.getMonth();
		ArrayList<ThoiKy> listThoiKy= thoiKyBO.getListThoiKy();
		ArrayList<NhanVat> listNhanVat=nhanVatBO.getTopNhanVat();
		ArrayList<NhanVat> listNhanVatMoi=nhanVatBO.getNhanVatMoi();
		ArrayList<SuKien> listSuKien=suKienBO.getTopSuKien();
		ArrayList<SuKien> listSuKienSDR=suKienBO.getTopSuKienSDR(ngayDang, ngay, thang);
		ArrayList<SuKien> listSuKienMoi=suKienBO.getTopSuKienMoi();
		indexForm.setThoiKy(listThoiKy);
		indexForm.setNhanVat(listNhanVat);
		indexForm.setSuKien(listSuKien);
		indexForm.setSuKienSapDienRa(listSuKienSDR);
		indexForm.setNhanVatMoi(listNhanVatMoi);
		indexForm.setSuKienMoi(listSuKienMoi);
		return mapping.findForward("success");
	}
}
