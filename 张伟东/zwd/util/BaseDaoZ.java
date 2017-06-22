/**
 * 
 */
package zwd.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import zwd.entity.OrderEntity;


public class BaseDaoZ {
	static String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	//static String url="jdbc:sqlserver://localhost:1433; databaseName=orders";
	static String url="jdbc:sqlserver://172.16.22.61:1433; databaseName=orders";
	static String user="sa";
	static String password="123456";
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	PreparedStatement ps1=null;
	ResultSet rs1=null;
	//1������
		static{
			try {
				Class.forName(driver);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	//2��ȡ��ݿ�����
	public static Connection getConnection(){
		Connection conn=null;
		try {
			conn=DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	//5�ر���ݿ�����
	public static void closeConnection(PreparedStatement ps,Connection conn,ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(ps!=null){
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	//���ò���
	public PreparedStatement setParam(PreparedStatement ps,Object[] params){
		//ѭ�����ò���
		if(params!=null){
			for (int i = 0; i < params.length; i++){
				try {
					ps.setObject(i+1, params[i]);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
		}
		return ps;
	}
	//���ӡ�ɾ���޸�
	public int executeUpdate(String sql,Object[] params){
		Connection conn=getConnection();
		int ret=0;
		try {
			ps=conn.prepareStatement(sql);
	
			ps=setParam(ps, params);
			ret=ps.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeConnection(ps, conn, null);
		}
		return ret;
	}
	
	public List <Map <String,Object>> executeQuery(String sql,Object[] params){
		List <Map<String, Object>> objectList=new ArrayList <Map<String, Object>>();
		Connection conn=getConnection();
		try {
			ps=conn.prepareStatement(sql);
	
			ps=setParam(ps, params);
			rs=ps.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();//�����ڻ�ȡ���� ResultSet �������е����ͺ�������Ϣ�Ķ���
		while(rs.next()){//ѭ���������е���
			//��һ����ݷ�װ��һ��map���ϣ�����ٰ�map��װ��list
			Map<String, Object> rowMap=new HashMap<String, Object>();
			for (int i = 0; i < rsmd.getColumnCount(); i++) {//ѭ���������е���
				rowMap.put(rsmd.getColumnName(i+1), rs.getObject(i+1));//��ȡ����
			}
			objectList.add(rowMap);
		}
		//System.out.println(rsmd.getColumnCount());
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeConnection(ps, conn, rs);
		}
		return objectList;
	}
	
}
