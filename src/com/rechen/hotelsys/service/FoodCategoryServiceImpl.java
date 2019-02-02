/**
 * 
 */
package com.rechen.hotelsys.service;

import java.util.List;

import com.rechen.hotelsys.dao.FoodCategoryDao;
import com.rechen.hotelsys.domain.FoodCategory;

/**
 * @author Re.chen
 *
 */
public class FoodCategoryServiceImpl implements FoodCategoryService {
	
	private FoodCategoryDao foodCategoryDao;

	@Override
	public void saveFoodCategory(FoodCategory foodCategory) {
		foodCategoryDao.saveFoodCategory(foodCategory);		
	}

	@Override
	public List<FoodCategory> loadFoodCategory() {
		return foodCategoryDao.loadFoodCategory();
	}

	@Override
	public void deleteFoodCategory(Integer foodCategoryId) {
		foodCategoryDao.deleteFoodCategory(foodCategoryId);
	}

	@Override
	public FoodCategory getFoodCategoryById(Integer foodCategoryId) {
		return foodCategoryDao.getFoodCategoryById(foodCategoryId);
	}

	@Override
	public void updateFoodCategory(FoodCategory foodCategory) {
		foodCategoryDao.updateFoodCategory(foodCategory);
	}
	
	//------------------
	public void setFoodCategoryDao(FoodCategoryDao foodCategoryDao) {
		this.foodCategoryDao = foodCategoryDao;
	}

}
