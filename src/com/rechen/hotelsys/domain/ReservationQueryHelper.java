/**
 * 
 */
package com.rechen.hotelsys.domain;

/**
 * @author Re.chen
 *
 */
public class ReservationQueryHelper extends ValueObject{
	
	private Integer qryHotelId;//组合查询--所属分店
	private String qryRoomType;//房间类型
	private String qryCustomerName;//客户姓名
	private Integer qryCustomerId;//客户Id
	
	
	public Integer getQryHotelId() {
		return qryHotelId;
	}
	public void setQryHotelId(Integer qryHotelId) {
		this.qryHotelId = qryHotelId;
	}
	public String getQryRoomType() {
		return qryRoomType;
	}
	public void setQryRoomType(String qryRoomType) {
		this.qryRoomType = qryRoomType;
	}
	public String getQryCustomerName() {
		return qryCustomerName;
	}
	public void setQryCustomerName(String qryCustomerName) {
		this.qryCustomerName = qryCustomerName;
	}
	public Integer getQryCustomerId() {
		return qryCustomerId;
	}
	public void setQryCustomerId(Integer qryCustomerId) {
		this.qryCustomerId = qryCustomerId;
	}
	
}
