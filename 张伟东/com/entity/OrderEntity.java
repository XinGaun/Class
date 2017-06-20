/**
 * 
 */
package com.entity;

import java.util.Date;

/**
 * @描述：订单实体类
 * @所在公司 AAA
 * @author 张伟东
 * @日期2017-6-15下午8:33:20
 */
public class OrderEntity {
	private int orderID;//订单id
	private String orderStatus;//订单状态
	private Date orderTime;//订单时间
	private String payway;//支付方式
	private int countPrice;//总价
	private String fooddMess;//菜品说明
	
	public String getFooddMess() {
		return fooddMess;
	}
	public void setFooddMess(String fooddMess) {
		this.fooddMess = fooddMess;
	}
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public String getPayway() {
		return payway;
	}
	public void setPayway(String payway) {
		this.payway = payway;
	}
	public int getCountPrice() {
		return countPrice;
	}
	public void setCountPrice(int countPrice) {
		this.countPrice = countPrice;
	}
	
	
}
