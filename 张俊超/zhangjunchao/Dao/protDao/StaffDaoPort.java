package zhangjunchao.Dao.protDao;

import java.util.List;
import java.util.Map;

import com.zjc.entity.Staff;



public interface StaffDaoPort {
	/**
	 * 用户类信息插入接口
	 * @param c
	 * @return
	 */
	public int update(Staff sta);
	/**
	 * 用户类信息的删除接口
	 * @param c
	 * @return
	 */
	public int delete(Staff sta);
	/**
	 * 用户类信息查询接口
	 * @return
	 */
	public List<Map<String,Object>> queryall();
	/**
	 * 修改用户类状态接口
	 * @return
	 */
	public int alterstaff(Staff sta);
	/**
	 * 单个用户信息查询接口
	 * @return
	 */
	public int querysingle(Staff sta);
	/**
	 * 模糊用户信息查询接口
	 * @return
	 */
	public List<Map<String, Object>> fuzzyquerystaff();
}
