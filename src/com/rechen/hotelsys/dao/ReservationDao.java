/**
 * 
 */
package com.rechen.hotelsys.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.rechen.hotelsys.domain.Reservation;
import com.rechen.hotelsys.domain.ReservationQueryHelper;

/**
 * @author Re.chen
 *
 */
public interface ReservationDao {
	
	void saveReservation(Reservation reservation);
	List<Reservation> loadReservation();
	void deleteReservation(Integer reservationId);
	Reservation getReservationById(Integer reservationId);
	void updateReservation(Reservation reservation);
	
	Integer cntReservationByCondition(ReservationQueryHelper helper);
	List<Reservation> getScopedReservationsByCondition(ReservationQueryHelper helper , Integer startIndex , Integer fetchSize);
	DetachedCriteria genCriteriaByHelper(ReservationQueryHelper helper);
	
}
