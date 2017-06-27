package com.deskaction;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import UserDaoImplGuan.DeskClassGuan;
import UserDaoImplGuan.Menu;

import com.action.Bseaction;
import com.service.ToolService;

public class Action extends Bseaction {
	private ToolService ts = new ToolService();//获取数据库 数据 类的实现
	private Menu menu = new Menu();
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
	private String id;//菜品种类id
	private String deskid;
	private String name;
	private String foodPrice;
	private String num;
	private String str;//模糊搜索
	private String sum;
	private String foodid;
	private String shopname;
	private String shopdeskid;
	private String money;
	private String informationdeskid;//订单详情 桌台号
	private String orderid;
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public String getInformationdeskid() {
		return informationdeskid;
	}
	public void setInformationdeskid(String informationdeskid) {
		this.informationdeskid = informationdeskid;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getShopdeskid() {
		return shopdeskid;
	}
	public void setShopdeskid(String shopdeskid) {
		this.shopdeskid = shopdeskid;
	}
	public String getShopname() {
		return shopname;
	}
	public void setShopname(String shopname) {
		this.shopname = shopname;
	}
	public String getFoodid() {
		return foodid;
	}
	public void setFoodid(String foodid) {
		this.foodid = foodid;
	}
	public String getSum() {
		return sum;
	}
	public void setSum(String sum) {
		this.sum = sum;
	}
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFoodPrice() {
		return foodPrice;
	}
	public void setFoodPrice(String foodPrice) {
		this.foodPrice = foodPrice;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	
	public String getDeskid() {
		return deskid;
	}
	public void setDeskid(String deskid) {
		this.deskid = deskid;
	}
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
	private List<Map<String, Object>> car;
	
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
		ts.updateDeskid(deskid2, deskid1);
		ts.updateDeskid1(deskid2, deskid1);
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
		List<Map<String,Object>> menulist = ts.selectMenu();
		super.setSession("menuList", menulist);
		super.setSession("deskid", desk);
		List<Map<String,Object>> classifylist = ts.getClassify();
		super.setSession("classlist",classifylist );
		return "catchmenu";
	}
	/**
	 * 根据菜品种类id查询菜品
	 */
	public String Menu(){
		int id = Integer.parseInt(getId());
		List<Map<String,Object>> menu = ts.getMenu(id);
		super.setSession("menu", menu);
		ServletActionContext.getRequest().getSession().removeAttribute("menulist");	
		return "catchmenu";
	}
	/**
	 * 加入购物车
	 * @param car 
	 * 
	 */
	public String shop(){
		HttpServletRequest request = ServletActionContext.getRequest();
		Menu menu = new Menu();
		if("".equals(getFoodid()) || getFoodid()==null){
			return "shop";
		}
		int foodid1 = Integer.parseInt(getFoodid());
		menu = ts.getFoodprice(foodid1);
		float su = menu.getFoodPrice();
		int num = Integer.parseInt(getNum());
		float sum1 = su*num;
		Map map = new HashMap();
		map.put("name", name);
		map.put("price", foodPrice);
		map.put("num", num);
		map.put("sum", sum1);
		map.put("foodid",foodid1);
		HttpSession session = request.getSession();
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();//购物车
		if(session.getAttribute("car")==null){
			list.add(map);	
			session.setAttribute("car", list);
			return "shop";
		}else{
			car = (List<Map<String, Object>>) session.getAttribute("car");
			boolean find = false;
			for (int i = 0; i < car.size(); i++) {
				Map map1 = car.get(i);
				if(map1.get("name").equals(name)){
					int oldnum = (Integer) map1.get("num");
					int num1 = oldnum+num;
					map1.put("num", num1);
					float oldsum = (Float) map1.get("sum");
					float sum2 = oldsum+sum1;
					map1.put("sum", sum2);
					//list.add(map1);
					find=true;
					break;
				}
			}
			if(find==false){
				car.add(map);
			}
		}
		session.setAttribute("car", car);
		return "shop";
	}
	/**
	 * 订单
	 * @return
	 */
	public String catchOrders(){
		List<Map<String,Object>> orderlist = ts.gerUser_order();
		super.setSession("orderlist", orderlist);
		ServletActionContext.getRequest().getSession().removeAttribute("orderli");
		return "orders";
	}
	/**
	 * 模糊搜索菜单
	 */
	public String serchMenu(){
		if("".equals(str)){
			return "catchmenu";
		}
		List<Map<String,Object>> menulist = ts.searchMenu(str);
		super.setSession("menulist", menulist);
		ServletActionContext.getRequest().getSession().removeAttribute("menu");	
		return "catchmenu";
	}
	/**
	 * 删除购物车
	 * @return
	 */
	public String removeShop(){
		List<Map<String,Object>> ca = (List<Map<String,Object>>) super.getSesstion("car", car);
		HttpServletRequest request = ServletActionContext.getRequest();
		String name1 = request.getParameter("name");
		for (int i = 0; i < ca.size(); i++) {
			if(ca.get(i).get("name").equals(name1)){
				ca.remove(i);
			}
		}
		return "shop";
	}
	/**
	 * 添加订单
	 * @return
	 */
	public String addDetails(){
		List<Map<String,Object>> aa = (List<Map<String, Object>>) super.getSesstion("car", car);
		if(aa!=null || aa.size()>0){
				int deskid = Integer.parseInt(shopdeskid);
				int money = Integer.parseInt(getMoney());
				ts.intoUserorder(money, deskid);
				List<Map<String,Object>> dd = ts.catchOrderid(deskid);
				int orderid = (Integer) dd.get(0).get("orderID");

			for (int i = 0; i < aa.size(); i++) {
				int foodID = (Integer) aa.get(i).get("foodid");
				int num = (Integer) aa.get(i).get("num");
				float countmoney =  (Float) aa.get(i).get("sum");
				ts.intoDetails(orderid, foodID, num, countmoney, deskid, "待制作");
				ServletActionContext.getRequest().getSession().removeAttribute("car");
				ServletActionContext.getRequest().getSession().removeAttribute("deskid");	
			}
		}
		else{
			return "shop";
		}
		return save1();
	}
	/**
	 * 桌台详情
	 * @return
	 */
	public String Information(){
		int deskid = Integer.parseInt(informationdeskid);
		List<Map<String,Object>> aa = ts.catchInformation(deskid);
		List<Map<String,Object>> bb = ts.catchInformationMenu(deskid);
		super.setSession("aa", aa);
		super.setSession("bb", bb);
		super.setSession("informationdeskid", informationdeskid);
		return "information";
	}
	/**
	 * 审核订单
	 * @return
	 */
	public String updateOrder(){
		int orderid = Integer.parseInt(getOrderid());
		ts.updateOrder(orderid);
		return catchOrders();
	}
	/**
	 * 结账订单
	 */
	public String updateOrderMoney(){
		int orderid = Integer.parseInt(getOrderid());
		ts.updateOrderMoney(orderid);
		ts.addOrderDate(orderid);
		return catchOrders();
		
	}
	/**
	 * 历史订单
	 * @return
	 */
	public String oldOrder(){
		List<Map<String,Object>> orderli = ts.gerUser_order1();
		super.setSession("orderli", orderli);
		ServletActionContext.getRequest().getSession().removeAttribute("orderlist");
		return "orders";
	}
}