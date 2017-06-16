package guanxin.Model.portModel;

public interface ModelPort {
	/**
	 * 创建一个唯一查询的接口
	 * @param name 传入需要比较的参数
	 * @return 返回一个int形的数值 
	 */
	public int distinct(Object o);
}
