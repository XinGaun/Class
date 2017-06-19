package zhangjunchao.Dao.protDao;

import java.util.List;
import java.util.Map;

import zjc.entity.Staff;

public interface StaffDaoPort {
	/**
	 * 菜类信息插入接口
	 * @param c
	 * @return
	 */
	public int update(Staff sta);
	/**
	 * 菜类信息的删除接口
	 * @param c
	 * @return
	 */
	public int delete(Staff sta);
	/**
	 * 菜类信息查询接口
	 * @return
	 */
	public List<Map<String,Object>> queryall();
	/**
	 * 修改菜类状态接口
	 * @return
	 */
	public int alter(Staff sta);
	/**
	 * 单个用户信息查询接口
	 * @return
	 */
	public int querysingle(Staff sta);
}
