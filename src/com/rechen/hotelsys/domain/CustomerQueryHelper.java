/**
 * 
 */
package com.rechen.hotelsys.domain;

/**
 * @author Re.chen
 *
 */
public class CustomerQueryHelper extends ValueObject{
	
	private String qryCustomerSex;//客户性别
	private String qryCustomerName;//客户姓名
	
	
	//-------------------
	public String getQryCustomerSex() {
		return qryCustomerSex;
	}
	public void setQryCustomerSex(String qryCustomerSex) {
		this.qryCustomerSex = qryCustomerSex;
	}
	public String getQryCustomerName() {
		return qryCustomerName;
	}
	public void setQryCustomerName(String qryCustomerName) {
		this.qryCustomerName = qryCustomerName;
	}
	
	


}
