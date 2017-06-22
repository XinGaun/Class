package realizeGuan;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import queryGuan.portGuan;
import UserDaoImplGuan.DeskClassGuan;

import com.util.BaseDao;
import com.util.Pool;

public class RealizeztGuan implements portGuan{
	/**
	 * ʵ�ֲ�ѯ�ӿڣ���ѯ��̨����Ϣ
	 * sql�����sql���
	 * return ����һ��List��������
	 */
	BaseDao db = new BaseDao();
	/**
	 * 查询餐桌全部数据
	 */
	public List<Map <String,Object>> query() {
		String sql = "select d.deskID ,d.deskSize,z.ztclassname ,s.statuname from Desk d ,ztclass z,statu s where d.sta= s.statuid and d.ztclassid = z.ztclassid";
		return db.executeQuery(sql, null);
	}
	/**
	 * 添加桌台
	 */
	public int add(DeskClassGuan dc) {
		String sql = "insert into Desk (deskSize ,ztclassid) values(?,?)";
		Object[]param = new Object[]{dc.getDeskSize(),dc.getZtclassid()};
		return db.executeUpdate(sql, param);
	}
    /**
     * 修改餐桌状态
     */
	public void update(int staid,int deskid ) {
		// TODO Auto-generated method stub
		String sql = "update Desk set sta = "+staid+" where deskId = "+deskid+"";
		Connection con = db.getConnection();
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement = con.prepareStatement(sql);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 根据餐桌号查询餐桌
	 */
	public List<Map <String,Object>> getdesk(int id){
		String sql = "select d.deskID ,d.deskSize,z.ztclassname ,s.statuname from Desk d ,ztclass z,statu s where d.sta= s.statuid and d.ztclassid = z.ztclassid and d.deskID="+id+"";
		Object[]param = new Object[]{id};
		return db.executeQuery(sql, param);
	}
	/**
	 * 首页显示未使用的餐桌
	 * @return
	 */
	public List<Map <String,Object>> getDesknotuse(){
		String sql = "select deskID from Desk where sta = 2";
		return db.executeQuery(sql, null);
	}
	/**
	 * 根据桌台号 查询本桌台的状态
	 * @param deskid
	 * @return
	 */
	public List<Map <String,Object>> getstatusName(int deskid){
		String sql = "select s.statuname from Desk d, statu s where d.sta = s.statuid and d.deskID = "+deskid+"";
		Object[] param = new Object[]{deskid};
		return db.executeQuery(sql, param);
	}
	/**
	 * 获取桌子
	 */
	public List<Map<String, Object>> getdeskone(){
		String sql = "select d.deskID ,d.deskSize,z.ztclassname ,s.statuname from Desk d ,ztclass z,statu s where d.sta= s.statuid and d.ztclassid = z.ztclassid and d.ztclassid =1";
		return db.executeQuery(sql, null);
	}
	/**
	 * 获取包厢
	 */
	public List<Map <String,Object>> getdesksecond(){
		String sql = "select d.deskID ,d.deskSize,z.ztclassname ,s.statuname from Desk d ,ztclass z,statu s where d.sta= s.statuid and d.ztclassid = z.ztclassid and d.ztclassid =2";
		return db.executeQuery(sql, null);
	}
	/**
	 * 获取可用的桌子
	 * @return
	 */
	public List<Map <String,Object>> getdesknotuse(){
		String sql = "select d.deskID ,d.deskSize,z.ztclassname ,s.statuname from Desk d ,ztclass z,statu s where d.sta= s.statuid and d.ztclassid = z.ztclassid and d.ztclassid = 1 and d.sta = 2";
		return db.executeQuery(sql, null);
	}
	/**
	 * 获取可用的包厢
	 * @return
	 */
	public List<Map <String,Object>> gethomedesknotuse(){
		String sql = "select d.deskID ,d.deskSize,z.ztclassname ,s.statuname from Desk d ,ztclass z,statu s where d.sta= s.statuid and d.ztclassid = z.ztclassid and d.ztclassid = 2 and d.sta = 2";
		return db.executeQuery(sql, null);
	}
	/**
	 * 查询人数大于num的桌子
	 * @return
	 */
	public List<Map <String,Object>> peDesknum(int num){
		String sql = "select d.deskID ,d.deskSize,z.ztclassname ,s.statuname from Desk d ,ztclass z,statu s where d.sta= s.statuid and d.ztclassid = z.ztclassid and d.sta = 2 and  d.ztclassid = 1 and deskSize >="+num+" ";
		Object[]param = new Object[]{num};
		return db.executeQuery(sql, param);
	}
	/**
	 * 查询人数大于num的包厢
	 * @return
	 */
	public List<Map <String,Object>> peHomeDesknum(int num){
		String sql = "select d.deskID ,d.deskSize,z.ztclassname ,s.statuname from Desk d ,ztclass z,statu s where d.sta= s.statuid and d.ztclassid = z.ztclassid and d.sta = 2 and  d.ztclassid = 2 and deskSize >="+num+" ";
		Object[]param = new Object[]{num};
		return db.executeQuery(sql, param);
	}
}
