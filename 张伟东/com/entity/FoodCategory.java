/**
 * 
 */
package com.entity;

/**
 * @描述：菜品分类
 * @所在公司 AAA
 * @author 张伟东
 * @日期2017-6-17上午8:42:20
 */
public class FoodCategory {
	private  Integer classid;//菜品种类编号
	private String classname;//菜品种类名字
	private Integer stutu;//种类状态
	public Integer getClassid() {
		return classid;
	}
	public void setClassid(Integer classid) {
		this.classid = classid;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	public Integer getStutu() {
		return stutu;
	}
	public void setStutu(Integer stutu) {
		this.stutu = stutu;
	}
	
}
