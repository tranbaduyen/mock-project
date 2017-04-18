package model.bean;

public class MucDongGop {
	private String mucDongGopID;
	private String mucDongGopTen;
	public String getMucDongGopID() {
		return mucDongGopID;
	}
	public void setMucDongGopID(String mucDongGopID) {
		this.mucDongGopID = mucDongGopID;
	}
	public String getMucDongGopTen() {
		return mucDongGopTen;
	}
	public void setMucDongGopTen(String mucDongGopTen) {
		this.mucDongGopTen = mucDongGopTen;
	}
	public MucDongGop(String mucDongGopID, String mucDongGopTen) {
		super();
		this.mucDongGopID = mucDongGopID;
		this.mucDongGopTen = mucDongGopTen;
	}
	
}
