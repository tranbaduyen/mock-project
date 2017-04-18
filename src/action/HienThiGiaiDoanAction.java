package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.GiaiDoan;
import model.bean.ThoiKy;
import model.bo.GiaiDoanBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.HienThiGiaiDoanForm;

public class HienThiGiaiDoanAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HienThiGiaiDoanForm hienThiGiaiDoan =(HienThiGiaiDoanForm) form;
		
		int id= hienThiGiaiDoan.getId();
		GiaiDoanBO giaiDoanBO=new GiaiDoanBO();
		ArrayList<GiaiDoan> gd = giaiDoanBO.getListGiaiDoanT(id);
		hienThiGiaiDoan.setListGiaiDoan(gd);
		ArrayList<String> gdpage= giaiDoanBO.getPageGiaiDoan(id);
		hienThiGiaiDoan.setGiaiDoan(gdpage);
		ThoiKy thoiKy=giaiDoanBO.getInfoThoiKy(id);
		hienThiGiaiDoan.setThoiKy(thoiKy);
		
		return mapping.findForward("success");
	}

}
