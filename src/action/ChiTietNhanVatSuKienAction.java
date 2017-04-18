package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.BinhLuan;
import model.bean.NhanVatSuKien;
import model.bean.NoiDung;
import model.bo.BinhLuanBO;
import model.bo.DanhGiaBO;
import model.bo.GiaiDoanBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.ChiTietNhanVatSuKienForm;

public class ChiTietNhanVatSuKienAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ChiTietNhanVatSuKienForm chiTietNhanVatSuKienForm = (ChiTietNhanVatSuKienForm) form;
		
		int id= chiTietNhanVatSuKienForm.getId();
		int type= chiTietNhanVatSuKienForm.getType();
		GiaiDoanBO giaiDoanBO=new GiaiDoanBO();
		NhanVatSuKien nhanVatSuKien= giaiDoanBO.getNhanVatSuKien(id, type);
		chiTietNhanVatSuKienForm.setNhanVatSuKien(nhanVatSuKien);
		ArrayList<NoiDung> arrayList= giaiDoanBO.getNoiDung(id, type);
		chiTietNhanVatSuKienForm.setNoiDung(arrayList);
		
		giaiDoanBO.updateLuotXem(id, type);
		BinhLuanBO binhLuanBO =new BinhLuanBO();
		ArrayList<BinhLuan> binhLuan= binhLuanBO.getBinhLuan(id, type);
		chiTietNhanVatSuKienForm.setBinhLuan(binhLuan);
		DanhGiaBO danhGiaBO= new DanhGiaBO();
		
		if(request.getSession(false).getAttribute("userName")==null){
			String diem=danhGiaBO.getDiemTB(id, type);
			chiTietNhanVatSuKienForm.setDanhGia(diem);
		}else{
			String userName=request.getSession(false).getAttribute("userName").toString();
			String diem=danhGiaBO.getDiem(id, type, userName);
			chiTietNhanVatSuKienForm.setDanhGia(diem);
		}
		
		
		int soBinhLuan= binhLuanBO.countBinhLuan(id,type);
		if(soBinhLuan>10){
		chiTietNhanVatSuKienForm.setXemThem("Xem thêm");
		}else
			chiTietNhanVatSuKienForm.setXemThem("");
		return mapping.findForward("success");
	}

}
