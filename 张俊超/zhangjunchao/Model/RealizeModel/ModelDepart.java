package zhangjunchao.Model.RealizeModel;

import java.util.List;
import java.util.Map;

import zhangjunchao.Dao.protDao.DepartDaoPort;
import zhangjunchao.Dao.realizeDao.DepartDao;
import zhangjunchao.Model.portModel.DepartModelPort;

public class ModelDepart implements DepartModelPort {
	DepartDaoPort dedap = new DepartDao();
	public List<Map<String, Object>> queryalldepart() {
		// TODO Auto-generated method stub
		return dedap.queryalldepart();
	}

}
