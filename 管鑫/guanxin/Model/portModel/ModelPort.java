package guanxin.Model.portModel;

import guanxin.util.paging;

import java.util.List;
import java.util.Map;

import com.zjc.entity.Classify;

public interface ModelPort {
	/**
	 * 创建一个菜类查询的接口
	 * @param name 传入需要比较的参数
	 * @return 返回一个int形的数值 
	 */
	public int update(Classify c);
	/**
	 * 创建菜类信息删除接口
	 * @param c
	 * @return
	 */
	public int delete(Classify c);
	/**
	 * 创建查询菜类信息接口
	 * @return
	 */
	public List<Map<String,Object>> queryall();
	/**
	 * 创建修改菜类状态接口
	 * @param c
	 * @return
	 */
	public int alterclassify(Classify c);
	/**
	 * 分页查询菜类数据接口
	 * @param adsc 传入现在第几页
	 * @param linage 传入每页显示几行数据
	 * @return 返回一个查询结果集
	 */
	public paging PagingQuery(Integer adsc,Integer linage);
	/**
	 * 获取菜类数据总数
	 * @return 返回结果
	 */
	public int getCount();
}
