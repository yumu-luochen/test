/**
 * 
 */
package com.rechen.hotelsys.service;

import java.util.List;

import com.rechen.hotelsys.domain.Customer;
import com.rechen.hotelsys.domain.CustomerQueryHelper;
import com.rechen.hotelsys.utils.Page;

/**
 * @author Re.chen
 *
 */
public interface CustomerService {
	void saveCustomer(Customer customer);
	List<Customer> loadCustomer();
	List<Customer> loadCustomer(CustomerQueryHelper helper);
	void deleteCustomer(Integer customerId);
	Customer getCustomerById(Integer customerId);
	void updateCustomer(Customer customer);
	
	Page getPagedCustomers(CustomerQueryHelper helper,Page initPage);
}
