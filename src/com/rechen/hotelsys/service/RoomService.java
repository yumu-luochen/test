/**
 * 
 */
package com.rechen.hotelsys.service;

import java.util.List;

import com.rechen.hotelsys.domain.Room;
import com.rechen.hotelsys.domain.RoomQueryHelper;
import com.rechen.hotelsys.utils.Page;

/**
 * @author Re.chen
 *
 */
public interface RoomService {
	void saveRoom(Room room);
	List<Room> loadRoom();
	List<Room> loadRoomByHotelId(Integer hotelId);
	void deleteRoom(Integer roomId);
	Room getRoomById(Integer roomId);
	void updateRoom(Room room);
	
	Page getPagedRooms(RoomQueryHelper helper,Page initPage);
}
