/**
 * 
 */
package com.rechen.hotelsys.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.rechen.hotelsys.dao.HotelDao;
import com.rechen.hotelsys.dao.RoomDao;
import com.rechen.hotelsys.domain.Hotel;
import com.rechen.hotelsys.domain.Room;
import com.rechen.hotelsys.domain.RoomQueryHelper;
import com.rechen.hotelsys.utils.Page;

/**
 * @author Re.chen
 *
 */
public class RoomServiceImpl implements RoomService {

	private static final Logger logger = Logger.getLogger(RoomServiceImpl.class);
	
	private RoomDao roomDao;
	private HotelDao hotelDao;

	@Override
	public void saveRoom(Room room) {
		logger.info("准备增加客房,客房信息为:"+room);
		roomDao.saveRoom(room);
		logger.info("检测到添加客房信息,准备对分店的客房数量进行增加");
		Hotel hotel = hotelDao.getHotelById(room.getHotel().getHotelId());
		hotel.setHotelPic(hotelDao.getHotelPicById(room.getHotel().getHotelId()));
		logger.info("相关分店为:"+hotel.getHotelName());
		hotel.setHotelRoomCount(hotel.getHotelRoomCount()+1);
		logger.info("已经成功对分店:"+hotel.getHotelName()+"的客房数量进行添加");
		hotelDao.updateHotel(hotel);
	}

	@Override
	public List<Room> loadRoom() {
		return roomDao.loadRoom();
	}

	@Override
	public List<Room> loadRoomByHotelId(Integer hotelId) {
		return roomDao.loadRoomByHotelId(hotelId);
	}

	@Override
	public void deleteRoom(Integer roomId) {		
		Hotel hotel = roomDao.getRoomById(roomId).getHotel();
		hotel.setHotelPic(hotelDao.getHotelPicById(hotel.getHotelId()));
		
		hotel.setHotelRoomCount(hotel.getHotelRoomCount()-1);
		hotelDao.updateHotel(hotel);
		roomDao.deleteRoom(roomId);
	}

	@Override
	public Room getRoomById(Integer roomId) {
		return roomDao.getRoomById(roomId);
	}

	@Override
	public void updateRoom(Room room) {
		Hotel oldHotel = roomDao.getRoomById(room.getRoomId()).getHotel();
		Hotel newHotel = hotelDao.getHotelById(room.getHotel().getHotelId());
		roomDao.updateRoom(room);
		
		if(!oldHotel.getHotelId().equals(newHotel.getHotelId())){
			logger.info("检测到客房更换分店!旧分店名称为:"+oldHotel.getHotelName()+",新分店名称为:"+newHotel.getHotelName());
			oldHotel.setHotelPic(hotelDao.getHotelPicById(oldHotel.getHotelId()));
			oldHotel.setHotelRoomCount(oldHotel.getHotelRoomCount()-1);
			hotelDao.updateHotel(oldHotel);
			
			newHotel.setHotelPic(hotelDao.getHotelPicById(newHotel.getHotelId()));
			newHotel.setHotelRoomCount(newHotel.getHotelRoomCount()+1);
			logger.info("客房更换分店完成!");
			hotelDao.updateHotel(newHotel);
		}
	}

	@Override
	public Page getPagedRooms(RoomQueryHelper helper, Page initPage) {
		initPage.setTotalRecNum((long)roomDao.cntRoomByCondition(helper));
		initPage.setPageContent(roomDao.getScopedRoomsByCondition(helper, initPage.getStartIndex(), initPage.getPageSize()));
		return initPage;
	}
	
	
	//--------------------------------
	public void setRoomDao(RoomDao roomDao) {
		this.roomDao = roomDao;
	}

	public void setHotelDao(HotelDao hotelDao) {
		this.hotelDao = hotelDao;
	}



}
