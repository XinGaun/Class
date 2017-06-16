package guanxin.Controller;

import guanxin.Model.Logic.addClassify;
import guanxin.Model.RealizeModel.ModelClassify;
import guanxin.Model.portModel.ModelPort;


public class ClassifyAction  extends BaseAction{
	/**
	 * 该方法验证了Classify表中是否有相同的值
	 * @author Administrator 有相同的值返回1，否则返回0
	 *
	 */
	public String execute(){
		super.getResponse().setContentType("text/html;charset=UTF-8");
		String classname = super.getRequest().getParameter("classify");
		ModelPort mp = new ModelClassify();
		int a = mp.distinct(classname);
		super.getOut().print(a);
		super.getOut().flush();
		super.getOut().close();
		return SUCCESS;
	}
	
	/**
	 * 该方法将数据插入数据库中的Classify表中
	 * @return 返回值大于0为插入成功，否则插入失败
	 */
	public String addClassify(){
		super.getResponse().setContentType("text/html;charset=UTF-8");
		String classname = super.getRequest().getParameter("classify");
		addClassify ac = new guanxin.Model.Logic.addClassify();
		int a = ac.addClass(classname);
		super.getOut().print(a);
		super.getOut().flush();
		super.getOut().close();
		return SUCCESS;
	}
}



