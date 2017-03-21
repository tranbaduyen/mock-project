/**
 * 
 */
package model.bo;

import java.util.ArrayList;

import model.bean.GiaiDoan;
import model.dao.GiaiDoanDAO;

/**
 * @author HCD-Fresher161
 *
 */
public class GiaiDoanBO {
	GiaiDoanDAO giaiDoanDAO = new GiaiDoanDAO();
	public ArrayList<GiaiDoan> getListGiaiDoan (){
		return giaiDoanDAO.getListGiaiDoan();
	}
	public ArrayList<GiaiDoan> getListGiaiDoan (int maThoiKi){
		return giaiDoanDAO.getListGiaiDoan(maThoiKi);
	}
}
