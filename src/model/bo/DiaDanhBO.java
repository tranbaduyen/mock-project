/**
 * 
 */
package model.bo;

import java.util.ArrayList;

import model.bean.DiaDanh;
import model.dao.DiaDanhDAO;

/**
 * @author admin
 *
 */
public class DiaDanhBO {
	DiaDanhDAO diaDanhDAO = new DiaDanhDAO();
	
	public ArrayList<DiaDanh> getListDiaDanhGan(){
		return diaDanhDAO.getListDiaDanh();
	}
	
	public DiaDanh getThongTinDiaDanh(int maDiaDanh) {
		// TODO Auto-generated method stub
		return diaDanhDAO.getThongTinDiaDanh(maDiaDanh);
	}
}
