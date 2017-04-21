/**
 * 
 */
package form;

import org.apache.struts.action.ActionForm;

import model.bean.DiaDanh;

/**
 * @author admin
 *
 */
public class DiaDanhForm extends ActionForm{
	private int maDiaDanh;
	private String tenDiaDanh;
	private int maSuKien;
	private String tenSuKien;
	private String noiDung;
	private String hinhAnh;
	private float viDo;
	private float kinhDo;
	private String submit;
	private String action;
	private DiaDanh diaDanh;
	
	
	
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public DiaDanh getDiaDanh() {
		return diaDanh;
	}
	public void setDiaDanh(DiaDanh diaDanh) {
		this.diaDanh = diaDanh;
	}
	public int getMaDiaDanh() {
		return maDiaDanh;
	}
	public void setMaDiaDanh(int maDiaDanh) {
		this.maDiaDanh = maDiaDanh;
	}
	public String getTenDiaDanh() {
		return tenDiaDanh;
	}
	public void setTenDiaDanh(String tenDiaDanh) {
		this.tenDiaDanh = tenDiaDanh;
	}
	public int getMaSuKien() {
		return maSuKien;
	}
	public void setMaSuKien(int maSuKien) {
		this.maSuKien = maSuKien;
	}
	public String getTenSuKien() {
		return tenSuKien;
	}
	public void setTenSuKien(String tenSuKien) {
		this.tenSuKien = tenSuKien;
	}
	public String getNoiDung() {
		return noiDung;
	}
	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}
	public String getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	public float getViDo() {
		return viDo;
	}
	public void setViDo(float viDo) {
		this.viDo = viDo;
	}
	public float getKinhDo() {
		return kinhDo;
	}
	public void setKinhDo(float kinhDo) {
		this.kinhDo = kinhDo;
	}
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}
	
	
	
}
