package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.DanhGiaBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.AjaxDanhGiaFrom;

public class AjaxDanhGiaAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		AjaxDanhGiaFrom ajaxDanhGiaFrom = (AjaxDanhGiaFrom) form;
		int id=ajaxDanhGiaFrom.getId();
		int type=ajaxDanhGiaFrom.getType();
		int diem= Integer.parseInt(ajaxDanhGiaFrom.getRating());
		DanhGiaBO danhGiaBO =new DanhGiaBO();
		String kq="";
		if(request.getSession(false).getAttribute("userName")==null){
			kq="Vui lòng đăng nhập";
		}else{
			String userName=request.getSession(false).getAttribute("userName").toString();
			
			if(danhGiaBO.checkDanhGia(id, type, userName))
				danhGiaBO.updateDanhGia(id, type, userName, diem);
			else
				danhGiaBO.insertDanhGia(id, type, userName, diem);
		}
		response.setContentType("text/text;charset=utf-8");
		response.setHeader("cache-control", "no-cache");
		PrintWriter out = response.getWriter();
		out.println(kq);
		out.flush();
		return null;
	}
}
