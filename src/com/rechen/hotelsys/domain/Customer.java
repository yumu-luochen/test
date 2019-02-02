/**
 * 
 */
package com.rechen.hotelsys.domain;

/**
 * 客户实体类
 * @author Re.chen
 *
 */
public class Customer extends ValueObject {
	
	private Integer customerId;//客户Id
	private String customerName;//客户姓名
	private String customerSex;//客户性别
	private String customerIdentity;//客户身份证
	private String customerPhone;//客户手机号
	private String customerEmail;//客户邮件地址
	private String customerBook;//客户是否已经预定
	
	

	//------------------------------------
	public Integer getCustomerId() {
		return customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getCustomerSex() {
		return customerSex;
	}
	public void setCustomerSex(String customerSex) {
		this.customerSex = customerSex;
	}
	public String getCustomerIdentity() {
		return customerIdentity;
	}
	public void setCustomerIdentity(String customerIdentity) {
		this.customerIdentity = customerIdentity;
	}
	public String getCustomerPhone() {
		return customerPhone;
	}
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getCustomerBook() {
		return customerBook;
	}
	public void setCustomerBook(String customerBook) {
		this.customerBook = customerBook;
	}
	
}
