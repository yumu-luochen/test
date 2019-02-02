/**
 * 
 */
package com.rechen.hotelsys.domain;

/**
 * @author Re.chen
 *
 */
public class FoodCategory extends ValueObject {
	
	private Integer foodCategoryId;
	private String foodCategoryName;
	
	public Integer getFoodCategoryId() {
		return foodCategoryId;
	}
	public void setFoodCategoryId(Integer foodCategoryId) {
		this.foodCategoryId = foodCategoryId;
	}
	public String getFoodCategoryName() {
		return foodCategoryName;
	}
	public void setFoodCategoryName(String foodCategoryName) {
		this.foodCategoryName = foodCategoryName;
	}
}
