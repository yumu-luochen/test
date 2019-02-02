/**
 * 
 */
package com.rechen.hotelsys.action;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.rechen.hotelsys.domain.Hotel;
import com.rechen.hotelsys.domain.Room;
import com.rechen.hotelsys.domain.RoomQueryHelper;
import com.rechen.hotelsys.exception.DataAccessException;
import com.rechen.hotelsys.service.HotelService;
import com.rechen.hotelsys.service.RoomService;
import com.rechen.hotelsys.utils.Page;

/**
 * @author Re.chen
 *
 */
@ParentPackage("hotelSysPkg")
@Namespace("/room")
public class RoomAction extends BaseAction{
	private static final Logger logger = Logger.getLogger(RoomAction.class);
	
	private Room room;
	private List<Hotel> hotelList;
	private RoomQueryHelper helper = new RoomQueryHelper();
	private Page page = new Page();
	
	private HotelService hotelService;
	private RoomService roomService;
	
	@Action(value="toInput",results={@Result(name="input_page",location="/view/room/input_room.jsp")})
	public String toInput(){		
		this.hotelList = hotelService.loadHotel();
		return "input_page";
	}
	
	@Action(value="saveRoom",results={@Result(name="list_action",location="loadRoom",type="redirectAction")})
	public String saveRoom(){		
		roomService.saveRoom(room);
		return "list_action";
	}
	
	@Action(value="loadRoom",results={@Result(name="list_page",location="/view/room/list_room.jsp")})
	public String loadRoom(){		
		this.hotelList = hotelService.loadHotel();
		this.page = roomService.getPagedRooms(helper, page);
		
		
		return "list_page";
	}
	
	@Action(value="deleteRoom",results={@Result(name="list_action",location="loadRoom",type="redirectAction")})
	public String deleteRoom(){		
		roomService.deleteRoom(room.getRoomId());
		return "list_action";
	}
	
	@Action(value="preUpdate",results={@Result(name="update_page",location="/view/room/update_room.jsp")})
	public String preUpdate(){
		this.room = roomService.getRoomById(room.getRoomId());
		this.hotelList = hotelService.loadHotel();
		
		return "update_page";
	}
	
	@Action(value="updateRoom",results={@Result(name="list_action",location="loadRoom",type="redirectAction"),
										@Result(name="update_page",location="/view/room/update_room")
										})
	public String updateRoom(){		
		try{
			roomService.updateRoom(room);
		}catch(DataAccessException e){
			ServletActionContext.getRequest().setAttribute("errMsg", e.getMessage());
			this.hotelList = hotelService.loadHotel();
			return "update_page";
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

}
