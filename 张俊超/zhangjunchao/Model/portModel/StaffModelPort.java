package zhangjunchao.Model.portModel;

import java.util.List;
import java.util.Map;

import zjc.entity.Staff;
  
public interface StaffModelPort {
	/**
	 * 创建一个用户  类查询的接口
	 * @param name 传入需要比较的参数
	 * @return 返回一个int形的数值 
	 */
	public int update(Staff sta);
	/**
	 * 创建菜用户信息删除接口
	 * @param c
	 * @return
	 */
	public int delete(Staff sta);
	/**
	 * 创建查询用户信息接口
	 * @return
	 */
	public List<Map<String,Object>> queryall();
	/**
	 * 创建修改用户类状态接口
	 * @param c
	 * @return
	 */
	public int alter(Staff sta);
	/**
	 * 创建查询单个用户信息接口
	 * @return
	 */
	public int querysingle(Staff sta);
	/**
	 /**
	 * 创建模糊查询用户信息接口
	 * @return
	 */
	public List<Map<String, Object>> fuzzyquerystaff();
}
