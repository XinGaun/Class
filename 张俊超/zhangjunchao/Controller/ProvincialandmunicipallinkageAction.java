package zhangjunchao.Controller;

import java.util.List;
import java.util.Map;

import zhangjunchao.Dao.realizeDao.ProvincialandmunicipallinkageDao;

public class ProvincialandmunicipallinkageAction extends BaseAction{
	ProvincialandmunicipallinkageDao prdao = new ProvincialandmunicipallinkageDao();
	/**
	 * 查询省、市、县
	 * @return
	 */
/*	public String getProvince (){
		getResponse().setCharacterEncoding("utf-8");
		List list=prdao.getProvince();
		getOut().print(list);
	
		return null;
	}
	public String getcity(){
		getResponse().setCharacterEncoding("utf-8"); 
		List list=prdao.getCity();
		getOut().print(list);
		
		return null;
	} 
	public String getDistr (){
		getResponse().setCharacterEncoding("utf-8"); 
		List list=prdao.getDistr();
		getOut().print(list);
		
		return null;
	} */
	public String pcd(){
		getResponse().setCharacterEncoding("utf-8"); 
		String str = (String) getRequest().getAttribute("Addres");
		System.out.println(str);
		getOut().print(str);
		return null;
	}
}
