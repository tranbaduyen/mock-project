package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.GiaiDoan;
import model.bean.MucDongGop;
import model.bean.SuKien;
import model.bean.ThoiKy;
import model.bo.BaiDangBO;
import model.bo.GiaiDoanBO;
import model.bo.NhanVatBO;
import model.bo.SuKienBO;
import model.bo.ThoiKyBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import common.ProcessString;

import form.BaiDangForm;
import form.HienThiGiaiDoanForm;

public class BaiDangAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
					throws Exception {
		request.setCharacterEncoding("UTF-8");
		BaiDangForm baiDangForm = (BaiDangForm) form;
		
		if(request.getSession(false).getAttribute("userName")==null){
			response.sendRedirect("login.html");
			
		}
		int maThoiKi = baiDangForm.getMaThoiKy();

		ThoiKyBO thoiKyBO = new ThoiKyBO();
		ArrayList<ThoiKy> thoiKy = thoiKyBO.getListThoiKy();
		baiDangForm.setThoiKy(thoiKy);

		GiaiDoanBO giaiDoanBO = new GiaiDoanBO();
		ArrayList<GiaiDoan> giaiDoan = giaiDoanBO.getListGiaiDoanTAM(maThoiKi);
		baiDangForm.setGiaiDoan(giaiDoan);

		ArrayList<MucDongGop> mucDongGopList = new ArrayList<MucDongGop>();
		mucDongGopList.add(new MucDongGop("1", "Nhan Vat"));
		mucDongGopList.add(new MucDongGop("2", "Su Kien"));
		mucDongGopList.add(new MucDongGop("3", "Dia Danh"));



		baiDangForm.setMucDongGopList(mucDongGopList);
		System.out.println(baiDangForm.getGui());
		if("gui".equals(baiDangForm.getGui())){	
			int maThoiKi1 = baiDangForm.getMaThoiKy();
			int maGiaiDoan = baiDangForm.getMaGiaiDoan();
			String mucDongGopTen = baiDangForm.getMucDongGopTen();
			String tieuDe = baiDangForm.getTieuDe();
			String namSinh = baiDangForm.getNamSinh();
			String namMat = baiDangForm.getNamMat();
			String noiDung = baiDangForm.getNoiDung();
			String nguon = baiDangForm.getNguon();
			String ngayBatDau = baiDangForm.getNgayBatDau();
			String ngayKetThuc = baiDangForm.getNgayKetThuc();
			if("".equals(tieuDe.trim())){
				baiDangForm.setTieuDe("Tiêu đề không được bỏ trống");
				return mapping.findForward("baiDang");
			}
			if("".equals(noiDung.trim())){
				baiDangForm.setNoiDungErros("Nội dung không được bỏ trống");
				return mapping.findForward("baiDang");
			}
		
			if(mucDongGopTen.equals(mucDongGopList.get(0).getMucDongGopID())){
				if(!ProcessString.checkDate(namSinh)){
					baiDangForm.setNamSinhErros("Định dạng ngày tháng phải MM-DD-YYYY");
					return mapping.findForward("baiDang");
				}
				if(!ProcessString.checkDate(namMat)){
					baiDangForm.setNamMatErros("Định dạng ngày tháng phải MM-DD-YYYY");
					return mapping.findForward("baiDang");
				}

				if("".equals(nguon.trim())){
					baiDangForm.setNguonErros("Nguồn không được bỏ trống");
					return mapping.findForward("baiDang");

				}

				NhanVatBO nhanVatBO = new NhanVatBO();
				nhanVatBO.themBaiDang(maThoiKi1, maGiaiDoan, mucDongGopTen, tieuDe, namSinh, namMat, noiDung, nguon);
				return mapping.findForward("success");
			}
			if(mucDongGopTen.equals(mucDongGopList.get(1).getMucDongGopID())){

				if(!ProcessString.checkDate(ngayBatDau)){
					baiDangForm.setNgayBatDauErrors("Định dạng ngày tháng phải MM-DD-YYYY");
					return mapping.findForward("baiDang");
				}
				if(!ProcessString.checkDate(ngayKetThuc)){
					baiDangForm.setNgayKetThucErros("Định dạng ngày tháng phải MM-DD-YYYY");
					return mapping.findForward("baiDang");
				}
				SuKienBO suKienBO = new SuKienBO();
				suKienBO.themBaiDang(maThoiKi1, maGiaiDoan, mucDongGopTen, tieuDe, ngayBatDau, ngayKetThuc, noiDung, nguon);
				return mapping.findForward("success");
			}		
		}
		return mapping.findForward("baiDang");
	}

}
