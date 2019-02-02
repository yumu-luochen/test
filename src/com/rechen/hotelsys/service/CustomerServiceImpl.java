/**
 * 
 */
package com.rechen.hotelsys.service;

import java.util.List;

import com.rechen.hotelsys.dao.CustomerDao;
import com.rechen.hotelsys.domain.Customer;
import com.rechen.hotelsys.domain.CustomerQueryHelper;
import com.rechen.hotelsys.utils.Page;

/**
 * @author Re.chen
 *
 */
public class CustomerServiceImpl implements CustomerService {
	private CustomerDao customerDao;

	@Override
	public void saveCustomer(Customer customer) {
		customerDao.saveCustomer(customer);
	}

	@Override
	public List<Customer> loadCustomer() {
		return customerDao.loadCustomer();
	}

	@Override
	public List<Customer> loadCustomer(CustomerQueryHelper helper) {
		return customerDao.loadCustomer(helper);
	}

	@Override
	public void deleteCustomer(Integer customerId) {
		customerDao.deleteCustomer(customerId);
	}

	@Override
	public Customer getCustomerById(Integer customerId) {
		return customerDao.getCustomerById(customerId);
	}

	@Override
	public void updateCustomer(Customer customer) {
		customerDao.updateCustomer(customer);
	}

	@Override
	public Page getPagedCustomers(CustomerQueryHelper helper, Page initPage) {
		
		initPage.setTotalRecNum((long)customerDao.cntCustomerByCondition(helper));
		initPage.setPageContent(customerDao.getScopedRoomsByCondition(helper, initPage.getStartIndex(), initPage.getPageSize()));
		
		return initPage;
	}
	
	
	//-----------

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	
}
