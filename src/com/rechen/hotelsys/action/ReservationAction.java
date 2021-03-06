/**
 * 
 */
package com.rechen.hotelsys.action;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.rechen.hotelsys.domain.Customer;
import com.rechen.hotelsys.domain.Hotel;
import com.rechen.hotelsys.domain.Reservation;
import com.rechen.hotelsys.domain.ReservationQueryHelper;
import com.rechen.hotelsys.domain.Room;
import com.rechen.hotelsys.exception.DataAccessException;
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
public class ReservationAction extends BaseAction implements RequestAware,SessionAware{
	
	private static final Logger logger = Logger.getLogger(ReservationAction.class);
	
	private Reservation reservation;
	private Customer customer;
	private List<Hotel> hotelList;
	private List<Room> roomList;
	private List<Customer> customerList;
	private List<Reservation> reservationList;
	private ReservationQueryHelper helper = new ReservationQueryHelper();
	private Page page = new Page();
	
	private Map<String,Object> request;
	private Map<String,Object> session;
	
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
	
	@Action(value="saveReservation",results={@Result(name="list_action",location="loadReservation",type="redirectAction"),
											 @Result(name="input_page",location="/view/reservation/input_reservation.jsp")})
	public String saveReservation(){
		try{
			boolean flag = false;
			this.customerList = customerService.loadCustomer();
			for(int i = 0;i<customerList.size();i++){
				if(customerList.get(i).getCustomerId().equals(reservation.getCustomer().getCustomerId()))
						flag = true;
			}
			if(!flag)
				throw new DataAccessException("该客户Id不存在!!");
			reservationService.saveReservation(reservation);
		}catch(DataAccessException e){
			this.request.put("errMsg", e.getMessage());
			this.hotelList = hotelService.loadHotel();
			this.customerList = customerService.loadCustomer();
			roomMap = new HashMap<Integer,List<Room>>();
			List<Room> roomTest = new ArrayList<Room>(); 
			for(int i=0;i<hotelList.size();i++){
				roomTest = roomService.loadRoomByHotelId(hotelList.get(i).getHotelId());
				roomMap.put(hotelList.get(i).getHotelId(),roomTest);
			}
			logger.info(e.getMessage());
			return "input_page";
		}
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
	
	@Action(value="updateReservation",results={@Result(name="list_action",location="loadReservation",type="redirectAction"),
											   @Result(name="update_page",location="/view/reservation/update_reservation.jsp")})
	public String updateReservation(){
		try{
			boolean flag = false;
			this.customerList = customerService.loadCustomer();
			for(int i = 0;i<customerList.size();i++){
				if(customerList.get(i).getCustomerId().equals(reservation.getCustomer().getCustomerId()))
						flag = true;
			}
			if(!flag)
				throw new DataAccessException("该客户Id不存在!!");
			reservationService.updateReservation(reservation);
		}catch(DataAccessException e){
			this.request.put("errMsg", e.getMessage());
			this.hotelList = hotelService.loadHotel();
			this.customerList = customerService.loadCustomer();
			roomMap = new HashMap<Integer,List<Room>>();
			List<Room> roomTest = new ArrayList<Room>(); 
			for(int i=0;i<hotelList.size();i++){
				roomTest = roomService.loadRoomByHotelId(hotelList.get(i).getHotelId());
				roomMap.put(hotelList.get(i).getHotelId(),roomTest);
			}
			logger.info(e.getMessage());
			return "update_page";
		}
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Map<String, Object> getRequest() {
		return request;
	}

	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	

}
