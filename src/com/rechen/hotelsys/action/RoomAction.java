/**
 * 
 */
package com.rechen.hotelsys.action;

import java.util.List;
import java.util.Map;

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
import com.rechen.hotelsys.domain.Room;
import com.rechen.hotelsys.domain.RoomQueryHelper;
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
@Namespace("/room")
public class RoomAction extends BaseAction implements RequestAware,SessionAware{
	private static final Logger logger = Logger.getLogger(RoomAction.class);
	
	private Room room;
	private Reservation reservation;
	private List<Hotel> hotelList;
	private List<Reservation> reservationList;
	private RoomQueryHelper helper = new RoomQueryHelper();
	private Page page = new Page();
	private Map<String,Object> request;
	private Map<String,Object> session;
	
	private HotelService hotelService;
	private RoomService roomService;
	private ReservationService reservationService;
	
	@Action(value="toInput",results={@Result(name="input_page",location="/view/room/input_room.jsp")})
	public String toInput(){		
		this.hotelList = hotelService.loadHotel();
		return "input_page";
	}
	
	@Action(value="saveRoom",results={@Result(name="list_action",location="loadRoom",type="redirectAction"),
								      @Result(name="input_page",location="/view/room/input_room.jsp")})
	public String saveRoom(){	
		
		try{
			roomService.saveRoom(room);
		}catch(DataAccessException e){
			this.request.put("errMsg", e.getMessage());
			this.hotelList = hotelService.loadHotel();
			logger.info(e.getMessage());
			return "input_page";
		}
		
		return "list_action";
	}
	
	@Action(value="loadRoom",results={@Result(name="list_page",location="/view/room/list_room.jsp")})
	public String loadRoom(){		
		this.hotelList = hotelService.loadHotel();
		this.page = roomService.getPagedRooms(helper, page);
		
		
		return "list_page";
	}
	
	@Action(value="deleteRoom",results={@Result(name="list_action",location="loadRoom",type="redirectAction"),
										@Result(name="list_page",location="/view/room/list_room.jsp")})
	public String deleteRoom(){
		try{
			this.reservationList = reservationService.loadReservation();
			for(int i = 0; i<reservationList.size();i++){
				if(reservationList.get(i).getRoom().getRoomId().equals(room.getRoomId()) )
					throw new DataAccessException("该房间存在已预订的客户,请先取消客户的预订!");
			}
			roomService.deleteRoom(room.getRoomId());
		}catch (DataAccessException e) {
			this.request.put("errMsg", e.getMessage());
			this.hotelList = hotelService.loadHotel();
			this.page = roomService.getPagedRooms(helper, page);
			return "list_page";
		}
		
		return "list_action";
	}
	
	@Action(value="preUpdate",results={@Result(name="update_page",location="/view/room/update_room.jsp")})
	public String preUpdate(){
		this.room = roomService.getRoomById(room.getRoomId());
		this.hotelList = hotelService.loadHotel();
		
		return "update_page";
	}
	
	@Action(value="updateRoom",results={@Result(name="list_action",location="loadRoom",type="redirectAction"),
										@Result(name="update_action",location="preUpdate",type="redirectAction")
										})
	public String updateRoom(){		
		try{
			roomService.updateRoom(room);
		}catch(DataAccessException e){
			this.request.put("errMsg",e.getMessage());
			this.room = roomService.getRoomById(room.getRoomId());
			this.hotelList = hotelService.loadHotel();
			return "update_action";
		}
		return "list_action";
	}
	//------------------------
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public List<Hotel> getHotelList() {
		return hotelList;
	}
	public void setHotelList(List<Hotel> hotelList) {
		this.hotelList = hotelList;
	}
	public RoomQueryHelper getHelper() {
		return helper;
	}
	public void setHelper(RoomQueryHelper helper) {
		this.helper = helper;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}

	public void setHotelService(HotelService hotelService) {
		this.hotelService = hotelService;
	}
	public void setRoomService(RoomService roomService) {
		this.roomService = roomService;
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

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public List<Reservation> getReservationList() {
		return reservationList;
	}

	public void setReservationList(List<Reservation> reservationList) {
		this.reservationList = reservationList;
	}

	public void setReservationService(ReservationService reservationService) {
		this.reservationService = reservationService;
	}


}
