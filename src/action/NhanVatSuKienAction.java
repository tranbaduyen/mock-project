package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.GiaiDoan;
import model.bean.NhanVatSuKien;
import model.bo.GiaiDoanBO;
import model.bo.NhanVatBO;
import model.bo.SuKienBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.NhanVatSuKienForm;

public class NhanVatSuKienAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		NhanVatSuKienForm nhanVatSuKienForm = (NhanVatSuKienForm) form;
		NhanVatBO nhanVatBO =new NhanVatBO();
		SuKienBO suKienBO =new SuKienBO();
		int id = nhanVatSuKienForm.getId();
		int type=nhanVatSuKienForm.getType();
		if(type==1){
			nhanVatSuKienForm.setTypeName("Sự Kiện");
			ArrayList<NhanVatSuKien> listNVSK= suKienBO.getListSuKienT(id);
			nhanVatSuKienForm.setNhanVatSK(listNVSK);
			if(suKienBO.checkListSK(id)>7){
				nhanVatSuKienForm.setXemThem("Xem tiếp");
				nhanVatSuKienForm.setTatCa("| Tất cả");
			}
			else{
				nhanVatSuKienForm.setXemThem("");
				nhanVatSuKienForm.setTatCa("");
			}
		}

		else{
			nhanVatSuKienForm.setTypeName("Nhân Vật");
			ArrayList<NhanVatSuKien> listNVSK= nhanVatBO.getListNhanVat(id);
			nhanVatSuKienForm.setNhanVatSK(listNVSK);
			if(nhanVatBO.checkListNV(id)>7){
				nhanVatSuKienForm.setXemThem("Xem tiếp");
				nhanVatSuKienForm.setTatCa("| Tất cả");
			}
			else{
				nhanVatSuKienForm.setXemThem("");
				nhanVatSuKienForm.setTatCa("");
			}
		}
		GiaiDoanBO giaiDoanBO = new GiaiDoanBO();


		ArrayList<String> namChiaNho = giaiDoanBO.getNamChiaNho(id, type);
		nhanVatSuKienForm.setNamChiaNho(namChiaNho);
		GiaiDoan giaiDoan = giaiDoanBO.getInfoGiaiDoan(id);
		nhanVatSuKienForm.setGiaiDoan(giaiDoan);
		return mapping.findForward("success");
	}
}
