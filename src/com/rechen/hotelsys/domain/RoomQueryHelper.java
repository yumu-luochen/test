/**
 * 
 */
package com.rechen.hotelsys.domain;

/**
 * @author Re.chen
 *
 */
public class RoomQueryHelper extends ValueObject{
	
	private Integer qryHotelId;//组合查询--所属分店
	private String qryRoomType;//房间类型
	private String qryRoomStatus;//房间状态
	
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
	public String getQryRoomStatus() {
		return qryRoomStatus;
	}
	public void setQryRoomStatus(String qryRoomStatus) {
		this.qryRoomStatus = qryRoomStatus;
	}

}
