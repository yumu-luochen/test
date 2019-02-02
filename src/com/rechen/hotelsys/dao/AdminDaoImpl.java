/**
 * 
 */
package com.rechen.hotelsys.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.rechen.hotelsys.domain.Admin;
import com.rechen.hotelsys.exception.DataAccessException;

/**
 * @author Re.chen
 *
 */
public class AdminDaoImpl extends HibernateDaoSupport implements AdminDao {

	private static final Logger logger = Logger.getLogger(AdminDaoImpl.class);
	
	@Override
	public Admin getAdminByNo(String adminNo) {
		Admin admin = null;
		
			admin = (Admin)this.getHibernateTemplate().get(Admin.class,adminNo);
			if(admin==null)
				throw new DataAccessException("账号为："+adminNo+"不存在，请检查！！！");

		return admin;
	}

	@Override
	public Admin checkAdmin(String adminNo, String adminPwd) {
		
		Admin admin = this.getAdminByNo(adminNo);
		
		if(!admin.getAdminPwd().equals(adminPwd))
			throw new DataAccessException("账号正确，但是密码不正确！！！");
		return admin;
	}

	@Override
	public void saveAdmin(Admin admin) {
		logger.info("正在尝试添加管理员信息:"+admin.toString());
		this.getHibernateTemplate().save(admin);
	}

	@Override
	public List<Admin> loadAdmin() {
		return (List<Admin>)this.getHibernateTemplate().find("from Admin a order by a.adminNo desc");
	}

	@Override
	public void deleteAdmin(String adminNo) {
		logger.info("正在删除管理员No:"+adminNo);
		this.getHibernateTemplate().delete(this.getAdminByNo(adminNo));
	}

	@Override
	public void updateAdmin(Admin admin) {
		logger.info("正在更新管理员No:"+admin.getAdminNo());
		this.getHibernateTemplate().update(admin);
	}

}
