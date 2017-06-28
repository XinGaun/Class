package zhangjunchao.Controller;

import guanxin.Model.RealizeModel.ModelClassify;
import guanxin.Model.portModel.ModelPort;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.opensymphony.xwork2.ModelDriven;
import com.zjc.entity.Classify;


public class ClassifyAction  extends BaseAction implements ModelDriven<Classify>{
	Classify c = new Classify();
	ModelPort dp = new ModelClassify();
	public Classify getModel() {
		// TODO Auto-generated method stub	
		return c;
	}
	/**
	 * 获取菜谱表的所有信息
	 * @return 返回菜品表所有信息
	 */
	public String findall(){
		List<Map<String,Object>> ClassifyList = dp.queryall();
		HttpSession session = getSession();
		session.setAttribute("ClassifyList",ClassifyList);
		return "findall";
	}
	/**
	 * 验证菜类名称是否唯一
	 * @return
	 */
	public String soleClassify(){
		List<Map<String,Object>> ClassifyList = dp.queryall();
		int a = 1;
		System.out.println(ClassifyList.get(0).get("classname"));
		for(int i=0;i<ClassifyList.size();i++){		
			if(c.getClassname().equals(ClassifyList.get(i).get("classname"))){
				a= 0;
			}
		}
		getOut().print(a);
		return null;
	}
	/**
	 * 实现菜类表的插入
	 * @return 返回插入信息
	 */
	public String updeteClassify(){
		dp.update(c);
		getSession().setAttribute("addClass","插入成功"); 
		findall();
		return "findall";
	}
	/**
	 * 实现菜类状态的修改
	 * @return
	 */
	public String alterClassify(){
		dp.alterclassify(c);
		findall();
		return "findall";
	}
}



