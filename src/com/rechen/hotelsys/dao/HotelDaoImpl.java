/**
 * 
 */
package com.rechen.hotelsys.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.rechen.hotelsys.domain.Hotel;

/**
 * @author Re.chen
 *
 */
public class HotelDaoImpl extends HibernateDaoSupport implements HotelDao {
	
	private static final Logger logger = Logger.getLogger(HotelDaoImpl.class);

	@Override
	public void saveHotel(Hotel hotel) {
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

}
