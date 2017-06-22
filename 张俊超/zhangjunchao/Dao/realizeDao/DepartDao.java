package zhangjunchao.Dao.realizeDao;

import java.util.List;
import java.util.Map;

import com.util.BaseDao;

import zhangjunchao.Controller.BaseAction;
import zhangjunchao.Dao.protDao.DepartDaoPort;

public class DepartDao extends BaseDao implements DepartDaoPort {
	BaseAction base = new BaseAction();
	public List<Map<String, Object>> queryalldepart() {
		// TODO Auto-generated method stub
		String sql="select * from depart ";
		return executeQuery(sql,null);
	} 
}
