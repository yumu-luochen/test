/**
 * 
 */
package com.rechen.hotelsys.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.rechen.hotelsys.domain.Customer;
import com.rechen.hotelsys.domain.CustomerQueryHelper;

/**
 * @author Re.chen
 *
 */
public interface CustomerDao {
	void saveCustomer(Customer customer);
	List<Customer> loadCustomer();
	List<Customer> loadCustomer(CustomerQueryHelper helper);
	void deleteCustomer(Integer customerId);
	Customer getCustomerById(Integer customerId);
	void updateCustomer(Customer customer);
	
	Integer cntCustomerByCondition(CustomerQueryHelper helper);
	List<Customer> getScopedRoomsByCondition(CustomerQueryHelper helper,Integer startIndex,Integer fetchSize);
	DetachedCriteria genCriteriaByHelper(CustomerQueryHelper helper);
}
