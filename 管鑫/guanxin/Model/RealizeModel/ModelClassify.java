package guanxin.Model.RealizeModel;

import guanxin.Dao.protDao.daoProt;
import guanxin.Dao.realizeDao.ClassifyDao;
import guanxin.Model.portModel.ModelPort;
import guanxin.util.paging;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

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
	/**
	 * 分页查询菜类数据实现类
	 * @param adsc 传入现在第几页
	 * @param linage 传入每页显示几行数据
	 * @return 返回一个查询结果集
	 */
	public paging PagingQuery(Integer pagination, Integer linage) {

		pagination = pagination==null?1:pagination;
		pagination = pagination==0?++pagination:pagination;
		linage = linage == null?5:linage;
		int notpag = (pagination-1)*linage;
		paging pg = new paging();
	
		pg.setList(prot.PagingQuery(notpag, linage));
		pg.setTotal(getCount());
		pg.setPagination(pagination);
		pg.setLinage(linage);
		return pg;
	}
	/**
	 * 获取菜类数据总数
	 * @return 返回结果
	 */
	public int getCount(){
		return prot.getCount();
	};
}
