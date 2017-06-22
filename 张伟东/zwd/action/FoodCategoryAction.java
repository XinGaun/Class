/**
 * 
 */
package zwd.action;

import java.util.List;
import java.util.Map;

import zwd.biz.UserInfoBiz;
import zwd.biz.imp.UserInfoBizImp;
import zwd.entity.FoodCategory;

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
	public FoodCategory getModel() {//模型
		
		return fc;
	}
	//查询所有的菜品种类
	public String findFoodCategory(){
		List<Map<String, Object>> findFoodCategory = uib.findFoodCategory();//查找到所有的菜品种类
		session.put("findFoodCategory", findFoodCategory);//将查询所有的菜品放入session内
		return "success";//返回到首页
	}
	//根据菜品的分类编号查询编号下的所有菜品
	public String findOneFoodCategory(){
		//调用查询一类菜品的方法
		List<Map<String, Object>> findOndFoodCategory = uib.findOndFoodCategory(fc.getClassid());
		session.put("findOndFoodCategory", findOndFoodCategory);//将查询一类的菜品放入session
		session.put("findFoodBySearch", null);//清空搜索的session
		return "success";
		
	}
}
