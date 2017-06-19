package zhangjunchao.Model.RealizeModel;

import java.util.List;
import java.util.Map;

import zhangjunchao.Dao.protDao.StaffDaoPort;
import zhangjunchao.Dao.protDao.daoProt;
import zhangjunchao.Dao.realizeDao.ClassifyDao;
import zhangjunchao.Dao.realizeDao.StaffDao;
import zhangjunchao.Model.portModel.StaffModelPort;
import zjc.entity.Staff;

public class ModelStaff implements StaffModelPort {
	StaffDaoPort staport = new StaffDao();
	/**
	 * 该方法实现了用户类的信息的插入
	 * @return 返回一个int类型确认是否插入成功
	 */
	public int update(Staff sta) {
		// TODO Auto-generated method stub
		return staport.update(sta);
	}
	/**实现用户类信息的删除
	 * @return 返回int类型 确认是否删除
	 */
	public int delete(Staff sta) {
		// TODO Auto-generated method stub
		return staport.delete(sta);
	}
	/**
	 * 实现查询用户类所有信息
	 * @return 返回list合集
	 */
	public List<Map<String, Object>> queryall() {
		// TODO Auto-generated method stub
		return staport.queryall();
	}
	/**
	 * 实现修改用户类状态
	 * @author Administrator 返回修改结果
	 */
	public int alter(Staff sta) {
		// TODO Auto-generated method stub
		return staport.alter(sta);
	}
	/**
	 * 实现查询单个用户类所有信息
	 * @return 返回list合集
	 */
	public int querysingle(Staff sta) {
		// TODO Auto-generated method stub
		return staport.querysingle(sta);
	}
}
