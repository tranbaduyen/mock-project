/**
 * 
 */
package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.ThoiKi;

/**
 * @author HCD-Fresher161
 *
 */
public class ThoiKiDAO {
	DataAccess da = new DataAccess();
	Connection connection=null;
	Statement stmt=null;
	
	public ArrayList<ThoiKi> getListThoiKi() {
		connection = da.getConnect();
		String sql=	"SELECT MATHOIKI, TENTHOIKI FROM THOIKI";
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ArrayList<ThoiKi> list = new ArrayList<ThoiKi>();
		ThoiKi thoiKi;
		try {
			while(rs.next()){
				thoiKi = new ThoiKi();
				thoiKi.setMaThoiKi(rs.getInt("MATHOIKI"));
				thoiKi.setTenThoiKi(rs.getString("TENTHOIKI"));
				thoiKi.setNoiDung(rs.getString("NOIDUNG"));
				list.add(thoiKi);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
