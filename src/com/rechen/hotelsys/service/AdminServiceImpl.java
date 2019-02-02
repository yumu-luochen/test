/**
 * 
 */
package com.rechen.hotelsys.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.rechen.hotelsys.dao.AdminDao;
import com.rechen.hotelsys.domain.Admin;

/**
 * @author Re.chen
 *
 */
public class AdminServiceImpl implements AdminService {
	private static final Logger logger = Logger.getLogger(AdminServiceImpl.class);
	private AdminDao adminDao;
	
	@Override
	public Admin getAdminByNo(String adminNo) {
		logger.info("获取到账号为:"+adminNo+"开始读取整个账号信息!");
		return this.adminDao.getAdminByNo(adminNo);
	}

	@Override
	public Admin checkAdmin(String adminNo, String adminPwd) {
		logger.info("获取到账号和密码为:"+adminNo+"|"+adminPwd+"开始确认账号信息!");
		return this.adminDao.checkAdmin(adminNo, adminPwd);
	}
	
	

	@Override
	public void saveAdmin(Admin admin) {
		adminDao.saveAdmin(admin);
	}

	@Override
	public List<Admin> loadAdmin() {
		return adminDao.loadAdmin();
	}

	@Override
	public void deleteAdmin(String adminNo) {
		adminDao.deleteAdmin(adminNo);
	}

	@Override
	public void updateAdmin(Admin admin) {
		adminDao.updateAdmin(admin);
	}

	//-----------------
	
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

}
