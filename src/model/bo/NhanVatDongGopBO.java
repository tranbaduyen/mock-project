/**
 * 
 */
package model.bo;

import java.util.ArrayList;

import model.bean.NhanVat;
import model.bean.NhanVatDongGop;
import model.dao.NhanVatDongGopDAO;

/**
 * @author HCD-Fresher161
 *
 */
public class NhanVatDongGopBO {
	NhanVatDongGopDAO nhanVatDongGopDAO = new NhanVatDongGopDAO();
	
	public int getSoLuongSuKienChoDuyet(){
		return nhanVatDongGopDAO.getSoLuongNhanVatChoDuyet();
	}
	
	public NhanVatDongGop getThongTinNhanVatDongGop(int maBDNV) {
		return nhanVatDongGopDAO.getThongTinNhanVatDongGop(maBDNV);
	}
	public ArrayList<NhanVatDongGop> getListNhanVatDongGop() {
		// TODO Auto-generated method stub
		return nhanVatDongGopDAO.getListNhanVatDongGop();
	}
	public NhanVat getThongTinNhanVat(int maBDNV) {
		return nhanVatDongGopDAO.getThongTinNhanVat(maBDNV);
	}

	public void duyetNhanVatDongGop(int maBDNV, int pheDuyet) {
		// TODO Auto-generated method stub
		nhanVatDongGopDAO.duyetNhanVatDongGop(maBDNV,pheDuyet);
	}
}
