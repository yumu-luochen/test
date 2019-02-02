/**
 * 
 */
package com.rechen.hotelsys.domain;

/**
 * @author Re.chen
 *
 */
public class Room extends ValueObject {
	
	private Integer roomId;
	private String roomNo;
	private String roomType;
	private String[] roomEquip;//屋内设施
	private String roomEquipStr;//最后提交给数据库的
	private String roomStatus;//'#{"a":"空置房间","b":"已预订","c":"退房保洁中","d":"整理维修","e":"已入住","f":"未保洁"}'
	private String roomMemo;
	private Hotel hotel;//房间所属分店
	
	
	public Integer getRoomId() {
		return roomId;
	}
	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}
	public String getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public String[] getRoomEquip() {
		return roomEquip;
	}
	public void setRoomEquip(String[] roomEquip) {
		this.roomEquip = roomEquip;
		
			StringBuilder sb = new StringBuilder();
			for(int i = 0;i<roomEquip.length;i++)
				sb.append(roomEquip[i]).append("|");
			sb.deleteCharAt(sb.length()-1);
			
		this.roomEquipStr = sb.toString();
	}
	public String getRoomEquipStr() {
		return roomEquipStr;
	}
	public void setRoomEquipStr(String roomEquipStr) {
		this.roomEquipStr = roomEquipStr;
		this.roomEquip=roomEquipStr.split("\\|");
	}
	public String getRoomStatus() {
		return roomStatus;
	}
	public void setRoomStatus(String roomStatus) {
		this.roomStatus = roomStatus;
	}
	public String getRoomMemo() {
		return roomMemo;
	}
	public void setRoomMemo(String roomMemo) {
		this.roomMemo = roomMemo;
	}
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	
}
