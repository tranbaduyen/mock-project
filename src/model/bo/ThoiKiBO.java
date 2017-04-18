/**
 * 
 */
package model.bo;

import java.util.ArrayList;

import model.bean.ThoiKi;
import model.dao.ThoiKiDAO;

/**
 * @author HCD-Fresher161
 *
 */
public class ThoiKiBO {
	ThoiKiDAO thoiKiDAO = new ThoiKiDAO();
	
	public ArrayList<ThoiKi> getListThoiKi() {
		return thoiKiDAO.getListThoiKi();
	}
	
	public void suaThoiKy(int maThoiKi, String tenThoiKi, String noiDung) {
		// TODO Auto-generated method stub
		thoiKiDAO.suaThoiKi(maThoiKi, tenThoiKi, noiDung);
	}

	public ThoiKi getThongTinThoiKy(int maThoiKi) {
		// TODO Auto-generated method stub
		return thoiKiDAO.getThongTinThoiKi(maThoiKi);
	}
}
