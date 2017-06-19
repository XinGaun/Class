package queryGuan;

import java.util.List;
import java.util.Map;

import UserDaoImplGuan.DeskClassGuan;

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
}
