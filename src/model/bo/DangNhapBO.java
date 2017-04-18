package model.bo;

import model.dao.DangNhapDAO;

public class DangNhapBO {

	DangNhapDAO dangNhapDAO =new DangNhapDAO();
	
	/**
	 * Kiểm tra đăng nhập
	 * @param userName
	 * @param password
	 * @return
	 */
	public boolean checkLogin(String userName, String password) {
		return dangNhapDAO.checkLogin(userName,password);
	}

	public boolean checkLevel(String userName, String password) {
		return dangNhapDAO.checkLevel(userName,password);
	}

}
