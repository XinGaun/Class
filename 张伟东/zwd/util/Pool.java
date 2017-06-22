package zwd.util;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;



public class Pool {
	private BasicDataSource datasource = null;
	public Pool(){
		getdatasource();
	}
	/**getdatasource()
	 * ����һ�����ӳ�
	 * 
	 */
	public void getdatasource(){
		datasource = new BasicDataSource();
		datasource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		datasource.setUrl("jdbc:sqlserver://localhost:1433;DatabaseName=Hello");
		datasource.setUsername("sa");
		datasource.setPassword("123456");	
	}
	/**getConnection()
	 * ��ȡһ��Connection����
	 * 
	 */
	public Connection getConnection(){
		try {
			if(datasource==null){
				getdatasource();
			}
			return datasource.getConnection();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return null;
	}
	/**
	 * close()
	 * �ر�datasource
	 */
	public void close(){
		try {
			datasource.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
