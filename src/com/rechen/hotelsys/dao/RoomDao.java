package com.rechen.hotelsys.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.rechen.hotelsys.domain.Room;
import com.rechen.hotelsys.domain.RoomQueryHelper;

public interface RoomDao {
	
	void saveRoom(Room room);
	List<Room> loadRoom();
	List<Room> loadRoomByHotelId(Integer hotelId);
	void deleteRoom(Integer roomId);
	Room getRoomById(Integer roomId);
	void updateRoom(Room room);
	//在某查询条件下记录的条数
	Integer cntRoomByCondition(RoomQueryHelper helper);
	//在某种查询条件下,从startIndex开始取值,取fetchSize条记录
	List<Room> getScopedRoomsByCondition(RoomQueryHelper helper,Integer startIndex,Integer fetchSize);
	DetachedCriteria genCriteriaByHelper(RoomQueryHelper helper);
}
