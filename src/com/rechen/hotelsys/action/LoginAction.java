/**
 * 
 */
package com.rechen.hotelsys.action;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.rechen.hotelsys.action.LoginAction;
import com.rechen.hotelsys.domain.Admin;
import com.rechen.hotelsys.exception.HotelSysException;
import com.rechen.hotelsys.service.AdminService;

/**
 * 登录界面Action
 * @author Re.chen
 *
 */
@ParentPackage("hotelSysPkg")
@Namespace("/login")
@InterceptorRef("guest")
public class LoginAction extends BaseAction implements RequestAware,SessionAware{
	private Admin admin;
	private Map<String,Object> request;
	private Map<String,Object> session;
	private AdminService adminService;
	private List<Admin> adminList;
	private static final Logger logger = Logger.getLogger(LoginAction.class);
	
	
	
	/** 进入登录界面的action */
	@Action(value="toLogin",results={@Result(name="login_page",location="/view/login.jsp")})
	public String toLogin(){
		logger.info("进入登录界面!");
		return "login_page";
	}
	
	/** 登录界面确认账号信息的aciton */
	@Action(value="login",results={@Result(name="home_page",location="/view/home.jsp"),
						           @Result(name="login_page",location="/view/login.jsp")
								  })
	public String login() throws Exception{
		try{
			logger.info("开始尝试登录!");
			this.admin = adminService.checkAdmin(admin.getAdminNo(), admin.getAdminPwd());
			this.session.put("loginedAdmin", admin);
			logger.info("账号信息核对成功!即将进入主界面!");
			return "home_page";
		}catch(HotelSysException e){
			this.request.put("errMsg",e.getMessage());
			logger.info("账号信息不正确!原因为:"+e.getMessage());
			return "login_page";
		}
	}
	
	/** 进入首页界面的action */
	@Action(value="home",results={@Result(name="home_page",location="/view/home.jsp")})
	public String home(){
		return "home_page";
	}
	
	@Action(value="loginOut",results={@Result(name="login_action",location="/view/login.jsp")})
	public String loginOut(){
		this.session.remove("loginedAdmin");
		this.session = null;
		return "login_action";
	}
	
	//操作员管理界面Action
	@Action(value="toInput",results={@Result(name="input_page",location="/view/admin/input_admin.jsp")})
	public String toInput(){
		logger.info("进入管理员登记界面!");
		return "input_page";
	}
	
	
	@Action(value="saveAdmin",results={@Result(name="list_action",location="loadAdmin",type="redirectAction")})
	public String saveAdmin(){
		adminService.saveAdmin(admin);
		return "list_action";
	}
	
	@Action(value="loadAdmin",results={@Result(name="list_page",location="/view/admin/list_admin.jsp")})
	public String loadAdmin(){
		this.adminList = adminService.loadAdmin();
		return "list_page";
	}
	
	@Action(value="deleteAdmin",results={@Result(name="list_action",location="loadAdmin",type="redirectAction")})
	public String deleteAdmin(){
		adminService.deleteAdmin(admin.getAdminNo());
		return "list_action";
	}	
	
	@Action(value="preUpdate",results={@Result(name="update_page",location="/view/admin/update_admin.jsp")})
	public String preUpdate(){
		this.admin = adminService.getAdminByNo(admin.getAdminNo());
		return "update_page";
	}	
	
	@Action(value="updateAdmin",results={@Result(name="list_action",location="loadAdmin",type="redirectAction")})
	public String updateAdmin(){
		adminService.updateAdmin(admin);
		return "list_action";
	}	
	
	//----------------------
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	public List<Admin> getAdminList() {
		return adminList;
	}

	public void setAdminList(List<Admin> adminList) {
		this.adminList = adminList;
	}
	
}
