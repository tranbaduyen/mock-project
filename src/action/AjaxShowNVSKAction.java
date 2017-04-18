package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.NhanVatBO;
import model.bo.SuKienBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.AjaxShowNVSKForm;

public class AjaxShowNVSKAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {

		AjaxShowNVSKForm ajaxShowNVSKForm= (AjaxShowNVSKForm) form;
		int id = ajaxShowNVSKForm.getId();
		int type = ajaxShowNVSKForm.getType();
		int num = ajaxShowNVSKForm.getNumPost();
		String kq="";
		NhanVatBO nhanVatBO =new NhanVatBO();
		SuKienBO suKienBO=new SuKienBO();
		if(type==1){
			if(suKienBO.checkListSK(id)<num){
				kq=suKienBO.showListSK(id,num);
			}
			else{
				kq=suKienBO.showListSK(id,num)+"<span class=\"show-post\" onclick=\"showNVSK("+id+","+type+","+(num+7)+");\">Xem tiếp</span>";
				kq+="<span class=\"show-post\" onclick=\"showNVSK("+id+","+type+","+100000+");\"> | Tất cả</span>";
			}
		}else{
			if(nhanVatBO.checkListNV(id)<num){
				kq=nhanVatBO.showListNV(id, num);
			}
			else{
				kq=nhanVatBO.showListNV(id,num)+"<span class=\"show-post\" onclick=\"showNVSK("+id+","+type+","+(num+7)+");\">Xem tiếp</span>";
				kq+="<span class=\"show-post\" onclick=\"showNVSK("+id+","+type+","+100000+");\"> | Tất cả</span>";
			}
		}
		response.setContentType("text/text;charset=utf-8");
		response.setHeader("cache-control", "no-cache");
		PrintWriter out = response.getWriter();
		out.println(kq);
		out.flush();
		return null;
	}
}
