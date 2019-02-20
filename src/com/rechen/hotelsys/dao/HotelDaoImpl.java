/**
 * 
 */
package com.rechen.hotelsys.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.rechen.hotelsys.domain.Hotel;
import com.rechen.hotelsys.exception.DataAccessException;

/**
 * @author Re.chen
 *
 */
public class HotelDaoImpl extends HibernateDaoSupport implements HotelDao {
	
	private static final Logger logger = Logger.getLogger(HotelDaoImpl.class);

	@Override
	public void saveHotel(Hotel hotel) {	
		if(StringUtils.isEmpty(hotel.getHotelName()))
			throw new DataAccessException("必须输入分店名称!");
		if(StringUtils.isEmpty(hotel.getHotelAddr()))
			throw new DataAccessException("必须输入分店地址!");
		if(StringUtils.isEmpty(hotel.getHotelPhone()))
			throw new DataAccessException("必须输入分店电话!");
		this.getHibernateTemplate().save(hotel);
	}

	@Override
	public List<Hotel> loadHotel() {
		return (List<Hotel>)this.getHibernateTemplate().find("from Hotel h order by h.hotelId desc");
	}

	@Override
	public void deleteHotel(Integer hotelId) {
		this.getHibernateTemplate().delete(this.getHotelById(hotelId));
	}

	@Override
	public Hotel getHotelById(Integer hotelId) {
		return (Hotel)this.getHibernateTemplate().load(Hotel.class, hotelId);
	}

	@Override
	public void updateHotel(Hotel hotel) {
		if(StringUtils.isEmpty(hotel.getHotelName()))
			throw new DataAccessException("必须输入分店名称!");
		if(StringUtils.isEmpty(hotel.getHotelAddr()))
			throw new DataAccessException("必须输入分店地址!");
		if(StringUtils.isEmpty(hotel.getHotelPhone()))
			throw new DataAccessException("必须输入分店电话!");
		this.getHibernateTemplate().update(hotel);
	}

	@Override
	public byte[] getHotelPicById(Integer hotelId) {
		byte[] hotelPic = null;
		Hotel hotel = this.getHotelById(hotelId);
		if(hotel!=null)
			hotelPic = hotel.getHotelPic();
		return hotelPic;
	}

	@Override
	public Hotel checkHotel(Hotel hotel) {
		
		if(hotel.getHotelRoomCount()!=0)
			throw new DataAccessException("该分店下还拥有着房间,不能删除!请删除完该分店下的所有房间后再尝试操作!");
		
		return hotel;
	}
	
}
