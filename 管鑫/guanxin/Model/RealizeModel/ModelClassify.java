package guanxin.Model.RealizeModel;

import guanxin.Dao.protDao.daoProt;
import guanxin.Dao.realizeDao.ClassifyDao;
import guanxin.Model.portModel.ModelPort;

import java.util.List;

import com.zjc.entity.Classify;

public class ModelClassify implements ModelPort{
	/**
	 * 该方法实现了接口ModelPort，用来查询Classify表中是否有相同值
	 * @return 如果有相同的值返回值大于0，否则返回值小于0
	 */
	public int distinct(Object o) {
		// TODO Auto-generated method stub
		daoProt dp = new ClassifyDao();
		List<Classify> list =  (List<Classify>) dp.query();
		int a =0;
		for(int i=0;i<list.size();i++){
			if(list.get(i).getClassname().equals(o)){
				a = 1;
			}
		}
		return a;
	}
	
}
