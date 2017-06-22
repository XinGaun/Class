/**
 * 
 */
package zwd.biz;

import java.util.List;
import java.util.Map;

import zwd.entity.OrderEntity;
import zwd.entity.UserInfo;


/**
 * @描述：用户的实现接口
 * @所在公司 AAA
 * @author 张伟东
 * @日期2017-6-15上午10:17:55
 */
public interface UserInfoBiz {
	int addUser(UserInfo userinfo);//注册用户
	int updatePwd(String newPwd,String Mobile);//修改密码
	List<Map<String,Object>>findUserByUserNameAndMobile(String UserName,String Mobile);//密码找回
	List<Map<String,Object>>findUser(String Mobile);//查看个人的信息
	List<Map<String,Object>>userLogin(String Mobile,String Userpwd);//用户登录
	List<Map<String,Object>>findOrders(String Mobile );//查看订单
	int addOrders(OrderEntity order);//添加订单
	int addOrder_details(int orderID,int foodID,int num,float countMoney);//添加订单详情表
	List<Map<String,Object>>findFoodIDByFoodName(String foodName);//根据菜名查询菜品的id
	int updteOrderCountMoney(int orderID,float countMoney);//修改订单总价钱
	List<Map<String,Object>>findOrdersDetails(int i);//查看订单详情
	List<Map<String,Object>>findOrdersByMobile(String Mobile);//根据个人手机号查询降序订单
	List<Map<String,Object>>findAllFoods();//查找全部菜品
	List<Map<String,Object>>findAllFoodsBySearch(String search);//通过搜索字查询含有关键字的菜品
	List<Map<String,Object>>findOneFood(int foodID);//查找单个菜品
	List<Map<String,Object>>findFoodCategory();//查看所有的菜品种类
	List<Map<String,Object>>findOndFoodCategory(int classid);//查看一个菜品种类下的所有产品
}
