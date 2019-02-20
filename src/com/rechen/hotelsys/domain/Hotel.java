/**
 * 
 */
package com.rechen.hotelsys.domain;

/**
 * @author Re.chen
 *
 */
public class Hotel extends ValueObject {
	private Integer hotelId;
	private String hotelName;
	private String hotelAddr;
	private String hotelPhone;
	private Integer hotelRoomCount;
	private byte[] hotelPic;
	
	
	
	//getter和setter
	public Integer getHotelId() {
		return hotelId;
	}
	public void setHotelId(Integer hotelId) {
		this.hotelId = hotelId;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getHotelAddr() {
		return hotelAddr;
	}
	public void setHotelAddr(String hotelAddr) {
		this.hotelAddr = hotelAddr;
	}
	public String getHotelPhone() {
		return hotelPhone;
	}
	public void setHotelPhone(String hotelPhone) {
		this.hotelPhone = hotelPhone;
	}
	public Integer getHotelRoomCount() {
		return hotelRoomCount;
	}
	public void setHotelRoomCount(Integer hotelRoomCount) {
		this.hotelRoomCount = hotelRoomCount;
	}
	public byte[] getHotelPic() {
		return hotelPic;
	}
	public void setHotelPic(byte[] hotelPic) {
		this.hotelPic = hotelPic;
	}
	
	
	

	
	
}
