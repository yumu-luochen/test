/**
 * 
 */
package com.rechen.hotelsys.dao;

import java.util.List;

import com.rechen.hotelsys.domain.FoodCategory;

/**
 * @author Re.chen
 *
 */
public interface FoodCategoryDao {
	void saveFoodCategory(FoodCategory foodCategory);
	List<FoodCategory> loadFoodCategory();
	void deleteFoodCategory(Integer foodCategoryId);
	FoodCategory getFoodCategoryById(Integer foodCategoryId);
	void updateFoodCategory(FoodCategory foodCategory);
}
