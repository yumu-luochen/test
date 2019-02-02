/**
 * 
 */
package com.rechen.hotelsys.service;

import java.util.List;

import com.rechen.hotelsys.domain.Food;
import com.rechen.hotelsys.domain.FoodQueryHelper;
import com.rechen.hotelsys.utils.Page;

/**
 * @author Re.chen
 *
 */
public interface FoodService {
	
	void saveFood(Food food);
	List<Food> loadFood();
	void deleteFood(Integer foodId);
	Food getFoodById(Integer foodId);
	void updateFood(Food food);

	Page getPagedFoods(FoodQueryHelper helper,Page initPage);
}
