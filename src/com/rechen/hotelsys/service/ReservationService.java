/**
 * 
 */
package com.rechen.hotelsys.service;

import java.util.List;

import com.rechen.hotelsys.domain.Reservation;
import com.rechen.hotelsys.domain.ReservationQueryHelper;
import com.rechen.hotelsys.utils.Page;

/**
 * @author Re.chen
 *
 */
public interface ReservationService {
	
	void saveReservation(Reservation reservation);
	List<Reservation> loadReservation();
	void deleteReservation(Integer reservationId);
	Reservation getReservationById(Integer reservationId);
	void updateReservation(Reservation reservation);
	
	Page getPagedReservations(ReservationQueryHelper helper,Page initPage);
	
}
