package form;

import java.util.ArrayList;

import model.bean.BinhLuan;
import model.bean.NhanVatSuKien;
import model.bean.NoiDung;

import org.apache.struts.action.ActionForm;

public class ChiTietNhanVatSuKienForm extends ActionForm{

	private int id;
	private int type;
	private NhanVatSuKien nhanVatSuKien;
	private ArrayList<NoiDung> noiDung;
	private ArrayList<BinhLuan> binhLuan;

	private String danhGia;
	
	private String xemThem;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public NhanVatSuKien getNhanVatSuKien() {
		return nhanVatSuKien;
	}
	public void setNhanVatSuKien(NhanVatSuKien nhanVatSuKien) {
		this.nhanVatSuKien = nhanVatSuKien;
	}
	public ArrayList<NoiDung> getNoiDung() {
		return noiDung;
	}
	public void setNoiDung(ArrayList<NoiDung> noiDung) {
		this.noiDung = noiDung;
	}
	public ArrayList<BinhLuan> getBinhLuan() {
		return binhLuan;
	}
	public void setBinhLuan(ArrayList<BinhLuan> binhLuan) {
		this.binhLuan = binhLuan;
	}
	public String getXemThem() {
		return xemThem;
	}
	public void setXemThem(String xemThem) {
		this.xemThem = xemThem;
	}
	public String getDanhGia() {
		return danhGia;
	}
	public void setDanhGia(String danhGia) {
		this.danhGia = danhGia;
	}

	
	
	
	
	
	
}
