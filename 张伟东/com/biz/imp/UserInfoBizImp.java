/**
 * 
 */
package com.biz.imp;

import java.util.List;
import java.util.Map;

import com.biz.UserInfoBiz;
import com.dao.UserInfoDao;
import com.dao.imp.UserInfoDaoImp;
import com.entity.UserInfo;

/**
 * @描述：用户实现类
 * @所在公司 AAA
 * @author 张伟东
 * @日期2017-6-15上午10:18:38
 */
public class UserInfoBizImp implements UserInfoBiz {

	UserInfoDao uid = new UserInfoDaoImp();
	//用户注册
	public int addUser(UserInfo userinfo) {
		return uid.addUser(userinfo);
	}
	//用户登录
	public List<Map<String, Object>> userLogin(String Mobile, String Userpwd) {
		return uid.userLogin(Mobile, Userpwd);
	}
	//查看订单
	public List<Map<String, Object>> findOrders(String Mobile) {
		
		return uid.findOrders(Mobile);
	}
	//查看订单详情
	public List<Map<String, Object>> findOrdersDetails(int orderID) {
		return uid.findOrdersDetails(orderID);
	}
	//查看全部菜品
	public List<Map<String, Object>> findAllFoods() {
	
		return uid.findAllFoods();
	}
	//查找单个菜品
	public List<Map<String, Object>> findOneFood(int foodID) {
		
		return uid.findOneFood(foodID);
	}
	//查看所有的菜品种类
	public List<Map<String, Object>> findFoodCategory() {
		
		return uid.findFoodCategory();
	}
	//查看一个菜品种类下的所有产品
	public List<Map<String, Object>> findOndFoodCategory(int classid) {

		return uid.findOndFoodCategory(classid);
	}
	//查看个人的信息
	public List<Map<String, Object>> findUser(String Mobile) {
		// TODO Auto-generated method stub
		return uid.findUser(Mobile);
	}
//密码找回
	public List<Map<String, Object>> findUserByUserNameAndMobile(
			String UserName, String Mobile) {
		
		return uid.findUserByUserNameAndMobile(UserName, Mobile);
	}
	//修改密码
	public int updatePwd(String newPwd, String Mobile) {
		return uid.updatePwd(newPwd, Mobile);
	}
	//通过搜索字查询含有关键字的菜品
	public List<Map<String, Object>> findAllFoodsBySearch(String search) {
		
		return uid.findAllFoodsBySearch(search);
	}


}
