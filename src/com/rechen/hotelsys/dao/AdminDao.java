/**
 * 
 */
package com.rechen.hotelsys.dao;

import java.util.List;

import com.rechen.hotelsys.domain.Admin;

/**
 * @author Re.chen
 *
 */
public interface AdminDao{
	
	Admin checkAdmin(String adminNo,String adminPwd);
	
	void saveAdmin(Admin admin);
	List<Admin> loadAdmin();
	void deleteAdmin(String adminNo);
	Admin getAdminByNo(String adminNo);
	void updateAdmin(Admin admin);
	
	
}
