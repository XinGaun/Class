package zhangjunchao.Model.RealizeModel;

import java.util.List;
import java.util.Map;

import zhangjunchao.Dao.protDao.daoProt;
import zhangjunchao.Dao.realizeDao.ClassifyDao;
import zhangjunchao.Model.portModel.ModelPort;
import zjc.entity.Classify;

public class ModelClassify implements ModelPort{
	daoProt prot = new ClassifyDao();
	/**
	 * 该方法实现了用户类的信息的插入
	 * @return 返回一个int类型确认是否插入成功
	 */
	public int update(Classify c) {
		// TODO Auto-generated method stub
		return prot.update(c);
	}
	/**实现菜类信息的删除
	 * @return 返回int类型 确认是否删除
	 */
	public int delete(Classify c) {
		// TODO Auto-generated method stub
		return prot.delete(c);
	}
	/**
	 * 实现查询用户类所有信息
	 * @return 返回list合集
	 */
	public List<Map<String, Object>> queryall() {				
		return prot.queryall();
	}
	/**
	 * 实现修改用户类状态
	 * @author Administrator 返回修改结果
	 */
	public int alterclassify(Classify c) {
		return prot.alterclassify(c);
	}
	
}
