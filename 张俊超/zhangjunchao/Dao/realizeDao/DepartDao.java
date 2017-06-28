package zhangjunchao.Dao.realizeDao;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import zhangjunchao.Controller.BaseAction;
import zhangjunchao.Dao.protDao.DepartDaoPort;

import com.util.BaseDao;
import com.zjc.entity.Depart;

public class DepartDao extends BaseDao implements DepartDaoPort {
	BaseAction base = new BaseAction();
	Depart depart = new Depart();
	/**
	 * 查询部门信息方法
	 * @return 返回list合集
	 */
	public List<Map<String, Object>> queryalldepart() {
		// TODO Auto-generated method stub
		String sql="select * from depart order by departid desc";
		return executeQuery(sql,null);
	}
	/**
	 *模糊查询部门信息方法
	 *@return 返回list合集
	 */
	public List<Map<String, Object>> fuzzyquerydepart() {
		// TODO Auto-generated method stub
		HttpServletRequest rs = base.getRequest(); 
		String sql = " select departid,departname from depart where departname like '%"+rs.getParameter("depname")+"%'";
		return executeQuery(sql,null);
	}
	/**
	 * 添加部门的方法
	 * 
	 */
	public int updatedepart(Depart dep) {
		// TODO Auto-generated method stub
		int a = 0;
		String sql = " insert into depart values (?,?) ";
		Object[] obj = new Object[]{dep.getDepartname(),dep.getDepartstatus()};
		return executeUpdate(sql, obj);
	}
	/**
	 * 修改部门信息的状态
	 */
	public int alterdepart(Depart dep) {
		// TODO Auto-generated method stub
		String sql= "update depart set departstatus = ? where departid = ?";
		if(dep.getDepartstatus()==1){
			dep.setDepartstatus(2);
		}
		else{
			dep.setDepartstatus(1);
		}
		Object[] obj = new Object[]{dep.getDepartstatus(),dep.getDepartid()};
		return executeUpdate(sql,obj);
	}
	
}
