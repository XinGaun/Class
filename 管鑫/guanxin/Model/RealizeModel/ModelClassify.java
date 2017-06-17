package guanxin.Model.RealizeModel;

import guanxin.Dao.protDao.daoProt;
import guanxin.Dao.realizeDao.ClassifyDao;
import guanxin.Model.portModel.ModelPort;

import java.util.List;
import java.util.Map;

import com.zjc.entity.Classify;

public class ModelClassify implements ModelPort{
	daoProt prot = new ClassifyDao();
	/**
	 * 该方法实现了菜类的信息的插入
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
	 * 实现查询菜类所有信息
	 * @return 返回list合集
	 */
	public List<Map<String, Object>> queryall() {				
		return prot.queryall();
	}
	/**
	 * 实现修改菜类状态
	 * @author Administrator 返回修改结果
	 */
	public int alterclassify(Classify c) {
		return prot.alterclassify(c);
	}
	
}
