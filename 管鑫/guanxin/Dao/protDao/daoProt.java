package guanxin.Dao.protDao;

import java.util.List;
import java.util.Map;

import com.zjc.entity.Classify;

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
	/**
	 * 分页查询菜类数据接口
	 * @param adsc 传入从第几条开始显示
	 * @param linage 传入每页显示几行数据
	 * @return 返回一个查询结果集
	 */
	public List<Map<String,Object>> PagingQuery(int adsc,int linage);
	/**
	 * 获取菜类数据总数
	 * @return 返回结果
	 */
	public int getCount();
	
	
}
