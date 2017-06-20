/**
 * 
 */
package com.entity;

/**
 * @描述：用户实体类
 * @所在公司 AAA
 * @author 张伟东
 * @日期2017-6-15上午10:12:09
 */
public class UserInfo {
	private String Mobile;
	private String Userpwd;
	private String UserAddress;
	private String UserName;
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
	public String getUserAddress() {
		return UserAddress;
	}
	public void setUserAddress(String userAddress) {
		UserAddress = userAddress;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	
}
