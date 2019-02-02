/**
 * 
 */
package com.rechen.hotelsys.service;

import java.util.List;

import com.rechen.hotelsys.domain.Hotel;

/**
 * @author Re.chen
 *
 */
public interface HotelService {
	void saveHotel(Hotel hotel);
	List<Hotel> loadHotel();
	void deleteHotel(Integer hotelId);
	Hotel getHotelById(Integer hotelId);
	void updateHotel(Hotel hotel);
	byte[] getHotelPicById(Integer hotelId);
}
