/**
 * 
 */
package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.GiaiDoan;
import model.bean.NhanVat;
import model.bean.SuKien;
import model.bean.ThoiKi;
import model.bo.GiaiDoanBO;
import model.bo.NhanVatDongGopBO;
import model.bo.SuKienBO;
import model.bo.ThoiKiBO;

import com.sun.mail.handlers.message_rfc822;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.BaiDongGopForm;

/**
 * @author HCD-Fresher161
 *
 */
public class DuyetNhanVatDongGopAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		BaiDongGopForm baiDongGopForm = (BaiDongGopForm) form;
		
		NhanVatDongGopBO nhanVatDongGopBO = new NhanVatDongGopBO();
		
		//lay danh sach cac thoi ki
		ThoiKiBO thoiKiBO = new ThoiKiBO();
		ArrayList<ThoiKi> listThoiKi = thoiKiBO.getListThoiKi();
		baiDongGopForm.setListThoiKi(listThoiKi);
		
		//lay danh sach cac giai doan
		GiaiDoanBO giaiDoanBO = new GiaiDoanBO();
		ArrayList<GiaiDoan> listGiaiDoan = giaiDoanBO.getListGiaiDoan();
		baiDongGopForm.setListGiaiDoan(listGiaiDoan);
		
		//lay danh sach cac su kien
		SuKienBO suKienBO = new SuKienBO();
		ArrayList<SuKien> listSuKien = suKienBO.getListSuKien();
		baiDongGopForm.setListSuKien(listSuKien);
		
		final String from = "tranbaduyen1995@gmail.com";
		final String password = "tmhntlccmld";
		String to ;
		final String subject = "Thông báo duyệt bài viết đóng góp";
		final String body = "Bài viết của bạn đã được admin duyệt. Cảm ơn bạn đã đóng góp bài viết cho website !!!";
		Properties properties = new Properties();
		{
		      properties.put("mail.smtp.host", "smtp.gmail.com");
		      properties.put("mail.smtp.socketFactory.port", "465");
		      properties.put("mail.smtp.socketFactory.class",
		                     "javax.net.ssl.SSLSocketFactory");
		      properties.put("mail.smtp.auth", "true");
		      properties.put("mail.smtp.port", "465");
		}
		//sua sinh vien
		int maBDNV = baiDongGopForm.getMaBDNV();
		int maNhanVat = baiDongGopForm.getMaNhanVat();
		System.out.println(""+baiDongGopForm.getSubmit());
		if("submit".equals(baiDongGopForm.getSubmit())){					//nhan nut Xac nhan o trang Them sinh vien
			String tenNhanVat= baiDongGopForm.getTenNhanVat();
			String namSinh= baiDongGopForm.getNamSinh();
			String namMat = baiDongGopForm.getNamMat();
			String hinhAnh = baiDongGopForm.getHinhAnh();
			String nguon = baiDongGopForm.getNguon();
			String email = baiDongGopForm.getEmail();
			int maThoiKi = baiDongGopForm.getMaThoiKi();
			int maGiaiDoan = baiDongGopForm.getMaGiaiDoan();
			int pheDuyet = baiDongGopForm.getPheDuyet();
			int maSuKien = baiDongGopForm.getMaSuKien();
			nhanVatDongGopBO.duyetNhanVatDongGop(maBDNV, pheDuyet);
			String tieuDeEmail = "About confirm your contribution. ";
			String noiDungEmail = "Thank you for your contribution. Administrator has approved your contribution !";
			
			if(pheDuyet==1){
				try {            
			           Email mail = new SimpleEmail();
			 
			           // Cấu hình thông tin Email Server
			           mail.setHostName("smtp.googlemail.com");
			           mail.setSmtpPort(465);
			           mail.setAuthenticator(new DefaultAuthenticator("tranbaduyen1995@gmail.com","tmhntlccmld"));
			            
			           // Với gmail cái này là bắt buộc.
			           mail.setSSLOnConnect(true);
			            
			           // Người gửi
			           mail.setFrom("tranbaduyen1995@gmail.com");
			            
			           // Tiêu đề
			           mail.setSubject(tieuDeEmail);
			            
			           // Nội dung email
			           mail.setMsg(noiDungEmail);
			      
			           // Người nhận
			           mail.addTo(email);            
			           mail.send();
			           System.out.println("Sent to "+email+ " !!!");
			       } catch (Exception e) {
			           e.printStackTrace();
			       }
			} 
			return mapping.findForward("duyetNVxong");
		} else {														//chuyen sang trang Sua sinh vien
			NhanVat nhanVat = nhanVatDongGopBO.getThongTinNhanVat(maBDNV);
			baiDongGopForm.setMaGDNV(nhanVat.getMaGDNV());
			baiDongGopForm.setMaSKNV(nhanVat.getMaSKNV());
			baiDongGopForm.setMaNhanVat(nhanVat.getMaNhanVat());
			baiDongGopForm.setTenNhanVat(nhanVat.getTenNhanVat());
			baiDongGopForm.setNamSinh(nhanVat.getNamSinh());
			baiDongGopForm.setNamMat(nhanVat.getNamMat());
			baiDongGopForm.setTuNgayGDNV(nhanVat.getTuNgayGDNV());
			baiDongGopForm.setDenNgayGDNV(nhanVat.getDenNgayGDNV());
			baiDongGopForm.setTuNgaySKNV(nhanVat.getTuNgaySKNV());
			baiDongGopForm.setDenNgaySKNV(nhanVat.getDenNgaySKNV());
			baiDongGopForm.setMaGiaiDoan(nhanVat.getMaGiaiDoan());
			baiDongGopForm.setMaThoiKi(nhanVat.getMaThoiKi());
			baiDongGopForm.setMaSuKien(nhanVat.getMaSuKien());
			baiDongGopForm.setHinhAnh(nhanVat.getHinhAnh());
			baiDongGopForm.setNoiDung(nhanVat.getNoiDung());
			baiDongGopForm.setNguon(nhanVat.getNguon());
			baiDongGopForm.setPheDuyet(nhanVat.getPheDuyet());
			baiDongGopForm.setEmail(nhanVat.getEmail());
			return mapping.findForward("duyetNV");
		}
	}
}
