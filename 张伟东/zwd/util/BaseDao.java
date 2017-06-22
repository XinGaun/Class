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

public class BaseDao {
	static String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	static String url="jdbc:sqlserver://localhost:1433; databaseName=Hello";
	static String user="sa";
	static String password="123456";
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	/**
	 * 注册数据库
	 */
	static{
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 获得数据库连接
	 * 
	 * @return 返回一个连接
	 */
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
	/**
	 * 
	 * 关闭流
	 * @param ps
	 * @param conn
	 * @param rs
	 */
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
	/**
	 * 数据的插入
	 * @param ps PreparedStatement 预编译
	 * @param params 带插入数据
	 * @return
	 */
	public PreparedStatement setParam(PreparedStatement ps,Object[] params){

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
	/**
	 * 
	 * 插入执行
	 * @param sql sql语句
	 * @param params 带插入数据
	 * @return 执行结果
	 */
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
	/**
	 * 数据的查询
	 * @param sql 查询的SQL语句
	 * @param params 带插入查询sql语句的数据
	 * @return  返回查询结果Map
	 */
	public List <Map <String,Object>> executeQuery(String sql,Object[] params){
		List <Map<String, Object>> objectList=new ArrayList <Map<String, Object>>();
		Connection conn=getConnection();
		try {
			ps=conn.prepareStatement(sql);
			ps=setParam(ps, params);
			rs=ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			while(rs.next()){

				Map<String, Object> rowMap=new HashMap<String, Object>();
				for (int i = 0; i < rsmd.getColumnCount(); i++) {
					rowMap.put(rsmd.getColumnName(i+1), rs.getObject(i+1));
				}
				objectList.add(rowMap);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeConnection(ps, conn, rs);
		}
		return objectList;
	}

}
