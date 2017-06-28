package zhangjunchao.Controller;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import zhangjunchao.Model.RealizeModel.ModelDepart;
import zhangjunchao.Model.RealizeModel.ModelStaff;
import zhangjunchao.Model.portModel.DepartModelPort;
import zhangjunchao.Model.portModel.StaffModelPort;

import com.opensymphony.xwork2.ModelDriven;
import com.zjc.entity.Staff;

public class StaffAction extends BaseAction implements ModelDriven<Staff> {
	private DepartAction da = new DepartAction();
	DepartModelPort demodel = new ModelDepart();
	//Depart depa = new Depart();
	Staff sta = new Staff();
 	StaffModelPort stamodel = new ModelStaff();
	BaseAction base = new BaseAction();
	HttpSession seesion = base.getSession();

	public Staff getModel() {
		// TODO Auto-generated method stub	
		return sta;
	}
	
/**
	public Depart getModel1() {
		// TODO Auto-generated method stub	
		return dep;
	}
	*/
	
	/**
	 * 获取用户表的所有信息
	 * @return 返回用户表所有信息
	 */
	public String findall(){
		List<Map<String,Object>> StaffList = stamodel.queryall();
		HttpSession session = getSession();
		session.setAttribute("userlist",StaffList);
		return "findall";
	}
	/**
	 * 验证用户类名称是否唯一
	 * @return
	 */
	public String solestaffcard(){
		List<Map<String,Object>> Stafflist = stamodel.queryall();
		int a = 1;
		System.out.println(Stafflist .get(0).get("staffName"));
		for(int i=0;i<Stafflist.size();i++){		
			if(sta.getStaffName().equals(Stafflist .get(i).get("staffName"))){
				a= 0;
			}
		}
		getOut().print(a);
		return null;
	}
	/**
	 * 实现用户类表的插入
	 * @return 返回插入信息
	 */
	public String updetestaff(){
		stamodel.update(sta);
		findall();
		return "findall";
	}
	/**
	 * 实现用户类状态的修改
	 * @return
	 */
	public String alterstaff(){
		stamodel.alterstaff(sta);
		findall();
		return "usermode";
	}
	/**
	 * 验证登录
	 * 查询名字，角色放进session中，然后取出。
	 */
	public String loggingverify (){
		//HttpServletRequest request = ServletActionContext.getRequest();
		//String miblie = sta.getMobile();	
		int a = stamodel.querysingle(sta); 
		if (a>0) {
			List<Map<String, Object>> st = stamodel.queryall();
			for (int i = 0; i <st.size(); i++) {
				Map<String, Object> map = st.get(i);
				if (map.get("Mobile").equals(sta.getMobile())) {
					seesion.setAttribute("staffId",map.get("staffId"));
					seesion.setAttribute("name",map.get("staffName"));
					seesion.setAttribute("sex",map.get("sex"));
					seesion.setAttribute("age",map.get("age"));
					seesion.setAttribute("cardID",map.get("cardID"));
					seesion.setAttribute("Mobile",map.get("Mobile"));
					seesion.setAttribute("Userpwd",map.get("Userpwd"));
					seesion.setAttribute("Addres",map.get("Addres"));
					seesion.setAttribute("Rdate",map.get("Rdate"));
					seesion.setAttribute("depart",map.get("depart"));
					seesion.setAttribute("staffstatus",map.get("staffstatus"));
				} else {

				}
			}
			return "ok";
		} else {
			return "error";
		}
	}
	/**
	 * 注销用户的方法
	 * @return
	 */
	public  String logout (){
		//System.out.println(seesion.getAttribute("name"));
		seesion.invalidate();
		return "logout";
	}
	/**
	 * 查询所有用户的所有值 
	 * @return
	 */
	public String userslist (){
		List<Map<String, Object>> st = stamodel.queryall();
		HttpSession se = base.getSession();
		se.setAttribute("userlist", st);
		return "userlist";
	} 
	/**
	 *  模糊查询用户的所有信息
	 * 
	 * @return
	 */
	public String fuzzyquerystaff (){
		List<Map<String, Object>> st = stamodel. fuzzyquerystaff();
		HttpSession se = base.getSession();
		se.setAttribute("fuzzyquerystaff",st);
		return "fuzzyquerystaff";
	}

}
