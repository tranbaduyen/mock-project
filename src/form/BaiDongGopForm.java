/**
 * 
 */
package form;

import java.util.ArrayList;

import model.bean.GiaiDoan;
import model.bean.NhanVat;
import model.bean.NhanVatDongGop;
import model.bean.SuKien;
import model.bean.SuKienDongGop;
import model.bean.ThoiKi;

import org.apache.struts.action.ActionForm;

/**
 * @author HCD-Fresher161
 *
 */
public class BaiDongGopForm extends ActionForm{
	private int maBDSK;
	private int maBDNV;
	private int maSuKien;
	private String tenSuKien;
	private String tenNhanVat;
	private int maNhanVat;
	private String userName;
	private String ngayDang;
	private String ngayBatDau;
	private String ngayKetThuc;
	private String noiDung;
	private String hinhAnh;
	private int maPhanLoai;
	private String tenPhanLoai;
	private String nguon;
	private int pheDuyet;
	private String action;
	private String tenThoiKi;
	private int maThoiKi;
	private int maGiaiDoan;
	private String tenGiaiDoan;
	private ArrayList<ThoiKi> listThoiKi;
	private ArrayList<GiaiDoan> listGiaiDoan;
	private String submitSK;
	private String submitNV;
	private SuKienDongGop suKienDongGop;
	private NhanVatDongGop nhanVatDongGop;
	private SuKien suKien;
	private NhanVat nhanVat;
	/**
	 * @return the maBDSK
	 */
	public int getMaBDSK() {
		return maBDSK;
	}
	/**
	 * @param maBDSK the maBDSK to set
	 */
	public void setMaBDSK(int maBDSK) {
		this.maBDSK = maBDSK;
	}
	/**
	 * @return the maBDNV
	 */
	public int getMaBDNV() {
		return maBDNV;
	}
	/**
	 * @param maBDNV the maBDNV to set
	 */
	public void setMaBDNV(int maBDNV) {
		this.maBDNV = maBDNV;
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
	 * @return the ngayDang
	 */
	public String getNgayDang() {
		return ngayDang;
	}
	/**
	 * @param ngayDang the ngayDang to set
	 */
	public void setNgayDang(String ngayDang) {
		this.ngayDang = ngayDang;
	}
	/**
	 * @return the nguon
	 */
	public String getNguon() {
		return nguon;
	}
	/**
	 * @param nguon the nguon to set
	 */
	public void setNguon(String nguon) {
		this.nguon = nguon;
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
	 * @return the listThoiKi
	 */
	public ArrayList<ThoiKi> getListThoiKi() {
		return listThoiKi;
	}
	/**
	 * @param listThoiKi the listThoiKi to set
	 */
	public void setListThoiKi(ArrayList<ThoiKi> listThoiKi) {
		this.listThoiKi = listThoiKi;
	}
	/**
	 * @return the listGiaiDoan
	 */
	public ArrayList<GiaiDoan> getListGiaiDoan() {
		return listGiaiDoan;
	}
	/**
	 * @param listGiaiDoan the listGiaiDoan to set
	 */
	public void setListGiaiDoan(ArrayList<GiaiDoan> listGiaiDoan) {
		this.listGiaiDoan = listGiaiDoan;
	}
	/**
	 * @return the submitSK
	 */
	public String getSubmitSK() {
		return submitSK;
	}
	/**
	 * @param submitSK the submitSK to set
	 */
	public void setSubmitSK(String submitSK) {
		this.submitSK = submitSK;
	}
	/**
	 * @return the submitNV
	 */
	public String getSubmitNV() {
		return submitNV;
	}
	/**
	 * @param submitNV the submitNV to set
	 */
	public void setSubmitNV(String submitNV) {
		this.submitNV = submitNV;
	}
	/**
	 * @return the suKienDongGop
	 */
	public SuKienDongGop getSuKienDongGop() {
		return suKienDongGop;
	}
	/**
	 * @param suKienDongGop the suKienDongGop to set
	 */
	public void setSuKienDongGop(SuKienDongGop suKienDongGop) {
		this.suKienDongGop = suKienDongGop;
	}
	/**
	 * @return the nhanVatDongGop
	 */
	public NhanVatDongGop getNhanVatDongGop() {
		return nhanVatDongGop;
	}
	/**
	 * @param nhanVatDongGop the nhanVatDongGop to set
	 */
	public void setNhanVatDongGop(NhanVatDongGop nhanVatDongGop) {
		this.nhanVatDongGop = nhanVatDongGop;
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
	/**
	 * @return the tenThoiKi
	 */
	public String getTenThoiKi() {
		return tenThoiKi;
	}
	/**
	 * @param tenThoiKi the tenThoiKi to set
	 */
	public void setTenThoiKi(String tenThoiKi) {
		this.tenThoiKi = tenThoiKi;
	}
	/**
	 * @return the maThoiKi
	 */
	public int getMaThoiKi() {
		return maThoiKi;
	}
	/**
	 * @param maThoiKi the maThoiKi to set
	 */
	public void setMaThoiKi(int maThoiKi) {
		this.maThoiKi = maThoiKi;
	}
	/**
	 * @return the maGiaiDoan
	 */
	public int getMaGiaiDoan() {
		return maGiaiDoan;
	}
	/**
	 * @param maGiaiDoan the maGiaiDoan to set
	 */
	public void setMaGiaiDoan(int maGiaiDoan) {
		this.maGiaiDoan = maGiaiDoan;
	}
	/**
	 * @return the tenGiaiDoan
	 */
	public String getTenGiaiDoan() {
		return tenGiaiDoan;
	}
	/**
	 * @param tenGiaiDoan the tenGiaiDoan to set
	 */
	public void setTenGiaiDoan(String tenGiaiDoan) {
		this.tenGiaiDoan = tenGiaiDoan;
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
	 * @return the ngayBatDau
	 */
	public String getNgayBatDau() {
		return ngayBatDau;
	}
	/**
	 * @param ngayBatDau the ngayBatDau to set
	 */
	public void setNgayBatDau(String ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}
	/**
	 * @return the ngayKetThuc
	 */
	public String getNgayKetThuc() {
		return ngayKetThuc;
	}
	/**
	 * @param ngayKetThuc the ngayKetThuc to set
	 */
	public void setNgayKetThuc(String ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
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
	 * @return the hinhAnh
	 */
	public String getHinhAnh() {
		return hinhAnh;
	}
	/**
	 * @param hinhAnh the hinhAnh to set
	 */
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	/**
	 * @return the maPhanLoai
	 */
	public int getMaPhanLoai() {
		return maPhanLoai;
	}
	/**
	 * @param maPhanLoai the maPhanLoai to set
	 */
	public void setMaPhanLoai(int maPhanLoai) {
		this.maPhanLoai = maPhanLoai;
	}
	/**
	 * @return the tenPhanLoai
	 */
	public String getTenPhanLoai() {
		return tenPhanLoai;
	}
	/**
	 * @param tenPhanLoai the tenPhanLoai to set
	 */
	public void setTenPhanLoai(String tenPhanLoai) {
		this.tenPhanLoai = tenPhanLoai;
	}
	
	
	
	
}
