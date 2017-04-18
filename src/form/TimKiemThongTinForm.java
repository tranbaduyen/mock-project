package form;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import model.bean.GiaiDoan;
import model.bean.MucDongGop;
import model.bean.NhanVat;
import model.bean.NhanVatSuKien;
import model.bean.SuKien;
import model.bean.ThoiKy;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class TimKiemThongTinForm extends ActionForm {
	private ArrayList<NhanVat> nhanVat;
	private ArrayList<ThoiKy> thoiKy;
	private int maThoiKy;
	private String tenThoiKy;
	private String maNhanVat;
	private String hinhAnh;
	private String tenNhanVat;
	private String tenSuKien;

	private String keyWord;
	private String maSuKien;
	private ArrayList<SuKien> suKien;
	private String rdSearch;
	
	private String submit;
	private String timKiem;
	private ArrayList<NhanVatSuKien> nhanVatSuKien;
	
	private String ngayBD;
	private String ngayKT;
	private String thangBD;
	private String thangKT;
	private String namBD;
	private String namKT;
	
	private String tenGiaiDoan;
	private int maGiaiDoan;
	private ArrayList<GiaiDoan> giaiDoan;
	private String keyWordErros;
	private String namBDErros;
	private String namKTErros;

	public String getNamBDErros() {
		return namBDErros;
	}
	public void setNamBDErros(String namBDErros) {
		this.namBDErros = namBDErros;
	}
	public String getNamKTErros() {
		return namKTErros;
	}
	public void setNamKTErros(String namKTErros) {
		this.namKTErros = namKTErros;
	}
	public String getKeyWordErros() {
		return keyWordErros;
	}
	public void setKeyWordErros(String keyWordErros) {
		this.keyWordErros = keyWordErros;
	}
	public String getTenGiaiDoan() {
		return tenGiaiDoan;
	}
	public void setTenGiaiDoan(String tenGiaiDoan) {
		this.tenGiaiDoan = tenGiaiDoan;
	}
	public int getMaGiaiDoan() {
		return maGiaiDoan;
	}
	public void setMaGiaiDoan(int maGiaiDoan) {
		this.maGiaiDoan = maGiaiDoan;
	}
	public ArrayList<GiaiDoan> getGiaiDoan() {
		return giaiDoan;
	}
	public void setGiaiDoan(ArrayList<GiaiDoan> giaiDoan) {
		this.giaiDoan = giaiDoan;
	}
	
	
	public ArrayList<NhanVat> getNhanVat() {
		return nhanVat;
	}
	public void setNhanVat(ArrayList<NhanVat> nhanVat) {
		this.nhanVat = nhanVat;
	}
	public ArrayList<ThoiKy> getThoiKy() {
		return thoiKy;
	}
	public void setThoiKy(ArrayList<ThoiKy> thoiKy) {
		this.thoiKy = thoiKy;
	}
	public int getMaThoiKy() {
		return maThoiKy;
	}
	public void setMaThoiKy(int maThoiKy) {
		this.maThoiKy = maThoiKy;
	}
	public String getTenThoiKy() {
		return tenThoiKy;
	}
	public void setTenThoiKy(String tenThoiKy) {
		this.tenThoiKy = tenThoiKy;
	}
	public String getMaNhanVat() {
		return maNhanVat;
	}
	public void setMaNhanVat(String maNhanVat) {
		this.maNhanVat = maNhanVat;
	}
	public String getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	public String getTenNhanVat() {
		return tenNhanVat;
	}
	public void setTenNhanVat(String tenNhanVat) {
		this.tenNhanVat = tenNhanVat;
	}
	public String getTenSuKien() {
		return tenSuKien;
	}
	public void setTenSuKien(String tenSuKien) {
		this.tenSuKien = tenSuKien;
	}
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	public String getMaSuKien() {
		return maSuKien;
	}
	public void setMaSuKien(String maSuKien) {
		this.maSuKien = maSuKien;
	}
	public ArrayList<SuKien> getSuKien() {
		return suKien;
	}
	public void setSuKien(ArrayList<SuKien> suKien) {
		this.suKien = suKien;
	}
	public String getRdSearch() {
		return rdSearch;
	}
	public void setRdSearch(String rdSearch) {
		this.rdSearch = rdSearch;
	}
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}
	public String getTimKiem() {
		return timKiem;
	}
	public void setTimKiem(String timKiem) {
		this.timKiem = timKiem;
	}
	public ArrayList<NhanVatSuKien> getNhanVatSuKien() {
		return nhanVatSuKien;
	}
	public void setNhanVatSuKien(ArrayList<NhanVatSuKien> nhanVatSuKien) {
		this.nhanVatSuKien = nhanVatSuKien;
	}
	public String getNgayBD() {
		return ngayBD;
	}
	public void setNgayBD(String ngayBD) {
		this.ngayBD = ngayBD;
	}
	public String getNgayKT() {
		return ngayKT;
	}
	public void setNgayKT(String ngayKT) {
		this.ngayKT = ngayKT;
	}
	public String getThangBD() {
		return thangBD;
	}
	public void setThangBD(String thangBD) {
		this.thangBD = thangBD;
	}
	public String getThangKT() {
		return thangKT;
	}
	public void setThangKT(String thangKT) {
		this.thangKT = thangKT;
	}
	public String getNamBD() {
		return namBD;
	}
	public void setNamBD(String namBD) {
		this.namBD = namBD;
	}
	public String getNamKT() {
		return namKT;
	}
	public void setNamKT(String namKT) {
		this.namKT = namKT;
	}
	
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
