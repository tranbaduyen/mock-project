package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.GiaiDoanBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.AjaxNhanVatSuKienForm;

public class AjaxNhanVatSuKienAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			AjaxNhanVatSuKienForm ajaxNhanVatSuKienForm =(AjaxNhanVatSuKienForm) form;
			int nambd= ajaxNhanVatSuKienForm.getId();
			int type = ajaxNhanVatSuKienForm.getType();
			
			int namkt=nambd+50;
			GiaiDoanBO giaiDoanBO =new GiaiDoanBO();
			String kq= giaiDoanBO.getListNVSK(nambd, namkt, type);
			response.setContentType("text/text;charset=utf-8");
			response.setHeader("cache-control", "no-cache");
			PrintWriter out = response.getWriter();
			out.println(kq);
			out.flush();
			return null;
	}
}
