/**
 * 
 */
package com.rechen.hotelsys.domain;

/**
 * @author Re.chen
 *
 */
public class Food extends ValueObject {
	
	private Integer foodId;//食品编号Id
	private String foodName;//食品名称
	private Double foodPurchasedPrice;//食品购入价格
	private Double foodSellPrice;//食品出售价格
	private Integer foodNumber;//食品数量
	private FoodCategory foodCategory;//食品所属分类
	
	
	//---------------
	public Integer getFoodId() {
		return foodId;
	}
	public void setFoodId(Integer foodId) {
		this.foodId = foodId;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public Double getFoodPurchasedPrice() {
		return foodPurchasedPrice;
	}
	public void setFoodPurchasedPrice(Double foodPurchasedPrice) {
		this.foodPurchasedPrice = foodPurchasedPrice;
	}
	public Double getFoodSellPrice() {
		return foodSellPrice;
	}
	public void setFoodSellPrice(Double foodSellPrice) {
		this.foodSellPrice = foodSellPrice;
	}
	public Integer getFoodNumber() {
		return foodNumber;
	}
	public void setFoodNumber(Integer foodNumber) {
		this.foodNumber = foodNumber;
	}
	public FoodCategory getFoodCategory() {
		return foodCategory;
	}
	public void setFoodCategory(FoodCategory foodCategory) {
		this.foodCategory = foodCategory;
	}
	
	
	
}
