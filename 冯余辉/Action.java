package com.deskaction;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import UserDaoImplGuan.DeskClassGuan;

import com.action.Bseaction;
import com.service.ToolService;

public class Action extends Bseaction {
	
	private ToolService ts = new ToolService();//获取数据库 数据 类的实现
	private List<DeskClassGuan> list;//
	private String desksize;//添加桌子的人数
	private String deskclass;//添加桌子的种类
	private String information;//查询input的数据
	private String user;//桌号
	private String use;//桌号
	private String deskidone;//桌号
	private String deskid1;//转台桌号
	private String deskid2;//转台桌号
	private String desknum;//结账桌号
	private String opendeskid;//开台桌号
	public String getOpendeskid() {
		return opendeskid;
	}
	public void setOpendeskid(String opendeskid) {
		this.opendeskid = opendeskid;
	}
	public String getDesknum() {
		return desknum;
	}
	public void setDesknum(String desknum) {
		this.desknum = desknum;
	}
	public String getDeskidone() {
		return deskidone;
	}
	public void setDeskidone(String deskidone) {
		this.deskidone = deskidone;
	}
	private String peosonnum;//人数
	
	public String getPeosonnum() {
		return peosonnum;
	}
	public void setPeosonnum(String peosonnum) {
		this.peosonnum = peosonnum;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getUse() {
		return use;
	}
	public void setUse(String use) {
		this.use = use;
	}
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information;
	}
	public String getDesksize() {
		return desksize;
	}
	public void setDesksize(String desksize) {
		this.desksize = desksize;
	}
	public String getDeskclass() {
		return deskclass;
	}
	public void setDeskclass(String deskclass) {
		this.deskclass = deskclass;
	}
	public List<DeskClassGuan> getList() {
		return list;
	}
	public void setList(List<DeskClassGuan> list) {
		this.list = list;
	}
	public String getDeskid1() {
		return deskid1;
	}
	public void setDeskid1(String deskid1) {
		this.deskid1 = deskid1;
	}
	public String getDeskid2() {
		return deskid2;
	}
	public void setDeskid2(String deskid2) {
		this.deskid2 = deskid2;
	}
	/**
	 * 显示页面
	 * @return
	 */
	public String save(){
		List<Map<String,Object>> list= ts.query();//获取餐台表的全部信息
		super.setSession("list",list);
		return "success";//转到picture-list.jsp页面
	}
	/**
	 * 添加页面
	 * @return
	 */
	public String add(){
		
		return "fail";//转到systemadd.jsp页面——添加桌子页面
	}
	/**
	 * 添加数据  转到显示页面
	 * @return
	 */
	public String adddesk(){
		if("".equals(desksize)|| desksize==null|| "".equals(deskclass)||deskclass==null){
			return save();
		}
		int ds = Integer.parseInt(desksize);
		int cs = Integer.parseInt(deskclass);
		DeskClassGuan dc = new DeskClassGuan();
		dc.setDeskSize(ds);
		dc.setZtclassid(cs);
		ts.add(dc);
		return save();//转到picture-list.jsp页面
	}	
	/**
	 * 根据餐桌号查询桌台
	 * @return
	 */
	public String query(){
		if("".equals(information) || information==null){	
			return "success";
		}
		int id = Integer.parseInt(information);
		List<Map <String,Object>> list1 = ts.getdesk(id);
		super.setSession("listone", list1);
		return "ok";
	}
	
	/**
	 * 修改餐台状态 -使用
	 * @return
	 */
	public String update(){
		int desk = Integer.parseInt(user);
		ts.update(1, desk);
		return save();
	}
	
	/**
	 * 修改餐桌状态-空闲
	 */
	public String update1(){
		int desk = Integer.parseInt(use);
		ts.update(2, desk);
		return save();
	}
	/**
	 * 修改餐桌状态-空闲-清台
	 */
	public String updateFree(){
		if("".equals(getDeskidone())){
			return save1();
		}
		int desk = Integer.parseInt(deskidone);
		ts.update(2, desk);
		return save1();
	}
	/**
	 * 获取未使用餐桌 
	 * @return
	 */
	public String getDesknouse(){
		List<Map<String,Object>> list1 = ts.getdesknotuse();
		List<Map<String,Object>> list2 = ts.gethomedesknotuse();
		super.setSession("desknotuselist", list1);
		super.setSession("homedesknotuselist", list2);
		return "homepage";
	}
	/**
	 * 获取大厅  包厢 
	 */
	public String save1(){
		List<Map<String,Object>> list1= ts.getdeskone();
		List<Map<String,Object>> list2= ts.getdesksecond();
		super.setSession("desklistone",list1);
		super.setSession("desklistsecond", list2);
		return "opendesk";
	}
	/**
	 * 获取大厅
	 * @return
	 */
	public String getdesk(){
		List<Map<String,Object>> listdesk= ts.getdeskone();
		super.setSession("desklist",listdesk);
		return "deskone";
	}
	/**
	 * 获取包厢
	 * @return
	 */
	public String gethomedesk(){
		List<Map<String,Object>> listdeskhome= ts.getdesksecond();
		super.setSession("homedesklist",listdeskhome);
		return "homedesk";
	}
	/**
	 * 根据人数查询餐桌
	 * @return
	 */
	public String peNum(){
		if("".equals(getPeosonnum())){
			return save1();
		}
		int num = Integer.parseInt(peosonnum);
		List<Map<String,Object>> listdesk= ts.penum(num);
		List<Map<String,Object>> listhomedesk= ts.peHomeDesknum(num);
		super.setSession("list",listdesk);
		super.setSession("homelist", listhomedesk);
		return "freedesk";
	}
	/**
	 * 转台 -修改状态
	 */
	public String change(){
		if("".equals(getDeskid1()) || "".equals(getDeskid2()) ){	
			return "homepage";
		}
		int deskid1 = Integer.parseInt(getDeskid1());
		int deskid2 = Integer.parseInt(getDeskid2());
		ts.update(2, deskid1);
		ts.update(1, deskid2);
		return save1();
	}
	/**
	 * 结账
	 * @return
	 */
	public String checkout(){
		if("".equals(getDesknum()) || getDesknum()==null){	
			return "opendesk";
		}
		int deskid1 = Integer.parseInt(desknum);
		ts.update(2, deskid1);
		return save1();
	}
	/**
	 * 开台
	 */
	public String opendesk(){
		int desk= Integer.parseInt(opendeskid);
		ts.update(1, desk);
		return save1();
	}
}