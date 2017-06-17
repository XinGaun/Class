/**
 * 
 */
package com.util;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**@����  ������
 * @���ڹ�˾ AAA
 * @author ��ΰ��
 * @����2017-3-24����1:31:58
 */
public class FoverTime {
	/**
	 * 切换时间格式
	 * @param date 未初始化时间格式
	 * @return 返回一个初始化过的时间格式
	 */
	public static String dateToString(Date date){
		SimpleDateFormat time= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr=time.format(date);
		return dateStr;
	}
	/**
	 * 切换时间格式
	 * @param date String时间格式
	 * @return 返回一个初始化过的时间格式
	 */
	public static Date stringToDate(String date){
		Date strDate=null;
		SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd/HH:mm:ss");
		try {
			strDate=time.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return strDate;
	}
	/**
	 * 转换数据库格式
	 * @param date String类型时间
	 * @return 返回一个SQL类型的时间格式
	 */
	public static java.sql.Date stringToSqlDate(String date){
		Date strDate=null;
		SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			strDate=time.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new java.sql.Date(strDate.getTime());
	}
}
