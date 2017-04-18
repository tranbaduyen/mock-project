/**
 * 
 */
package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.BinhLuan;
import model.bo.BinhLuanBO;
import model.dao.BinhLuanDAO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.QuanLyBinhLuanForm;

/**
 * @author HCD-Fresher161
 *
 */
public class QuanLyBinhLuanAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		QuanLyBinhLuanForm quanLyBinhLuanForm = (QuanLyBinhLuanForm) form;
		
		ArrayList<BinhLuan> listBinhLuan = null;
		BinhLuanBO binhLuanBO = new BinhLuanBO();
		
		int soLuongBinhLuanChoDuyet = 0;
		
		listBinhLuan = binhLuanBO.getListBinhLuan();
		
		soLuongBinhLuanChoDuyet = BinhLuanDAO.getSoLuongBinhLuanChoDuyet();
		
		try {
			quanLyBinhLuanForm.setListBinhLuan(listBinhLuan);
			quanLyBinhLuanForm.setSoLuongBinhLuanChoDuyet(soLuongBinhLuanChoDuyet);
		} catch (NullPointerException npe) {
			System.out.println("Exception in "+ npe);
		}
		return mapping.findForward("dsBinhLuan");
	}
}
