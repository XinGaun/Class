/**
 * 
 */
package com.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.biz.UserInfoBiz;
import com.biz.imp.UserInfoBizImp;
import com.entity.AllFood;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.org.apache.bcel.internal.generic.GETSTATIC;
import com.util.BaseAction;

/**
 * @描述：菜品控制器
 * @所在公司 AAA
 * @author 张伟东
 * @日期2017-6-16下午2:36:22
 */
public class FoodAction extends BaseAction implements ModelDriven<AllFood> {
	AllFood af = new AllFood();//实例化菜品
	UserInfoBiz  uib = new UserInfoBizImp();//实例化对象
	Map<String, Object> session=ActionContext.getContext().getSession();//获取session
	public AllFood getModel() {
		return af;
	}
	//查询菜谱所有的菜品
	public String findAllFood(){
		List<Map<String, Object>> findAllFoods = uib.findAllFoods();//查询所有菜品方法
		session.put("findAllFoods", findAllFoods);
		session.put("findOndFoodCategory",null );
		return "success";
	}
	//查询单个菜品的信息
	public String findOneFood(){
		List<Map<String, Object>> findOneFood = uib.findOneFood(af.getFoodID());
		session.put("findOneFood", findOneFood);
		return "food_details";//返回到菜品的详情界面
		
	}
	//通过搜索字查询含有关键字的菜品
	
	public String findAllFoodsBySearch(){
		HttpServletRequest request = getRequest();//得到request
		String searchfood = request.getParameter("searchfood");//获取搜索文本框的值
		//根据关键字查询
		List<Map<String, Object>> findAllFoodsBySearch = uib.findAllFoodsBySearch(searchfood);
		//放入session内
		session.put("findFoodBySearch", findAllFoodsBySearch);
		return "success";
	}
	
	public AllFood getAf() {
		return af;
	}


	public void setAf(AllFood af) {
		this.af = af;
	}
	
	
}
