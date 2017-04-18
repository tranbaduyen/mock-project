/**
 * 
 */
package form;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import model.bean.BinhLuan;
import model.bean.NhanVat;
import model.bean.SuKien;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 * @author HCD-Fresher161
 *
 */
public class BinhLuanForm extends ActionForm{
	private int maBinhLuan;
	private String tenBinhLuan;
	private int maSuKien;
	private String tenSuKien;
	private String tenNhanVat;
	private int maNhanVat;
	private String userName;
	private String ten;
	private String ngayBinhLuan;
	private String noiDung;
	private int pheDuyet;
	private int diemDanhGia;
	private String action;
	private ArrayList<SuKien> listSuKien;
	private ArrayList<NhanVat> listNhanVat;
	private String submit;
	private BinhLuan binhLuan;
	private SuKien suKien;
	private NhanVat nhanVat;
	
	/**
	 * @return the ten
	 */
	public String getTen() {
		return ten;
	}
	/**
	 * @param ten the ten to set
	 */
	public void setTen(String ten) {
		this.ten = ten;
	}
	/**
	 * @return the maBinhLuan
	 */
	public int getMaBinhLuan() {
		return maBinhLuan;
	}
	/**
	 * @param maBinhLuan the maBinhLuan to set
	 */
	public void setMaBinhLuan(int maBinhLuan) {
		this.maBinhLuan = maBinhLuan;
	}
	/**
	 * @return the tenBinhLuan
	 */
	public String getTenBinhLuan() {
		return tenBinhLuan;
	}
	/**
	 * @param tenBinhLuan the tenBinhLuan to set
	 */
	public void setTenBinhLuan(String tenBinhLuan) {
		this.tenBinhLuan = tenBinhLuan;
	}
	/**
	 * @return the maSuKien
	 */
	public int getMaSuKien() {
		return maSuKien;
	}
	/**
	 * @param maSuKien the maSuKien to set
	 */
	public void setMaSuKien(int maSuKien) {
		this.maSuKien = maSuKien;
	}
	/**
	 * @return the tenSuKien
	 */
	public String getTenSuKien() {
		return tenSuKien;
	}
	/**
	 * @param tenSuKien the tenSuKien to set
	 */
	public void setTenSuKien(String tenSuKien) {
		this.tenSuKien = tenSuKien;
	}
	/**
	 * @return the tenNhanVat
	 */
	public String getTenNhanVat() {
		return tenNhanVat;
	}
	/**
	 * @param tenNhanVat the tenNhanVat to set
	 */
	public void setTenNhanVat(String tenNhanVat) {
		this.tenNhanVat = tenNhanVat;
	}
	/**
	 * @return the maNhanVat
	 */
	public int getMaNhanVat() {
		return maNhanVat;
	}
	/**
	 * @param maNhanVat the maNhanVat to set
	 */
	public void setMaNhanVat(int maNhanVat) {
		this.maNhanVat = maNhanVat;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the ngayBinhLuan
	 */
	public String getNgayBinhLuan() {
		return ngayBinhLuan;
	}
	/**
	 * @param ngayBinhLuan the ngayBinhLuan to set
	 */
	public void setNgayBinhLuan(String ngayBinhLuan) {
		this.ngayBinhLuan = ngayBinhLuan;
	}
	/**
	 * @return the noiDung
	 */
	public String getNoiDung() {
		return noiDung;
	}
	/**
	 * @param noiDung the noiDung to set
	 */
	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}
	/**
	 * @return the pheDuyet
	 */
	public int getPheDuyet() {
		return pheDuyet;
	}
	/**
	 * @param pheDuyet the pheDuyet to set
	 */
	public void setPheDuyet(int pheDuyet) {
		this.pheDuyet = pheDuyet;
	}
	/**
	 * @return the diemDanhGia
	 */
	public int getDiemDanhGia() {
		return diemDanhGia;
	}
	/**
	 * @param diemDanhGia the diemDanhGia to set
	 */
	public void setDiemDanhGia(int diemDanhGia) {
		this.diemDanhGia = diemDanhGia;
	}
	/**
	 * @return the action
	 */
	public String getAction() {
		return action;
	}
	/**
	 * @param action the action to set
	 */
	public void setAction(String action) {
		this.action = action;
	}
	/**
	 * @return the listSuKien
	 */
	public ArrayList<SuKien> getListSuKien() {
		return listSuKien;
	}
	/**
	 * @param listSuKien the listSuKien to set
	 */
	public void setListSuKien(ArrayList<SuKien> listSuKien) {
		this.listSuKien = listSuKien;
	}
	/**
	 * @return the listNhanVat
	 */
	public ArrayList<NhanVat> getListNhanVat() {
		return listNhanVat;
	}
	/**
	 * @param listNhanVat the listNhanVat to set
	 */
	public void setListNhanVat(ArrayList<NhanVat> listNhanVat) {
		this.listNhanVat = listNhanVat;
	}
	/**
	 * @return the submit
	 */
	public String getSubmit() {
		return submit;
	}
	/**
	 * @param submit the submit to set
	 */
	public void setSubmit(String submit) {
		this.submit = submit;
	}
	/**
	 * @return the binhLuan
	 */
	public BinhLuan getBinhLuan() {
		return binhLuan;
	}
	/**
	 * @param binhLuan the binhLuan to set
	 */
	public void setBinhLuan(BinhLuan binhLuan) {
		this.binhLuan = binhLuan;
	}
	/**
	 * @return the suKien
	 */
	public SuKien getSuKien() {
		return suKien;
	}
	/**
	 * @param suKien the suKien to set
	 */
	public void setSuKien(SuKien suKien) {
		this.suKien = suKien;
	}
	/**
	 * @return the nhanVat
	 */
	public NhanVat getNhanVat() {
		return nhanVat;
	}
	/**
	 * @param nhanVat the nhanVat to set
	 */
	public void setNhanVat(NhanVat nhanVat) {
		this.nhanVat = nhanVat;
	}
	
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// TODO Auto-generated method stub
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
