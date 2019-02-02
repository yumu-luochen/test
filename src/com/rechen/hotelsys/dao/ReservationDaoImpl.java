/**
 * 
 */
package com.rechen.hotelsys.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.rechen.hotelsys.domain.Reservation;
import com.rechen.hotelsys.domain.ReservationQueryHelper;
import com.rechen.hotelsys.domain.Room;
import com.rechen.hotelsys.service.CustomerService;
import com.rechen.hotelsys.service.RoomService;

/**
 * @author Re.chen
 *
 */
public class ReservationDaoImpl extends HibernateDaoSupport implements ReservationDao {
	
	private static final Logger logger = Logger.getLogger(ReservationDaoImpl.class);

	@Override
	public void saveReservation(Reservation reservation) {
		logger.info("正在尝试添加预定信息(房间id:"+reservation.getRoom().getRoomId()+",客户id:"+reservation.getCustomer().getCustomerId()+")");
		this.getHibernateTemplate().save(reservation);
	}

	@Override
	public List<Reservation> loadReservation() {
		logger.info("正在读取全部预定信息!");
		return (List<Reservation>)this.getHibernateTemplate().find("from Reservation r order by r.reservationId desc");
	}

	@Override
	public void deleteReservation(Integer reservationId) {
		logger.info("正在删除预定id为:"+reservationId+"的预定信息");
		this.getHibernateTemplate().delete(this.getReservationById(reservationId));
	}

	@Override
	public Reservation getReservationById(Integer reservationId) {
		logger.info("正在读取预定id为:"+reservationId+"的预定信息");
		return (Reservation) this.getHibernateTemplate().get(Reservation.class, reservationId);
		
	}

	@Override
	public void updateReservation(Reservation reservation) {
		logger.info("正在更新预定id为:"+reservation.getReservationId()+"的预定信息");
		this.getHibernateTemplate().update(reservation);
	}

	@Override
	public Integer cntReservationByCondition(ReservationQueryHelper helper) {
		DetachedCriteria detachedCriteria = this.genCriteriaByHelper(helper);
		detachedCriteria.setProjection(Projections.rowCount());
		Integer cnt = 0;
		cnt=Integer.parseInt(detachedCriteria.getExecutableCriteria(this.getSession()).list().get(0).toString());
		
		return cnt;
	}

	@Override
	public List<Reservation> getScopedReservationsByCondition(
			ReservationQueryHelper helper, Integer startIndex, Integer fetchSize) {

		DetachedCriteria detachedCriteria = this.genCriteriaByHelper(helper);
		List<Reservation> reservationList = null;
		
		reservationList = detachedCriteria.getExecutableCriteria(this.getSession()).setFirstResult(startIndex).setMaxResults(fetchSize).list();
		return reservationList;
		
	}

	@Override
	public DetachedCriteria genCriteriaByHelper(ReservationQueryHelper helper) {
		
		DetachedCriteria criteria = DetachedCriteria.forClass(Reservation.class);

		if(StringUtils.isNotEmpty(helper.getQryRoomType()))
			criteria.add(Restrictions.eq("room.roomType", helper.getQryRoomType()));
		if(helper.getQryHotelId()!=null)
			criteria.createCriteria("room.hotel").add(Restrictions.eq("hotelId", helper.getQryHotelId()));
		if(helper.getQryCustomerId()!=null)
			criteria.createCriteria("customer").add(Restrictions.eq("customerId", helper.getQryCustomerId()));
		if(StringUtils.isNotEmpty(helper.getQryCustomerName()))
			criteria.add(Restrictions.like("customer.customerName", helper.getQryCustomerName(),MatchMode.ANYWHERE));
		
		criteria.addOrder(Order.desc("reservationId"));
		
		
		return criteria;
		
	}

	
}
