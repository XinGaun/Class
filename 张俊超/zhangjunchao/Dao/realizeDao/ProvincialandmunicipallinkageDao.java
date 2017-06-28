package zhangjunchao.Dao.realizeDao;

import java.util.List;
import java.util.Map;

import com.util.BaseDao;

public class ProvincialandmunicipallinkageDao extends BaseDao {
	/**
	 * 查询省
	 * @return
	 */
	public List getProvince (){
		String sql = " select ProvinceName from S_Province ";
		return querylist(sql,null);
	}
	/**
	 * 查询市
	 * @return
	 */
	public List getCity (){
		String sql = " select CityName from S_City ";
		return querylist(sql,null);
	}
	/**
	 * 查询县
	 * @return
	 */
	public List getDistr (){
		String sql = " select DistrictName from S_District ";
		return querylist(sql,null);
	}
	
}
