/**
 * 
 */
package com.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.biz.UserInfoBiz;
import com.biz.imp.UserInfoBizImp;
import com.entity.OrderEntity;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @描述：订单控制器
 * @所在公司 AAA
 * @author 张伟东
 * @日期2017-6-16上午10:19:19
 */
public class OrderMessAction extends ActionSupport implements ModelDriven<OrderEntity>{
	UserInfoBiz uib = new UserInfoBizImp();//实例化业务层
	HttpServletRequest request = ServletActionContext.getRequest();
	//HttpSession session = request.getSession();
	Map<String, Object> session=ActionContext.getContext().getSession();
	OrderEntity oe = new OrderEntity();//实例化订单

	public OrderEntity getModel() {
		// TODO Auto-generated method stub
		return oe;
	}
	//查看订单详情
		public String findOrdersDetails(){
			//String oderIDStr = request.getParameter("oderID");
			//int oderID = Integer.parseInt(oderIDStr);
			List<Map<String, Object>> findOrdersDetails = uib.findOrdersDetails(oe.getOrderID());
			session.put("findOrdersDetails", findOrdersDetails);
			return "customer_mess";
		}
		public UserInfoBiz getUib() {
			return uib;
		}
		public void setUib(UserInfoBiz uib) {
			this.uib = uib;
		}
		public HttpServletRequest getRequest() {
			return request;
		}
		public void setRequest(HttpServletRequest request) {
			this.request = request;
		}
		public Map<String, Object> getSession() {
			return session;
		}
		public void setSession(Map<String, Object> session) {
			this.session = session;
		}
		public OrderEntity getOe() {
			return oe;
		}
		public void setOe(OrderEntity oe) {
			this.oe = oe;
		}

}
