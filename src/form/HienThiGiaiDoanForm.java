package form;

import java.util.ArrayList;

import model.bean.GiaiDoan;
import model.bean.ThoiKy;

import org.apache.struts.action.ActionForm;

public class HienThiGiaiDoanForm extends ActionForm{
	private int id;
	private ArrayList<GiaiDoan> listGiaiDoan;
	private ArrayList<String> giaiDoan;
	private ThoiKy thoiKy;
	private int maGiaiDoan;
	private String tenGiaiDoan;
	private String namBatDau, namKetThuc;
	private String banDoGIaiDoan;
	private String noiDung;
	private int maThoiKi, maNhanVat;
	private String username;
	public ArrayList<ThoiKy> thoiKi;
	private String action;
	private String submit;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<GiaiDoan> getListGiaiDoan() {
		return listGiaiDoan;
	}

	public void setListGiaiDoan(ArrayList<GiaiDoan> listGiaiDoan) {
		this.listGiaiDoan = listGiaiDoan;
	}

	public ArrayList<String> getGiaiDoan() {
		return giaiDoan;
	}

	public void setGiaiDoan(ArrayList<String> giaiDoan) {
		this.giaiDoan = giaiDoan;
	}

	public ThoiKy getThoiKy() {
		return thoiKy;
	}

	public void setThoiKy(ThoiKy thoiKy) {
		this.thoiKy = thoiKy;
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

	public String getNamBatDau() {
		return namBatDau;
	}

	public void setNamBatDau(String namBatDau) {
		this.namBatDau = namBatDau;
	}

	public String getNamKetThuc() {
		return namKetThuc;
	}

	public void setNamKetThuc(String namKetThuc) {
		this.namKetThuc = namKetThuc;
	}

	public String getBanDoGIaiDoan() {
		return banDoGIaiDoan;
	}

	public void setBanDoGIaiDoan(String banDoGIaiDoan) {
		this.banDoGIaiDoan = banDoGIaiDoan;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public int getMaThoiKi() {
		return maThoiKi;
	}

	public void setMaThoiKi(int maThoiKi) {
		this.maThoiKi = maThoiKi;
	}

	public int getMaNhanVat() {
		return maNhanVat;
	}

	public void setMaNhanVat(int maNhanVat) {
		this.maNhanVat = maNhanVat;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public ArrayList<ThoiKy> getThoiKi() {
		return thoiKi;
	}

	public void setThoiKi(ArrayList<ThoiKy> thoiKi) {
		this.thoiKi = thoiKi;
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

	

	
}
