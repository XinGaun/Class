package zhangjunchao.Dao.protDao;

import java.util.List;
import java.util.Map;

import com.zjc.entity.Depart;

public interface DepartDaoPort {
	/**
	 * 部门类信息查询接口
	 * @return
	 */
	public List<Map<String,Object>> queryalldepart();
	/**
	 * 部门类信息模糊查询接口
	 * @return
	 */
	public List<Map<String, Object>> fuzzyquerydepart();
	/**
	 * 插入部门类信息接口
	 * @return dep
	 */
	public int updatedepart(Depart dep);
	/**
	 * 修改部门表的状态
	 * @param dep
	 * @return
	 */
	public int alterdepart(Depart dep);

}
