/**
 * 
 */
package model.bo;

import java.util.ArrayList;

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
	
	public NhanVatDongGop getThongTinSuKienDongGop(int maBDNV) {
		return nhanVatDongGopDAO.getThongTinNhanVatDongGop(maBDNV);
	}
	public ArrayList<NhanVatDongGop> getListNhanVatDongGop() {
		// TODO Auto-generated method stub
		return nhanVatDongGopDAO.getListNhanVatDongGop();
	}
}
