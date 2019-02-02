/**
 * 
 */
package com.rechen.hotelsys.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.rechen.hotelsys.domain.FoodCategory;

/**
 * @author Re.chen
 *
 */
public class FoodCategoryDaoImpl extends HibernateDaoSupport implements FoodCategoryDao {
	
	private static final Logger logger = Logger.getLogger(HotelDaoImpl.class);

	@Override
	public void saveFoodCategory(FoodCategory foodCategory) {
		logger.info("正在保存食品分类名称:"+foodCategory.getFoodCategoryName());
		this.getHibernateTemplate().save(foodCategory);		
	}

	@Override
	public List<FoodCategory> loadFoodCategory() {
		logger.info("正在读取食品分类信息");
		return (List<FoodCategory>)this.getHibernateTemplate().find("from FoodCategory fc order by fc.foodCategoryId desc");
	}

	@Override
	public void deleteFoodCategory(Integer foodCategoryId) {
		logger.info("正在删除食品分类Id:"+foodCategoryId);
		this.getHibernateTemplate().delete(this.getFoodCategoryById(foodCategoryId));
	}

	@Override
	public FoodCategory getFoodCategoryById(Integer foodCategoryId) {
		return (FoodCategory) this.getHibernateTemplate().load(FoodCategory.class, foodCategoryId);
	}

	@Override
	public void updateFoodCategory(FoodCategory foodCategory) {
		logger.info("正在更新食品分类Id:"+foodCategory.getFoodCategoryId());
		this.getHibernateTemplate().update(foodCategory);
	}

}
