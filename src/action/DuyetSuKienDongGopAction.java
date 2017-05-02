/**
 * 
 */
package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.GiaiDoan;
import model.bean.PhanLoaiSuKien;
import model.bean.SuKien;
import model.bean.ThoiKi;
import model.bo.GiaiDoanBO;
import model.bo.PhanLoaiSuKienBO;
import model.bo.SuKienDongGopBO;
import model.bo.ThoiKiBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

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

import form.BaiDongGopForm;

/**
 * @author HCD-Fresher161
 *
 */
public class DuyetSuKienDongGopAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		BaiDongGopForm baiDongGopForm = (BaiDongGopForm) form;
		
		SuKienDongGopBO suKienDongGopBO = new SuKienDongGopBO();
		
		//lay danh sach cac thoi ki
		ThoiKiBO thoiKiBO = new ThoiKiBO();
		ArrayList<ThoiKi> listThoiKi = thoiKiBO.getListThoiKi();
		baiDongGopForm.setListThoiKi(listThoiKi);
		
		//lay danh sach cac giai doan
		GiaiDoanBO giaiDoanBO = new GiaiDoanBO();
		ArrayList<GiaiDoan> listGiaiDoan = giaiDoanBO.getListGiaiDoan();
		baiDongGopForm.setListGiaiDoan(listGiaiDoan);
		
		//lay danh sach cac phan loai
		PhanLoaiSuKienBO phanLoaiSuKienBO = new PhanLoaiSuKienBO();
		ArrayList<PhanLoaiSuKien> listPhanLoaiSuKien = phanLoaiSuKienBO.getListPhanLoaiSuKien();
		baiDongGopForm.setListPhanLoaiSuKien(listPhanLoaiSuKien);
		
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
		//
		int maBDSK = baiDongGopForm.getMaBDSK();
		int maSuKien = baiDongGopForm.getMaSuKien();
		System.out.println(""+baiDongGopForm.getSubmit());
		if("submit".equals(baiDongGopForm.getSubmit())){					
			String tenSuKien= baiDongGopForm.getTenSuKien();
			String ngayBatDau= baiDongGopForm.getNgayBatDau();
			String ngayKetThuc = baiDongGopForm.getNgayKetThuc();
			String hinhAnh = baiDongGopForm.getHinhAnh();
			String nguon = baiDongGopForm.getNguon();
			to = baiDongGopForm.getEmail();
			int maThoiKi = baiDongGopForm.getMaThoiKi();
			int maGiaiDoan = baiDongGopForm.getMaGiaiDoan();
			int pheDuyet = baiDongGopForm.getPheDuyet();
			int maPhanLoai = baiDongGopForm.getMaPhanLoai();
			suKienDongGopBO.duyetSuKienDongGop(maBDSK, pheDuyet);
			if(pheDuyet==1){
				try
			      {
			         Session session = Session.getDefaultInstance(properties,  
			            new javax.mail.Authenticator() {
			            protected PasswordAuthentication 
			            getPasswordAuthentication() {
			            return new 
			            PasswordAuthentication(from, password);
			            }});

			         Message message = new MimeMessage(session);
			         message.setFrom(new InternetAddress(from));
			         message.setRecipients(Message.RecipientType.TO, 
			            InternetAddress.parse(to));
			         message.setSubject(subject);
			         message.setText(body);
			         Transport.send(message);
			         System.out.println("Mess: "+ message.getSubject());
			      }
			      catch(Exception e)
			      {
			         e.printStackTrace();
			      }
			} 
			
			return mapping.findForward("duyetSKxong");
		} else {														
			SuKien suKien = suKienDongGopBO.getThongTinSuKien(maBDSK);
			baiDongGopForm.setMaSuKien(suKien.getMaSuKien());
			baiDongGopForm.setTenSuKien(suKien.getTenSuKien());
			baiDongGopForm.setNgayBatDau(suKien.getNgayBatDau());
			baiDongGopForm.setNgayKetThuc(suKien.getNgayKetThuc());
			baiDongGopForm.setMaGiaiDoan(suKien.getMaGiaiDoan());
			baiDongGopForm.setMaThoiKi(suKien.getMaThoiKi());
			baiDongGopForm.setMaPhanLoai(suKien.getMaPhanLoai());
			baiDongGopForm.setHinhAnh(suKien.getHinhAnh());
			baiDongGopForm.setNoiDung(suKien.getNoiDung());
			baiDongGopForm.setNguon(suKien.getNguon());
			baiDongGopForm.setPheDuyet(suKien.getPheDuyet());
			return mapping.findForward("duyetSK");
		}
	}
}
