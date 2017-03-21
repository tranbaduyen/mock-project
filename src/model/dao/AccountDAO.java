/**
 * 
 */
package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Account;


/**
 * @author HCD-Fresher161
 *
 */
public class AccountDAO {
	DataAccess da = new DataAccess();
	Connection connection=null;
	Statement stmt=null;
	
	public ArrayList<Account> getListAccount() {
		connection = da.getConnect();
		String sql = "SELECT * FROM  ACCOUNT ";
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		ArrayList<Account> list = new ArrayList<Account>();
		Account account;
		try {
			while (rs.next()) {
				account = new Account();
				account.setUserName(rs.getString("USERNAME"));
				account.setPass(rs.getString("PASS"));
				account.setTen(rs.getString("TEN"));
				account.setEmail(rs.getString("EMAIL"));
				account.setDiaChi(rs.getString("DIACHI"));
				account.setPhanQuyen(rs.getInt("PHANQUYEN"));
				account.setHinhDaiDien(rs.getString("HINHDAIDIEN"));
				list.add(account);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
			return list;
		}

	public Account getThongTinAccount(String userName) {
		// TODO Auto-generated method stub
		connection = da.getConnect();
		String sql=	String.format("SELECT USERNAME, TEN, EMAIL, DIACHI, PHANQUYEN, HINHDAIDIEN "+
					" FROM ACCOUNT WHERE USERNAME = '%s'", userName);
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Account account = new Account();
		try {
			while(rs.next()){
				account.setUserName(rs.getString("USERNAME"));
				account.setTen(rs.getString("TEN"));
				account.setEmail(rs.getString("EMAIL"));
				account.setDiaChi(rs.getString("DIACHI"));
				account.setPhanQuyen(rs.getInt("PHANQUYEN"));
				account.setHinhDaiDien(rs.getString("HINHDAIDIEN"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return account;
	}

	public void suaAccount(String userName, String ten, String email, String diaChi, int phanQuyen, String hinhDaiDien) {
		// TODO Auto-generated method stub
		connection = da.getConnect();
		String sql=	String.format("UPDATE ACCOUNT "+
				" SET TEN = N'%s', EMAIL = '%s', DIACHI = '%s', PHANQUYEN = %s, HINHDAIDIEN = '%s' " +
				" WHERE USERNAME = '%s'", ten, email, diaChi, phanQuyen, hinhDaiDien, userName);
		System.out.println(sql);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void xoaAccount(String userName) {
		// TODO Auto-generated method stub
		connection = da.getConnect();
		String sql=	String.format("DELETE FROM ACCOUNT WHERE USERNAME = '%s'", userName);
		System.out.println(sql);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
