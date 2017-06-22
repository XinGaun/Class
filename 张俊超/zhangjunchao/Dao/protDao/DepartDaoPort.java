package zhangjunchao.Dao.protDao;

import java.util.List;
import java.util.Map;

public interface DepartDaoPort {
	/**
	 * 部门类信息查询接口
	 * @return
	 */
	public List<Map<String,Object>> queryalldepart();
}
