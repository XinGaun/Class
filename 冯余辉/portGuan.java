package queryGuan;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import UserDaoImplGuan.DeskClassGuan;
import UserDaoImplGuan.Menu;

public interface portGuan {
	/**
	 * ������ѯ�ӿ�
	 * @param sql ��ѯʹ�õ�SQL���
	 * @return ����һ��List��������
	 * 查看全部桌台数据
	 */
	public List<Map <String,Object>> query();
	/**
	 * 增加桌台
	 */
	public int add(DeskClassGuan dc);
	/**
	 * 更新桌台
	 */
	public void update(int staid,int deskid);
	/**
	 * 根据餐桌号查询餐桌
	 * @return
	 */
	public List<Map <String,Object>> getdesk(int id);
	/**
	 * 分页查询
	 * @param pagesize
	 * @param pagenum
	 * @return
	 */
	/*public List<DeskClassGuan> getDeskClassGuan(int pagenum,int pagesize);*/
	/**
	 * 查询未使用餐台
	 * @param statuid
	 * @return
	 */
	public List<Map <String,Object>> getDesknotuse();
	/**
	 * 根据桌台号 查询本桌台的状态
	 * @param deskid
	 * @return
	 */
	public List<Map <String,Object>> getstatusName(int deskid);
	/**
	 * 获取桌子
	 * @return
	 */
	public List<Map <String,Object>> getdeskone();
	/**
	 * 获取包厢
	 * @return
	 */
	public List<Map <String,Object>> getdesksecond();
	/**
	 * 获取可用的桌子
	 * @return
	 */
	public List<Map <String,Object>> getdesknotuse();
	/**
	 * 获取可用的包厢
	 * @return
	 */
	public List<Map <String,Object>> gethomedesknotuse();
	/**
	 * 查询人数大于num的餐桌
	 * @return
	 */
	public List<Map <String,Object>> peDesknum(int num);
	/**
	 * 查询人数大于num的包厢
	 * @return
	 */
	public List<Map <String,Object>> peHomeDesknum(int num);
	/**
	 * 查询菜品
	 */
	public List<Map <String,Object>> selectMenu();
	/**
	 * 菜品种类查询
	 */
	public List<Map <String,Object>> getClassify();
	/**
	 * 查询菜品
	 * @param id
	 * @return
	 */
	public List<Map <String,Object>> getMenu(int id);
	/**
	 * 订单
	 * @return
	 */
	public List<Map <String,Object>> gerUser_order();
	public List<Map <String,Object>> gerUser_order1();
	/**
	 * 迷糊搜索 菜品
	 */
	public List<Map <String,Object>> searchMenu(String str);
	public Menu getFoodprice(int id);
	/**
	 * 添加订单
	 */
	public int intoUserorder(float money,int deskid);
	/**
	 * 定单详情
	 */
	public int intoDetails(int orderid,int foodid,int num,float countmoney,int deskid,String statu);
	/**
	 * 根据桌号查询订单号
	 * @param deskid
	 * @return
	 */
	public List<Map <String,Object>> catchOrderid(int deskid);
	/**
	 * 根据桌号查询订单号  价钱
	 * @param deskid
	 * @return
	 */
	public List<Map <String,Object>> catchInformation(int deskid);
	/**
	 * 根据桌号查询菜单
	 * @param deskid
	 * @return
	 */
	public List<Map <String,Object>> catchInformationMenu(int deskid);
	/**
	 * 审核订单
	 * @param orderid
	 * @return
	 */
	public int updateOrder(int orderid);
	/**
	 * 订单结束时间
	 * @param orderid
	 * @return
	 */
	public int addOrderDate(int orderid);
	/**
	 * 结账
	 */
	public int updateOrderMoney(int orderid);
	/**
	 * 转台
	 */
	public int updateDeskid(int deskid2,int deskid1);
	public int updateDeskid1(int deskid2,int deskid1);
}
