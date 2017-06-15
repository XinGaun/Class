package com.zjc.entity;

import java.util.Date;

public class Staff {
	private String staffName;
	private String sex;
	private String age;
	private String cardID;
	private String Mobile;
	private String Userpwd;
	private String Addres;
	private Date Rdate;
	
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getCardID() {
		return cardID;
	}
	public void setCardID(String cardID) {
		this.cardID = cardID;
	}
	public String getMobile() {
		return Mobile;
	}
	public void setMobile(String mobile) {
		Mobile = mobile;
	}
	public String getUserpwd() {
		return Userpwd;
	}
	public void setUserpwd(String userpwd) {
		Userpwd = userpwd;
	}
	public String getAddres() {
		return Addres;
	}
	public void setAddres(String addres) {
		Addres = addres;
	}
	public Date getRdate() {
		return Rdate;
	}
	public void setRdate(Date rdate) {
		Rdate = rdate;
	}
}
