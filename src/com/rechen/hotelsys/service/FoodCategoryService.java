/**
 * 
 */
package com.rechen.hotelsys.service;

import java.util.List;

import com.rechen.hotelsys.domain.FoodCategory;

/**
 * @author Re.chen
 *
 */
public interface FoodCategoryService {
	void saveFoodCategory(FoodCategory foodCategory);
	List<FoodCategory> loadFoodCategory();
	void deleteFoodCategory(Integer foodCategoryId);
	FoodCategory getFoodCategoryById(Integer foodCategoryId);
	void updateFoodCategory(FoodCategory foodCategory);
}
