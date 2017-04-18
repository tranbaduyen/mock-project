package form;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import model.bean.GiaiDoan;
import model.bean.MucDongGop;
import model.bean.ThoiKy;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class BaiDangForm extends ActionForm{
	private ArrayList<GiaiDoan> giaiDoan;
	public ArrayList<ThoiKy> thoiKy;
	private String tenThoiKy;
	private int maThoiKy;
	private String action;
	private String submit;
	private String gui;
	
	private int maGiaiDoan;
	private String tenGiaiDoan;
	private String mucDongGopID;
	private String mucDongGopTen;
	private ArrayList<MucDongGop> mucDongGopList;
	private String tieuDe;
	private String noiDung;
	private String nguon;
	private String namSinh;
	private String namMat;
	private String ngayBatDau;
	private String ngayKetThuc;
	private String ngayBatDauErrors;
	private String ngayKetThucErros;
	private String namSinhErros;
	private String namMatErros;
	
	private String tieuDeErros;
	private String nguonErros;
	
	private String noiDungErros;
	
	
	public String getNoiDungErros() {
		return noiDungErros;
	}
	public void setNoiDungErros(String noiDungErros) {
		this.noiDungErros = noiDungErros;
	}
	public String getTieuDeErros() {
		return tieuDeErros;
	}
	public void setTieuDeErros(String tieuDeErros) {
		this.tieuDeErros = tieuDeErros;
	}
	public String getNguonErros() {
		return nguonErros;
	}
	public void setNguonErros(String nguonErros) {
		this.nguonErros = nguonErros;
	}
	public String getNgayBatDauErrors() {
		return ngayBatDauErrors;
	}
	public void setNgayBatDauErrors(String ngayBatDauErrors) {
		this.ngayBatDauErrors = ngayBatDauErrors;
	}
	public String getNgayKetThucErros() {
		return ngayKetThucErros;
	}
	public void setNgayKetThucErros(String ngayKetThucErros) {
		this.ngayKetThucErros = ngayKetThucErros;
	}
	public String getNamSinhErros() {
		return namSinhErros;
	}
	public void setNamSinhErros(String namSinhErros) {
		this.namSinhErros = namSinhErros;
	}
	public String getNamMatErros() {
		return namMatErros;
	}
	public void setNamMatErros(String namMatErros) {
		this.namMatErros = namMatErros;
	}
	public ArrayList<GiaiDoan> getGiaiDoan() {
		return giaiDoan;
	}
	public void setGiaiDoan(ArrayList<GiaiDoan> giaiDoan) {
		this.giaiDoan = giaiDoan;
	}
	public ArrayList<ThoiKy> getThoiKy() {
		return thoiKy;
	}
	public void setThoiKy(ArrayList<ThoiKy> thoiKy) {
		this.thoiKy = thoiKy;
	}
	public String getTenThoiKy() {
		return tenThoiKy;
	}
	public void setTenThoiKy(String tenThoiKy) {
		this.tenThoiKy = tenThoiKy;
	}
	public int getMaThoiKy() {
		return maThoiKy;
	}
	public void setMaThoiKy(int maThoiKy) {
		this.maThoiKy = maThoiKy;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}
	public String getGui() {
		return gui;
	}
	public void setGui(String gui) {
		this.gui = gui;
	}
	public int getMaGiaiDoan() {
		return maGiaiDoan;
	}
	public void setMaGiaiDoan(int maGiaiDoan) {
		this.maGiaiDoan = maGiaiDoan;
	}
	public String getTenGiaiDoan() {
		return tenGiaiDoan;
	}
	public void setTenGiaiDoan(String tenGiaiDoan) {
		this.tenGiaiDoan = tenGiaiDoan;
	}
	public String getMucDongGopID() {
		return mucDongGopID;
	}
	public void setMucDongGopID(String mucDongGopID) {
		this.mucDongGopID = mucDongGopID;
	}
	public String getMucDongGopTen() {
		return mucDongGopTen;
	}
	public void setMucDongGopTen(String mucDongGopTen) {
		this.mucDongGopTen = mucDongGopTen;
	}
	public ArrayList<MucDongGop> getMucDongGopList() {
		return mucDongGopList;
	}
	public void setMucDongGopList(ArrayList<MucDongGop> mucDongGopList) {
		this.mucDongGopList = mucDongGopList;
	}
	public String getTieuDe() {
		return tieuDe;
	}
	public void setTieuDe(String tieuDe) {
		this.tieuDe = tieuDe;
	}
	public String getNoiDung() {
		return noiDung;
	}
	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}
	public String getNguon() {
		return nguon;
	}
	public void setNguon(String nguon) {
		this.nguon = nguon;
	}
	public String getNamSinh() {
		return namSinh;
	}
	public void setNamSinh(String namSinh) {
		this.namSinh = namSinh;
	}
	public String getNamMat() {
		return namMat;
	}
	public void setNamMat(String namMat) {
		this.namMat = namMat;
	}
	public String getNgayBatDau() {
		return ngayBatDau;
	}
	public void setNgayBatDau(String ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}
	public String getNgayKetThuc() {
		return ngayKetThuc;
	}
	public void setNgayKetThuc(String ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
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
