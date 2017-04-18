package form;

import java.util.ArrayList;

import model.bean.GiaiDoan;
import model.bean.NhanVatSuKien;

import org.apache.struts.action.ActionForm;

public class NhanVatSuKienForm extends ActionForm{

	private int id;
	private int type;
	private String typeName;
	private ArrayList<String> namChiaNho;
	private GiaiDoan giaiDoan;
	
	private ArrayList<NhanVatSuKien> nhanVatSK;
	private String xemThem;
	private String tatCa;
	
	
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

	public ArrayList<String> getNamChiaNho() {
		return namChiaNho;
	}

	public void setNamChiaNho(ArrayList<String> namChiaNho) {
		this.namChiaNho = namChiaNho;
	}

	public GiaiDoan getGiaiDoan() {
		return giaiDoan;
	}

	public void setGiaiDoan(GiaiDoan giaiDoan) {
		this.giaiDoan = giaiDoan;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public ArrayList<NhanVatSuKien> getNhanVatSK() {
		return nhanVatSK;
	}

	public void setNhanVatSK(ArrayList<NhanVatSuKien> nhanVatSK) {
		this.nhanVatSK = nhanVatSK;
	}

	public String getXemThem() {
		return xemThem;
	}

	public void setXemThem(String xemThem) {
		this.xemThem = xemThem;
	}

	public String getTatCa() {
		return tatCa;
	}

	public void setTatCa(String tatCa) {
		this.tatCa = tatCa;
	}
	
	
	
	
}
