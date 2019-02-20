/**
 * 
 */
package com.rechen.hotelsys.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.rechen.hotelsys.domain.Room;
import com.rechen.hotelsys.domain.RoomQueryHelper;
import com.rechen.hotelsys.exception.DataAccessException;

/**
 * @author Re.chen
 *
 */
public class RoomDaoImpl extends HibernateDaoSupport implements RoomDao {
	
	private static final Logger logger = Logger.getLogger(RoomDaoImpl.class);

	@Override
	public void saveRoom(Room room) {
		logger.info("正在尝试添加房间信息:"+room.toString());
		if(StringUtils.isEmpty(room.getRoomNo()))
			throw new DataAccessException("必须输入房间编号!");
		if(room.getHotel().getHotelId()==null)
			throw new DataAccessException("必须选择相应分店!");
		if(StringUtils.isEmpty(room.getRoomType()))
			throw new DataAccessException("必须选择房间类型!");
		if(StringUtils.isEmpty(room.getRoomEquipStr()))
			throw new DataAccessException("必须添加屋内设施!");
		if(StringUtils.isEmpty(room.getRoomStatus()))
			throw new DataAccessException("必须设定房间状态!");
		this.getHibernateTemplate().save(room);
	}

	@Override
	public List<Room> loadRoom() {
		logger.info("正在读取全部房间信息!");
		return (List<Room>)this.getHibernateTemplate().find("from Room r order by r.roomId desc");
	}

	@Override
	public List<Room> loadRoomByHotelId(Integer hotelId) {

		List<Room> roomList = (List<Room>)this.getHibernateTemplate().find("from Room r where r.hotel.hotelId=?",hotelId);
		return  roomList;
	}

	@Override
	public void deleteRoom(Integer roomId) {
		logger.info("正在删除房间号为:"+roomId+"的房间");
		this.getHibernateTemplate().delete(this.getRoomById(roomId));
	}

	@Override
	public Room getRoomById(Integer roomId) {
		logger.info("正在读取客房编号为:"+roomId);
		return (Room)this.getHibernateTemplate().get(Room.class,roomId);
	}

	@Override
	public void updateRoom(Room room) {
		logger.info("正在更新客房编号为:"+room.getRoomId());
		if(StringUtils.isEmpty(room.getRoomNo()))
			throw new DataAccessException("必须输入房间编号!");
		if(room.getHotel().getHotelId()==null)
			throw new DataAccessException("必须选择相应分店!");
		if(StringUtils.isEmpty(room.getRoomType()))
			throw new DataAccessException("必须选择房间类型!");
		if(StringUtils.isEmpty(room.getRoomEquipStr()))
			throw new DataAccessException("必须添加屋内设施!");
		if(StringUtils.isEmpty(room.getRoomStatus()))
			throw new DataAccessException("必须设定房间状态!");
		this.getHibernateTemplate().update(room);
	}

	@Override
	public Integer cntRoomByCondition(RoomQueryHelper helper) {
		
		DetachedCriteria detachedCriteria = this.genCriteriaByHelper(helper);
		detachedCriteria.setProjection(Projections.rowCount());
		Integer cnt = 0;
		cnt=Integer.parseInt(detachedCriteria.getExecutableCriteria(this.getSession()).list().get(0).toString());
		
		return cnt;
	}

	@Override
	public List<Room> getScopedRoomsByCondition(RoomQueryHelper helper,
			Integer startIndex, Integer fetchSize) {
		
		DetachedCriteria detachedCriteria = this.genCriteriaByHelper(helper);
		List<Room> roomList = null;
		
		roomList = detachedCriteria.getExecutableCriteria(this.getSession()).setFirstResult(startIndex).setMaxResults(fetchSize).list();
		return roomList;
	}

	@Override
	public DetachedCriteria genCriteriaByHelper(RoomQueryHelper helper) {
		
		DetachedCriteria criteria = DetachedCriteria.forClass(Room.class);
		
		if(StringUtils.isNotEmpty(helper.getQryRoomType()))
			criteria.add(Restrictions.eq("roomType", helper.getQryRoomType()));
		if(StringUtils.isNotEmpty(helper.getQryRoomStatus()))
			criteria.add(Restrictions.eq("roomStatus", helper.getQryRoomStatus()));
		if(helper.getQryHotelId()!=null){
			criteria.createCriteria("hotel").add(Restrictions.eq("hotelId", helper.getQryHotelId()));
		}
		criteria.addOrder(Order.desc("roomId"));
		
		
		return criteria;
	}


}
