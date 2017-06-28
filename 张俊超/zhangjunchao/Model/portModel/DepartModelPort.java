package zhangjunchao.Model.portModel;

import java.util.List;
import java.util.Map;

import com.zjc.entity.Depart;

public interface DepartModelPort {
	
	/**
	 * 创建查询部门类信息接口
	 * @return
	 */
	public List<Map<String,Object>> queryalldepart();
	/**
	 * 创建模糊查询部门类信息接口
	 * @return
	 */
	public List<Map<String, Object>> fuzzyquerydepart();
	/**
	 * 创建添加部门类信息接口
	 * @return
	 */
	public int updatedepart(Depart dep);
	/**
	 * 修改部门类状态信息接口
	 * @return
	 */
	public int alterdepart(Depart dep);
}
