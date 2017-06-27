package realizeGuan;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import queryGuan.portGuan;
import UserDaoImplGuan.DeskClassGuan;
import UserDaoImplGuan.Menu;

import com.util.BaseDao;

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
	/**
	 * 查询菜品
	 */
	public List<Map <String,Object>> selectMenu(){
		String sql = "select * from menu";
		return db.executeQuery(sql, null);
	}
	/**
	 * 菜品种类查询
	 */
	public List<Map <String,Object>> getClassify(){
		String sql = "select * from classify";
		return db.executeQuery(sql, null);
	}
	/**
	 * 查询菜品
	 * @param id
	 * @return
	 */
	public List<Map <String,Object>> getMenu(int id){
		if(id==1){
			String sql = " select picture,foodID,foodName ,foodPrice from  menu  where classId = "+id+"";
			Object[]param = new Object[]{id};
			return db.executeQuery(sql, param);
		}
		else if(id==2){
			String sql = " select picture,foodID, foodName ,foodPrice from  menu  where classId = "+id+"";
			Object[]param = new Object[]{id};
			return db.executeQuery(sql, param);
		}
		else if(id==3){
			String sql = " select picture,foodID,foodName,foodPrice from  menu  where classId = "+id+"";
			Object[]param = new Object[]{id};
			return db.executeQuery(sql, param);
		}
		else if(id==4){
			String sql = " select picture,foodID,foodName,foodPrice from  menu  where classId = "+id+"";
			Object[]param = new Object[]{id};
			return db.executeQuery(sql, param);
		}
		else if(id==5){
			String sql = " select picture,foodID,foodName,foodPrice from  menu  where classId = "+id+"";
			Object[]param = new Object[]{id};
			return db.executeQuery(sql, param);
		}
		else if(id==45){
			String sql = " select picture,foodID,foodName,foodPrice from  menu  where classId = "+id+"";
			Object[]param = new Object[]{id};
			return db.executeQuery(sql, param);
		}
		else if(id==53){
			String sql = " select picture,foodID,foodName,foodPrice from  menu  where classId = "+id+"";
			Object[]param = new Object[]{id};
			return db.executeQuery(sql, param);
		}
		else if(id==54){
			String sql = " select picture,foodID,foodName,foodPrice from  menu  where classId = "+id+"";
			Object[]param = new Object[]{id};
			return db.executeQuery(sql, param);
		}
		return null;
	}
	/**
	 * 订单
	 * @return
	 */
	public List<Map <String,Object>> gerUser_order(){
		String sql = "select * from user_order where orderStatus != '已结账' and year(orderTime)=year(GETDATE()) and month(orderTime)=month(GETDATE()) and day(orderTime)=day(GETDATE())  ";
		return db.executeQuery(sql, null);
	}
	/**
	 * 历史订单
	 */
	public List<Map <String,Object>> gerUser_order1(){
		String sql = "SELECT * FROM user_order WHERE orderStatus = '已结账' and  datediff(month,[orderTime],getdate())=0  order by endTime desc ,orderID desc";
		return db.executeQuery(sql, null);
	}
	/**
	 * 模糊搜索 菜品
	 */
	public List<Map <String,Object>> searchMenu(String str){
		String sql = "select * from menu where foodName like '%"+str+"%'";
		Object[] param = new Object[]{str};
		return db.executeQuery(sql, param);
	}
	/**
	 * 根据foodid查询 food价格
	 */
	public Menu getFoodprice(int id){
		String sql = "select foodPrice from menu where foodID ="+id+"";
		Connection conn = db.getConnection();
		PreparedStatement statement = null;
		ResultSet set = null;
		Menu menu = new Menu();
		try {
			statement = conn.prepareStatement(sql);
			set = statement.executeQuery();
			while(set.next()){
				menu.setFoodPrice(set.getFloat(1));
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return menu;
	}
	/**
	 * 添加订单
	 */
	public int intoUserorder(float money,int deskid){
		String sql = "insert into user_order1 (orderStatus,countMoney,deskID) values('已审核',?,?)";
		Object[] param = new Object[]{money,deskid};
		return db.executeUpdate(sql, param);
	}
	/**
	 * 定单详情
	 */
	public int intoDetails(int orderid,int foodid,int num,float countmoney,int deskid,String statu){
		String sql = "insert into order_details (orderID,foodID,num,countMoney,deskID,stutu) values(?,?,?,?,?,?)";
		 Object[]param = new Object[]{orderid,foodid,num,countmoney,deskid,statu};
		 return db.executeUpdate(sql, param);
	}
	/**
	 * 根据桌号查询订单号
	 * @param deskid
	 * @return
	 */
	public List<Map <String,Object>> catchOrderid(int deskid){
		String sql = "select orderID from user_order1 where deskID="+deskid+"";
		Object[]param = new Object[]{deskid};
		return db.executeQuery(sql, param);
	}
	/**
	 * 根据桌号查询订单号  价钱
	 * @param deskid
	 * @return
	 */
	public List<Map <String,Object>> catchInformation(int deskid){
		String sql = "select orderID,countMoney from user_order1 where deskID="+deskid+" and orderStatus != '已结账'";
		Object[]param = new Object[]{deskid};
		return db.executeQuery(sql, param);
	}
	/**
	 * 根据桌号查询菜单
	 * @param deskid
	 * @return
	 */
	public List<Map <String,Object>> catchInformationMenu(int deskid){
		String sql = "select m.foodName ,o.num from user_order1 u, order_details o ,menu m where u.orderStatus = '已审核'and o.foodID = m.foodID and o.deskID= "+deskid+" ";
		Object[]param = new Object[]{deskid};
		return db.executeQuery(sql, param);
	}
	/**
	 * 审核订单
	 * @param orderid
	 * @return
	 */
	public int updateOrder(int orderid){
		String sql = " update user_order set orderStatus = '已审核' where orderID = "+orderid+" and  orderStatus = '未审核' ";
		Object[]param = new Object[]{orderid};
		return db.executeUpdate(sql, param);
	}
	/**
	 * 结账
	 */
	public int updateOrderMoney(int orderid){
		String sql = "update user_order set orderStatus = '已结账' where orderID = "+orderid+" and  orderStatus = '已审核'";
		return db.executeUpdate(sql, null);
	}
	/**
	 * 订单结束时间
	 * @param orderid
	 * @return
	 */
	public int addOrderDate(int orderid){
		String sql = " update user_order set endTime = getdate() where orderID = "+orderid+"";
		return db.executeUpdate(sql, null);
	}
	/**
	 * 转台
	 */
	public int updateDeskid(int deskid2,int deskid1){
		String sql = "update user_order1  set deskID = "+deskid2+" where deskID= "+deskid1+""; 
		return db.executeUpdate(sql, null);
	}
	public int updateDeskid1(int deskid2,int deskid1){
		String sql = "update order_details  set deskID = "+deskid2+" where deskID= "+deskid1+""; 
		return db.executeUpdate(sql, null);
	}
}
