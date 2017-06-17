package guanxin.Model.Logic;

import com.zjc.entity.Classify;

import guanxin.Dao.protDao.daoProt;
import guanxin.Dao.realizeDao.ClassifyDao;

public class functionClassify {
	daoProt dp = new ClassifyDao();
	/**
	 * 该方法用于数据库的Classify表信息的插入
	 * @param ClassName 需要插入的菜类名称
	 * @return 返回一个int类型数据 返回值大于0为成功，否则为失败
	 */
	public int addClass(String ClassName){
		
		Classify c = new Classify();
		c.setClassname(ClassName);
		c.setStutu(2);
		return dp.update(c);
	}
	/**
	 * 该方法用于数据库Classify表信息的删除
	 * @param Classid 需要删除菜类的名称
	 * @return 返回一个int类型数据 返回值大于0为成功，否则失败
	 */
	public int deleteClass(String Classid){
		Classify c = new Classify();
		int a = 0;
		if(Classid!=null && !Classid.equals("")){
			a = Integer.parseInt(Classid);
		}				
			c.setClassid(a);
		return dp.delete(c);
	}
}
