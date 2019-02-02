/**
 * 
 */
package com.rechen.hotelsys.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
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

import com.rechen.hotelsys.action.HotelAction;
import com.rechen.hotelsys.domain.Hotel;
import com.rechen.hotelsys.service.HotelService;

/**
 * @author Re.chen
 *
 */
@ParentPackage("hotelSysPkg")
@Namespace("/hotel")
public class HotelAction extends BaseAction {
	
	private static final Logger logger = Logger.getLogger(HotelAction.class);
	
	private Hotel hotel;

	private List<Hotel> hotelList;
	private HotelService hotelService;


	private File hotelPic;
	
	@Action(value="toInput",results={@Result(name="input_page",location="/view/hotel/input_hotel.jsp")})
	public String toInput(){
		logger.info("进入新开分店界面!");
		return "input_page";
	}
	
	@Action(value="saveHotel",results={@Result(name="list_action",location="loadHotels",type="redirectAction")})
	public String saveHotel(){
		logger.info("正在准备添加新的分店,分店的信息为:"+hotel.toString());
		FileInputStream fis = null;
		try{
			fis = new FileInputStream(hotelPic);
			byte[] imgData = new byte[fis.available()];
			fis.read(imgData);
			this.hotel.setHotelPic(imgData);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		hotelService.saveHotel(hotel);
		logger.info("成功添加新的分店!");
		return "list_action";
	}
	
	@Action(value="loadHotels",results={@Result(name="list_page",location="/view/hotel/list_hotel.jsp")})
	public String loadHotels(){
		logger.info("进入分店列表界面!");
		this.hotelList = hotelService.loadHotel();
		return "list_page";		
	}
	
	@Action(value="deleteHotel",results={@Result(name="list_action",location="loadHotels",type="redirectAction")})
	public String deleteHotel(){
		logger.info("准备删除id为:"+hotel.getHotelId()+"的分店!");
		hotelService.deleteHotel(hotel.getHotelId());
		logger.info("已经成功删除!");
		return "list_action";
	}
	
	@Action(value="preUpdate",results={@Result(name="update_page",location="/view/hotel/update_hotel.jsp")})
	public String preUpdate(){
		logger.info("进入修改分店id为:"+hotel.getHotelId()+"的界面");
		this.hotel = hotelService.getHotelById(hotel.getHotelId());
		return "update_page";
	}
	
	@Action(value="updateHotel",results={@Result(name="list_action",location="loadHotels",type="redirectAction")})
	public String updateHotel(){
		FileInputStream fis = null;
		try{
			if(hotelPic!=null){
				fis = new FileInputStream(hotelPic);
				byte[] imgData = new byte[fis.available()];
				fis.read(imgData);
				this.hotel.setHotelPic(imgData);
				}
			else{
				this.hotel.setHotelPic(hotelService.getHotelPicById(hotel.getHotelId()));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		hotelService.updateHotel(hotel);
		logger.info("成功修改分店信息,准备进入分店列表界面!");
		return "list_action";
	}
	
	@Action(value="getPic")
	public String getPic() throws Exception{
		byte[] hotelPic = hotelService.getHotelPicById(hotel.getHotelId());
		if(hotelPic == null || hotelPic.length==0){
			String defaultPicPath = ServletActionContext.getRequest().getRealPath("/")+"imgs/no-pic.jpg";
			FileInputStream fis = new FileInputStream(defaultPicPath);
			hotelPic = new byte[fis.available()];
			fis.read();
		}
		
		ServletActionContext.getResponse().setContentType("imgs/jpg");
		ServletOutputStream sos = ServletActionContext.getResponse().getOutputStream();
		sos.write(hotelPic);
		sos.flush();
		sos.close();
		return null;
	}
	//getter和setter
	public File getHotelPic() {
		return hotelPic;
	}

	public void setHotelPic(File hotelPic) {
		this.hotelPic = hotelPic;
	}

	public void setHotelService(HotelService hotelService) {
		this.hotelService = hotelService;
	}

	public List<Hotel> getHotelList() {
		return hotelList;
	}

	public void setHotelList(List<Hotel> hotelList) {
		this.hotelList = hotelList;
	}
	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
}
