/**
 * 
 */
package com.rechen.hotelsys.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.rechen.hotelsys.domain.Food;
import com.rechen.hotelsys.domain.FoodQueryHelper;
/**
 * @author Re.chen
 *
 */
public interface FoodDao {
	
	void saveFood(Food food);
	List<Food> loadFood();
	void deleteFood(Integer foodId);
	Food getFoodById(Integer foodId);
	void updateFood(Food food);
	
	//在某查询条件下记录的条数
	Integer cntFoodByCondition(FoodQueryHelper helper);
	//在某种查询条件下,从startIndex开始取值,取fetchSize条记录
	List<Food> getScopedFoodsByCondition(FoodQueryHelper helper,Integer startIndex,Integer fetchSize);
	DetachedCriteria genCriteriaByHelper(FoodQueryHelper helper);
	
}
