/**
 * 
 */
package com.rechen.hotelsys.domain;

/**
 * @author Re.chen
 *
 */
public class FoodQueryHelper extends ValueObject{
	
	private Integer qryFoodCategoryId;//食品分类Id
	private String qryFoodName;//食品名称
	
	
	//-------------------
	
	public String getQryFoodName() {
		return qryFoodName;
	}
	public Integer getQryFoodCategoryId() {
		return qryFoodCategoryId;
	}
	public void setQryFoodCategoryId(Integer qryFoodCategoryId) {
		this.qryFoodCategoryId = qryFoodCategoryId;
	}
	public void setQryFoodName(String qryFoodName) {
		this.qryFoodName = qryFoodName;
	}


}
