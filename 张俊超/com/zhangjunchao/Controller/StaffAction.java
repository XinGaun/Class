package zhangjunchao.Controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import zhangjunchao.Model.RealizeModel.ModelStaff;
import zhangjunchao.Model.portModel.StaffModelPort;
import zjc.entity.Staff;

import com.opensymphony.xwork2.ModelDriven;

public class StaffAction extends BaseAction implements ModelDriven<Staff> {
	Staff sta = new Staff();
	StaffModelPort stamodel = new ModelStaff();
	public Staff getModel() {
		// TODO Auto-generated method stub	
		return sta;
	}
	/**
	 * 获取用户表的所有信息
	 * @return 返回用户表所有信息
	 */
	public String findall(){
		List<Map<String,Object>> StaffList = stamodel.queryall();
		HttpSession session = getSession();
		session.setAttribute("StaffList",StaffList);
		return "findall";
	}
	/**
	 * 验证用户类名称是否唯一
	 * @return
	 */
	public String soleClassify(){
		List<Map<String,Object>> StaffList = stamodel.queryall();
		int a = 1;
		System.out.println(StaffList .get(0).get("staffName"));
		for(int i=0;i<StaffList .size();i++){		
			if(sta.getStaffName().equals(StaffList .get(i).get("staffName"))){
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
	public String updeteClassify(){
		stamodel.update(sta);
		getSession().setAttribute("addStaff","插入成功"); 
		findall();
		return "findall";
	}
	/**
	 * 实现用户类状态的修改
	 * @return
	 */
	public String alter(){
		stamodel.alter(sta);
		findall();
		return "findall";
	}
	/**
	 * 验证登录
	 * 
	 */
	public String loggingverify (){
		//HttpServletRequest request = ServletActionContext.getRequest();
		//String miblie = sta.getMobile();	
		int a = stamodel.querysingle(sta);
/**		List<Map<String, Object>> st = stamodel.queryall();
		Map<String, Object> map = st.get(0);
		String s = map.get(staffName);
		String miblie = sta.getMobile();
		*/
 		if (a>0) {
 			
			return "ok";
		} else {
			return "error";
		}
	}
}
