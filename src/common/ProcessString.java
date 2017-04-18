package common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProcessString {
	
	/**
	 * Hàm cắt chuỗi theo từ
	 * @param a
	 * @param begin
	 * @param end
	 * @return
	 */
	public static String catChuoi(String []a, int begin, int end){
		String s="";
		for(int i=begin;i<=end;i++){
			if(i==end)
				s+=a[i]+"...";
			else
				s+=a[i]+" ";
		}
		return s;
	}


	/**
	 * Kiểm tra email hợp lê hay không
	 * @param email
	 * @return
	 */
	public static Boolean checkEmail(String email){
		String regex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		if(matcher.matches())
			return true;
		else
			return false;
	}

	/** 
	 * Kiểm tra username đăng ký có hợp lệ hay không
	 * @param userName
	 * @return
	 */
	public static Boolean checkUserName(String userName){
		String regex = "^[a-z0-9_-]{3,15}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(userName);
		if(matcher.matches())
			return true;
		else
			return false;
	}
	public static void main(String[] args) {
		System.out.println(checkUserName("admin"));
	}
	
	
	
	public static Boolean checkDate(String date){
		String regex = "^(((0[1-9]|[12][0-9]|30)[-/]?(0[13-9]|1[012])|31[-/]?(0[13578]|1[02])|(0[1-9]|1[0-9]|2[0-8])[-/]?02)[-/]?[0-9]{4}|29[-/]?02[-/]?([0-9]{2}(([2468][048]|[02468][48])|[13579][26])|([13579][26]|[02468][048]|0[0-9]|1[0-6])00))$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(date);
		if(matcher.matches())
			return true;
		else
			return false;
	}
	

}
