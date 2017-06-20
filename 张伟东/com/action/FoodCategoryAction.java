/**
 * 
 */
package com.action;

import java.util.List;
import java.util.Map;

import com.biz.UserInfoBiz;
import com.biz.imp.UserInfoBizImp;
import com.entity.FoodCategory;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @描述：菜品种类控制器
 * @所在公司 AAA
 * @author 张伟东
 * @日期2017-6-17上午8:44:25
 */
public class FoodCategoryAction extends ActionSupport implements ModelDriven<FoodCategory> {

	FoodCategory fc = new FoodCategory();//实例化菜品种类
	UserInfoBiz  uib = new UserInfoBizImp();//实例化业务层
	Map<String, Object> session=ActionContext.getContext().getSession();//获取session
	public FoodCategory getModel() {
		
		return fc;
	}
	//查询所有的菜品种类
	public String findFoodCategory(){
		List<Map<String, Object>> findFoodCategory = uib.findFoodCategory();//查找到所有的菜品种类
		session.put("findFoodCategory", findFoodCategory);
		return "success";
	}
	//根据菜品的分类编号查询编号下的所有菜品
	public String findOneFoodCategory(){
		List<Map<String, Object>> findOndFoodCategory = uib.findOndFoodCategory(fc.getClassid());
		session.put("findOndFoodCategory", findOndFoodCategory);
		return "success";
		
	}
}
