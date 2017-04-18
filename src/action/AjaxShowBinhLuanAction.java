package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.BinhLuanBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.AjaxShowBinhLuanFrom;

public class AjaxShowBinhLuanAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		AjaxShowBinhLuanFrom ajaxShowBinhLuanFrom =(AjaxShowBinhLuanFrom) form;
		int id= ajaxShowBinhLuanFrom.getId();
		int type=ajaxShowBinhLuanFrom.getType();
		int numComment=ajaxShowBinhLuanFrom.getNumComment();
		String kq="";
		BinhLuanBO binhLuanBO=new BinhLuanBO();
		int soBL=binhLuanBO.countBinhLuan(id, type);
		if(numComment>soBL){
			kq= binhLuanBO.getBinhLuanAjax(id, type, numComment);
		}
		else{ 
			kq= binhLuanBO.getBinhLuanAjax(id, type, numComment)+
			"<span class=\"show-binh-luan\" onclick=\"showBinhLuan("+id+","+type+","+(numComment+10)+");\">Xem thêm</span>";
		}
		response.setContentType("text/text;charset=utf-8");
		response.setHeader("cache-control", "no-cache");
		PrintWriter out = response.getWriter();
		out.println(kq);
		out.flush();
		return null;
	}
}
