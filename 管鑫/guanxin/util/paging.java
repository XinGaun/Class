package guanxin.util;

import java.util.List;
/**
 * 分页帮助类
 * @author Administrator
 *
 */
public class paging {
	private int total;//总条数
	private String button;//按钮
	private List list;//结果集
	private int linage;//每页行数
	private int pagination;//当前页码
	private int allPage;//总页数
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	/**
	 * 如果当前页数小于等于1，就赋给当前页数1，如果当前页数大于总页数，就赋给当前页数总页数
	 * @return 返回A标签
	 */
	public String getButton() {
		StringBuffer bt = new StringBuffer();
		if(getPagination()<=1){
			setPagination(1);
		}
		if(getPagination()>=getAllPage()){
			bt.append("<a href=classify_pagingClassify.action?pagin=1&linage="+linage+">首页</a>&nbsp;&nbsp;&nbsp;");
			bt.append("<a href=classify_pagingClassify.action?pagin="+(getPagination()-1)+"&linage="+linage+">上一页</a>&nbsp;&nbsp;&nbsp;");

			bt.append("<a>下一页</a>&nbsp;&nbsp;&nbsp;");
			bt.append("<a href=classify_pagingClassify.action?pagin="+getAllPage()+"&linage="+linage+">尾页</a>&nbsp;&nbsp;&nbsp;");
		}else{
			bt.append("<a href=classify_pagingClassify.action?pagin=1&linage="+linage+">首页</a>&nbsp;&nbsp;&nbsp;");
			bt.append("<a href=classify_pagingClassify.action?pagin="+(getPagination()-1)+"&linage="+linage+">上一页</a>&nbsp;&nbsp;&nbsp;");

			bt.append("<a href=classify_pagingClassify.action?pagin="+(getPagination()+1)+"&linage="+linage+">下一页</a>&nbsp;&nbsp;&nbsp;");
			bt.append("<a href=classify_pagingClassify.action?pagin="+getAllPage()+"&linage="+linage+">尾页</a>&nbsp;&nbsp;&nbsp;");
		}
		
		
		return bt.toString();
	}
	public void setButton(String button) {
		this.button = button;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public int getLinage() {
		return linage;
	}
	public void setLinage(int linage) {
		this.linage = linage;
	}
	public int getPagination() {
		return pagination;
	}
	public void setPagination(int pagination) {
		this.pagination = pagination;
	}
	/**
	 * 计算出总页数
	 * @return
	 */
	public int getAllPage() {
		allPage = getTotal()/getLinage();
		if(getTotal()%getLinage()>0){
			allPage++;
		}
		return allPage;
	}
	public void setAllPage(int allPage) {
		this.allPage = allPage;
	}
	
}
