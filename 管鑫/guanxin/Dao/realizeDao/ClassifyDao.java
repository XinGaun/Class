package guanxin.Dao.realizeDao;

import guanxin.Dao.protDao.daoProt;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.util.BaseDao;
import com.zjc.entity.Classify;

public class ClassifyDao implements daoProt{
	BaseDao dao = new BaseDao();
	/**
	 * 实现插入的接口,用来进行Classify表的插入
	 * @return 返回插入结果 返回大于0为成功
	 */
	public int update(Classify c) {
		// TODO Auto-generated method stub
		int a = 0;
		String sql = "insert into classify values(?,?)";
		Object[] obj = new Object[]{c.getClassname(),c.getStutu()}; 
		a = dao.executeUpdate(sql,obj);
		return a;
	}
	/**
	 * 该方法实现了数据库的查询，通过该方法可以直接查询Classify表的所有信息
	 * @return 返回一个List Classify对象的数组
	 */
	public List<Classify> query() {
		// TODO Auto-generated method stub
		String sql = "select * from classify";
		ResultSet rs = dao.query(sql);
		List list = new ArrayList();
		try {
			while(rs.next()){
				Classify cify = new Classify();
				cify.setClassname(rs.getString("classname"));
				cify.setStutu(rs.getInt("stutu"));
				cify.setClassid(rs.getInt("classid"));
				list.add(cify);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
}
