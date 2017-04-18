package model.bo;

import java.util.ArrayList;

import model.bean.ThoiKy;
import model.dao.ThoiKyDAO;

public class ThoiKyBO {

	ThoiKyDAO thoiKyDAO =new ThoiKyDAO();
	/**
	 * Lấy danh sách thời kỳ
	 * @return
	 */
	public ArrayList<ThoiKy> getListThoiKy() {
		return thoiKyDAO.getListThoiKy();
	}
	


}
