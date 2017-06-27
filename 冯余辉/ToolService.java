package com.service;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import queryGuan.portGuan;
import realizeGuan.RealizeztGuan;
import UserDaoImplGuan.DeskClassGuan;
import UserDaoImplGuan.Menu;

public class ToolService {
	private portGuan pt = new RealizeztGuan();
	public List<Map <String,Object>> query(){
		return pt.query();
	}
	/**
	 * 增加桌台
	 */
	public void add(DeskClassGuan dc){
		pt.add(dc);
	}
	/**
	 * 更新桌台
	 */
	public void update(int staid,int deskid){
		pt.update(staid, deskid);
	}
	/**
	 * 查询桌台
	 * @param id
	 * @return
	 */
	public List<Map <String,Object>> getdesk(int id){
		return pt.getdesk(id);
	}
	/**
	 * 查询未使用餐桌
	 * @param statuid
	 * @return
	 */
	public List<Map <String,Object>> getDesknotuse(){
		return pt.getDesknotuse();
	}
	/**
	 * 根据桌台号 查询本桌台的状态
	 * @param deskid
	 * @return
	 */
	public List<Map <String,Object>> getstatusName(int deskid){
		return pt.getstatusName(deskid);
	}
	/**
	 * 获取桌子
	 * @return
	 */
	public List<Map<String, Object>> getdeskone(){
		return pt.getdeskone();
	}
	/**
	 * 获取包厢
	 * @return
	 */
	public List<Map<String, Object>> getdesksecond(){
		return pt.getdesksecond();
	}
	/**
	 * 获取可用的桌子
	 * @return
	 */
	public List<Map <String,Object>> getdesknotuse(){
		return pt.getdesknotuse();
	}
	/**
	 * 获取可用的包厢
	 * @return
	 */	public List<Map <String,Object>> gethomedesknotuse(){
		return pt.gethomedesknotuse();
	}
	/**
	 * 查询人数大于num的餐桌
	 * @return
	 */
	public List<Map <String,Object>> penum(int num){
		return pt.peDesknum(num);
	}
	/**
	 * 查询人数大于num的包厢
	 * @return
	 */
	public List<Map <String,Object>> peHomeDesknum(int num) {
		return pt.peHomeDesknum(num);
	}
	/**
	 * 查询菜品
	 */
	public List<Map <String,Object>> selectMenu(){
		return pt.selectMenu();
	}
	/**
	 * 菜品种类查询
	 */
	public List<Map <String,Object>> getClassify(){
		return pt.getClassify();
	}
	/**
	 * 查询菜品
	 * @param id
	 * @return
	 */
	public List<Map <String,Object>> getMenu(int id){
		return pt.getMenu(id);
	}
	/**
	 * 订单
	 * @return
	 */
	public List<Map <String,Object>> gerUser_order(){
		return pt.gerUser_order();
	}
	public List<Map <String,Object>> gerUser_order1(){
		return pt.gerUser_order1();
	}
	/**
	 * 迷糊搜索 菜品
	 */
	public List<Map <String,Object>> searchMenu(String str){
		return pt.searchMenu(str);
	}
	/**
	 *获取食物价钱 
	 */
	public Menu getFoodprice(int id){
		return pt.getFoodprice(id);
	}
	/**
	 * 添加订单
	 */
	public int intoUserorder(float money,int deskid){
		return pt.intoUserorder(money, deskid);
	}
	/**
	 * 定单详情
	 */
	public int intoDetails(int orderid,int foodid,int num,float countmoney,int deskid,String statu){
		return pt.intoDetails(orderid, foodid, num, countmoney, deskid, statu);
	}
	/**
	 * 根据桌号查询订单号
	 * @param deskid
	 * @return
	 */
	public List<Map <String,Object>> catchOrderid(int deskid){
		return pt.catchOrderid(deskid);
	}
	/**
	 * 根据桌号查询菜单
	 * @param deskid
	 * @return
	 */
	public List<Map <String,Object>> catchInformationMenu(int deskid){
		return pt.catchInformationMenu(deskid);
	}
	/**
	 * 根据桌号查询订单号  价钱
	 * @param deskid
	 * @return
	 */
	public List<Map <String,Object>> catchInformation(int deskid){
		return pt.catchInformation(deskid);
	}
	/**
	 * 审核订单
	 * @param orderid
	 * @return
	 */
	public int updateOrder(int orderid){
		return pt.updateOrder(orderid);
	}
	/**
	 * 订单结束时间
	 * @param orderid
	 * @return
	 */
	public int addOrderDate(int orderid){
		return pt.addOrderDate(orderid);
	}
	/**
	 * 结账
	 */
	public int updateOrderMoney(int orderid){
		return pt.updateOrderMoney(orderid);
	}
	/**
	 * 转台
	 */
	public int updateDeskid(int deskid2,int deskid1){
		return pt.updateDeskid(deskid2, deskid1);
	}
	public int updateDeskid1(int deskid2,int deskid1){
		return pt.updateDeskid1(deskid2, deskid1);
	}
}

