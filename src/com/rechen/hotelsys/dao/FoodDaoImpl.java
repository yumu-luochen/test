/**
 * 
 */
package com.rechen.hotelsys.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.rechen.hotelsys.domain.Food;
import com.rechen.hotelsys.domain.FoodQueryHelper;
import com.rechen.hotelsys.domain.Room;

/**
 * @author Re.chen
 *
 */
public class FoodDaoImpl extends HibernateDaoSupport implements FoodDao {

	private static final Logger logger = Logger.getLogger(FoodDaoImpl.class);
	
	@Override
	public void saveFood(Food food) {
		logger.info("正在尝试添加食品信息:"+food.toString());
		this.getHibernateTemplate().save(food);
	}

	@Override
	public List<Food> loadFood() {
		logger.info("正在读取全部食品信息!");
		return (List<Food>)this.getHibernateTemplate().find("from Food f order by f.foodId desc");
	}

	@Override
	public void deleteFood(Integer foodId) {
		logger.info("正在尝试删除食品Id:"+foodId);
		this.getHibernateTemplate().delete(this.getFoodById(foodId));
	}

	@Override
	public Food getFoodById(Integer foodId) {
		return (Food) this.getHibernateTemplate().get(Food.class, foodId);
	}

	@Override
	public void updateFood(Food food) {
		logger.info("正在更新食品信息Id:"+food.getFoodId());
		this.getHibernateTemplate().update(food);
	}

	@Override
	public Integer cntFoodByCondition(FoodQueryHelper helper) {
		DetachedCriteria detachedCriteria = this.genCriteriaByHelper(helper);
		detachedCriteria.setProjection(Projections.rowCount());
		Integer cnt = 0;
		cnt=Integer.parseInt(detachedCriteria.getExecutableCriteria(this.getSession()).list().get(0).toString());
		
		return cnt;
	}

	@Override
	public List<Food> getScopedFoodsByCondition(FoodQueryHelper helper,
			Integer startIndex, Integer fetchSize) {
		
		DetachedCriteria detachedCriteria = this.genCriteriaByHelper(helper);
		List<Food> foodList = null;
		
		foodList = detachedCriteria.getExecutableCriteria(this.getSession()).setFirstResult(startIndex).setMaxResults(fetchSize).list();
		
		return foodList;
	}

	@Override
	public DetachedCriteria genCriteriaByHelper(FoodQueryHelper helper) {
		
		DetachedCriteria criteria = DetachedCriteria.forClass(Food.class);
		
		if(helper.getQryFoodCategoryId()!=null)
			criteria.createCriteria("foodCategory").add(Restrictions.eq("foodCategoryId", helper.getQryFoodCategoryId()));
		if(StringUtils.isNotEmpty(helper.getQryFoodName()))
			criteria.add(Restrictions.like("foodName", helper.getQryFoodName(),MatchMode.ANYWHERE));

		criteria.addOrder(Order.desc("foodId"));
		
		
		return criteria;
	}

}
