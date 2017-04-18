package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.GiaiDoan;
import model.bean.NhanVatSuKien;
import model.bean.ThoiKy;
import model.bo.GiaiDoanBO;
import model.bo.NhanVatSuKienBO;
import model.bo.ThoiKyBO;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.TimKiemThongTinForm;

public class TimKiemThongTinAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		request.setCharacterEncoding("UTF-8");
		TimKiemThongTinForm timKiemThongTinForm = (TimKiemThongTinForm) form;

		int maThoiKy = timKiemThongTinForm.getMaThoiKy();

		//Lấy danh sách thời kì
		ThoiKyBO thoiKyBO = new ThoiKyBO();
		ArrayList<ThoiKy> thoiKy = thoiKyBO.getListThoiKy();
		timKiemThongTinForm.setThoiKy(thoiKy);

		//Lấy danh sách giai đoạn khi chọn mã thời kỳ
		GiaiDoanBO giaiDoanBO = new GiaiDoanBO();
		ArrayList<GiaiDoan> giaiDoan = giaiDoanBO.getListGiaiDoanTheoThoiKy(maThoiKy);
		timKiemThongTinForm.setGiaiDoan(giaiDoan);

		String keyWord = timKiemThongTinForm.getKeyWord();
		String rd=timKiemThongTinForm.getRdSearch();
		int maGiaiDoan = timKiemThongTinForm.getMaGiaiDoan();
		System.out.println("magiaidoan "+ maGiaiDoan);
		String namBD = timKiemThongTinForm.getNamBD();
		String namKT = timKiemThongTinForm.getNamKT();

		if(timKiemThongTinForm.getTimKiem()!=null){
			if("".equals(keyWord.trim())){
				timKiemThongTinForm.setKeyWordErros("Vui lòng nhập kí tự tìm kiếm");
				return mapping.findForward("failure");
			}
			if(keyWord!=null){
				if("0".equals(rd) ){
					// Nếu mã thời kì khác 0 thì
					if(maThoiKy!=0){
						// Nếu mã giai đoạn khác 0 thì in ra danh sách sự kiện theo từ khóa, mã thời kì và mã giai đoạn
						if(maGiaiDoan!=0){
							ArrayList<NhanVatSuKien> lisSuKien = NhanVatSuKienBO.getListSuKien(keyWord, maThoiKy, maGiaiDoan);
							if(lisSuKien.size()==0){
								timKiemThongTinForm.setKeyWord(null);
								return mapping.findForward("timKiemNull");
							}else{
								timKiemThongTinForm.setNhanVatSuKien(lisSuKien);
								timKiemThongTinForm.setKeyWord(null);
								return mapping.findForward("success");
							}

						}
						// Nếu mã giai đoạn = 0 thì in ra danh sách sự kiện theo mã thời kỳ
						else{
							ArrayList<NhanVatSuKien> listSuKien = NhanVatSuKienBO.getListSuKien(keyWord, maThoiKy);
							if(listSuKien.size()==0){
								timKiemThongTinForm.setKeyWord(null);
								return mapping.findForward("timKiemNull");
							}else{
								timKiemThongTinForm.setNhanVatSuKien(listSuKien);
								timKiemThongTinForm.setKeyWord(null);
								return mapping.findForward("success");
							}

						}
						// Nếu mã thời kì = 0  thì in ra danh sách sự kiện theo ký tự được nhập vào
					}else{
						ArrayList<NhanVatSuKien> listSuKien = NhanVatSuKienBO.getListSuKien(keyWord);
						if(listSuKien.size()==0){
							timKiemThongTinForm.setKeyWord(null);
							return mapping.findForward("timKiemNull");
						}else{
							timKiemThongTinForm.setNhanVatSuKien(listSuKien);
							timKiemThongTinForm.setKeyWord(null);
							return mapping.findForward("success");
						}

					}
				}else{
					// Nếu người dùng chọn nhân vật để tìm kiếm
					if("1".equals(rd)){
						// Nếu mã thời kỳ khác 0 thì
						if(maThoiKy!=0){
							// Nếu mã giai đoạn khác 0 thì in ra danh sách nhân vật theo từ khóa, mã thời kỳ và mã giai đoạn
							if(maGiaiDoan!=0){
								ArrayList<NhanVatSuKien> lisNhanVat = NhanVatSuKienBO.getListNhanVat(keyWord, maThoiKy, maGiaiDoan);
								if(lisNhanVat.size()==0){
									timKiemThongTinForm.setKeyWord(null);
									return mapping.findForward("timKiemNull");
								}else{
									timKiemThongTinForm.setNhanVatSuKien(lisNhanVat);
									timKiemThongTinForm.setKeyWord(null);
									return mapping.findForward("success");
								}
							}
							// Nếu mã giai đoạn bằng 0 thì lấy danh sách nhân vật theo thời kì đc chọn
							else{
								ArrayList<NhanVatSuKien> listNhanVat = NhanVatSuKienBO.getListNhanVat(keyWord, maThoiKy);
								if(listNhanVat.size()==0){
									timKiemThongTinForm.setKeyWord(null);
									return mapping.findForward("timKiemNull");
								}else{
									timKiemThongTinForm.setNhanVatSuKien(listNhanVat);
									timKiemThongTinForm.setKeyWord(null);
									return mapping.findForward("success");
								}		

							}
							// Nếu mã thời kì = 0 thì lấy danh sách nhân vật theo ký tự được nhập vào
						}else{
							ArrayList<NhanVatSuKien> listNhanVat= NhanVatSuKienBO.getListNhanVat(keyWord);
							if(listNhanVat.size()==0){
								timKiemThongTinForm.setKeyWord(null);
								return mapping.findForward("timKiemNull");
							}else{
								timKiemThongTinForm.setNhanVatSuKien(listNhanVat);
								timKiemThongTinForm.setKeyWord(null);
								return mapping.findForward("success");
							}

						}
					}
				}
			}
			//Nếu thời gian bắt đầu và thời gian kết thúc rỗng thì in ra danh sách sự kiện và nhân vật theo từ khóa
			if("".equals(namBD.trim()) || "".equals(namKT.trim())){
				ArrayList<NhanVatSuKien> listSuKienNhanVat = NhanVatSuKienBO.getListSuKienNhanVat(keyWord);
				if(listSuKienNhanVat.size()==0){
					timKiemThongTinForm.setKeyWord(null);
					return mapping.findForward("timKiemNull");
				}else{
					timKiemThongTinForm.setNhanVatSuKien(listSuKienNhanVat);
					timKiemThongTinForm.setKeyWord(null);
					return mapping.findForward("success");
				}


			}else{
				int namBDConvert = Integer.parseInt(namBD);
				int namKTConvert = Integer.parseInt(namKT);
				int lenghNamBD = namBD.length();
				int lenghNamKT = namKT.length();
				if(namBDConvert > namKTConvert || (lenghNamBD<4 || lenghNamKT<4)){
					timKiemThongTinForm.setNamBDErros("Thời gian nhập vào phải đủ 4 kí tự và năm kết thúc phải lớn hơn năm bắt đầu");
					return mapping.findForward("failure");
				}else{
					ArrayList<NhanVatSuKien> listNhanVatSuKienTheoNam = NhanVatSuKienBO.getListSuKienNhanVatTheoNam(keyWord, namBD, namKT);
					if(listNhanVatSuKienTheoNam.size()==0){
						timKiemThongTinForm.setKeyWord(null);
						return mapping.findForward("timKiemNull");
					}else{
						timKiemThongTinForm.setNhanVatSuKien(listNhanVatSuKienTheoNam);
						
						return mapping.findForward("success");
					}
				}
			}

		}

		return mapping.findForward("failure");
	}
}
