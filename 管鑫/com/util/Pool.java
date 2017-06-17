package com.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
		datasource.setUrl("jdbc:sqlserver://localhost:1433;DatabaseName=orders");
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
	public void addset(PreparedStatement ps,Object[] o){
		if(ps!=null){
			for (int i = 0; i < o.length; i++){
				try {
					ps.setObject(i+1,o[i]);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
		}
	}
	public int update(String sql,Object[] o){
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			addset(ps, o);
			return ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
