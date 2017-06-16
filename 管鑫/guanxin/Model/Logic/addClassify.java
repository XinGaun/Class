package guanxin.Model.Logic;

import com.zjc.entity.Classify;

import guanxin.Dao.protDao.daoProt;
import guanxin.Dao.realizeDao.ClassifyDao;

public class addClassify {
	/**
	 * 该方法用于数据库的Classify表信息的插入
	 * @param ClassName 需要插入的菜类名称
	 * @return 返回一个int类型数据 返回值大于0为成功，否则为失败
	 */
	public int addClass(String ClassName){
		daoProt dp = new ClassifyDao();
		Classify c = new Classify();
		c.setClassname(ClassName);
		c.setStutu(2);
		return dp.update(c);
	}
}
