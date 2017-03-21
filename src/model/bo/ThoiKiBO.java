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
}
