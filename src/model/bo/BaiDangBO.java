package model.bo;

import model.dao.BaiDangDAO;

public class BaiDangBO {
	BaiDangDAO baiDangDAO = new BaiDangDAO();
	public void themBaiDang(int maThoiKi) {
		baiDangDAO.themBaiDang(maThoiKi);
		
	}

}
