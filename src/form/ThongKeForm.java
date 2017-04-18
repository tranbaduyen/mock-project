/**
 * 
 */
package form;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import model.bean.GiaiDoan;
import model.bean.NhanVat;
import model.bean.SuKien;
import model.bean.ThoiKi;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 * @author HCD-Fresher161
 *
 */
public class ThongKeForm extends ActionForm{
	private int tongSoLuotXemSuKien;
	private int tongSoLuotXemNhanVat;
	private int tongSoLuotXemCauChuyen;
	private int tongSoLuotXemDiaDanh;
	
	private int tongSoLuotXemSuKienTrongNgay;
	private int tongSoLuotXemSuKienTrongTuan;
	private int tongSoLuotXemSuKienTrongThang;
	private int tongSoLuotXemSuKienTrongNam;
	
	
	private int tongSoLuotXemNhanVatTrongNgay;
	private int tongSoLuotXemNhanVatTrongTuan;
	private int tongSoLuotXemNhanVatTrongThang;
	private int tongSoLuotXemNhanVatTrongNam;
	
	private int tongSoLuotXemThoiKiTrongNgay;
	private int tongSoLuotXemThoiKiTrongTuan;
	private int tongSoLuotXemThoiKiTrongThang;
	private int tongSoLuotXemThoiKiTrongNam;
	
	private int tongSoLuotXemGiaiDoanTrongNgay;
	private int tongSoLuotXemGiaiDoanTrongTuan;
	private int tongSoLuotXemGiaiDoanTrongThang;
	private int tongSoLuotXemGiaiDoanTrongNam;
	
	private int tongSoBinhLuanSuKien;
	private int tongSoBinhLuanNhanVat;
	
	private int tongSoBinhLuanSuKienTrongNgay;
	private int tongSoBinhLuanSuKienTrongTuan;
	private int tongSoBinhLuanSuKienTrongThang;
	private int tongSoBinhLuanSuKienTrongNam;
	
	private int tongSoBinhLuanNhanVatTrongNgay;
	private int tongSoBinhLuanNhanVatTrongTuan;
	private int tongSoBinhLuanNhanVatTrongThang;
	private int tongSoBinhLuanNhanVatTrongNam;
	
	private ArrayList<SuKien> listSuKienTK;
	private ArrayList<SuKien> listSuKienTKNgay;
	private ArrayList<SuKien> listSuKienTKTuan;
	private ArrayList<SuKien> listSuKienTKThang;
	private ArrayList<SuKien> listSuKienTKNam;
	
	private ArrayList<NhanVat> listNhanVatTK;
	private ArrayList<ThoiKi> listThoiKiTK;
	private ArrayList<GiaiDoan> listGiaiDoanTK;
	
	
	
	
	
	/**
	 * @return the listSuKienTKNgay
	 */
	public ArrayList<SuKien> getListSuKienTKNgay() {
		return listSuKienTKNgay;
	}



	/**
	 * @param listSuKienTKNgay the listSuKienTKNgay to set
	 */
	public void setListSuKienTKNgay(ArrayList<SuKien> listSuKienTKNgay) {
		this.listSuKienTKNgay = listSuKienTKNgay;
	}



	/**
	 * @return the listSuKienTKTuan
	 */
	public ArrayList<SuKien> getListSuKienTKTuan() {
		return listSuKienTKTuan;
	}



	/**
	 * @param listSuKienTKTuan the listSuKienTKTuan to set
	 */
	public void setListSuKienTKTuan(ArrayList<SuKien> listSuKienTKTuan) {
		this.listSuKienTKTuan = listSuKienTKTuan;
	}



	/**
	 * @return the listSuKienTKThang
	 */
	public ArrayList<SuKien> getListSuKienTKThang() {
		return listSuKienTKThang;
	}



	/**
	 * @param listSuKienTKThang the listSuKienTKThang to set
	 */
	public void setListSuKienTKThang(ArrayList<SuKien> listSuKienTKThang) {
		this.listSuKienTKThang = listSuKienTKThang;
	}



	/**
	 * @return the listSuKienTKNam
	 */
	public ArrayList<SuKien> getListSuKienTKNam() {
		return listSuKienTKNam;
	}



	/**
	 * @param listSuKienTKNam the listSuKienTKNam to set
	 */
	public void setListSuKienTKNam(ArrayList<SuKien> listSuKienTKNam) {
		this.listSuKienTKNam = listSuKienTKNam;
	}



	/**
	 * @return the tongSoLuotXemSuKien
	 */
	public int getTongSoLuotXemSuKien() {
		return tongSoLuotXemSuKien;
	}



	/**
	 * @param tongSoLuotXemSuKien the tongSoLuotXemSuKien to set
	 */
	public void setTongSoLuotXemSuKien(int tongSoLuotXemSuKien) {
		this.tongSoLuotXemSuKien = tongSoLuotXemSuKien;
	}



	/**
	 * @return the tongSoLuotXemNhanVat
	 */
	public int getTongSoLuotXemNhanVat() {
		return tongSoLuotXemNhanVat;
	}



	/**
	 * @param tongSoLuotXemNhanVat the tongSoLuotXemNhanVat to set
	 */
	public void setTongSoLuotXemNhanVat(int tongSoLuotXemNhanVat) {
		this.tongSoLuotXemNhanVat = tongSoLuotXemNhanVat;
	}



	/**
	 * @return the tongSoLuotXemCauChuyen
	 */
	public int getTongSoLuotXemCauChuyen() {
		return tongSoLuotXemCauChuyen;
	}



	/**
	 * @param tongSoLuotXemCauChuyen the tongSoLuotXemCauChuyen to set
	 */
	public void setTongSoLuotXemCauChuyen(int tongSoLuotXemCauChuyen) {
		this.tongSoLuotXemCauChuyen = tongSoLuotXemCauChuyen;
	}



	/**
	 * @return the tongSoLuotXemDiaDanh
	 */
	public int getTongSoLuotXemDiaDanh() {
		return tongSoLuotXemDiaDanh;
	}



	/**
	 * @param tongSoLuotXemDiaDanh the tongSoLuotXemDiaDanh to set
	 */
	public void setTongSoLuotXemDiaDanh(int tongSoLuotXemDiaDanh) {
		this.tongSoLuotXemDiaDanh = tongSoLuotXemDiaDanh;
	}



	/**
	 * @return the tongSoLuotXemSuKienTrongNgay
	 */
	public int getTongSoLuotXemSuKienTrongNgay() {
		return tongSoLuotXemSuKienTrongNgay;
	}



	/**
	 * @param tongSoLuotXemSuKienTrongNgay the tongSoLuotXemSuKienTrongNgay to set
	 */
	public void setTongSoLuotXemSuKienTrongNgay(int tongSoLuotXemSuKienTrongNgay) {
		this.tongSoLuotXemSuKienTrongNgay = tongSoLuotXemSuKienTrongNgay;
	}



	/**
	 * @return the tongSoLuotXemSuKienTrongTuan
	 */
	public int getTongSoLuotXemSuKienTrongTuan() {
		return tongSoLuotXemSuKienTrongTuan;
	}



	/**
	 * @param tongSoLuotXemSuKienTrongTuan the tongSoLuotXemSuKienTrongTuan to set
	 */
	public void setTongSoLuotXemSuKienTrongTuan(int tongSoLuotXemSuKienTrongTuan) {
		this.tongSoLuotXemSuKienTrongTuan = tongSoLuotXemSuKienTrongTuan;
	}



	/**
	 * @return the tongSoLuotXemSuKienTrongThang
	 */
	public int getTongSoLuotXemSuKienTrongThang() {
		return tongSoLuotXemSuKienTrongThang;
	}



	/**
	 * @param tongSoLuotXemSuKienTrongThang the tongSoLuotXemSuKienTrongThang to set
	 */
	public void setTongSoLuotXemSuKienTrongThang(int tongSoLuotXemSuKienTrongThang) {
		this.tongSoLuotXemSuKienTrongThang = tongSoLuotXemSuKienTrongThang;
	}



	/**
	 * @return the tongSoLuotXemSuKienTrongNam
	 */
	public int getTongSoLuotXemSuKienTrongNam() {
		return tongSoLuotXemSuKienTrongNam;
	}



	/**
	 * @param tongSoLuotXemSuKienTrongNam the tongSoLuotXemSuKienTrongNam to set
	 */
	public void setTongSoLuotXemSuKienTrongNam(int tongSoLuotXemSuKienTrongNam) {
		this.tongSoLuotXemSuKienTrongNam = tongSoLuotXemSuKienTrongNam;
	}



	/**
	 * @return the tongSoLuotXemNhanVatTrongNgay
	 */
	public int getTongSoLuotXemNhanVatTrongNgay() {
		return tongSoLuotXemNhanVatTrongNgay;
	}



	/**
	 * @param tongSoLuotXemNhanVatTrongNgay the tongSoLuotXemNhanVatTrongNgay to set
	 */
	public void setTongSoLuotXemNhanVatTrongNgay(int tongSoLuotXemNhanVatTrongNgay) {
		this.tongSoLuotXemNhanVatTrongNgay = tongSoLuotXemNhanVatTrongNgay;
	}



	/**
	 * @return the tongSoLuotXemNhanVatTrongTuan
	 */
	public int getTongSoLuotXemNhanVatTrongTuan() {
		return tongSoLuotXemNhanVatTrongTuan;
	}



	/**
	 * @param tongSoLuotXemNhanVatTrongTuan the tongSoLuotXemNhanVatTrongTuan to set
	 */
	public void setTongSoLuotXemNhanVatTrongTuan(int tongSoLuotXemNhanVatTrongTuan) {
		this.tongSoLuotXemNhanVatTrongTuan = tongSoLuotXemNhanVatTrongTuan;
	}



	/**
	 * @return the tongSoLuotXemNhanVatTrongThang
	 */
	public int getTongSoLuotXemNhanVatTrongThang() {
		return tongSoLuotXemNhanVatTrongThang;
	}



	/**
	 * @param tongSoLuotXemNhanVatTrongThang the tongSoLuotXemNhanVatTrongThang to set
	 */
	public void setTongSoLuotXemNhanVatTrongThang(int tongSoLuotXemNhanVatTrongThang) {
		this.tongSoLuotXemNhanVatTrongThang = tongSoLuotXemNhanVatTrongThang;
	}



	/**
	 * @return the tongSoLuotXemNhanVatTrongNam
	 */
	public int getTongSoLuotXemNhanVatTrongNam() {
		return tongSoLuotXemNhanVatTrongNam;
	}



	/**
	 * @param tongSoLuotXemNhanVatTrongNam the tongSoLuotXemNhanVatTrongNam to set
	 */
	public void setTongSoLuotXemNhanVatTrongNam(int tongSoLuotXemNhanVatTrongNam) {
		this.tongSoLuotXemNhanVatTrongNam = tongSoLuotXemNhanVatTrongNam;
	}



	/**
	 * @return the tongSoLuotXemThoiKiTrongNgay
	 */
	public int getTongSoLuotXemThoiKiTrongNgay() {
		return tongSoLuotXemThoiKiTrongNgay;
	}



	/**
	 * @param tongSoLuotXemThoiKiTrongNgay the tongSoLuotXemThoiKiTrongNgay to set
	 */
	public void setTongSoLuotXemThoiKiTrongNgay(int tongSoLuotXemThoiKiTrongNgay) {
		this.tongSoLuotXemThoiKiTrongNgay = tongSoLuotXemThoiKiTrongNgay;
	}



	/**
	 * @return the tongSoLuotXemThoiKiTrongTuan
	 */
	public int getTongSoLuotXemThoiKiTrongTuan() {
		return tongSoLuotXemThoiKiTrongTuan;
	}



	/**
	 * @param tongSoLuotXemThoiKiTrongTuan the tongSoLuotXemThoiKiTrongTuan to set
	 */
	public void setTongSoLuotXemThoiKiTrongTuan(int tongSoLuotXemThoiKiTrongTuan) {
		this.tongSoLuotXemThoiKiTrongTuan = tongSoLuotXemThoiKiTrongTuan;
	}



	/**
	 * @return the tongSoLuotXemThoiKiTrongThang
	 */
	public int getTongSoLuotXemThoiKiTrongThang() {
		return tongSoLuotXemThoiKiTrongThang;
	}



	/**
	 * @param tongSoLuotXemThoiKiTrongThang the tongSoLuotXemThoiKiTrongThang to set
	 */
	public void setTongSoLuotXemThoiKiTrongThang(int tongSoLuotXemThoiKiTrongThang) {
		this.tongSoLuotXemThoiKiTrongThang = tongSoLuotXemThoiKiTrongThang;
	}



	/**
	 * @return the tongSoLuotXemThoiKiTrongNam
	 */
	public int getTongSoLuotXemThoiKiTrongNam() {
		return tongSoLuotXemThoiKiTrongNam;
	}



	/**
	 * @param tongSoLuotXemThoiKiTrongNam the tongSoLuotXemThoiKiTrongNam to set
	 */
	public void setTongSoLuotXemThoiKiTrongNam(int tongSoLuotXemThoiKiTrongNam) {
		this.tongSoLuotXemThoiKiTrongNam = tongSoLuotXemThoiKiTrongNam;
	}



	/**
	 * @return the tongSoLuotXemGiaiDoanTrongNgay
	 */
	public int getTongSoLuotXemGiaiDoanTrongNgay() {
		return tongSoLuotXemGiaiDoanTrongNgay;
	}



	/**
	 * @param tongSoLuotXemGiaiDoanTrongNgay the tongSoLuotXemGiaiDoanTrongNgay to set
	 */
	public void setTongSoLuotXemGiaiDoanTrongNgay(int tongSoLuotXemGiaiDoanTrongNgay) {
		this.tongSoLuotXemGiaiDoanTrongNgay = tongSoLuotXemGiaiDoanTrongNgay;
	}



	/**
	 * @return the tongSoLuotXemGiaiDoanTrongTuan
	 */
	public int getTongSoLuotXemGiaiDoanTrongTuan() {
		return tongSoLuotXemGiaiDoanTrongTuan;
	}



	/**
	 * @param tongSoLuotXemGiaiDoanTrongTuan the tongSoLuotXemGiaiDoanTrongTuan to set
	 */
	public void setTongSoLuotXemGiaiDoanTrongTuan(int tongSoLuotXemGiaiDoanTrongTuan) {
		this.tongSoLuotXemGiaiDoanTrongTuan = tongSoLuotXemGiaiDoanTrongTuan;
	}



	/**
	 * @return the tongSoLuotXemGiaiDoanTrongThang
	 */
	public int getTongSoLuotXemGiaiDoanTrongThang() {
		return tongSoLuotXemGiaiDoanTrongThang;
	}



	/**
	 * @param tongSoLuotXemGiaiDoanTrongThang the tongSoLuotXemGiaiDoanTrongThang to set
	 */
	public void setTongSoLuotXemGiaiDoanTrongThang(int tongSoLuotXemGiaiDoanTrongThang) {
		this.tongSoLuotXemGiaiDoanTrongThang = tongSoLuotXemGiaiDoanTrongThang;
	}



	/**
	 * @return the tongSoLuotXemGiaiDoanTrongNam
	 */
	public int getTongSoLuotXemGiaiDoanTrongNam() {
		return tongSoLuotXemGiaiDoanTrongNam;
	}



	/**
	 * @param tongSoLuotXemGiaiDoanTrongNam the tongSoLuotXemGiaiDoanTrongNam to set
	 */
	public void setTongSoLuotXemGiaiDoanTrongNam(int tongSoLuotXemGiaiDoanTrongNam) {
		this.tongSoLuotXemGiaiDoanTrongNam = tongSoLuotXemGiaiDoanTrongNam;
	}



	/**
	 * @return the tongSoBinhLuanSuKien
	 */
	public int getTongSoBinhLuanSuKien() {
		return tongSoBinhLuanSuKien;
	}



	/**
	 * @param tongSoBinhLuanSuKien the tongSoBinhLuanSuKien to set
	 */
	public void setTongSoBinhLuanSuKien(int tongSoBinhLuanSuKien) {
		this.tongSoBinhLuanSuKien = tongSoBinhLuanSuKien;
	}



	/**
	 * @return the tongSoBinhLuanNhanVat
	 */
	public int getTongSoBinhLuanNhanVat() {
		return tongSoBinhLuanNhanVat;
	}



	/**
	 * @param tongSoBinhLuanNhanVat the tongSoBinhLuanNhanVat to set
	 */
	public void setTongSoBinhLuanNhanVat(int tongSoBinhLuanNhanVat) {
		this.tongSoBinhLuanNhanVat = tongSoBinhLuanNhanVat;
	}



	/**
	 * @return the tongSoBinhLuanSuKienTrongNgay
	 */
	public int getTongSoBinhLuanSuKienTrongNgay() {
		return tongSoBinhLuanSuKienTrongNgay;
	}



	/**
	 * @param tongSoBinhLuanSuKienTrongNgay the tongSoBinhLuanSuKienTrongNgay to set
	 */
	public void setTongSoBinhLuanSuKienTrongNgay(int tongSoBinhLuanSuKienTrongNgay) {
		this.tongSoBinhLuanSuKienTrongNgay = tongSoBinhLuanSuKienTrongNgay;
	}



	/**
	 * @return the tongSoBinhLuanSuKienTrongTuan
	 */
	public int getTongSoBinhLuanSuKienTrongTuan() {
		return tongSoBinhLuanSuKienTrongTuan;
	}



	/**
	 * @param tongSoBinhLuanSuKienTrongTuan the tongSoBinhLuanSuKienTrongTuan to set
	 */
	public void setTongSoBinhLuanSuKienTrongTuan(int tongSoBinhLuanSuKienTrongTuan) {
		this.tongSoBinhLuanSuKienTrongTuan = tongSoBinhLuanSuKienTrongTuan;
	}



	/**
	 * @return the tongSoBinhLuanSuKienTrongThang
	 */
	public int getTongSoBinhLuanSuKienTrongThang() {
		return tongSoBinhLuanSuKienTrongThang;
	}



	/**
	 * @param tongSoBinhLuanSuKienTrongThang the tongSoBinhLuanSuKienTrongThang to set
	 */
	public void setTongSoBinhLuanSuKienTrongThang(int tongSoBinhLuanSuKienTrongThang) {
		this.tongSoBinhLuanSuKienTrongThang = tongSoBinhLuanSuKienTrongThang;
	}



	/**
	 * @return the tongSoBinhLuanSuKienTrongNam
	 */
	public int getTongSoBinhLuanSuKienTrongNam() {
		return tongSoBinhLuanSuKienTrongNam;
	}



	/**
	 * @param tongSoBinhLuanSuKienTrongNam the tongSoBinhLuanSuKienTrongNam to set
	 */
	public void setTongSoBinhLuanSuKienTrongNam(int tongSoBinhLuanSuKienTrongNam) {
		this.tongSoBinhLuanSuKienTrongNam = tongSoBinhLuanSuKienTrongNam;
	}



	/**
	 * @return the tongSoBinhLuanNhanVatTrongNgay
	 */
	public int getTongSoBinhLuanNhanVatTrongNgay() {
		return tongSoBinhLuanNhanVatTrongNgay;
	}



	/**
	 * @param tongSoBinhLuanNhanVatTrongNgay the tongSoBinhLuanNhanVatTrongNgay to set
	 */
	public void setTongSoBinhLuanNhanVatTrongNgay(int tongSoBinhLuanNhanVatTrongNgay) {
		this.tongSoBinhLuanNhanVatTrongNgay = tongSoBinhLuanNhanVatTrongNgay;
	}



	/**
	 * @return the tongSoBinhLuanNhanVatTrongTuan
	 */
	public int getTongSoBinhLuanNhanVatTrongTuan() {
		return tongSoBinhLuanNhanVatTrongTuan;
	}



	/**
	 * @param tongSoBinhLuanNhanVatTrongTuan the tongSoBinhLuanNhanVatTrongTuan to set
	 */
	public void setTongSoBinhLuanNhanVatTrongTuan(int tongSoBinhLuanNhanVatTrongTuan) {
		this.tongSoBinhLuanNhanVatTrongTuan = tongSoBinhLuanNhanVatTrongTuan;
	}



	/**
	 * @return the tongSoBinhLuanNhanVatTrongThang
	 */
	public int getTongSoBinhLuanNhanVatTrongThang() {
		return tongSoBinhLuanNhanVatTrongThang;
	}



	/**
	 * @param tongSoBinhLuanNhanVatTrongThang the tongSoBinhLuanNhanVatTrongThang to set
	 */
	public void setTongSoBinhLuanNhanVatTrongThang(int tongSoBinhLuanNhanVatTrongThang) {
		this.tongSoBinhLuanNhanVatTrongThang = tongSoBinhLuanNhanVatTrongThang;
	}



	/**
	 * @return the tongSoBinhLuanNhanVatTrongNam
	 */
	public int getTongSoBinhLuanNhanVatTrongNam() {
		return tongSoBinhLuanNhanVatTrongNam;
	}



	/**
	 * @param tongSoBinhLuanNhanVatTrongNam the tongSoBinhLuanNhanVatTrongNam to set
	 */
	public void setTongSoBinhLuanNhanVatTrongNam(int tongSoBinhLuanNhanVatTrongNam) {
		this.tongSoBinhLuanNhanVatTrongNam = tongSoBinhLuanNhanVatTrongNam;
	}



	/**
	 * @return the listSuKienTK
	 */
	public ArrayList<SuKien> getListSuKienTK() {
		return listSuKienTK;
	}



	/**
	 * @param listSuKienTK the listSuKienTK to set
	 */
	public void setListSuKienTK(ArrayList<SuKien> listSuKienTK) {
		this.listSuKienTK = listSuKienTK;
	}



	/**
	 * @return the listNhanVatTK
	 */
	public ArrayList<NhanVat> getListNhanVatTK() {
		return listNhanVatTK;
	}



	/**
	 * @param listNhanVatTK the listNhanVatTK to set
	 */
	public void setListNhanVatTK(ArrayList<NhanVat> listNhanVatTK) {
		this.listNhanVatTK = listNhanVatTK;
	}



	/**
	 * @return the listThoiKiTK
	 */
	public ArrayList<ThoiKi> getListThoiKiTK() {
		return listThoiKiTK;
	}



	/**
	 * @param listThoiKiTK the listThoiKiTK to set
	 */
	public void setListThoiKiTK(ArrayList<ThoiKi> listThoiKiTK) {
		this.listThoiKiTK = listThoiKiTK;
	}



	/**
	 * @return the listGiaiDoanTK
	 */
	public ArrayList<GiaiDoan> getListGiaiDoanTK() {
		return listGiaiDoanTK;
	}



	/**
	 * @param listGiaiDoanTK the listGiaiDoanTK to set
	 */
	public void setListGiaiDoanTK(ArrayList<GiaiDoan> listGiaiDoanTK) {
		this.listGiaiDoanTK = listGiaiDoanTK;
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
