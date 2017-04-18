package form;

import java.util.ArrayList;

import model.bean.NhanVat;
import model.bean.SuKien;
import model.bean.ThoiKy;

import org.apache.struts.action.ActionForm;

public class IndexForm extends ActionForm{

	private ArrayList<ThoiKy> thoiKy;
	private ArrayList<NhanVat> nhanVat;
	private ArrayList<NhanVat> nhanVatMoi;
	private ArrayList<SuKien> suKien;
	private ArrayList<SuKien> suKienSapDienRa;
	private ArrayList<SuKien> suKienMoi;
	
	
	
	public ArrayList<ThoiKy> getThoiKy() {
		return thoiKy;
	}
	public void setThoiKy(ArrayList<ThoiKy> thoiKy) {
		this.thoiKy = thoiKy;
	}
	public ArrayList<NhanVat> getNhanVat() {
		return nhanVat;
	}
	public void setNhanVat(ArrayList<NhanVat> nhanVat) {
		this.nhanVat = nhanVat;
	}
	public ArrayList<SuKien> getSuKien() {
		return suKien;
	}
	public void setSuKien(ArrayList<SuKien> suKien) {
		this.suKien = suKien;
	}
	public ArrayList<SuKien> getSuKienSapDienRa() {
		return suKienSapDienRa;
	}
	public void setSuKienSapDienRa(ArrayList<SuKien> suKienSapDienRa) {
		this.suKienSapDienRa = suKienSapDienRa;
	}
	public ArrayList<NhanVat> getNhanVatMoi() {
		return nhanVatMoi;
	}
	public void setNhanVatMoi(ArrayList<NhanVat> nhanVatMoi) {
		this.nhanVatMoi = nhanVatMoi;
	}
	public ArrayList<SuKien> getSuKienMoi() {
		return suKienMoi;
	}
	public void setSuKienMoi(ArrayList<SuKien> suKienMoi) {
		this.suKienMoi = suKienMoi;
	}
	
	
	
}
