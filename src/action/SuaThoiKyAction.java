/**
 * 
 */
package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.ThoiKi;
import model.bo.ThoiKiBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.ThoiKyForm;

/**
 * @author HCD-Fresher161
 *
 */
public class SuaThoiKyAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		ThoiKyForm thoiKyForm = (ThoiKyForm) form;

		ThoiKiBO thoiKiBO = new ThoiKiBO();
		
		//sua thoi ky
		int maThoiKi = thoiKyForm.getMaThoiKi();
		if("submit".equals(thoiKyForm.getSubmit())){					//nhan nut Xac nhan o trang Sua thoi ky
			String tenThoiKi = thoiKyForm.getTenThoiKi();
			String noiDung = thoiKyForm.getNoiDung();
			thoiKiBO.suaThoiKy(maThoiKi, tenThoiKi, noiDung);
			return mapping.findForward("suaTKxong");
		} else {														//chuyen sang trang Sua thoi ky
			ThoiKi thoiKi = thoiKiBO.getThongTinThoiKy(maThoiKi);
			thoiKyForm.setTenThoiKi(thoiKi.getTenThoiKi());
			thoiKyForm.setNoiDung(thoiKi.getNoiDung());
			return mapping.findForward("suaTK");
		}
	}
}
