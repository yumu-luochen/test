/**
 * 
 */
package com.rechen.hotelsys.service;

import java.util.List;

import com.rechen.hotelsys.dao.FoodDao;
import com.rechen.hotelsys.domain.Food;
import com.rechen.hotelsys.domain.FoodQueryHelper;
import com.rechen.hotelsys.utils.Page;

/**
 * @author Re.chen
 *
 */
public class FoodServiceImpl implements FoodService {

	private FoodDao foodDao;
	
	@Override
	public void saveFood(Food food) {
		foodDao.saveFood(food);
	}

	@Override
	public List<Food> loadFood() {
		return foodDao.loadFood();
	}

	@Override
	public void deleteFood(Integer foodId) {
		foodDao.deleteFood(foodId);
	}

	@Override
	public Food getFoodById(Integer foodId) {
		return foodDao.getFoodById(foodId);
	}

	@Override
	public void updateFood(Food food) {
		foodDao.updateFood(food);
	}

	@Override
	public Page getPagedFoods(FoodQueryHelper helper, Page initPage) {
		
		initPage.setTotalRecNum((long)foodDao.cntFoodByCondition(helper));
		initPage.setPageContent(foodDao.getScopedFoodsByCondition(helper, initPage.getStartIndex(), initPage.getPageSize()));
		
		return initPage;
	}
	//---------------
	
	public void setFoodDao(FoodDao foodDao) {
		this.foodDao = foodDao;
	}


	
}
