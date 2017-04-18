package model.bo;

import model.dao.DangKyDAO;

public class DangKyBO {

	DangKyDAO dangKyDAO =new DangKyDAO();

	/**
	 * Kiểm tra user name đăng ký có tồn tại chưa
	 * @param userName
	 * @return
	 */
	public boolean checkUserName(String userName) {
		return dangKyDAO.checkUserName(userName);
	}

	/**
	 * Thêm user mới vào csdl
	 * @param userName
	 * @param password
	 * @param hoVaTen
	 * @param email
	 * @param diaChi
	 */
	public void insertUser(String userName, String password, String hoVaTen,
			String email, String diaChi) {
		dangKyDAO.insertUser(userName,password,hoVaTen,email,diaChi);
		
	}

}
