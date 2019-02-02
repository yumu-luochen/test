/**
 * 
 */
package com.rechen.hotelsys.domain;

/**
 * 管理员实体类
 * @author Re.chen
 *
 */
public class Admin extends ValueObject {
	
	/** 管理员的账号	 */
	private String adminNo;
	
	/** 管理员的密码	 */
	private String adminPwd;
	
	/** 管理员的名称	 */
	private String adminName;
	
	
	
	
	//getter和setter方法
	public String getAdminNo() {
		return adminNo;
	}
	public void setAdminNo(String adminNo) {
		this.adminNo = adminNo;
	}
	public String getAdminPwd() {
		return adminPwd;
	}
	public void setAdminPwd(String adminPwd) {
		this.adminPwd = adminPwd;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	
}
