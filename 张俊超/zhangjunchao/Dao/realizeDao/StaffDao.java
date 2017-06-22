package zhangjunchao.Dao.realizeDao;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import zhangjunchao.Controller.BaseAction;
import zhangjunchao.Dao.protDao.StaffDaoPort;
import zjc.entity.Staff;

import com.util.BaseDao;

public  class StaffDao extends BaseDao implements StaffDaoPort {
	BaseAction base = new BaseAction();
	//HttpServletRequest re = base.getRequest();
	/**
	 * 实现插入的接口,用来进行staff表的插入
	 * @return 返回插入结果 返回大于0为成功
	 * 
	 */
	public int update(Staff sta) {
		// TODO Auto-generated method stub
		int a = 0;
		String sql = " insert into staff values (?,?,?,?,?,?,?,?,?,?) ";
		Object[] obj = new Object[]{sta.getStaffName(),sta.getSex(),sta.getAge(),sta.getCardID(),sta.getMobile(),sta.getUserpwd(),sta.getAddres(),sta.getRdate(),sta.getDepartid(),sta.getStaffstatus()};
		return executeUpdate(sql, obj);
	}
	/**
	 * 该方法实现了接口StaffDaoProt的删除数据，可以删除staff表中的一条数据 
	 * {@link Staff} 传入需要删除数据的条件
	 * @return 返回一个删除结果，大于0为成功，否则为失败
	 */
	public int delete(Staff sta) {
		// TODO Auto-generated method stub
		String sql = "delete from staff where staffId = ?";
		Object[] obj = new Object[]{sta.getStaffId()};
		return executeUpdate(sql, obj);
	}
	/**
	 * 查询用户信息方法
	 * @return 返回list合集
	 */
	public List<Map<String, Object>> queryall() {
		// TODO Auto-generated method stub
		//String sql = " select * from staff "
		String sql=" select staffId, staffName, sex, age, cardID, Mobile, Userpwd, Addres, Rdate, departname, staffstatus from depart,staff where depart=departid ";
		return executeQuery(sql,null);
	}
	/**
	 * 修改用户状态方法
	 * @return 返回执行结果
	 */
	public int alter(Staff sta) {
		// TODO Auto-generated method stub
		String sql= "update staff set stutu = ? where staffId = ?";
		if(sta.getStaffstatus()==1){
			sta.setStaffstatus(2);
		}
		else{
			sta.setStaffstatus(1);
		}
		Object[] obj = new Object[]{sta.getStaffId(),sta.getStaffstatus()};
		return executeUpdate(sql,obj);
	}
	/**
	 * 查询单个用户信息方法
	 * @return 返回list集合
	 */
	public int querysingle(Staff sta) {
		// TODO Auto-generated method stub
		String sql="select count (*) from staff where  Mobile = " +sta.getMobile()+ " and Userpwd = " + sta.getUserpwd();
		return executeQuerysingle(sql);
	}
	/**
	 * 模糊查询用户的所有信息
	 * 返回list集合
	 * @return
	 */
	public List<Map<String, Object>> fuzzyquerystaff() {
		// TODO Auto-generated method stub
		HttpServletRequest rs = base.getRequest(); 
		String sql=" select staffId, staffName, sex, age, cardID, Mobile, Userpwd, Addres, Rdate, departname, staffstatus from depart,staff where depart=departid and staffName like '%"+rs.getParameter("namephone")+"%'";
		return executeQuery(sql,null);
	}
}
