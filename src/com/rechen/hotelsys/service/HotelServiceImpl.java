/**
 * 
 */
package com.rechen.hotelsys.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.rechen.hotelsys.dao.HotelDao;
import com.rechen.hotelsys.domain.Hotel;

/**
 * @author Re.chen
 *
 */
public class HotelServiceImpl implements HotelService{
	private static final Logger logger = Logger.getLogger(HotelServiceImpl.class);
	private HotelDao hotelDao;

	public void setHotelDao(HotelDao hotelDao) {
		this.hotelDao = hotelDao;
	}

	@Override
	public void saveHotel(Hotel hotel) {
		logger.info("开始尝试保存酒店信息,信息为:"+hotel.toString());
		hotelDao.saveHotel(hotel);
	}

	@Override
	public List<Hotel> loadHotel() {
		logger.info("开始读取全部酒店信息!");
		return hotelDao.loadHotel();
	}

	@Override
	public void deleteHotel(Integer hotelId) {
		logger.info("开始尝试酒店信息,酒店ID为:"+hotelId);
		hotelDao.deleteHotel(hotelId);
	}

	@Override
	public Hotel getHotelById(Integer hotelId) {
		return hotelDao.getHotelById(hotelId);
	}

	@Override
	public void updateHotel(Hotel hotel) {
		logger.info("开始更新酒店信息,信息为:"+hotel.toString());
		hotelDao.updateHotel(hotel);
	}

	@Override
	public byte[] getHotelPicById(Integer hotelId) {
		return hotelDao.getHotelPicById(hotelId);
	}

}
