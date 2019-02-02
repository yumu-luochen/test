/**
 * 
 */
package com.rechen.hotelsys.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.rechen.hotelsys.domain.Customer;
import com.rechen.hotelsys.domain.Hotel;
import com.rechen.hotelsys.domain.Reservation;
import com.rechen.hotelsys.domain.ReservationQueryHelper;
import com.rechen.hotelsys.domain.Room;
import com.rechen.hotelsys.service.CustomerService;
import com.rechen.hotelsys.service.HotelService;
import com.rechen.hotelsys.service.ReservationService;
import com.rechen.hotelsys.service.RoomService;
import com.rechen.hotelsys.utils.Page;

/**
 * @author Re.chen
 *
 */

@ParentPackage("hotelSysPkg")
@Namespace("/reservation")
public class ReservationAction extends BaseAction {
	
	private static final Logger logger = Logger.getLogger(ReservationAction.class);
	
	private Reservation reservation;
	private List<Hotel> hotelList;
	private List<Room> roomList;
	private List<Customer> customerList;
	private List<Reservation> reservationList;
	private ReservationQueryHelper helper = new ReservationQueryHelper();
	private Page page = new Page();
	
	private RoomService roomService;
	private HotelService hotelService;
	private CustomerService customerService;
	private ReservationService reservationService;
	
	private Map<Integer,List<Room>> roomMap;
	
	
	@Action(value="toInput",results={@Result(name="input_page",location="/view/reservation/input_reservation.jsp")})
	public String toInput(){
		this.hotelList = hotelService.loadHotel();
		this.customerList = customerService.loadCustomer();
		
		roomMap = new HashMap<Integer,List<Room>>();
		List<Room> roomTest = new ArrayList<Room>(); 
		for(int i=0;i<hotelList.size();i++){
			roomTest = roomService.loadRoomByHotelId(hotelList.get(i).getHotelId());
			roomMap.put(hotelList.get(i).getHotelId(),roomTest);
		}
		
		return "input_page";
	}
	
	@Action(value="saveReservation",results={@Result(name="list_action",location="loadReservation",type="redirectAction")})
	public String saveReservation(){
		reservationService.saveReservation(reservation);
		return "list_action";
	}
	
	@Action(value="loadReservation",results={@Result(name="list_page",location="/view/reservation/list_reservation.jsp")})
	public String loadReservation(){
		this.hotelList = hotelService.loadHotel();
		this.roomList = roomService.loadRoom();	
		this.customerList = customerService.loadCustomer();
		this.reservationList = reservationService.loadReservation();
		Reservation reservationTest = new Reservation();
		for(int i = 0 ;i <reservationList.size() ; i++){
			reservationTest = reservationList.get(i);
			reservationTest.setRoom(roomService.getRoomById(reservationTest.getRoom().getRoomId()));
			reservationTest.setCustomer(customerService.getCustomerById(reservationTest.getCustomer().getCustomerId()));
			reservationList.set(i, reservationTest);
		}
		this.page = reservationService.getPagedReservations(helper, page);
		return "list_page";
	}
	
	@Action(value="deleteReservation",results={@Result(name="list_action",location="loadReservation",type="redirectAction")})
	public String deleteReservation(){
		reservationService.deleteReservation(reservation.getReservationId());
		return "list_action";
	}
	
	@Action(value="preUpdate",results={@Result(name="update_page",location="/view/reservation/update_reservation.jsp")})
	public String preUpdate(){
		this.hotelList = hotelService.loadHotel();
		this.customerList = customerService.loadCustomer();
		this.reservation = reservationService.getReservationById(reservation.getReservationId());
		
		roomMap = new HashMap<Integer,List<Room>>();
		List<Room> roomTest = new ArrayList<Room>(); 
		for(int i=0;i<hotelList.size();i++){
			roomTest = roomService.loadRoomByHotelId(hotelList.get(i).getHotelId());
			roomMap.put(hotelList.get(i).getHotelId(),roomTest);
		}
		
		return "update_page";
	}
	
	@Action(value="updateReservation",results={@Result(name="list_action",location="loadReservation",type="redirectAction")})
	public String updateReservation(){
		reservationService.updateReservation(reservation);
		return "list_action";
	}
	//-------------------
	
	public Reservation getReservation() {
		return reservation;
	}
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	public List<Hotel> getHotelList() {
		return hotelList;
	}
	public void setHotelList(List<Hotel> hotelList) {
		this.hotelList = hotelList;
	}
	public List<Room> getRoomList() {
		return roomList;
	}
	public void setRoomList(List<Room> roomList) {
		this.roomList = roomList;
	}
	public ReservationQueryHelper getHelper() {
		return helper;
	}
	public void setHelper(ReservationQueryHelper helper) {
		this.helper = helper;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public void setRoomService(RoomService roomService) {
		this.roomService = roomService;
	}
	public void setHotelService(HotelService hotelService) {
		this.hotelService = hotelService;
	}
	public void setReservationService(ReservationService reservationService) {
		this.reservationService = reservationService;
	}
	public List<Customer> getCustomerList() {
		return customerList;
	}
	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public Map<Integer, List<Room>> getRoomMap() {
		return roomMap;
	}

	public void setRoomMap(Map<Integer, List<Room>> roomMap) {
		this.roomMap = roomMap;
	}

	public List<Reservation> getReservationList() {
		return reservationList;
	}

	public void setReservationList(List<Reservation> reservationList) {
		this.reservationList = reservationList;
	}
	

}
