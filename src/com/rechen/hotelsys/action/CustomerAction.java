/**
 * 
 */
package com.rechen.hotelsys.action;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.rechen.hotelsys.domain.Customer;
import com.rechen.hotelsys.domain.CustomerQueryHelper;
import com.rechen.hotelsys.service.CustomerService;
import com.rechen.hotelsys.utils.Page;

/**
 * @author Re.chen
 *
 */
@ParentPackage("hotelSysPkg")
@Namespace("/customer")
public class CustomerAction extends BaseAction {
	private static final Logger logger = Logger.getLogger(CustomerAction.class);
	
	private Customer customer;
	private CustomerQueryHelper helper = new CustomerQueryHelper();
	private Page page = new Page();
	
	private CustomerService customerService;

	@Action(value="toInput",results={@Result(name="input_page",location="/view/customer/input_customer.jsp")})
	public String toInput(){
		logger.info("进入客户登记界面!");
		return "input_page";
	}
	
	@Action(value="saveCustomer",results={@Result(name="list_action",location="loadCustomer",type="redirectAction")})
	public String saveCustomer(){
		logger.info("准备保存客户信息:"+customer.toString());
		customerService.saveCustomer(customer);
		logger.info("客户信息保存完毕");
		return "list_action";
	}
	
	@Action(value="loadCustomer",results={@Result(name="list_page",location="/view/customer/list_customer.jsp")})
	public String loadCustomer(){
		this.page = customerService.getPagedCustomers(helper, page);
		
		return "list_page";
	}
	
	@Action(value="deleteCustomer",results={@Result(name="list_action",location="loadCustomer",type="redirectAction")})
	public String deleteCustomer(){
		customerService.deleteCustomer(customer.getCustomerId());
		return "list_action";
	}
	
	@Action(value="preUpdate",results={@Result(name="update_page",location="/view/customer/update_customer.jsp")})
	public String preUpdate(){
		this.customer = customerService.getCustomerById(customer.getCustomerId());
		return "update_page";
	}
	
	@Action(value="updateCustomer",results={@Result(name="list_action",location="loadCustomer",type="redirectAction")})
	public String updateCustomer(){
		customerService.updateCustomer(customer);
		return "list_action";
	}
	//---------------------------
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public CustomerQueryHelper getHelper() {
		return helper;
	}

	public void setHelper(CustomerQueryHelper helper) {
		this.helper = helper;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

}
