package action;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.bo.BinhLuanBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.AjaxGuiBinhLuanForm;

public class AjaxGuiBinhLuanAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {

		AjaxGuiBinhLuanForm ajaxGuiBinhLuanForm =(AjaxGuiBinhLuanForm) form;
		String kq="";

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		String ngayDang=dateFormat.format(date);
		int id=ajaxGuiBinhLuanForm.getId();
		int type= ajaxGuiBinhLuanForm.getType();
		String noiDung= ajaxGuiBinhLuanForm.getNoiDung().trim();
		if(request.getSession(false).getAttribute("userName")==null){
			kq="Bạn phải đăng nhập trước khi gửi bình luận.";
		}else{
			if("".equals(noiDung))
				kq="Nội dung không được bỏ trống!";
			else{
				BinhLuanBO binhLuanBO=new BinhLuanBO();
				String userName=request.getSession(false).getAttribute("userName").toString();
				if(binhLuanBO.checkTypeUser(userName)==1){
					binhLuanBO.addBinhLuan(id, type, userName, ngayDang, noiDung,1);
					kq="<script type=\"text/javascript\">showBinhLuan("+id+","+type+", 10)</script>";
				}else{
					kq="Bình luận của bạn sẽ được hiển thị sau khi được người quản trị xác nhận :)";
					binhLuanBO.addBinhLuan(id, type, userName, ngayDang, noiDung, 0);
				}
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
