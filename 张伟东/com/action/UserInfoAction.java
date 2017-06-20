/**
 * 
 */
package com.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.rmi.server.UID;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.processors.JsonBeanProcessor;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.biz.UserInfoBiz;
import com.biz.imp.UserInfoBizImp;
import com.entity.OrderEntity;
import com.entity.UserInfo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.util.BaseAction;

/**
 * @描述：
 * @所在公司 AAA
 * @author 张伟东
 * @日期2017-6-15上午10:20:16
 */
public class UserInfoAction extends BaseAction implements ModelDriven<UserInfo> {
	
	UserInfoBiz uib = new UserInfoBizImp();//实例化业务层
	HttpServletRequest request = ServletActionContext.getRequest();
	
	//HttpSession session = request.getSession();
	Map<String, Object> session=ActionContext.getContext().getSession();
	UserInfo ui = new UserInfo();//实例化用户实体类
	OrderEntity oe = new OrderEntity();//实例化订单
	HttpServletResponse response = ServletActionContext.getResponse();
	
	List<Map<String, Object>> findUser = uib.findUser(ui.getMobile());//根据手机号查询个人信息
	
	public UserInfo getModel() {
		// TODO Auto-generated method stub
		return ui;
	}

//用户注册

	public String uersReg()  {
			uib.addUser(ui);
			session.clear();
			session.put("Mobile", ui.getMobile());
			List<Map<String, Object>> findUser = uib.findUser(ui.getMobile());//根据手机号查询个人信息
			session.put("user", findUser);
			return "success";
		}
	//用户登录
	public String userLogin() {
		List<Map<String, Object>> userLogin = uib.userLogin(ui.getMobile(),ui.getUserpwd());
		if(userLogin.size()>0){//登录成功
			/*String parameter = request.getParameter("agree");
			if(null!=parameter){
				addCookie("Mobile", ui.getMobile());
				System.out.println(parameter);
			}else{
				
			}*/
			/**/
			session.put("Mobile", ui.getMobile());
			session.put("user", userLogin);
		/*	Map map = new HashMap();
			map.put("mo",  ui.getMobile());
			String jsonString = JSON.toJSONString(map);*/
			
			//writer.print(jsonString);
			return "success";//返回首页
		
		}
		else{
			return "login";//返回注册界面
			}
	}
	//注销登录
	public String logout(){
		session.clear();//清空session
		
		return "success";//返回首页
	}
	//验证注册时的号码是否已被注册
	public void findOnlyMobile(){
		String Mobile = request.getParameter("Mobile");
		List<Map<String, Object>> checkMobile = uib.findUser(Mobile);
		//System.out.println(checkMobile.size());
		if(checkMobile.size()>0&&checkMobile!=null){//数据库有数据证明手机号已被使用
			getOut().print(1);
		}else{//查询不到结果，表示手机号未被注册
			getOut().print(2);
			
		}
		
	}
	//查询个人信息
	public String updateMessage(){
		List<Map<String, Object>> findUser = uib.findUser(ui.getMobile());//根据手机号查询个人信息
		session.put("userMessage", findUser);
		return "user_message";
	}
	
	//密码找回
	public String findpwd(){
		String Mobile = request.getParameter("Mobile");
		String UserName = request.getParameter("UserName");
		List<Map<String, Object>> findPwd = uib.findUserByUserNameAndMobile(UserName,Mobile);
		if(findPwd.size()>0&&findPwd!=null){
			String jsonString = JSON.toJSONString(findPwd);
			getOut().print(jsonString);
		
		}else{
			getOut().print(2);
		}
		return null;
	}
	//修改密码前验证手机号码是否正确
	public String BeforeUpdate(){
		List<Map<String, Object>> userLogin = uib.userLogin(ui.getMobile(),ui.getUserpwd());
		if(userLogin.size()>0){//登录成功
			getOut().print(1);
		}else{
			getOut().print(2);
		}
		return null;
	}
	
	//修改个人信息未完成
		public String updatepwd(){
			int updatePwd = uib.updatePwd(ui.getUserpwd(), ui.getMobile());//执行更新方法
			
			return null;
		}
	
	
	
	  private void addCookie(String name,String value){
	        Cookie cookie = new Cookie(name, value);
	        cookie.setMaxAge(60*60*24);
	        ServletActionContext.getResponse().addCookie(cookie);
	    }
	    
	    private String getCookie(String name){
	        HttpServletRequest request = ServletActionContext.getRequest();
	        Cookie[] cookies = request.getCookies();
	        for(Cookie cookie : cookies)
	        {
	            if(cookie.getName().equals(name))
	            {
	                return cookie.getValue();
	            }
	        }
	        return null;
	    }
	//}
	    
	//查看订单
	public String findOrders( ){
	/*	//判断是否已经登录
		Object object = session.get("Mobile");//获取session里的手机号
		String sessionStr = object.toString();//转成字符串
		if(sessionStr==null){//如果session内容为空，说明没有登录，跳转到登录界面
			return "error";
		}
		//session有值，进入我的账户
		else{*/
			//System.out.println(ui.getMobile());
			List<Map<String, Object>> findOrders = uib.findOrders(ui.getMobile());//调用查询订单方法
			session.put("findOrders", findOrders);//将查询到的list放到session
			return "order_mess";
			}
	//查看订单详情
	public String findOrdersDetails(){
		String oderIDStr = request.getParameter("oderID");
		int oderID = Integer.parseInt(oderIDStr);
		List<Map<String, Object>> findOrdersDetails = uib.findOrdersDetails(oderID);
		session.put("findOrdersDetails", findOrdersDetails);
		return null;
	}
	
	public UserInfo getUi() {
		return ui;
	}
	public void setUi(UserInfo ui) {
		this.ui = ui;
	}
}
