package com.rechen.hotelsys.action;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.rechen.hotelsys.domain.Food;
import com.rechen.hotelsys.domain.FoodCategory;
import com.rechen.hotelsys.domain.FoodQueryHelper;
import com.rechen.hotelsys.service.FoodCategoryService;
import com.rechen.hotelsys.service.FoodService;
import com.rechen.hotelsys.utils.Page;

/**
 * 
 * @author Re.chen
 *
 */
@ParentPackage("hotelSysPkg")
@Namespace("/food")
public class FoodAction extends BaseAction{
	private static final Logger logger = Logger.getLogger(FoodAction.class);
	
	private Page page = new Page();
	
	private FoodCategory foodCategory;
	private List<FoodCategory> foodCategoryList;
	private FoodCategoryService foodCategoryService;
	
	private Food food;
	private FoodService foodService;
	private FoodQueryHelper helper = new FoodQueryHelper();
	//---------Food相关
	@Action(value="toInputFood",results={@Result(name="input_food_page",location="/view/food/input_food.jsp")})
	public String toInputFood(){
		logger.info("进入食品添加界面!");
		this.foodCategoryList = foodCategoryService.loadFoodCategory();
		return "input_food_page";
	}
	
	@Action(value="saveFood",results={@Result(name="list_food_action",location="loadFood",type="redirectAction")})
	public String saveFood(){
		foodService.saveFood(food);
		return "list_food_action";
	}
	
	@Action(value="loadFood",results={@Result(name="list_food_page",location="/view/food/list_food.jsp")})
	public String loadFood(){
		this.foodCategoryList = foodCategoryService.loadFoodCategory();
		this.page = foodService.getPagedFoods(helper, page);
		return "list_food_page";
	}
	
	@Action(value="deleteFood",results={@Result(name="list_food_action",location="loadFood",type="redirectAction")})
	public String deleteFood(){
		foodService.deleteFood(food.getFoodId());
		return "list_food_action";
	}
	
	@Action(value="preUpdateFood",results={@Result(name="update_food_page",location="/view/food/update_food.jsp")})
	public String preUpdateFood(){
		this.food = foodService.getFoodById(food.getFoodId());
		this.foodCategoryList = foodCategoryService.loadFoodCategory();
		return "update_food_page";
	}
	
	@Action(value="updateFood",results={@Result(name="list_food_action",location="loadFood",type="redirectAction")})
	public String updateFood(){
		foodService.updateFood(food);
		return "list_food_action";
	}
	
	//---------FoodCategory相关
	@Action(value="toInputFoodCategory",results={@Result(name="input_food_category_page",location="/view/food/input_food_category.jsp")})
	public String toInputFoodCategory(){
		logger.info("进入食品分类添加界面!");
		return "input_food_category_page";
	}
	
	@Action(value="saveFoodCategory",results={@Result(name="list_food_category_action",location="loadFoodCategory",type="redirectAction")})
	public String saveFoodCategory(){
		foodCategoryService.saveFoodCategory(foodCategory);
		return "list_food_category_action";
	}
	
	@Action(value="loadFoodCategory",results={@Result(name="list_food_category_page",location="/view/food/list_food_category.jsp")})
	public String loadFoodCategory(){
		this.foodCategoryList = foodCategoryService.loadFoodCategory();
		return "list_food_category_page";
	}
	
	@Action(value="deleteFoodCategory",results={@Result(name="list_food_category_action",location="loadFoodCategory",type="redirectAction")})
	public String deleteFoodCategory(){
		foodCategoryService.deleteFoodCategory(foodCategory.getFoodCategoryId());
		return "list_food_category_action";
	}
	
	@Action(value="preUpdateFoodCategory",results={@Result(name="update_food_category_page",location="/view/food/update_food_category.jsp")})
	public String preUpdateFoodCategory(){
		this.foodCategory = foodCategoryService.getFoodCategoryById(foodCategory.getFoodCategoryId());
		return "update_food_category_page";
	}
	
	@Action(value="updateFoodCategory",results={@Result(name="list_food_category_action",location="loadFoodCategory",type="redirectAction")})
	public String updateFoodCategory(){
		foodCategoryService.updateFoodCategory(foodCategory);
		return "list_food_category_action";
	}
	//------
	public FoodCategory getFoodCategory() {
		return foodCategory;
	}
	public void setFoodCategory(FoodCategory foodCategory) {
		this.foodCategory = foodCategory;
	}
	public void setFoodCategoryService(FoodCategoryService foodCategoryService) {
		this.foodCategoryService = foodCategoryService;
	}

	public List<FoodCategory> getFoodCategoryList() {
		return foodCategoryList;
	}

	public void setFoodCategoryList(List<FoodCategory> foodCategoryList) {
		this.foodCategoryList = foodCategoryList;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public void setFoodService(FoodService foodService) {
		this.foodService = foodService;
	}

	public FoodQueryHelper getHelper() {
		return helper;
	}

	public void setHelper(FoodQueryHelper helper) {
		this.helper = helper;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}
	
}
