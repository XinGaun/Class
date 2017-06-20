/**
 * 
 */
package com.dao.imp;

import java.util.List;
import java.util.Map;

import com.dao.UserInfoDao;
import com.entity.UserInfo;
import com.util.BaseDaoZ;

/**
 * @描述：
 * @所在公司 AAA
 * @author 张伟东
 * @日期2017-6-15上午10:15:57
 */
public class UserInfoDaoImp extends BaseDaoZ implements UserInfoDao {

	//用户注册
	public int addUser(UserInfo userinfo) {
		String sql="insert into users(Mobile,Userpwd,UserAddress,UserName) values(?,?,?,?)";
		Object [] params={userinfo.getMobile(),userinfo.getUserpwd(),userinfo.getUserAddress(),userinfo.getUserName()};
		return executeUpdate(sql, params);
	}
	//用户登录

	public List<Map<String, Object>> userLogin(String Mobile, String Userpwd) {
		String sql="select * from users where mobile =? and userpwd=?";
		Object []params={Mobile,Userpwd};
		return executeQuery(sql, params);
	}

	//查看购物车
	public List<Map<String, Object>> findOrders(String Mobile) {
		//String sql ="select * from (select cc.UserID,dd.* from (select aa.UserID,bb.orderID from users aa inner join user_order bb on aa.UserID=bb.UserID)cc inner join order_details dd on cc.orderID=dd.orderID) ee inner join menu ff on ee.foodID=ff.foodID where UserID =?";
		String sql="select * from users a inner join user_order b on a.Mobile=b.Mobile where a.Mobile=?";
		Object []params={Mobile};
		return executeQuery(sql, params);
	}
	//查看订单详情
	public List<Map<String, Object>> findOrdersDetails(int orderID) {
		String sql ="select * from users a ,user_order b ,order_details c,menu d where a.Mobile=b.Mobile and b.orderID=c.orderID and c.foodID=d.foodID and b.orderID=?";
		Object []params={orderID};
		return executeQuery(sql, params);
	}
	//查看全部的菜品
	public List<Map<String, Object>> findAllFoods() {
		String sql="select * from menu";
		return executeQuery(sql, null);
	}

	//查询单个菜品
	public List<Map<String, Object>> findOneFood(int foodID) {
		String sql="select * from menu where foodID=?";
		Object[]params={foodID};
		return executeQuery(sql, params);
	}
	//查看所有的菜品种类
	public List<Map<String, Object>> findFoodCategory() {
		String sql="select * from classify";
		return executeQuery(sql, null);
	}

	//查看一个菜品种类下的所有产品
	public List<Map<String, Object>> findOndFoodCategory(int classid) {
		String sql="select * from menu a inner join classify b on a.classid=b.classid where b.classid =?";
		Object[] params={classid};
		return executeQuery(sql, params);
	}
	//查看个人的信息
	public List<Map<String, Object>> findUser(String Mobile) {
		String sql = "select * from users where Mobile= ?";
		Object [] params ={Mobile};
		return executeQuery(sql, params);
	}

	//密码找回
	public List<Map<String, Object>> findUserByUserNameAndMobile(
			String UserName, String Mobile) {
		String sql ="select * from users where UserName=? and Mobile=?";
		Object [] params={UserName,Mobile};
		return executeQuery(sql, params);
	}

	//修改用户信息
	public List<Map<String, Object>> updateUser(UserInfo userinfo) {
		String sql="";
		return null;
	}

	//修改密码
	public int updatePwd(String newPwd,String Mobile) {
		String sql = "update users set Userpwd=? where Mobile=? ";
		Object[]params={ newPwd, Mobile};
		return executeUpdate(sql, params);
	}

	//通过搜索字查询含有关键字的菜品
	public List<Map<String, Object>> findAllFoodsBySearch(String search) {
		String sql = "select * from menu where foodName like '%"+search+"%'"; 
		return executeQuery(sql, null);
	}


}
