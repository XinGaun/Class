/**
 * 
 */
package zwd.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import zwd.biz.UserInfoBiz;
import zwd.biz.imp.UserInfoBizImp;
import zwd.entity.OrderEntity;

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
	//生成订单
		public String makeOrder(){
			//获取保存手机号的session
			Object MobileObje = request.getSession().getAttribute("Mobile");
			if(MobileObje==null){
				return "login";
			}else{
				String Mobile = MobileObje.toString();//获取个人的手机号
			oe.setMobile(Mobile);//订单添加手机号
			oe.setSort(1);//设置线上订单
			uib.addOrders(oe);//执行添加订单方法
			//查询插入数据的订单id。根据个人手机号查询最近一次的订单
			List<Map<String, Object>> findOrdersByMobile = uib.findOrdersByMobile(Mobile);//获取订单信息
			String orderIDStr = findOrdersByMobile.get(0).get("orderID").toString();//获取订单id
			int orderID = Integer.parseInt(orderIDStr);//将字符串转成int
			//获取购物车的session
			HttpSession cartSession = getRequest().getSession();
			//将cartsession强转成list获取map
			List<Map<String,Object>> cart= (List<Map<String ,Object>>)cartSession.getAttribute("cart");
			float countMoney = (float) 0.00;
			float countMoney1 = (float) 0.00;
			//循环购物车拿到菜品名称和数量
			for (int i = 0; i < cart.size(); i++) {
				Map<String,Object> temp = cart.get(i);
				//获取菜品名字
				String foodName = temp.get("foodName").toString();
				//获取菜品的数量
				int num = Integer.parseInt(temp.get("num").toString());
				//获取单个菜品的价格
				String foodPriceStr = temp.get("foodPrice").toString();
				float foodPrice = Float.parseFloat(foodPriceStr);	
				//获取当前菜品的单类总价钱
				countMoney1 =num*foodPrice;
				//得到最后的总价格
				countMoney=countMoney+countMoney1;
				//根据菜品名称获取相对应的菜品信息
				List<Map<String, Object>> onefoodID = uib.findFoodIDByFoodName(foodName);
				//获取菜品id
				String foodIDStr = onefoodID.get(0).get("foodID").toString();
				int foodID = Integer.parseInt(foodIDStr);//将字符串转成int
				int addOrder_details = uib.addOrder_details(orderID, foodID, num, countMoney1);
			}
			//修改订单的总价钱
			uib.updteOrderCountMoney(orderID,countMoney);
			//根据个人的订单表获取订单id
			/*cartSession.setAttribute("cart", "");*/
			return "order_mess";
		}
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
