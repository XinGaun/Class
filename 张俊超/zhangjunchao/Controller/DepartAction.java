package zhangjunchao.Controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import zhangjunchao.Model.RealizeModel.ModelDepart;
import zhangjunchao.Model.portModel.DepartModelPort;

import com.opensymphony.xwork2.ModelDriven;
import com.zjc.entity.Depart;

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
	public String findalldepart (){
		List<Map<String,Object>> departList = demodel.queryalldepart();
		HttpSession session = getSession();
		session.setAttribute("departlist",departList);
		return "departmentlist";
	}
	/**
	 *  模糊查询部门的所有信息
	 * 
	 * @return
	 */
	public String fuzzyquerydepart (){
		List<Map<String, Object>> st = demodel.fuzzyquerydepart();
		HttpSession se = base.getSession();
		se.setAttribute("fuzzydepart",st);
		return "fuzzyquerydepart";
	}

	/**
	 *  添加部门的信息
	 * 
	 * @return
	 */
	public String departadd (){
		demodel.updatedepart(dep);
		findalldepart();
		return "departmentadd";
	}
	/**
	 * 修改部门表的状态
	 * 
	 * @param dep
	 * @return
	 */
	public String alterdepart (){
		demodel.alterdepart(dep);
		findalldepart();
		return "departmode";
	}
	/**
	 * 
	 * 验证部门名称是否唯一
	 * @return
	 */
	public String soledepart (){
		List<Map<String,Object>> departlist = demodel.queryalldepart();
		int a = 1;
		for(int i=0;i<departlist.size();i++){		
			if(dep.getDepartname().equals(departlist.get(i).get("departname"))){
				a= 0;
			}
		}
		getOut().print(a);
		return null;
	}
}
