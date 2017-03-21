/**
 * 
 */
package model.bo;

import java.util.ArrayList;

import model.bean.SuKienDongGop;
import model.dao.SuKienDongGopDAO;

/**
 * @author HCD-Fresher161
 *
 */
public class SuKienDongGopBO {
	SuKienDongGopDAO suKienDongGopDAO = new SuKienDongGopDAO();
	
	public int getSoLuongSuKienChoDuyet(){
		return suKienDongGopDAO.getSoLuongSuKienChoDuyet();
	}
	
	public SuKienDongGop getThongTinSuKienDongGop(int maBDSK) {
		return suKienDongGopDAO.getThongTinSuKienDongGop(maBDSK);
	}
	public ArrayList<SuKienDongGop> getListSuKienDongGop() {
		// TODO Auto-generated method stub
		return suKienDongGopDAO.getListSuKienDongGop();
	}
}
