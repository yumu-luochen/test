package com.rechen.hotelsys.dao;

import java.util.List;

import com.rechen.hotelsys.domain.Hotel;

public interface HotelDao {
	
	void saveHotel(Hotel hotel);
	List<Hotel> loadHotel();
	void deleteHotel(Integer hotelId);
	Hotel getHotelById(Integer hotelId);
	void updateHotel(Hotel hotel);
	byte[] getHotelPicById(Integer hotelId);
	
	Hotel checkHotel(Hotel hotel);
}
