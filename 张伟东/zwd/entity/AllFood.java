/**
 * 
 */
package zwd.entity;

/**
 * @描述：菜品实体类
 * @所在公司 AAA
 * @author 张伟东
 * @日期2017-6-16下午2:31:42
 */
public class AllFood {
	private Integer foodID;
	private String foodName;
	private Integer  foodPrice;
	private Integer createtime ;
	private String foodCategory;
	private String foodCombine;
	public Integer getFoodID() {
		return foodID;
	}
	public void setFoodID(Integer foodID) {
		this.foodID = foodID;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public Integer getFoodPrice() {
		return foodPrice;
	}
	public void setFoodPrice(Integer foodPrice) {
		this.foodPrice = foodPrice;
	}
	public Integer getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Integer createtime) {
		this.createtime = createtime;
	}
	public String getFoodCategory() {
		return foodCategory;
	}
	public void setFoodCategory(String foodCategory) {
		this.foodCategory = foodCategory;
	}
	public String getFoodCombine() {
		return foodCombine;
	}
	public void setFoodCombine(String foodCombine) {
		this.foodCombine = foodCombine;
	}
	
}
