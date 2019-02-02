/**
 * 
 */
package com.rechen.hotelsys.dao;

import java.util.List;




import org.apache.commons.lang.xwork.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.rechen.hotelsys.domain.Customer;
import com.rechen.hotelsys.domain.CustomerQueryHelper;

/**
 * @author Re.chen
 *
 */
public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {
	
	private static final Logger logger = Logger.getLogger(CustomerDaoImpl.class);

	@Override
	public void saveCustomer(Customer customer) {
		logger.info("正在尝试添加客户信息:"+customer.toString());
		this.getHibernateTemplate().save(customer);
	}

	@Override
	public List<Customer> loadCustomer() {
		return (List<Customer>)this.getHibernateTemplate().find("from Customer c order by c.customerId desc");
	}

	@Override
	public List<Customer> loadCustomer(CustomerQueryHelper helper) {
		return null;
	}

	@Override
	public void deleteCustomer(Integer customerId) {
		logger.info("正在删除客户Id为:"+customerId+"的客户");
		this.getHibernateTemplate().delete(this.getCustomerById(customerId));
	}

	@Override
	public Customer getCustomerById(Integer customerId) {
		
		return (Customer) this.getHibernateTemplate().get(Customer.class, customerId);
	}

	@Override
	public void updateCustomer(Customer customer) {
		logger.info("正在更新客户编号为:"+customer.getCustomerId());
		this.getHibernateTemplate().update(customer);
	}

	@Override
	public Integer cntCustomerByCondition(CustomerQueryHelper helper) {
		
		DetachedCriteria detachedCriteria = this.genCriteriaByHelper(helper);
		detachedCriteria.setProjection(Projections.rowCount());
		Integer cnt = 0;
		cnt = Integer.parseInt(detachedCriteria.getExecutableCriteria(this.getSession()).list().get(0).toString());
		
		return cnt;
	}

	@Override
	public List<Customer> getScopedRoomsByCondition(CustomerQueryHelper helper,
			Integer startIndex, Integer fetchSize) {
		
		DetachedCriteria detachedCriteria = this.genCriteriaByHelper(helper);
		List<Customer> customerList = null;
		
		customerList = detachedCriteria.getExecutableCriteria(this.getSession()).setFirstResult(startIndex).setMaxResults(fetchSize).list();
		return customerList;
	}

	@Override
	public DetachedCriteria genCriteriaByHelper(CustomerQueryHelper helper) {
		
		DetachedCriteria criteria =DetachedCriteria.forClass(Customer.class);
		
		if(StringUtils.isNotEmpty(helper.getQryCustomerName()))
			criteria.add(Restrictions.like("customerName", helper.getQryCustomerName(),MatchMode.ANYWHERE));
		if(StringUtils.isNotEmpty(helper.getQryCustomerSex()))
			criteria.add(Restrictions.eq("customerSex", helper.getQryCustomerSex()));
		criteria.addOrder(Order.desc("customerId"));
		
		return criteria;
	}

}
