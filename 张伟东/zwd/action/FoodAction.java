/**
 * 
 */
package zwd.action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import zwd.biz.UserInfoBiz;
import zwd.biz.imp.UserInfoBizImp;
import zwd.entity.AllFood;
import zwd.util.BaseAction;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.org.apache.bcel.internal.generic.GETSTATIC;

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
		session.put("findFoodBySearch", null);//将搜索保存的菜品session清空
		session.put("findOndFoodCategory",null );//将按种类保存的菜品session清空
		session.put("findAllFoods", findAllFoods);
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
		//加入购物车
		public String addCar(){
			HttpServletRequest request = getRequest();
			HttpServletResponse response = getResponse();
				String numStr = request.getParameter("num");//获取数量
				int num = Integer.parseInt(numStr);//获取当前数量
				float countPrice = num*(af.getFoodPrice());//获取总价
				//创建map存储加入购物车的菜品信息
				Map foodmap = new HashMap();
				foodmap.put("foodName", request.getParameter("foodName"));//将菜名放入map集合中
				foodmap.put("foodPrice", request.getParameter("foodPrice"));//将菜名放入map集合中
				foodmap.put("num", num);//将菜品数量放入map集合中
				foodmap.put("countPrice",countPrice);//将菜名总价map集合中
				//将购物的信息放入session内
				HttpSession carSession = getSession();//购物车session
				//carSession.setAttribute("cart", null);
				//创建描述购物车的list
				List <Map<String,Object>> cart = null;
				//购买第一件产品，第一次购买没有车子
				if(carSession.getAttribute("cart")==null){
					//创建描述购物车
					cart = new ArrayList<Map<String,Object>>();
					cart.add(foodmap);//将第一次添加的菜品保存在车子内
				}else{
					//获取之前的购物车
					cart = (List<Map<String,Object>>)carSession.getAttribute("cart");
					//判断该次购买的产品是否已在车中，默认不在车中
					boolean inCart=false;
					for(int i = 0 ;i <cart.size(); i ++){//循环车子，判断是否购物车内有相印的菜品
						//获取购物车内每条菜品数据
						Map<String, Object> temprecord = cart.get(i);
						//判断菜品名字和购物车内的菜品名字是否重复
						if(temprecord.get("foodName").equals(af.getFoodName())){
							//取出之前已经购买的数量
							int oldNum = Integer.parseInt(temprecord.get("num").toString());
							int newCount = num+ oldNum;//原有的数量+新传入的数量==合计
							temprecord.put("num", newCount);//将总共的数量重新放入map集合中
							//计算总价
							float oldCount = Float.parseFloat(temprecord.get("countPrice").toString());//获取原有的总价
							float newcountPrice = oldCount + countPrice;
							temprecord.put("countPrice", newcountPrice);//将总共的数量重新放入map集合中
							inCart=true;
							break;
							//新的菜品时
						}
					}		
						if(inCart==false){		//已经不是第一次添加购物车，已经有车子了	
							cart.add(foodmap);//把菜品放入车子
						}
			}
				//将车子放入session
				carSession.setAttribute("cart",cart);
				//跳转到购物车界面
				return "shoppingcar";
			}
	public AllFood getAf() {
		return af;
	}


	public void setAf(AllFood af) {
		this.af = af;
	}
	
	
}
