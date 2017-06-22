package zhangjunchao.Controller;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import zhangjunchao.Model.RealizeModel.ModelDepart;
import zhangjunchao.Model.RealizeModel.ModelStaff;
import zhangjunchao.Model.portModel.DepartModelPort;
import zhangjunchao.Model.portModel.StaffModelPort;
import zjc.entity.Depart;

import com.opensymphony.xwork2.ModelDriven;

public class DepartAction extends BaseAction implements ModelDriven<Depart> {
	Depart dep = new Depart();
	DepartModelPort demodel = new ModelDepart();
	BaseAction base = new BaseAction();
	HttpSession seesion = base.getSession();
	
	public Depart getModel() {
		// TODO Auto-generated method stub
		return dep;
	}
	/**
	 * 查询部门表的所有信息
	 * 
	 */
	public String findalldepart(){
		List<Map<String,Object>> departList = demodel.queryalldepart();
		HttpSession session = getSession();
		session.setAttribute("departlist",departList);
		return "findalldepart";
	} 
}
