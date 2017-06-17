package guanxin.Dao.realizeDao;

import guanxin.Dao.protDao.daoProt;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.util.BaseDao;
import com.zjc.entity.Classify;

public class ClassifyDao extends BaseDao implements daoProt{
	
	/**
	 * 实现插入的接口,用来进行Classify表的插入
	 * @return 返回插入结果 返回大于0为成功
	 */
	public int update(Classify c) {
		// TODO Auto-generated method stub
		int a = 0;
		String sql = "insert into classify values(?,?)";
		Object[] obj = new Object[]{c.getClassname(),c.getStutu()}; 		
		return executeUpdate(sql,obj);
	}
	
	/**
	 * 该方法实现了接口daoProt的删除数据，可以删除Classify表中的一条数据
	 * {@link Classify} 传入需要删除数据的条件
	 * @return 返回一个删除结果，大于0为成功，否则为失败
	 */
	public int delete(Classify c) {
		// TODO Auto-generated method stub
		String sql = "delete from classify where classid = ?";
		Object[] obj = new Object[]{c.getClassid()};
		return executeUpdate(sql, obj);		 
	}
	/**
	 * 查询菜类信息方法
	 * @return 返回list合集
	 */
	public List<Map<String, Object>> queryall() {
		String sql="select * from classify";
		return executeQuery(sql,null);
	}
	/**
	 * 修改菜类状态方法
	 * @return 返回执行结果
	 */
	public int alterclassify(Classify c) {
		String sql= "update classify set stutu = ? where classid = ?";
		if(c.getStutu()==1){
			c.setStutu(2);
		}
		else{
			c.setStutu(1);
		}
		Object[] obj = new Object[]{c.getStutu(),c.getClassid()};
		return executeUpdate(sql,obj);
	}
	
}
