/**
 * 
 */
package com.rechen.hotelsys.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.rechen.hotelsys.dao.CustomerDao;
import com.rechen.hotelsys.dao.ReservationDao;
import com.rechen.hotelsys.dao.RoomDao;
import com.rechen.hotelsys.domain.Customer;
import com.rechen.hotelsys.domain.Reservation;
import com.rechen.hotelsys.domain.ReservationQueryHelper;
import com.rechen.hotelsys.domain.Room;
import com.rechen.hotelsys.utils.Page;

/**
 * @author Re.chen
 *
 */
public class ReservationServiceImpl implements ReservationService {
	
	private ReservationDao reservationDao;
	private RoomDao roomDao;
	private CustomerDao customerDao;
	
	private static final Logger logger = Logger.getLogger(ReservationServiceImpl.class);
	
	@Override
	public void saveReservation(Reservation reservation) {
		
		reservationDao.saveReservation(reservation);
		
		logger.info("进行对客房状态的修改,客房id为"+reservation.getRoom().getRoomId());
		Room room = roomDao.getRoomById(reservation.getRoom().getRoomId());
		room.setRoomStatus("b");
		logger.info("客房状态修改完毕,状态为已预订!");
		roomDao.updateRoom(room);
		
		logger.info("进行对客户的预定状态修改,客户id为"+reservation.getCustomer().getCustomerId());
		Customer customer = customerDao.getCustomerById(reservation.getCustomer().getCustomerId());
		customer.setCustomerBook("t");
		logger.info("客户状态修改完毕,状态为已预订!");
		customerDao.updateCustomer(customer);
	}

	@Override
	public List<Reservation> loadReservation() {
		return reservationDao.loadReservation();
	}

	@Override
	public void deleteReservation(Integer reservationId) {
		
		
		Reservation reservation = this.getReservationById(reservationId);
		logger.info("检测到取消预定,开始对客房状态信息进行修改");
		logger.info("进行对客房状态的修改,客房id为"+reservation.getRoom().getRoomId());
		Room room = roomDao.getRoomById(reservation.getRoom().getRoomId());
		room.setRoomStatus("a");
		logger.info("客房状态修改完毕,状态为空置房间!");
		roomDao.updateRoom(room);
		
		logger.info("进行对客户的预定状态修改,客户id为"+reservation.getCustomer().getCustomerId());
		Customer customer = customerDao.getCustomerById(reservation.getCustomer().getCustomerId());
		customer.setCustomerBook("f");
		logger.info("客户状态修改完毕,状态为未预订!");
		
		reservationDao.deleteReservation(reservationId);
		customerDao.updateCustomer(customer);
	}

	@Override
	public Reservation getReservationById(Integer reservationId) {
		return reservationDao.getReservationById(reservationId);
	}

	@Override
	public void updateReservation(Reservation reservation) {
		
		Room oldRoom = reservationDao.getReservationById(reservation.getReservationId()).getRoom();
		Room newRoom = roomDao.getRoomById(reservation.getRoom().getRoomId());
		
		Customer oldCustomer = reservationDao.getReservationById(reservation.getReservationId()).getCustomer();
		Customer newCustomer = customerDao.getCustomerById(reservation.getCustomer().getCustomerId());
		
		
		
		if(oldCustomer.getCustomerId()!=newCustomer.getCustomerId()){
			logger.info("检测到更换客户!");
			
			logger.info("进行对旧客户状态的修改,客户id为"+oldCustomer.getCustomerId());
			oldCustomer.setCustomerBook("f");
			customerDao.updateCustomer(oldCustomer);
			logger.info("旧客户状态修改完毕,状态为未预订!");
			
			logger.info("进行对新客户状态的修改,客户id为"+newCustomer.getCustomerId());
			newCustomer.setCustomerBook("t");
			customerDao.updateCustomer(newCustomer);
			logger.info("新客户状态修改完毕,状态为已预订!");	
			
		}
		
		if(oldRoom.getRoomId()!=newRoom.getRoomId()){
			logger.info("检测到客户更换预定房间!");
			
			logger.info("进行对旧客房状态的修改,客房id为"+oldRoom.getRoomId());
			oldRoom.setRoomStatus("a");
			roomDao.updateRoom(oldRoom);
			logger.info("旧客房状态修改完毕,状态为空置房间!");
			
			logger.info("进行对新客房状态的修改,客房id为"+newRoom.getRoomId());
			newRoom.setRoomStatus("b");
			roomDao.updateRoom(newRoom);
			logger.info("新客房状态修改完毕,状态为已预订!");			
		}
		
		reservationDao.updateReservation(reservation);
		
		logger.info("预定信息修改完成!");
	}

	@Override
	public Page getPagedReservations(ReservationQueryHelper helper,
			Page initPage) {
		
		initPage.setTotalRecNum((long)reservationDao.cntReservationByCondition(helper));
		initPage.setPageContent(reservationDao.getScopedReservationsByCondition(helper, initPage.getStartIndex(), initPage.getPageSize()));
		
		return initPage;
	}

	//----------------
	
	public void setRoomDao(RoomDao roomDao) {
		this.roomDao = roomDao;
	}

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	public void setReservationDao(ReservationDao reservationDao) {
		this.reservationDao = reservationDao;
	}
	
	
	
}
