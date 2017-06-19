package zhangjunchao.Dao.protDao;

import java.util.List;
import java.util.Map;

import zjc.entity.Classify;

public interface daoProt {
	/**
	 * 菜类信息插入接口
	 * @param c
	 * @return
	 */
	public int update(Classify c);
	/**
	 * 菜类信息的删除接口
	 * @param c
	 * @return
	 */
	public int delete(Classify c);
	/**
	 * 菜类信息查询接口
	 * @return
	 */
	public List<Map<String,Object>> queryall();
	/**
	 * 修改菜类状态接口
	 * @return
	 */
	public int alterclassify(Classify c);
	
}
