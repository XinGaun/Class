package zhangjunchao.Model.RealizeModel;

import java.util.List;
import java.util.Map;

import zhangjunchao.Dao.protDao.DepartDaoPort;
import zhangjunchao.Dao.realizeDao.DepartDao;
import zhangjunchao.Model.portModel.DepartModelPort;

import com.zjc.entity.Depart;
 
public class ModelDepart implements DepartModelPort {
	DepartDaoPort dedap = new DepartDao();
	/**
	 * 查询部门表的所有信息
	 * 
	 */
	public List<Map<String, Object>> queryalldepart() {
		// TODO Auto-generated method stub
		return dedap.queryalldepart();
	}
	/**
	 * 模糊查询部门表的信息
	 * 
	 */
	public List<Map<String, Object>> fuzzyquerydepart() {
		// TODO Auto-generated method stub
		return dedap.fuzzyquerydepart();
	}
	/**
	 * 添加部门表的信息
	 * 
	 */
	public int updatedepart(Depart depa) {
		// TODO Auto-generated method stub
		return dedap.updatedepart(depa);
	}
	/**
	 * 修改部门表状态
	 */
	
	public int alterdepart(Depart dep) {
		// TODO Auto-generated method stub
		return dedap.alterdepart(dep);
	}
	
}
